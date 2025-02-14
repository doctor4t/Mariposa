package dev.doctor4t.redwood.datagen;

import dev.doctor4t.redwood.index.RedwoodBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class RedwoodBlockLootTableGen extends FabricBlockLootTableProvider {
    protected RedwoodBlockLootTableGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.addDrop(RedwoodBlocks.SEQUOIA_PLANKS);
        this.addDrop(RedwoodBlocks.SEQUOIA_SAPLING);
        this.addDrop(RedwoodBlocks.SEQUOIA_LOG);
        this.addDrop(RedwoodBlocks.STACKED_SEQUOIA_LOGS);
        this.addDrop(RedwoodBlocks.STRIPPED_SEQUOIA_LOG);
        this.addDrop(RedwoodBlocks.SEQUOIA_WOOD);
        this.addDrop(RedwoodBlocks.STRIPPED_SEQUOIA_WOOD);
        this.addDrop(RedwoodBlocks.SEQUOIA_SIGN);
        this.addDrop(RedwoodBlocks.SEQUOIA_HANGING_SIGN);
        this.addDrop(RedwoodBlocks.SEQUOIA_PRESSURE_PLATE);
        this.addDrop(RedwoodBlocks.SEQUOIA_TRAPDOOR);
        this.addDrop(RedwoodBlocks.SEQUOIA_STAIRS);
        this.addDrop(RedwoodBlocks.SEQUOIA_BUTTON);
        this.addDrop(RedwoodBlocks.SEQUOIA_FENCE_GATE);
        this.addDrop(RedwoodBlocks.SEQUOIA_FENCE);
        this.addPottedPlantDrops(RedwoodBlocks.POTTED_SEQUOIA_SAPLING);
        this.addDrop(RedwoodBlocks.SEQUOIA_SLAB, this::slabDrops);
        this.addDrop(RedwoodBlocks.SEQUOIA_DOOR, this::doorDrops);
        this.addDrop(RedwoodBlocks.SEQUOIA_LEAVES, block -> this.leavesDrops(block, RedwoodBlocks.SEQUOIA_SAPLING, SAPLING_DROP_CHANCE));

    }

    protected void addFamily(BlockFamily family) {
        this.addFamily(family, this::addSelfDrop);
    }

    protected void addFamily(BlockFamily family, Consumer<Block> consumer) {
        family.getVariants().values().forEach(consumer);
        consumer.accept(family.getBaseBlock());
    }

    protected void addSelfDrop(Block block) {
        this.addSelfDrop(block, this::drops);
    }

    protected void addSelfDrop(Block block, Function<Block, LootTable.Builder> function) {
        if (block.getHardness() == -1.0f) {
            // Register drops as nothing if block is unbreakable
            this.addDrop(block, dropsNothing());
        } else {
            this.addDrop(block, function);
        }
    }

    protected void addNothingDrop(Block block) {
        this.addDrop(block, dropsNothing());
    }

    protected ConstantLootNumberProvider count(float value) {
        return ConstantLootNumberProvider.create(value);
    }
}
