package dev.doctor4t.mariposa.datagen;

import dev.doctor4t.mariposa.index.MariposaBlocks;
import dev.doctor4t.mariposa.index.MariposaItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MariposaLangGen extends FabricLanguageProvider {
    protected MariposaLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add(MariposaBlocks.SEQUOIA_SAPLING, "Sequoia Sapling");
		translationBuilder.add(MariposaBlocks.POTTED_SEQUOIA_SAPLING, "Potted Sequoia Sapling");
		translationBuilder.add(MariposaBlocks.SEQUOIA_LOG, "Sequoia Log");
		translationBuilder.add(MariposaBlocks.SEQUOIA_WOOD, "Sequoia Wood");
		translationBuilder.add(MariposaBlocks.STRIPPED_SEQUOIA_LOG, "Stripped Sequoia Log");
		translationBuilder.add(MariposaBlocks.STRIPPED_SEQUOIA_WOOD, "Stripped Sequoia Wood");
		translationBuilder.add(MariposaBlocks.STACKED_SEQUOIA_LOGS, "Stacked Sequoia Logs");
		translationBuilder.add(MariposaBlocks.SEQUOIA_LEAVES, "Sequoia Leaves");
		translationBuilder.add(MariposaBlocks.SEQUOIA_PLANKS, "Sequoia Planks");
		translationBuilder.add(MariposaBlocks.SEQUOIA_STAIRS, "Sequoia Stairs");
		translationBuilder.add(MariposaBlocks.SEQUOIA_SLAB, "Sequoia Slab");
		translationBuilder.add(MariposaBlocks.SEQUOIA_FENCE, "Sequoia Fence");
		translationBuilder.add(MariposaBlocks.SEQUOIA_FENCE_GATE, "Sequoia Fence Gate");
		translationBuilder.add(MariposaBlocks.SEQUOIA_DOOR, "Sequoia Door");
		translationBuilder.add(MariposaBlocks.SEQUOIA_TRAPDOOR, "Sequoia Trapdoor");
		translationBuilder.add(MariposaBlocks.SEQUOIA_PRESSURE_PLATE, "Sequoia Pressure Plate");
		translationBuilder.add(MariposaBlocks.SEQUOIA_BUTTON, "Sequoia Button");
		translationBuilder.add(MariposaItems.SEQUOIA_SIGN, "Sequoia Sign");
		translationBuilder.add(MariposaItems.SEQUOIA_HANGING_SIGN, "Sequoia Hanging Sign");
		translationBuilder.add(MariposaItems.SEQUOIA_BOAT, "Sequoia Boat");
		translationBuilder.add(MariposaItems.SEQUOIA_CHEST_BOAT, "Sequoia Chest Boat");

        translationBuilder.add("tag.item.mariposa.sequoia_logs", "Sequoia Logs");
    }
}
