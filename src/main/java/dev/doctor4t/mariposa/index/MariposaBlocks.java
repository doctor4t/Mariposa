package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.tree.SequoiaSaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public interface MariposaBlocks {
    BlockSetType SEQUOIA_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Mariposa.id("sequoia"));
    WoodType SEQUOIA_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(Mariposa.id("sequoia"), SEQUOIA_BLOCK_SET_TYPE);
    SaplingGenerator SEQUOIA_SAPLING_GENERATOR = new SequoiaSaplingGenerator();
//    SaplingGenerator SEQUOIA_SAPLING_GENERATOR = new SaplingGenerator(
//            "sequoia",
//            0.5F,
//            Optional.of(MariposaConfiguredFeatures.SEQUOIA),
//            Optional.empty(),
//            Optional.empty(),
//            Optional.empty(),
//            Optional.empty(),
//            Optional.empty()
//    );
    Block SEQUOIA_PLANKS = createWithItem(
            "sequoia_planks",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.RED)
                            .instrument(Instrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            )
    );
    Block SEQUOIA_SAPLING = createWithItem(
            "sequoia_sapling",
            new SaplingBlock(
                    SEQUOIA_SAPLING_GENERATOR,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_GREEN)
                            .noCollision()
                            .ticksRandomly()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.GRASS)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );
    Block SEQUOIA_LOG = createWithItem("sequoia_log", Blocks.createLogBlock(MapColor.RED, MapColor.BROWN));
    Block STACKED_SEQUOIA_LOGS = createWithItem("stacked_sequoia_logs", Blocks.createLogBlock(MapColor.RED, MapColor.BROWN));
    Block STRIPPED_SEQUOIA_LOG = createWithItem("stripped_sequoia_log", Blocks.createLogBlock(MapColor.RED, MapColor.RED));
    Block SEQUOIA_WOOD = createWithItem(
            "sequoia_wood",
            new PillarBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.RED).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()
            )
    );
    Block STRIPPED_SEQUOIA_WOOD = createWithItem(
            "stripped_sequoia_wood",
            new PillarBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.RED).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()
            )
    );
    Block SEQUOIA_LEAVES = createWithItem("sequoia_leaves", Blocks.createLeavesBlock(BlockSoundGroup.GRASS));
    Block SEQUOIA_SIGN = create(
            "sequoia_sign",
            new SignBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(SEQUOIA_LOG.getDefaultMapColor())
                            .solid()
                            .instrument(Instrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .burnable(),
                    SEQUOIA_WOOD_TYPE
            )
    );
    Block SEQUOIA_WALL_SIGN = create(
            "sequoia_wall_sign",
            new WallSignBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(SEQUOIA_LOG.getDefaultMapColor())
                            .solid()
                            .instrument(Instrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .dropsLike(SEQUOIA_SIGN)
                            .burnable(),
                    SEQUOIA_WOOD_TYPE
            )
    );
    Block SEQUOIA_HANGING_SIGN = create(
            "sequoia_hanging_sign",
            new HangingSignBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(SEQUOIA_LOG.getDefaultMapColor())
                            .solid()
                            .instrument(Instrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .burnable(),
                    SEQUOIA_WOOD_TYPE
            )
    );
    Block SEQUOIA_WALL_HANGING_SIGN = create(
            "sequoia_wall_hanging_sign",
            new WallHangingSignBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.OAK_TAN)
                            .solid()
                            .instrument(Instrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .dropsLike(SEQUOIA_HANGING_SIGN)
                            .burnable(),
                    SEQUOIA_WOOD_TYPE
            )
    );
    Block SEQUOIA_PRESSURE_PLATE = createWithItem(
            "sequoia_pressure_plate",
            new PressurePlateBlock(
                    PressurePlateBlock.ActivationRule.EVERYTHING,
                    AbstractBlock.Settings.create()
                            .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(Instrument.BASS)
                            .noCollision()
                            .strength(0.5F)
                            .burnable()
                            .pistonBehavior(PistonBehavior.DESTROY),
                    SEQUOIA_BLOCK_SET_TYPE
            )
    );
    Block SEQUOIA_TRAPDOOR = createWithItem(
            "sequoia_trapdoor",
            new TrapdoorBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.RED)
                            .instrument(Instrument.BASS)
                            .strength(3.0F)
                            .nonOpaque()
                            .allowsSpawning(Blocks::never)
                            .burnable(),
                    SEQUOIA_BLOCK_SET_TYPE
            )
    );
    Block SEQUOIA_STAIRS = createWithItem("sequoia_stairs", createStairsBlock(SEQUOIA_PLANKS));
    Block POTTED_SEQUOIA_SAPLING = create("potted_sequoia_sapling", Blocks.createFlowerPotBlock(SEQUOIA_SAPLING));
    Block SEQUOIA_BUTTON = createWithItem("sequoia_button", Blocks.createWoodenButtonBlock(SEQUOIA_BLOCK_SET_TYPE));
    Block SEQUOIA_SLAB = createWithItem(
            "sequoia_slab",
            new SlabBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.RED)
                            .instrument(Instrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            )
    );
    Block SEQUOIA_FENCE_GATE = createWithItem(
            "sequoia_fence_gate",
            new FenceGateBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(Instrument.BASS)
                            .strength(2.0F, 3.0F)
                            .burnable(),
                    SEQUOIA_WOOD_TYPE
            )
    );
    Block SEQUOIA_FENCE = createWithItem(
            "sequoia_fence",
            new FenceBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                            .instrument(Instrument.BASS)
                            .strength(2.0F, 3.0F)
                            .burnable()
                            .sounds(BlockSoundGroup.WOOD)
            )
    );
    Block SEQUOIA_DOOR = create(
            "sequoia_door",
            new DoorBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                            .instrument(Instrument.BASS)
                            .strength(3.0F)
                            .nonOpaque()
                            .burnable()
                            .pistonBehavior(PistonBehavior.DESTROY),
                    SEQUOIA_BLOCK_SET_TYPE
            )
    );

    static <T extends Block> T create(String name, T block) {
        return Registry.register(Registries.BLOCK, Mariposa.id(name), block);
    }

    static <T extends Block> T createWithItem(String name, T block) {
        return createWithItem(name, block, new Item.Settings());
    }

    static <T extends Block> T createWithItem(String name, T block, Item.Settings settings) {
        return createWithItem(name, block, b -> new BlockItem(b, settings));
    }

    static <T extends Block> T createWithItem(String name, T block, Function<T, BlockItem> itemGenerator) {
        MariposaItems.create(name, itemGenerator.apply(block));
        return MariposaBlocks.create(name, block);
    }

    private static Block createStairsBlock(Block base) {
        return new StairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base));
    }

    static void initialize() {
        StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
        StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_LOG, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
//        BlockEntityType.SIGN.addSupportedBlock(MariposaBlocks.SEQUOIA_SIGN);
//        BlockEntityType.SIGN.addSupportedBlock(MariposaBlocks.SEQUOIA_WALL_SIGN);
//        BlockEntityType.HANGING_SIGN.addSupportedBlock(MariposaBlocks.SEQUOIA_HANGING_SIGN);
//        BlockEntityType.HANGING_SIGN.addSupportedBlock(MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN);
    }
}
