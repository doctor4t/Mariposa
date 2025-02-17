package dev.doctor4t.mariposa.world.gen.feature;

import com.mojang.serialization.Codec;
import dev.doctor4t.mariposa.world.gen.feature.config.GiantSequoiaLogFeatureConfig;
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
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class GiantSequoiaLogFeature extends Feature<GiantSequoiaLogFeatureConfig> {
    public GiantSequoiaLogFeature(Codec<GiantSequoiaLogFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<GiantSequoiaLogFeatureConfig> context) {
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();

        BlockPos origin = context.getOrigin();
        BlockPos.Mutable blockPos = origin.withY(structureWorldAccess.getTopY(Heightmap.Type.WORLD_SURFACE_WG, origin.getX(), origin.getZ())-3).mutableCopy();

        if (!structureWorldAccess.getBlockState(blockPos.down()).isIn(BlockTags.DIRT)) {
            return false;
        }

        blockPos.setY(blockPos.getY() - 1);
        BlockRotation blockRotation = BlockRotation.random(random);
        GiantSequoiaLogFeatureConfig GiantSequoiaLogFeatureConfig = context.getConfig();
        int i = random.nextInt(GiantSequoiaLogFeatureConfig.sequoiaStructures().size());
        StructureTemplateManager structureTemplateManager = structureWorldAccess.toServerWorld().getServer().getStructureTemplateManager();
        StructureTemplate structureTemplate = structureTemplateManager.getTemplateOrBlank(GiantSequoiaLogFeatureConfig.sequoiaStructures().get(i));
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

        structurePlacementData.clearProcessors();
        structurePlacementData.addProcessor(BlockIgnoreStructureProcessor.IGNORE_AIR_AND_STRUCTURE_BLOCKS);
        structureTemplate.place(structureWorldAccess, chunkCenterPos, chunkCenterPos, structurePlacementData, random, 4);
        structurePlacementData.clearProcessors();

        return true;
    }
}
