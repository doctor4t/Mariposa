package dev.doctor4t.mariposa.datagen;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.index.MariposaBlocks;
import dev.doctor4t.mariposa.index.MariposaItems;
import dev.doctor4t.mariposa.index.MariposaTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;

import java.util.concurrent.CompletableFuture;

public class MariposaRecipeGen extends FabricRecipeProvider {
    public MariposaRecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                generateFamily(MariposaModelGen.SEQUOIA_BLOCK_FAMILY, FeatureSet.of(FeatureFlags.VANILLA));
                offerPlanksRecipe(MariposaBlocks.SEQUOIA_PLANKS, MariposaTags.SEQUOIA_LOGS_ITEM, 4);
                offerBarkBlockRecipe(MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.SEQUOIA_LOG);
                offerBarkBlockRecipe(MariposaBlocks.STRIPPED_SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
                offerStackedBlockRecipe(this, recipeExporter, MariposaBlocks.STACKED_SEQUOIA_LOGS, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
                offerHangingSignRecipe(MariposaItems.SEQUOIA_HANGING_SIGN, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
            }
        };
    }

    public static void offerStackedBlockRecipe(RecipeGenerator generator, RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        generator.createShaped(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .input('#', input)
                .pattern("###")
                .pattern("###")
                .group("stacked")
                .criterion("has_log", generator.conditionsFromItem(input))
                .offerTo(exporter);
    }

    @Override
    public String getName() {
        return Mariposa.MOD_ID;
    }
}