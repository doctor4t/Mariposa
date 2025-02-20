package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.block.MariposaHangingSignBlock;
import dev.doctor4t.mariposa.block.MariposaSignBlock;
import dev.doctor4t.mariposa.block.MariposaWallHangingSignBlock;
import dev.doctor4t.mariposa.block.MariposaWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;

import java.util.function.Function;

public interface MariposaBlocks {
    BlockSetType SEQUOIA_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Mariposa.id("sequoia"));
    WoodType SEQUOIA_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(Mariposa.id("sequoia"), SEQUOIA_BLOCK_SET_TYPE);
    Block SEQUOIA_PLANKS = createWithItem(
            "sequoia_planks",
            Block::new, AbstractBlock.Settings.create()
                    .mapColor(MapColor.RED)
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    Block SEQUOIA_SAPLING = createWithItem(
            "sequoia_sapling",
            settings -> new SaplingBlock(
                    new MariposaSaplingGenerator.SEQUOIA(),
                    settings
            ), AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    Block SEQUOIA_LOG = createWithItem("sequoia_log", PillarBlock::new, createLogSettings(MapColor.RED, MapColor.BROWN));

    Block STACKED_SEQUOIA_LOGS = createWithItem("stacked_sequoia_logs", PillarBlock::new, createLogSettings(MapColor.RED, MapColor.BROWN));
    Block STRIPPED_SEQUOIA_LOG = createWithItem("stripped_sequoia_log", PillarBlock::new, createLogSettings(MapColor.RED, MapColor.RED));
    Block SEQUOIA_WOOD = createWithItem(
            "sequoia_wood",
            PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.RED).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()
    );
    Block STRIPPED_SEQUOIA_WOOD = createWithItem(
            "stripped_sequoia_wood",
            PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.RED).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()
    );
    Block SEQUOIA_LEAVES = createWithItem("sequoia_leaves", LeavesBlock::new, createLeavesSettings(BlockSoundGroup.GRASS));
    Block SEQUOIA_SIGN = create(
            "sequoia_sign",
            settings -> new MariposaSignBlock(
                    settings,
                    SEQUOIA_WOOD_TYPE
            ), AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .mapColor(SEQUOIA_LOG.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()
    );
    Block SEQUOIA_WALL_SIGN = create(
            "sequoia_wall_sign",
            settings -> new MariposaWallSignBlock(
                    settings,
                    SEQUOIA_WOOD_TYPE
            ), AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                    .mapColor(SEQUOIA_LOG.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .dropsLike(SEQUOIA_SIGN)
                    //.lootTable(SEQUOIA_SIGN.getLootTableKey())
                    .burnable()
    );
    Block SEQUOIA_HANGING_SIGN = create(
            "sequoia_hanging_sign",
            settings -> new MariposaHangingSignBlock(
                    settings,
                    SEQUOIA_WOOD_TYPE
            ), AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                    .mapColor(SEQUOIA_LOG.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()
    );
    Block SEQUOIA_WALL_HANGING_SIGN = create(
            "sequoia_wall_hanging_sign",
            settings -> new MariposaWallHangingSignBlock(
                    settings,
                    SEQUOIA_WOOD_TYPE
            ), AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
                    .mapColor(MapColor.OAK_TAN)
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .dropsLike(SEQUOIA_HANGING_SIGN)
                    //.lootTable(SEQUOIA_HANGING_SIGN.getLootTableKey())
                    .burnable()
    );
    Block SEQUOIA_PRESSURE_PLATE = createWithItem(
            "sequoia_pressure_plate",
            settings -> new PressurePlateBlock(
                    PressurePlateBlock.ActivationRule.EVERYTHING,
                    settings,
                    SEQUOIA_BLOCK_SET_TYPE
            ), AbstractBlock.Settings.create()
                    .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(0.5F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    Block SEQUOIA_TRAPDOOR = createWithItem(
            "sequoia_trapdoor",
            settings -> new TrapdoorBlock(
                    settings,
                    SEQUOIA_BLOCK_SET_TYPE
            ), AbstractBlock.Settings.create()
                    .mapColor(MapColor.RED)
                    .instrument(Instrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable()
    );
    Block SEQUOIA_STAIRS = createWithItem("sequoia_stairs",
            settings -> new StairsBlock(SEQUOIA_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(SEQUOIA_PLANKS));
    Block POTTED_SEQUOIA_SAPLING = create("potted_sequoia_sapling",
            settings -> new FlowerPotBlock(SEQUOIA_SAPLING, settings),
            createFlowerPotSettings());
    Block SEQUOIA_BUTTON = createWithItem("sequoia_button",
            settings -> new ButtonBlock(settings, SEQUOIA_BLOCK_SET_TYPE, 30, true),
            createButtonSettings());
    Block SEQUOIA_SLAB = createWithItem(
            "sequoia_slab",
            SlabBlock::new, AbstractBlock.Settings.create()
                    .mapColor(MapColor.RED)
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    Block SEQUOIA_FENCE_GATE = createWithItem(
            "sequoia_fence_gate",
            settings -> new FenceGateBlock(
                    settings,
                    SEQUOIA_WOOD_TYPE
            ), AbstractBlock.Settings.create().mapColor(SEQUOIA_PLANKS.getDefaultMapColor()).solid().instrument(Instrument.BASS).strength(2.0F, 3.0F).burnable()
    );
    Block SEQUOIA_FENCE = createWithItem(
            "sequoia_fence",
            FenceBlock::new, AbstractBlock.Settings.create()
                    .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable()
                    .sounds(BlockSoundGroup.WOOD)
    );
    Block SEQUOIA_DOOR = create(
            "sequoia_door",
            settings -> new DoorBlock(
                    settings,
                    SEQUOIA_BLOCK_SET_TYPE
            ), AbstractBlock.Settings.create()
                    .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                    .instrument(Instrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );


    //region settings creators
    @SuppressWarnings("SameParameterValue")
    private static AbstractBlock.Settings createLogSettings(MapColor topMapColor, MapColor sideMapColor) {
        return AbstractBlock.Settings.create()
                .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                .instrument(Instrument.BASS)
                .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
                .burnable();
    }

    @SuppressWarnings("SameParameterValue")
    private static AbstractBlock.Settings createLeavesSettings(BlockSoundGroup soundGroup) {
        return AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN)
                .strength(0.2F)
                .ticksRandomly()
                .sounds(soundGroup)
                .nonOpaque()
                .allowsSpawning(Blocks::canSpawnOnLeaves)
                .suffocates(Blocks::never)
                .blockVision(Blocks::never)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY)
                .solidBlock(Blocks::never);
    }

    private static AbstractBlock.Settings createFlowerPotSettings() {
        return AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    }

    private static AbstractBlock.Settings createButtonSettings() {
        return AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY);
    }
    //endregion

    static Block create(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return Registry.register(Registries.BLOCK, Mariposa.id(name), factory.apply(settings));
    }

    static Block createWithItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = create(name, factory, settings);
        MariposaItems.create(name, itemSettings -> new BlockItem(block, itemSettings), new Item.Settings());
        return block;
    }

    static void initialize() {
        StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
        StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_LOG, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
        FabricBlockEntityTypeBuilder.create(BlockEntityType.SIGN::instantiate).addBlocks(
                MariposaBlocks.SEQUOIA_SIGN,
                MariposaBlocks.SEQUOIA_WALL_SIGN
        );
        FabricBlockEntityTypeBuilder.create(BlockEntityType.HANGING_SIGN::instantiate).addBlocks(
                MariposaBlocks.SEQUOIA_HANGING_SIGN,
                MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN
        );
    }
}
