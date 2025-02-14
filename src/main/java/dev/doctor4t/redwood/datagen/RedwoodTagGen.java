package dev.doctor4t.redwood.datagen;

import dev.doctor4t.redwood.index.RedwoodBlocks;
import dev.doctor4t.redwood.index.RedwoodTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class RedwoodTagGen {

    public static class RedwoodBlockTagGen extends FabricTagProvider.BlockTagProvider {
        public RedwoodBlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            this.getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(
                            RedwoodBlocks.SEQUOIA_PLANKS
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                    .add(
                            RedwoodBlocks.SEQUOIA_BUTTON
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                    .add(
                            RedwoodBlocks.SEQUOIA_DOOR
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(
                            RedwoodBlocks.SEQUOIA_STAIRS
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(
                            RedwoodBlocks.SEQUOIA_SLAB
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                    .add(
                            RedwoodBlocks.SEQUOIA_FENCE
                    );
            this.getOrCreateTagBuilder(BlockTags.SAPLINGS)
                    .add(
                            RedwoodBlocks.SEQUOIA_SAPLING
                    );
            this.getOrCreateTagBuilder(RedwoodTags.SEQUOIA_LOGS).add(RedwoodBlocks.SEQUOIA_LOG, RedwoodBlocks.SEQUOIA_WOOD, RedwoodBlocks.STRIPPED_SEQUOIA_LOG, RedwoodBlocks.STRIPPED_SEQUOIA_WOOD);
            this.getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                    .addTag(RedwoodTags.SEQUOIA_LOGS)
                    .add(RedwoodBlocks.STACKED_SEQUOIA_LOGS);
            this.getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
                    .add(RedwoodBlocks.SEQUOIA_LOG);
            this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                    .add(
                            RedwoodBlocks.POTTED_SEQUOIA_SAPLING
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                    .add(
                            RedwoodBlocks.SEQUOIA_PRESSURE_PLATE
                    );
            this.getOrCreateTagBuilder(BlockTags.LEAVES)
                    .add(
                            RedwoodBlocks.SEQUOIA_LEAVES
                    );
            this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                    .add(
                            RedwoodBlocks.SEQUOIA_TRAPDOOR
                    );
            this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                    .add(
                            RedwoodBlocks.SEQUOIA_SIGN
                    );
            this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                    .add(
                            RedwoodBlocks.SEQUOIA_WALL_SIGN
                    );
            this.getOrCreateTagBuilder(BlockTags.SIGNS).addTag(BlockTags.STANDING_SIGNS).addTag(BlockTags.WALL_SIGNS);
            this.getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                    .add(
                            RedwoodBlocks.SEQUOIA_HANGING_SIGN
                    );
            this.getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                    .add(
                            RedwoodBlocks.SEQUOIA_WALL_HANGING_SIGN
                    );
            this.getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                    .add(
                            RedwoodBlocks.SEQUOIA_FENCE_GATE
                    );
            this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                    .add(
                            RedwoodBlocks.SEQUOIA_LEAVES
                    );
        }
    }

    public static class RedwoodItemTagGen extends FabricTagProvider.ItemTagProvider {
        public RedwoodItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            this.getOrCreateTagBuilder(RedwoodTags.SEQUOIA_LOGS_ITEM).add(
                    RedwoodBlocks.SEQUOIA_LOG.asItem(),
                    RedwoodBlocks.SEQUOIA_WOOD.asItem(),
                    RedwoodBlocks.STRIPPED_SEQUOIA_LOG.asItem(),
                    RedwoodBlocks.STRIPPED_SEQUOIA_WOOD.asItem(),
                    RedwoodBlocks.STACKED_SEQUOIA_LOGS.asItem()
            );
        }
    }
}
