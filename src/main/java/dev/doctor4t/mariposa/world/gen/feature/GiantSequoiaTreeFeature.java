package dev.doctor4t.mariposa.world.gen.feature;

import com.mojang.serialization.Codec;
import dev.doctor4t.mariposa.world.gen.feature.config.GiantSequoiaTreeFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.apache.commons.lang3.mutable.MutableInt;

public class GiantSequoiaTreeFeature extends Feature<GiantSequoiaTreeFeatureConfig> {
	public GiantSequoiaTreeFeature(Codec<GiantSequoiaTreeFeatureConfig> codec) {
		super(codec);
	}

	@Override
	public boolean generate(FeatureContext<GiantSequoiaTreeFeatureConfig> context) {
		Random random = context.getRandom();
		StructureWorldAccess structureWorldAccess = context.getWorld();

		BlockPos origin = context.getOrigin();
		BlockPos.Mutable blockPos = origin.withY(structureWorldAccess.getTopYInclusive()).mutableCopy();
		for (int y = 0; y < 500; y++) {
			blockPos.setY(blockPos.getY() - 1);
			BlockRotation blockRotation = BlockRotation.random(random);
			GiantSequoiaTreeFeatureConfig giantSequoiaTreeFeatureConfig = context.getConfig();
			int i = random.nextInt(giantSequoiaTreeFeatureConfig.sequoiaStructures().size());
			StructureTemplateManager structureTemplateManager = structureWorldAccess.toServerWorld().getServer().getStructureTemplateManager();
			StructureTemplate structureTemplate = structureTemplateManager.getTemplateOrBlank(giantSequoiaTreeFeatureConfig.sequoiaStructures().get(i));
			ChunkPos chunkPos = new ChunkPos(blockPos);
			BlockBox blockBox = new BlockBox(
					chunkPos.getStartX() - 16,
					structureWorldAccess.getBottomY(),
					chunkPos.getStartZ() - 16,
					chunkPos.getEndX() + 16,
					structureWorldAccess.getTopYInclusive(),
					chunkPos.getEndZ() + 16
			);

			Vec3i size = structureTemplate.getSize();

			BlockPos chunkCenterPos = blockPos;
			switch (blockRotation) {
				case NONE -> chunkCenterPos = chunkCenterPos.add(-size.getX() / 2, 0, -size.getZ() / 2);
				case CLOCKWISE_90 -> chunkCenterPos = chunkCenterPos.add(size.getX() / 2, 0, -size.getZ() / 2);
				case CLOCKWISE_180 -> chunkCenterPos = chunkCenterPos.add(size.getX() / 2, 0, size.getZ() / 2);
				case COUNTERCLOCKWISE_90 -> chunkCenterPos = chunkCenterPos.add(-size.getX() / 2, 0, size.getZ() / 2);
			}

			StructurePlacementData structurePlacementData = new StructurePlacementData().setRotation(blockRotation).setBoundingBox(blockBox).setRandom(random);
			int cornersInGround = getCornersInGround(structureWorldAccess, structureTemplate.calculateBoundingBox(structurePlacementData, chunkCenterPos));

			if (cornersInGround == -1) {
				return false;
			}

			if (cornersInGround >= giantSequoiaTreeFeatureConfig.minCornersInFloor()) {
				structurePlacementData.clearProcessors();
				structurePlacementData.addProcessor(BlockIgnoreStructureProcessor.IGNORE_AIR_AND_STRUCTURE_BLOCKS);
				structureTemplate.place(structureWorldAccess, chunkCenterPos, chunkCenterPos, structurePlacementData, random, 4);
				structurePlacementData.clearProcessors();

				return true;
			}
		}
		return false;
	}

	// -1 abort search cause there is water
	private static int getCornersInGround(StructureWorldAccess world, BlockBox box) {
		MutableInt mutableInt = new MutableInt(0);
		box.forEachVertex(pos -> {
			if (mutableInt.intValue() == -1) {
				return;
			}

			if (pos.getY() == box.getMinY()) {
				BlockState blockState = world.getBlockState(pos);
				if (!blockState.getFluidState().isEmpty() || blockState.isIn(BlockTags.LOGS)) {
					mutableInt.setValue(-1);
					return;
				}
				if (blockState.isIn(BlockTags.DIRT)) {
					mutableInt.add(1);
				}
			}
		});
		return mutableInt.intValue();
	}
}
