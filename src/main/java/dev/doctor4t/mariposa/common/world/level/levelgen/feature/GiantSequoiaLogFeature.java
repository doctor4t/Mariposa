/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

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
		WorldGenLevel level = context.level();

		BlockPos origin = context.origin();
		BlockPos.MutableBlockPos blockPos = origin.atY(level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, origin.getX(), origin.getZ()) - 3).mutable();

		if (!level.getBlockState(blockPos.below()).is(BlockTags.DIRT)) {
			return false;
		}

		blockPos.setY(blockPos.getY() - 1);
		Rotation rotation = Rotation.getRandom(random);
		GiantSequoiaLogConfiguration config = context.config();
		int i = random.nextInt(config.sequoiaStructures().size());
		StructureTemplateManager manager = level.getLevel().getServer().getStructureManager();
		StructureTemplate template = manager.getOrCreate(config.sequoiaStructures().get(i));
		ChunkPos chunkPos = ChunkPos.containing(blockPos);
		BoundingBox blockBox = new BoundingBox(
				chunkPos.getMinBlockX() - 16,
				level.getMinY(),
				chunkPos.getMinBlockZ() - 16,
				chunkPos.getMaxBlockX() + 16,
				level.getMaxY(),
				chunkPos.getMaxBlockZ() + 16
		);

		Vec3i size = template.getSize();

		BlockPos chunkCenterPos = blockPos;
		switch (rotation) {
			case NONE -> chunkCenterPos = chunkCenterPos.offset(-size.getX() / 2, 0, -size.getZ() / 2);
			case CLOCKWISE_90 -> chunkCenterPos = chunkCenterPos.offset(size.getX() / 2, 0, -size.getZ() / 2);
			case CLOCKWISE_180 -> chunkCenterPos = chunkCenterPos.offset(size.getX() / 2, 0, size.getZ() / 2);
			case COUNTERCLOCKWISE_90 -> chunkCenterPos = chunkCenterPos.offset(-size.getX() / 2, 0, size.getZ() / 2);
		}

		StructurePlaceSettings settings = new StructurePlaceSettings().setRotation(rotation).setBoundingBox(blockBox).setRandom(random);

		settings.clearProcessors();
		settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
		template.placeInWorld(level, chunkCenterPos, chunkCenterPos, settings, random, 4);
		settings.clearProcessors();

		return true;
	}
}
