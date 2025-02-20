package dev.doctor4t.mariposa.datagen;

import dev.doctor4t.mariposa.index.MariposaBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;

import java.util.function.Consumer;
import java.util.function.Function;

public class MariposaBlockLootTableGen extends FabricBlockLootTableProvider {
    protected MariposaBlockLootTableGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        this.addDrop(MariposaBlocks.SEQUOIA_PLANKS);
        this.addDrop(MariposaBlocks.SEQUOIA_SAPLING);
        this.addDrop(MariposaBlocks.SEQUOIA_LOG);
        this.addDrop(MariposaBlocks.STACKED_SEQUOIA_LOGS);
        this.addDrop(MariposaBlocks.STRIPPED_SEQUOIA_LOG);
        this.addDrop(MariposaBlocks.SEQUOIA_WOOD);
        this.addDrop(MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
        this.addDrop(MariposaBlocks.SEQUOIA_SIGN);
        this.addDrop(MariposaBlocks.SEQUOIA_HANGING_SIGN);
        this.addDrop(MariposaBlocks.SEQUOIA_PRESSURE_PLATE);
        this.addDrop(MariposaBlocks.SEQUOIA_TRAPDOOR);
        this.addDrop(MariposaBlocks.SEQUOIA_STAIRS);
        this.addDrop(MariposaBlocks.SEQUOIA_BUTTON);
        this.addDrop(MariposaBlocks.SEQUOIA_FENCE_GATE);
        this.addDrop(MariposaBlocks.SEQUOIA_FENCE);
        this.addPottedPlantDrops(MariposaBlocks.POTTED_SEQUOIA_SAPLING);
        this.addDrop(MariposaBlocks.SEQUOIA_SLAB, this::slabDrops);
        this.addDrop(MariposaBlocks.SEQUOIA_DOOR, this::doorDrops);
        this.addDrop(MariposaBlocks.SEQUOIA_LEAVES, block -> this.leavesDrops(block, MariposaBlocks.SEQUOIA_SAPLING, SAPLING_DROP_CHANCE));

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
