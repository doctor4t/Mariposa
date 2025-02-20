package dev.doctor4t.mariposa.datagen;

import com.google.common.collect.ImmutableMap;
import dev.doctor4t.mariposa.index.MariposaBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

import java.util.Map;

public class MariposaModelGen extends FabricModelProvider {
    private final Map<Block, TexturedModel> uniqueModels = ImmutableMap.<Block, TexturedModel>builder()
            .build();

    public static BlockFamily SEQUOIA_BLOCK_FAMILY = BlockFamilies.register(MariposaBlocks.SEQUOIA_PLANKS)
            .button(MariposaBlocks.SEQUOIA_BUTTON)
            .fence(MariposaBlocks.SEQUOIA_FENCE)
            .fenceGate(MariposaBlocks.SEQUOIA_FENCE_GATE)
            .pressurePlate(MariposaBlocks.SEQUOIA_PRESSURE_PLATE)
            .sign(MariposaBlocks.SEQUOIA_SIGN, MariposaBlocks.SEQUOIA_WALL_SIGN)
            .slab(MariposaBlocks.SEQUOIA_SLAB)
            .stairs(MariposaBlocks.SEQUOIA_STAIRS)
            .door(MariposaBlocks.SEQUOIA_DOOR)
            .trapdoor(MariposaBlocks.SEQUOIA_TRAPDOOR)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build();

    public MariposaModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        this.registerFamily(generator, SEQUOIA_BLOCK_FAMILY);
        generator.registerLog(MariposaBlocks.SEQUOIA_LOG).log(MariposaBlocks.SEQUOIA_LOG).wood(MariposaBlocks.SEQUOIA_WOOD);
        generator.registerLog(MariposaBlocks.STRIPPED_SEQUOIA_LOG).log(MariposaBlocks.STRIPPED_SEQUOIA_LOG).wood(MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
        generator.registerLog(MariposaBlocks.STACKED_SEQUOIA_LOGS).uvLockedLog(MariposaBlocks.STACKED_SEQUOIA_LOGS);
        generator.registerHangingSign(MariposaBlocks.STRIPPED_SEQUOIA_LOG, MariposaBlocks.SEQUOIA_HANGING_SIGN, MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN);
        generator.registerFlowerPotPlant(MariposaBlocks.SEQUOIA_SAPLING, MariposaBlocks.POTTED_SEQUOIA_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerSimpleCubeAll(MariposaBlocks.SEQUOIA_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }

    private void registerFamily(BlockStateModelGenerator generator, BlockFamily family) {
        TexturedModel texturedModel = this.uniqueModels.getOrDefault(family.getBaseBlock(), TexturedModel.CUBE_ALL.get(family.getBaseBlock()));
        generator.new BlockTexturePool(texturedModel.getTextures()).base(family.getBaseBlock(), texturedModel.getModel()).family(family);
    }
}
