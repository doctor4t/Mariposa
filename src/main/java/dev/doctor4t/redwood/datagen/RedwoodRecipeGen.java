package dev.doctor4t.redwood.datagen;

import dev.doctor4t.redwood.index.RedwoodBlocks;
import dev.doctor4t.redwood.index.RedwoodItems;
import dev.doctor4t.redwood.index.RedwoodTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;

import java.util.concurrent.CompletableFuture;

public class RedwoodRecipeGen extends FabricRecipeProvider {
    public RedwoodRecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        generateFamily(exporter, RedwoodModelGen.SEQUOIA_BLOCK_FAMILY, FeatureSet.of(FeatureFlags.VANILLA));
        offerPlanksRecipe(exporter, RedwoodBlocks.SEQUOIA_PLANKS, RedwoodTags.SEQUOIA_LOGS_ITEM, 4);
        offerBarkBlockRecipe(exporter, RedwoodBlocks.SEQUOIA_WOOD, RedwoodBlocks.SEQUOIA_LOG);
        offerBarkBlockRecipe(exporter, RedwoodBlocks.STRIPPED_SEQUOIA_WOOD, RedwoodBlocks.STRIPPED_SEQUOIA_LOG);
        offerStackedBlockRecipe(exporter, RedwoodBlocks.STACKED_SEQUOIA_LOGS, RedwoodBlocks.STRIPPED_SEQUOIA_LOG);
        offerHangingSignRecipe(exporter, RedwoodItems.SEQUOIA_HANGING_SIGN, RedwoodBlocks.STRIPPED_SEQUOIA_LOG);
    }

    public static void offerStackedBlockRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .input('#', input)
                .pattern("###")
                .pattern("###")
                .group("stacked")
                .criterion("has_log", conditionsFromItem(input))
                .offerTo(exporter);
    }

}