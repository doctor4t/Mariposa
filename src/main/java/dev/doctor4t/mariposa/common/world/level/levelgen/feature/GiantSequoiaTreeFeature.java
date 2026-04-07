/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations.GiantSequoiaTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.apache.commons.lang3.mutable.MutableInt;

public class GiantSequoiaTreeFeature extends Feature<GiantSequoiaTreeConfiguration> {
	public GiantSequoiaTreeFeature(Codec<GiantSequoiaTreeConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<GiantSequoiaTreeConfiguration> context) {
		RandomSource random = context.random();
		WorldGenLevel structureWorldAccess = context.level();

		BlockPos origin = context.origin();
		BlockPos.MutableBlockPos blockPos = origin.atY(structureWorldAccess.getMaxY()).mutable();
		for (int y = 0; y < 500; y++) {
			blockPos.setY(blockPos.getY() - 1);
			Rotation blockRotation = Rotation.getRandom(random);
			GiantSequoiaTreeConfiguration giantSequoiaTreeConfiguration = context.config();
			int i = random.nextInt(giantSequoiaTreeConfiguration.sequoiaStructures().size());
			StructureTemplateManager structureTemplateManager = structureWorldAccess.getLevel().getServer().getStructureManager();
			StructureTemplate structureTemplate = structureTemplateManager.getOrCreate(giantSequoiaTreeConfiguration.sequoiaStructures().get(i));
			ChunkPos chunkPos = ChunkPos.containing(blockPos);
			BoundingBox blockBox = new BoundingBox(
					chunkPos.getMinBlockX() - 16,
					structureWorldAccess.getMinY(),
					chunkPos.getMinBlockZ() - 16,
					chunkPos.getMaxBlockX() + 16,
					structureWorldAccess.getMaxY(),
					chunkPos.getMaxBlockZ() + 16
			);

			Vec3i size = structureTemplate.getSize();

			BlockPos chunkCenterPos = blockPos;
			switch (blockRotation) {
				case NONE -> chunkCenterPos = chunkCenterPos.offset(-size.getX() / 2, 0, -size.getZ() / 2);
				case CLOCKWISE_90 -> chunkCenterPos = chunkCenterPos.offset(size.getX() / 2, 0, -size.getZ() / 2);
				case CLOCKWISE_180 -> chunkCenterPos = chunkCenterPos.offset(size.getX() / 2, 0, size.getZ() / 2);
				case COUNTERCLOCKWISE_90 ->
						chunkCenterPos = chunkCenterPos.offset(-size.getX() / 2, 0, size.getZ() / 2);
			}

			StructurePlaceSettings structurePlacementData = new StructurePlaceSettings().setRotation(blockRotation).setBoundingBox(blockBox).setRandom(random);
			int cornersInGround = getCornersInGround(structureWorldAccess, structureTemplate.getBoundingBox(structurePlacementData, chunkCenterPos));

			if (cornersInGround == -1) {
				return false;
			}

			if (cornersInGround >= giantSequoiaTreeConfiguration.minCornersInFloor()) {
				structurePlacementData.clearProcessors();
				structurePlacementData.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
				structureTemplate.placeInWorld(structureWorldAccess, chunkCenterPos, chunkCenterPos, structurePlacementData, random, 4);
				structurePlacementData.clearProcessors();

				return true;
			}
		}
		return false;
	}

	// -1 abort search cause there is water
	private static int getCornersInGround(WorldGenLevel world, BoundingBox box) {
		MutableInt mutableInt = new MutableInt(0);
		box.forAllCorners(pos -> {
			if (mutableInt.intValue() == -1) {
				return;
			}

			if (pos.getY() == box.minY()) {
				BlockState blockState = world.getBlockState(pos);
				if (!blockState.getFluidState().isEmpty() || blockState.is(BlockTags.LOGS)) {
					mutableInt.setValue(-1);
					return;
				}
				if (blockState.is(BlockTags.DIRT)) {
					mutableInt.add(1);
				}
			}
		});
		return mutableInt.intValue();
	}
}
