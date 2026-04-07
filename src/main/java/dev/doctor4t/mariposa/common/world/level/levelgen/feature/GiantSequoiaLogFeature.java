package dev.doctor4t.mariposa.common.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations.GiantSequoiaLogConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class GiantSequoiaLogFeature extends Feature<GiantSequoiaLogConfiguration> {
	public GiantSequoiaLogFeature(Codec<GiantSequoiaLogConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<GiantSequoiaLogConfiguration> context) {
		RandomSource random = context.random();
		WorldGenLevel structureWorldAccess = context.level();

		BlockPos origin = context.origin();
		BlockPos.MutableBlockPos blockPos = origin.atY(structureWorldAccess.getHeight(Heightmap.Types.WORLD_SURFACE_WG, origin.getX(), origin.getZ()) - 3).mutable();

		if (!structureWorldAccess.getBlockState(blockPos.below()).is(BlockTags.DIRT)) {
			return false;
		}

		blockPos.setY(blockPos.getY() - 1);
		Rotation blockRotation = Rotation.getRandom(random);
		GiantSequoiaLogConfiguration GiantSequoiaLogConfiguration = context.config();
		int i = random.nextInt(GiantSequoiaLogConfiguration.sequoiaStructures().size());
		StructureTemplateManager structureTemplateManager = structureWorldAccess.getLevel().getServer().getStructureManager();
		StructureTemplate structureTemplate = structureTemplateManager.getOrCreate(GiantSequoiaLogConfiguration.sequoiaStructures().get(i));
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
			case COUNTERCLOCKWISE_90 -> chunkCenterPos = chunkCenterPos.offset(-size.getX() / 2, 0, size.getZ() / 2);
		}

		StructurePlaceSettings structurePlacementData = new StructurePlaceSettings().setRotation(blockRotation).setBoundingBox(blockBox).setRandom(random);

		structurePlacementData.clearProcessors();
		structurePlacementData.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
		structureTemplate.placeInWorld(structureWorldAccess, chunkCenterPos, chunkCenterPos, structurePlacementData, random, 4);
		structurePlacementData.clearProcessors();

		return true;
	}
}
