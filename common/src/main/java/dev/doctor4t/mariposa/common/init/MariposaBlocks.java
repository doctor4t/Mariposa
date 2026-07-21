package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.references.MariposaBlockIds;
import dev.doctor4t.mariposa.common.references.MariposaBlockItemIds;
import dev.doctor4t.mariposa.common.world.level.block.SequoiaLeavesBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;
import java.util.function.Function;

import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;

public interface MariposaBlocks {
	BlockSetType SEQUOIA_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Mariposa.id("sequoia"));
	WoodType SEQUOIA_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(Mariposa.id("sequoia"), SEQUOIA_BLOCK_SET_TYPE);
	TreeGrower SEQUOIA_SAPLING_GENERATOR = new TreeGrower(
			"sequoia",
			0.5F,
			Optional.of(MariposaConfiguredFeatures.SEQUOIA),
			Optional.empty(),
			Optional.empty(),
			Optional.empty(),
			Optional.empty(),
			Optional.empty()
	);

	Block SEQUOIA_SAPLING = registerWithItem(MariposaBlockItemIds.SEQUOIA_SAPLING, properties -> new SaplingBlock(SEQUOIA_SAPLING_GENERATOR, properties), of()
			.mapColor(MapColor.PLANT)
			.noCollision()
			.randomTicks()
			.instabreak()
			.sound(SoundType.GRASS)
			.pushReaction(PushReaction.DESTROY)
	);
	Block POTTED_SEQUOIA_SAPLING = register(MariposaBlockIds.POTTED_SEQUOIA_SAPLING, properties -> new FlowerPotBlock(SEQUOIA_SAPLING, properties), Blocks.flowerPotProperties());
	Block SEQUOIA_LOG = registerWithItem(MariposaBlockItemIds.SEQUOIA_LOG, RotatedPillarBlock::new, Blocks.logProperties(MapColor.COLOR_RED, MapColor.COLOR_BROWN, SoundType.WOOD));
	Block SEQUOIA_WOOD = registerWithItem(MariposaBlockItemIds.SEQUOIA_WOOD, RotatedPillarBlock::new, of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sound(SoundType.WOOD)
			.ignitedByLava());
	Block STRIPPED_SEQUOIA_LOG = registerWithItem(MariposaBlockItemIds.STRIPPED_SEQUOIA_LOG, RotatedPillarBlock::new, Blocks.logProperties(MapColor.COLOR_RED, MapColor.COLOR_RED, SoundType.WOOD));
	Block STRIPPED_SEQUOIA_WOOD = registerWithItem(MariposaBlockItemIds.STRIPPED_SEQUOIA_WOOD, RotatedPillarBlock::new, of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sound(SoundType.WOOD)
			.ignitedByLava());
	Block STACKED_SEQUOIA_LOGS = registerWithItem(MariposaBlockItemIds.STACKED_SEQUOIA_LOGS, RotatedPillarBlock::new, Blocks.logProperties(MapColor.COLOR_RED, MapColor.COLOR_BROWN, SoundType.WOOD));
	Block SEQUOIA_LEAVES = registerWithItem(MariposaBlockItemIds.SEQUOIA_LEAVES, properties -> new SequoiaLeavesBlock(0.01F, properties), Blocks.leavesProperties(SoundType.GRASS));
	Block SEQUOIA_PLANKS = registerWithItem(MariposaBlockItemIds.SEQUOIA_PLANKS, Block::new, of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.sound(SoundType.WOOD)
			.ignitedByLava()
	);
	Block SEQUOIA_STAIRS = registerWithItem(MariposaBlockItemIds.SEQUOIA_STAIRS, properties -> new StairBlock(SEQUOIA_PLANKS.defaultBlockState(), properties), ofFullCopy(SEQUOIA_PLANKS));
	Block SEQUOIA_SLAB = registerWithItem(MariposaBlockItemIds.SEQUOIA_SLAB, SlabBlock::new, of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.sound(SoundType.WOOD)
			.ignitedByLava()
	);
	Block SEQUOIA_FENCE = registerWithItem(MariposaBlockItemIds.SEQUOIA_FENCE, FenceBlock::new, of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.ignitedByLava()
			.sound(SoundType.WOOD)
	);
	Block SEQUOIA_FENCE_GATE = registerWithItem(MariposaBlockItemIds.SEQUOIA_FENCE_GATE, properties -> new FenceGateBlock(SEQUOIA_WOOD_TYPE, properties), of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.ignitedByLava()
	);
	Block SEQUOIA_DOOR = register(MariposaBlockItemIds.SEQUOIA_DOOR, properties -> new DoorBlock(SEQUOIA_BLOCK_SET_TYPE, properties), of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.noOcclusion()
			.ignitedByLava()
			.pushReaction(PushReaction.DESTROY)
	);
	Block SEQUOIA_TRAPDOOR = registerWithItem(MariposaBlockItemIds.SEQUOIA_TRAPDOOR, properties -> new TrapDoorBlock(SEQUOIA_BLOCK_SET_TYPE, properties), of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.noOcclusion()
			.isValidSpawn(Blocks::never)
			.ignitedByLava()
	);
	Block SEQUOIA_PRESSURE_PLATE = registerWithItem(MariposaBlockItemIds.SEQUOIA_PRESSURE_PLATE, properties -> new PressurePlateBlock(SEQUOIA_BLOCK_SET_TYPE, properties), of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(0.5F)
			.ignitedByLava()
			.pushReaction(PushReaction.DESTROY)
	);
	Block SEQUOIA_BUTTON = registerWithItem(MariposaBlockItemIds.SEQUOIA_BUTTON, properties -> new ButtonBlock(SEQUOIA_BLOCK_SET_TYPE, 30, properties), Blocks.buttonProperties());
	Block SEQUOIA_SHELF = registerWithItem(MariposaBlockItemIds.SEQUOIA_SHELF, ShelfBlock::new, of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.sound(SoundType.SHELF)
			.strength(2, 3)
			.ignitedByLava());
	Block SEQUOIA_SIGN = register(MariposaBlockItemIds.SEQUOIA_SIGN, properties -> new StandingSignBlock(SEQUOIA_WOOD_TYPE, properties), of()
			.mapColor(SEQUOIA_LOG.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.ignitedByLava()
	);
	Block SEQUOIA_WALL_SIGN = register(MariposaBlockIds.SEQUOIA_WALL_SIGN, properties -> new WallSignBlock(SEQUOIA_WOOD_TYPE, properties), of()
			.mapColor(SEQUOIA_LOG.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.overrideLootTable(SEQUOIA_SIGN.getLootTable())
			.ignitedByLava()
	);
	Block SEQUOIA_HANGING_SIGN = register(MariposaBlockItemIds.SEQUOIA_HANGING_SIGN, properties -> new CeilingHangingSignBlock(SEQUOIA_WOOD_TYPE, properties), of()
			.mapColor(SEQUOIA_LOG.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.ignitedByLava()
	);
	Block SEQUOIA_WALL_HANGING_SIGN = register(MariposaBlockIds.SEQUOIA_WALL_HANGING_SIGN, properties -> new WallHangingSignBlock(SEQUOIA_WOOD_TYPE, properties), of()
			.mapColor(MapColor.WOOD)
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.overrideLootTable(SEQUOIA_HANGING_SIGN.getLootTable())
			.ignitedByLava()
	);

	private static Block register(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
		return Blocks.register(key, factory, properties);
	}

	private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
		return register(id.block(), factory, properties);
	}

	private static Block registerWithItem(BlockItemId id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
		Block block = register(id, factory, properties);
		MariposaItems.register(id.item(), itemProperties -> new BlockItem(block, itemProperties), new Item.Properties().useBlockDescriptionPrefix());
		return block;
	}

	static void initialize() {
		StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
		StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_LOG, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
		BlockEntityTypes.SHELF.addValidBlock(SEQUOIA_SHELF);
		BlockEntityTypes.SIGN.addValidBlock(MariposaBlocks.SEQUOIA_SIGN);
		BlockEntityTypes.SIGN.addValidBlock(MariposaBlocks.SEQUOIA_WALL_SIGN);
		BlockEntityTypes.HANGING_SIGN.addValidBlock(MariposaBlocks.SEQUOIA_HANGING_SIGN);
		BlockEntityTypes.HANGING_SIGN.addValidBlock(MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN);
	}
}
