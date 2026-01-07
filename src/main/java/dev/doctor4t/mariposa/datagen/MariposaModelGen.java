package dev.doctor4t.mariposa.datagen;

import dev.doctor4t.mariposa.index.MariposaBlocks;
import dev.doctor4t.mariposa.index.MariposaItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

public class MariposaModelGen extends FabricModelProvider {
	public static final BlockFamily SEQUOIA_BLOCK_FAMILY = BlockFamilies.register(MariposaBlocks.SEQUOIA_PLANKS)
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
		generator.registerFlowerPotPlantAndItem(MariposaBlocks.SEQUOIA_SAPLING, MariposaBlocks.POTTED_SEQUOIA_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.createLogTexturePool(MariposaBlocks.SEQUOIA_LOG).log(MariposaBlocks.SEQUOIA_LOG).wood(MariposaBlocks.SEQUOIA_WOOD);
		generator.createLogTexturePool(MariposaBlocks.STRIPPED_SEQUOIA_LOG).log(MariposaBlocks.STRIPPED_SEQUOIA_LOG).wood(MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
		generator.createLogTexturePool(MariposaBlocks.STACKED_SEQUOIA_LOGS).uvLockedLog(MariposaBlocks.STACKED_SEQUOIA_LOGS);
		generator.registerSimpleCubeAll(MariposaBlocks.SEQUOIA_LEAVES);
		generator.registerCubeAllModelTexturePool(SEQUOIA_BLOCK_FAMILY.getBaseBlock()).family(SEQUOIA_BLOCK_FAMILY);
		generator.registerHangingSign(MariposaBlocks.STRIPPED_SEQUOIA_LOG, MariposaBlocks.SEQUOIA_HANGING_SIGN, MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN);
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator) {
		generator.register(MariposaItems.SEQUOIA_BOAT, Models.GENERATED);
		generator.register(MariposaItems.SEQUOIA_CHEST_BOAT, Models.GENERATED);
	}
}
