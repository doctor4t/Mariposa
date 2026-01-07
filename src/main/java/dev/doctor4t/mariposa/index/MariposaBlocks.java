package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.block.SequoiaLeavesBlock;
import dev.doctor4t.mariposa.datagen.MariposaConfiguredFeatures;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;

import java.util.Optional;
import java.util.function.Function;

import static net.minecraft.block.AbstractBlock.Settings.copy;
import static net.minecraft.block.AbstractBlock.Settings.create;

public interface MariposaBlocks {
    BlockSetType SEQUOIA_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Mariposa.id("sequoia"));
    WoodType SEQUOIA_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(Mariposa.id("sequoia"), SEQUOIA_BLOCK_SET_TYPE);
    SaplingGenerator SEQUOIA_SAPLING_GENERATOR = new SaplingGenerator(
            "sequoia",
            0.5F,
            Optional.of(MariposaConfiguredFeatures.SEQUOIA),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
    );

	Block SEQUOIA_SAPLING = registerWithItem("sequoia_sapling", settings -> new SaplingBlock(SEQUOIA_SAPLING_GENERATOR, settings), create()
					.mapColor(MapColor.DARK_GREEN)
					.noCollision()
					.ticksRandomly()
					.breakInstantly()
					.sounds(BlockSoundGroup.GRASS)
					.pistonBehavior(PistonBehavior.DESTROY)
	);
	Block POTTED_SEQUOIA_SAPLING = register("potted_sequoia_sapling", settings -> new FlowerPotBlock(SEQUOIA_SAPLING, settings), Blocks.createFlowerPotSettings());
	Block SEQUOIA_LOG = registerWithItem("sequoia_log", PillarBlock::new, Blocks.createLogSettings(MapColor.RED, MapColor.BROWN, BlockSoundGroup.WOOD));
	Block SEQUOIA_WOOD = registerWithItem("sequoia_wood", PillarBlock::new, create()
			.mapColor(MapColor.RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sounds(BlockSoundGroup.WOOD)
			.burnable());
	Block STRIPPED_SEQUOIA_LOG = registerWithItem("stripped_sequoia_log", PillarBlock::new, Blocks.createLogSettings(MapColor.RED, MapColor.RED, BlockSoundGroup.WOOD));
	Block STRIPPED_SEQUOIA_WOOD = registerWithItem("stripped_sequoia_wood", PillarBlock::new, create()
			.mapColor(MapColor.RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sounds(BlockSoundGroup.WOOD)
			.burnable());
	Block STACKED_SEQUOIA_LOGS = registerWithItem("stacked_sequoia_logs", PillarBlock::new, Blocks.createLogSettings(MapColor.RED, MapColor.BROWN, BlockSoundGroup.WOOD));
	Block SEQUOIA_LEAVES = registerWithItem("sequoia_leaves", settings -> new SequoiaLeavesBlock(0.01F, settings), Blocks.createLeavesSettings(BlockSoundGroup.GRASS));
	Block SEQUOIA_PLANKS = registerWithItem("sequoia_planks", Block::new, create()
			.mapColor(MapColor.RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.sounds(BlockSoundGroup.WOOD)
			.burnable()
    );
	Block SEQUOIA_STAIRS = registerWithItem("sequoia_stairs", settings -> new StairsBlock(SEQUOIA_PLANKS.getDefaultState(), settings), copy(SEQUOIA_PLANKS));
	Block SEQUOIA_SLAB = registerWithItem("sequoia_slab", SlabBlock::new, create()
			.mapColor(MapColor.RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.sounds(BlockSoundGroup.WOOD)
			.burnable()
	);
	Block SEQUOIA_FENCE = registerWithItem("sequoia_fence", FenceBlock::new, create()
			.mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.burnable()
			.sounds(BlockSoundGroup.WOOD)
	);
	Block SEQUOIA_FENCE_GATE = registerWithItem("sequoia_fence_gate", settings -> new FenceGateBlock(SEQUOIA_WOOD_TYPE, settings), create()
			.mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.burnable()
	);
	Block SEQUOIA_DOOR = register("sequoia_door", settings -> new DoorBlock(SEQUOIA_BLOCK_SET_TYPE, settings), create()
			.mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.nonOpaque()
			.burnable()
			.pistonBehavior(PistonBehavior.DESTROY)
	);
	Block SEQUOIA_TRAPDOOR = registerWithItem("sequoia_trapdoor", settings -> new TrapdoorBlock(SEQUOIA_BLOCK_SET_TYPE, settings), create()
			.mapColor(MapColor.RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.nonOpaque()
			.allowsSpawning(Blocks::never)
			.burnable()
	);
	Block SEQUOIA_PRESSURE_PLATE = registerWithItem("sequoia_pressure_plate", settings -> new PressurePlateBlock(SEQUOIA_BLOCK_SET_TYPE, settings), create()
			.mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(0.5F)
			.burnable()
			.pistonBehavior(PistonBehavior.DESTROY)
	);
	Block SEQUOIA_BUTTON = registerWithItem("sequoia_button", settings -> new ButtonBlock(SEQUOIA_BLOCK_SET_TYPE, 30, settings), Blocks.createButtonSettings());
    Block SEQUOIA_SIGN = register("sequoia_sign", settings -> new SignBlock(SEQUOIA_WOOD_TYPE, settings), create()
			.mapColor(SEQUOIA_LOG.getDefaultMapColor())
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.burnable()
    );
    Block SEQUOIA_WALL_SIGN = register("sequoia_wall_sign", settings -> new WallSignBlock(SEQUOIA_WOOD_TYPE, settings), create()
			.mapColor(SEQUOIA_LOG.getDefaultMapColor())
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.lootTable(SEQUOIA_SIGN.getLootTableKey())
			.burnable()
    );
    Block SEQUOIA_HANGING_SIGN = register("sequoia_hanging_sign", settings -> new HangingSignBlock(SEQUOIA_WOOD_TYPE, settings), create()
			.mapColor(SEQUOIA_LOG.getDefaultMapColor())
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.burnable()
    );
    Block SEQUOIA_WALL_HANGING_SIGN = register("sequoia_wall_hanging_sign", settings -> new WallHangingSignBlock(SEQUOIA_WOOD_TYPE, settings), create()
			.mapColor(MapColor.OAK_TAN)
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.lootTable(SEQUOIA_HANGING_SIGN.getLootTableKey())
			.burnable()
    );

    static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return Blocks.register(RegistryKey.of(RegistryKeys.BLOCK, Mariposa.id(name)), factory, settings);
    }

    static Block registerWithItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = register(name, factory, settings);
        MariposaItems.register(name, itemSettings -> new BlockItem(block, itemSettings), new Item.Settings().useBlockPrefixedTranslationKey());
        return block;
    }

    static void initialize() {
        StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
        StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_LOG, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
        BlockEntityType.SIGN.addSupportedBlock(MariposaBlocks.SEQUOIA_SIGN);
        BlockEntityType.SIGN.addSupportedBlock(MariposaBlocks.SEQUOIA_WALL_SIGN);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(MariposaBlocks.SEQUOIA_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN);
    }
}
