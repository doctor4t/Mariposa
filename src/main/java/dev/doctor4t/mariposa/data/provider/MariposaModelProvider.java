package dev.doctor4t.mariposa.data.provider;

import dev.doctor4t.mariposa.common.init.MariposaBlocks;
import dev.doctor4t.mariposa.common.init.MariposaItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;

public class MariposaModelProvider extends FabricModelProvider {
	public static final BlockFamily SEQUOIA_BLOCK_FAMILY = BlockFamilies.familyBuilder(MariposaBlocks.SEQUOIA_PLANKS)
			.button(MariposaBlocks.SEQUOIA_BUTTON)
			.fence(MariposaBlocks.SEQUOIA_FENCE)
			.fenceGate(MariposaBlocks.SEQUOIA_FENCE_GATE)
			.pressurePlate(MariposaBlocks.SEQUOIA_PRESSURE_PLATE)
			.sign(MariposaBlocks.SEQUOIA_SIGN, MariposaBlocks.SEQUOIA_WALL_SIGN)
			.slab(MariposaBlocks.SEQUOIA_SLAB)
			.stairs(MariposaBlocks.SEQUOIA_STAIRS)
			.door(MariposaBlocks.SEQUOIA_DOOR)
			.trapdoor(MariposaBlocks.SEQUOIA_TRAPDOOR)
			.recipeGroupPrefix("wooden")
			.recipeUnlockedBy("has_planks")
			.getFamily();

	public MariposaModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators generators) {
		generators.createPlantWithDefaultItem(MariposaBlocks.SEQUOIA_SAPLING, MariposaBlocks.POTTED_SEQUOIA_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.woodProvider(MariposaBlocks.SEQUOIA_LOG).logWithHorizontal(MariposaBlocks.SEQUOIA_LOG).wood(MariposaBlocks.SEQUOIA_WOOD);
		generators.woodProvider(MariposaBlocks.STRIPPED_SEQUOIA_LOG).logWithHorizontal(MariposaBlocks.STRIPPED_SEQUOIA_LOG).wood(MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
		generators.woodProvider(MariposaBlocks.STACKED_SEQUOIA_LOGS).logUVLocked(MariposaBlocks.STACKED_SEQUOIA_LOGS);
		generators.createTrivialCube(MariposaBlocks.SEQUOIA_LEAVES);
		generators.family(SEQUOIA_BLOCK_FAMILY.getBaseBlock()).generateFor(SEQUOIA_BLOCK_FAMILY);
		generators.createShelf(MariposaBlocks.SEQUOIA_SHELF, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
		generators.createHangingSign(MariposaBlocks.STRIPPED_SEQUOIA_LOG, MariposaBlocks.SEQUOIA_HANGING_SIGN, MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN);
	}

	@Override
	public void generateItemModels(ItemModelGenerators generators) {
		generators.generateFlatItem(MariposaItems.SEQUOIA_BOAT, ModelTemplates.FLAT_ITEM);
		generators.generateFlatItem(MariposaItems.SEQUOIA_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
	}
}
