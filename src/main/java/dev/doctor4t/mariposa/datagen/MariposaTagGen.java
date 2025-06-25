package dev.doctor4t.mariposa.datagen;

import dev.doctor4t.mariposa.index.MariposaBlocks;
import dev.doctor4t.mariposa.index.MariposaTags;
import dev.doctor4t.mariposa.world.gen.MariposaBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class MariposaTagGen {

    public static class MariposaBlockTagGen extends FabricTagProvider.BlockTagProvider {
        public MariposaBlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            valueLookupBuilder(BlockTags.PLANKS)
                    .add(
                            MariposaBlocks.SEQUOIA_PLANKS
                    );
            valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                    .add(
                            MariposaBlocks.SEQUOIA_BUTTON
                    );
            valueLookupBuilder(BlockTags.WOODEN_DOORS)
                    .add(
                            MariposaBlocks.SEQUOIA_DOOR
                    );
            valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                    .add(
                            MariposaBlocks.SEQUOIA_STAIRS
                    );
            valueLookupBuilder(BlockTags.WOODEN_SLABS)
                    .add(
                            MariposaBlocks.SEQUOIA_SLAB
                    );
            valueLookupBuilder(BlockTags.WOODEN_FENCES)
                    .add(
                            MariposaBlocks.SEQUOIA_FENCE
                    );
            valueLookupBuilder(BlockTags.SAPLINGS)
                    .add(
                            MariposaBlocks.SEQUOIA_SAPLING
                    );
            valueLookupBuilder(MariposaTags.SEQUOIA_LOGS).add(MariposaBlocks.SEQUOIA_LOG, MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_LOG, MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
            valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                    .addTag(MariposaTags.SEQUOIA_LOGS)
                    .add(MariposaBlocks.STACKED_SEQUOIA_LOGS);
            valueLookupBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
                    .add(MariposaBlocks.SEQUOIA_LOG);
            valueLookupBuilder(BlockTags.FLOWER_POTS)
                    .add(
                            MariposaBlocks.POTTED_SEQUOIA_SAPLING
                    );
            valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                    .add(
                            MariposaBlocks.SEQUOIA_PRESSURE_PLATE
                    );
            valueLookupBuilder(BlockTags.LEAVES)
                    .add(
                            MariposaBlocks.SEQUOIA_LEAVES
                    );
            valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                    .add(
                            MariposaBlocks.SEQUOIA_TRAPDOOR
                    );
            valueLookupBuilder(BlockTags.STANDING_SIGNS)
                    .add(
                            MariposaBlocks.SEQUOIA_SIGN
                    );
            valueLookupBuilder(BlockTags.WALL_SIGNS)
                    .add(
                            MariposaBlocks.SEQUOIA_WALL_SIGN
                    );
            valueLookupBuilder(BlockTags.SIGNS).addTag(BlockTags.STANDING_SIGNS).addTag(BlockTags.WALL_SIGNS);
            valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
                    .add(
                            MariposaBlocks.SEQUOIA_HANGING_SIGN
                    );
            valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
                    .add(
                            MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN
                    );
            valueLookupBuilder(BlockTags.FENCE_GATES)
                    .add(
                            MariposaBlocks.SEQUOIA_FENCE_GATE
                    );
            valueLookupBuilder(BlockTags.HOE_MINEABLE)
                    .add(
                            MariposaBlocks.SEQUOIA_LEAVES
                    );
        }
    }

    public static class MariposaItemTagGen extends FabricTagProvider.ItemTagProvider {
        public MariposaItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            valueLookupBuilder(ItemTags.PLANKS)
                    .add(
                            MariposaBlocks.SEQUOIA_PLANKS.asItem()
                    );
            valueLookupBuilder(MariposaTags.SEQUOIA_LOGS_ITEM).add(
                    MariposaBlocks.SEQUOIA_LOG.asItem(),
                    MariposaBlocks.SEQUOIA_WOOD.asItem(),
                    MariposaBlocks.STRIPPED_SEQUOIA_LOG.asItem(),
                    MariposaBlocks.STRIPPED_SEQUOIA_WOOD.asItem(),
                    MariposaBlocks.STACKED_SEQUOIA_LOGS.asItem()
            );
        }
    }

    public static class MariposaBiomeTagGen extends FabricTagProvider<Biome> {
        public MariposaBiomeTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, RegistryKeys.BIOME, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            builder(ConventionalBiomeTags.IS_FOREST).addOptional(
                    MariposaBiomes.REDWOOD_FOREST
            );
            builder(ConventionalBiomeTags.IS_OVERWORLD).addOptional(
                    MariposaBiomes.REDWOOD_FOREST
            );
            builder(ConventionalBiomeTags.IS_TEMPERATE_OVERWORLD).addOptional(
                    MariposaBiomes.REDWOOD_FOREST
            );
        }
    }
}
