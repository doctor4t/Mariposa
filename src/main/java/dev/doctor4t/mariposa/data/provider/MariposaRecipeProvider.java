package dev.doctor4t.mariposa.data.provider;

import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.init.MariposaBlocks;
import dev.doctor4t.mariposa.common.init.MariposaItems;
import dev.doctor4t.mariposa.common.tag.MariposaTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class MariposaRecipeProvider extends FabricRecipeProvider {
	public MariposaRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
		return new RecipeProvider(registries, output) {
			@Override
			public void buildRecipes() {
				woodFromLogs(MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.SEQUOIA_LOG);
				woodFromLogs(MariposaBlocks.STRIPPED_SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
				offerStackedBlockRecipe(this, output, MariposaBlocks.STACKED_SEQUOIA_LOGS, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
				planksFromLogs(MariposaBlocks.SEQUOIA_PLANKS, MariposaTags.SEQUOIA_LOGS_ITEM, 4);
				generateRecipes(MariposaModelProvider.SEQUOIA_BLOCK_FAMILY, FeatureFlagSet.of(FeatureFlags.VANILLA));
				shelf(MariposaBlocks.SEQUOIA_SHELF, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
				hangingSign(MariposaItems.SEQUOIA_HANGING_SIGN, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
				woodenBoat(MariposaItems.SEQUOIA_BOAT, MariposaBlocks.SEQUOIA_PLANKS);
				chestBoat(MariposaItems.SEQUOIA_CHEST_BOAT, MariposaItems.SEQUOIA_BOAT);
			}
		};
	}

	public static void offerStackedBlockRecipe(RecipeProvider provider, RecipeOutput output1, ItemLike output, ItemLike input) {
		provider.shaped(RecipeCategory.BUILDING_BLOCKS, output, 6)
				.define('#', input)
				.pattern("###")
				.pattern("###")
				.group("stacked")
				.unlockedBy("has_log", provider.has(input))
				.save(output1);
	}

	@Override
	public String getName() {
		return Mariposa.MOD_ID + "_recipes";
	}
}