package dev.doctor4t.mariposa.common.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.apache.commons.lang3.mutable.MutableInt;

import java.util.List;

public record GiantSequoiaTreeFeature(List<Identifier> sequoiaStructures, int minCornersInFloor) implements Feature {
	public static final MapCodec<GiantSequoiaTreeFeature> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
					Identifier.CODEC.listOf().fieldOf("sequoia_structures").forGetter(config -> config.sequoiaStructures),
					Codec.intRange(0, 7).fieldOf("min_corners_in_floor").forGetter(config -> config.minCornersInFloor)
			).apply(instance, GiantSequoiaTreeFeature::new)
	);

	@Override
	public MapCodec<GiantSequoiaTreeFeature> codec() {
		return CODEC;
	}

	@Override
	public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
		BlockPos.MutableBlockPos blockPos = origin.atY(level.getMaxY()).mutable();
		for (int y = 0; y < 500; y++) {
			blockPos.setY(blockPos.getY() - 1);
			Rotation rotation = Rotation.getRandom(random);
			int i = random.nextInt(sequoiaStructures().size());
			StructureTemplateManager manager = level.getLevel().getServer().getStructureTemplateManager();
			StructureTemplate template = manager.getOrCreate(sequoiaStructures().get(i));
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
			int cornersInGround = getCornersInGround(level, template.getBoundingBox(settings, chunkCenterPos));

			if (cornersInGround == -1) {
				return false;
			}

			if (cornersInGround >= minCornersInFloor()) {
				settings.clearProcessors();
				settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
				template.placeInWorld(level, chunkCenterPos, chunkCenterPos, settings, random, 4);
				settings.clearProcessors();

				return true;
			}
		}
		return false;
	}

	// -1 abort search cause there is water
	private static int getCornersInGround(WorldGenLevel level, BoundingBox box) {
		MutableInt mutableInt = new MutableInt(0);
		box.forAllCorners(pos -> {
			if (mutableInt.intValue() == -1) {
				return;
			}

			if (pos.getY() == box.minY()) {
				BlockState state = level.getBlockState(pos);
				if (!state.getFluidState().isEmpty() || state.is(BlockTags.LOGS)) {
					mutableInt.setValue(-1);
					return;
				}
				if (state.is(BlockTags.DIRT)) {
					mutableInt.add(1);
				}
			}
		});
		return mutableInt.intValue();
	}
}
