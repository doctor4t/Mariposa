package dev.doctor4t.mariposa.data.provider;

import dev.doctor4t.mariposa.common.init.MariposaBlocks;
import dev.doctor4t.mariposa.common.init.MariposaItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class MariposaLanguageProvider extends FabricLanguageProvider {
	public MariposaLanguageProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generateTranslations(HolderLookup.Provider registries, TranslationBuilder builder) {
		builder.add(MariposaBlocks.SEQUOIA_SAPLING, "Sequoia Sapling");
		builder.add(MariposaBlocks.POTTED_SEQUOIA_SAPLING, "Potted Sequoia Sapling");
		builder.add(MariposaBlocks.SEQUOIA_LOG, "Sequoia Log");
		builder.add(MariposaBlocks.SEQUOIA_WOOD, "Sequoia Wood");
		builder.add(MariposaBlocks.STRIPPED_SEQUOIA_LOG, "Stripped Sequoia Log");
		builder.add(MariposaBlocks.STRIPPED_SEQUOIA_WOOD, "Stripped Sequoia Wood");
		builder.add(MariposaBlocks.STACKED_SEQUOIA_LOGS, "Stacked Sequoia Logs");
		builder.add(MariposaBlocks.SEQUOIA_LEAVES, "Sequoia Leaves");
		builder.add(MariposaBlocks.SEQUOIA_PLANKS, "Sequoia Planks");
		builder.add(MariposaBlocks.SEQUOIA_STAIRS, "Sequoia Stairs");
		builder.add(MariposaBlocks.SEQUOIA_SLAB, "Sequoia Slab");
		builder.add(MariposaBlocks.SEQUOIA_FENCE, "Sequoia Fence");
		builder.add(MariposaBlocks.SEQUOIA_FENCE_GATE, "Sequoia Fence Gate");
		builder.add(MariposaBlocks.SEQUOIA_DOOR, "Sequoia Door");
		builder.add(MariposaBlocks.SEQUOIA_TRAPDOOR, "Sequoia Trapdoor");
		builder.add(MariposaBlocks.SEQUOIA_PRESSURE_PLATE, "Sequoia Pressure Plate");
		builder.add(MariposaBlocks.SEQUOIA_BUTTON, "Sequoia Button");
		builder.add(MariposaBlocks.SEQUOIA_SHELF, "Sequoia Shelf");
		builder.add(MariposaItems.SEQUOIA_SIGN, "Sequoia Sign");
		builder.add(MariposaItems.SEQUOIA_HANGING_SIGN, "Sequoia Hanging Sign");
		builder.add(MariposaItems.SEQUOIA_BOAT, "Sequoia Boat");
		builder.add(MariposaItems.SEQUOIA_CHEST_BOAT, "Sequoia Chest Boat");

		builder.add("tag.item.mariposa.sequoia_logs", "Sequoia Logs");
	}
}
