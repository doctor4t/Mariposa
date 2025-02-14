package dev.doctor4t.redwood.datagen;

import com.google.common.collect.ImmutableMap;
import dev.doctor4t.redwood.index.RedwoodBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

import java.util.Map;

public class RedwoodModelGen extends FabricModelProvider {
    private final Map<Block, TexturedModel> uniqueModels = ImmutableMap.<Block, TexturedModel>builder()
            .build();

    public RedwoodModelGen(FabricDataOutput output) {
        super(output);
    }

    public static BlockFamily SEQUOIA_BLOCK_FAMILY = BlockFamilies.register(RedwoodBlocks.SEQUOIA_PLANKS)
            .button(RedwoodBlocks.SEQUOIA_BUTTON)
            .fence(RedwoodBlocks.SEQUOIA_FENCE)
            .fenceGate(RedwoodBlocks.SEQUOIA_FENCE_GATE)
            .pressurePlate(RedwoodBlocks.SEQUOIA_PRESSURE_PLATE)
            .sign(RedwoodBlocks.SEQUOIA_SIGN, RedwoodBlocks.SEQUOIA_WALL_SIGN)
            .slab(RedwoodBlocks.SEQUOIA_SLAB)
            .stairs(RedwoodBlocks.SEQUOIA_STAIRS)
            .door(RedwoodBlocks.SEQUOIA_DOOR)
            .trapdoor(RedwoodBlocks.SEQUOIA_TRAPDOOR)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build();

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        this.registerFamily(generator, SEQUOIA_BLOCK_FAMILY);
        generator.registerLog(RedwoodBlocks.SEQUOIA_LOG).log(RedwoodBlocks.SEQUOIA_LOG).wood(RedwoodBlocks.SEQUOIA_WOOD);
        generator.registerLog(RedwoodBlocks.STRIPPED_SEQUOIA_LOG).log(RedwoodBlocks.STRIPPED_SEQUOIA_LOG).wood(RedwoodBlocks.STRIPPED_SEQUOIA_WOOD);
        generator.registerLog(RedwoodBlocks.STACKED_SEQUOIA_LOGS).uvLockedLog(RedwoodBlocks.STACKED_SEQUOIA_LOGS);
        generator.registerHangingSign(RedwoodBlocks.STRIPPED_SEQUOIA_LOG, RedwoodBlocks.SEQUOIA_HANGING_SIGN, RedwoodBlocks.SEQUOIA_WALL_HANGING_SIGN);
        generator.registerFlowerPotPlant(RedwoodBlocks.SEQUOIA_SAPLING, RedwoodBlocks.POTTED_SEQUOIA_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerSimpleCubeAll(RedwoodBlocks.SEQUOIA_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
    }

    private void registerFamily(BlockStateModelGenerator generator, BlockFamily family) {
        TexturedModel texturedModel = this.uniqueModels.getOrDefault(family.getBaseBlock(), TexturedModel.CUBE_ALL.get(family.getBaseBlock()));
        generator.new BlockTexturePool(texturedModel.getTextures()).base(family.getBaseBlock(), texturedModel.getModel()).family(family);
    }
}
