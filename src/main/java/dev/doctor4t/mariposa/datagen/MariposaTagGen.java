package dev.doctor4t.mariposa.datagen;

import dev.doctor4t.mariposa.index.MariposaBlocks;
import dev.doctor4t.mariposa.index.MariposaTags;
import dev.doctor4t.mariposa.world.gen.MariposaBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
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
            this.getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(
                            MariposaBlocks.SEQUOIA_PLANKS
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                    .add(
                            MariposaBlocks.SEQUOIA_BUTTON
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                    .add(
                            MariposaBlocks.SEQUOIA_DOOR
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(
                            MariposaBlocks.SEQUOIA_STAIRS
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(
                            MariposaBlocks.SEQUOIA_SLAB
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                    .add(
                            MariposaBlocks.SEQUOIA_FENCE
                    );
            this.getOrCreateTagBuilder(BlockTags.SAPLINGS)
                    .add(
                            MariposaBlocks.SEQUOIA_SAPLING
                    );
            this.getOrCreateTagBuilder(MariposaTags.SEQUOIA_LOGS).add(MariposaBlocks.SEQUOIA_LOG, MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_LOG, MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
            this.getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                    .addTag(MariposaTags.SEQUOIA_LOGS)
                    .add(MariposaBlocks.STACKED_SEQUOIA_LOGS);
            this.getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
                    .add(MariposaBlocks.SEQUOIA_LOG);
            this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                    .add(
                            MariposaBlocks.POTTED_SEQUOIA_SAPLING
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                    .add(
                            MariposaBlocks.SEQUOIA_PRESSURE_PLATE
                    );
            this.getOrCreateTagBuilder(BlockTags.LEAVES)
                    .add(
                            MariposaBlocks.SEQUOIA_LEAVES
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                    .add(
                            MariposaBlocks.SEQUOIA_TRAPDOOR
                    );
            this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                    .add(
                            MariposaBlocks.SEQUOIA_SIGN
                    );
            this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                    .add(
                            MariposaBlocks.SEQUOIA_WALL_SIGN
                    );
            this.getOrCreateTagBuilder(BlockTags.SIGNS).addTag(BlockTags.STANDING_SIGNS).addTag(BlockTags.WALL_SIGNS);
            this.getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                    .add(
                            MariposaBlocks.SEQUOIA_HANGING_SIGN
                    );
            this.getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                    .add(
                            MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN
                    );
            this.getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                    .add(
                            MariposaBlocks.SEQUOIA_FENCE_GATE
                    );
            this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
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
            this.getOrCreateTagBuilder(ItemTags.PLANKS)
                    .add(
                            MariposaBlocks.SEQUOIA_PLANKS.asItem()
                    );
            this.getOrCreateTagBuilder(MariposaTags.SEQUOIA_LOGS_ITEM).add(
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
            this.getOrCreateTagBuilder(ConventionalBiomeTags.FOREST).addOptional(
                    MariposaBiomes.REDWOOD_FOREST
            );
            this.getOrCreateTagBuilder(ConventionalBiomeTags.IN_OVERWORLD).addOptional(
                    MariposaBiomes.REDWOOD_FOREST
            );
            this.getOrCreateTagBuilder(ConventionalBiomeTags.CLIMATE_TEMPERATE).addOptional(
                    MariposaBiomes.REDWOOD_FOREST
            );
        }
    }
}
