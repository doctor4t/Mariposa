/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.world.level.block.SequoiaLeavesBlock;
import dev.doctor4t.mariposa.data.provider.MariposaConfiguredFeatures;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
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

	Block SEQUOIA_SAPLING = registerWithItem("sequoia_sapling", settings -> new SaplingBlock(SEQUOIA_SAPLING_GENERATOR, settings), of()
			.mapColor(MapColor.PLANT)
			.noCollision()
			.randomTicks()
			.instabreak()
			.sound(SoundType.GRASS)
			.pushReaction(PushReaction.DESTROY)
	);
	Block POTTED_SEQUOIA_SAPLING = register("potted_sequoia_sapling", settings -> new FlowerPotBlock(SEQUOIA_SAPLING, settings), Blocks.flowerPotProperties());
	Block SEQUOIA_LOG = registerWithItem("sequoia_log", RotatedPillarBlock::new, Blocks.logProperties(MapColor.COLOR_RED, MapColor.COLOR_BROWN, SoundType.WOOD));
	Block SEQUOIA_WOOD = registerWithItem("sequoia_wood", RotatedPillarBlock::new, of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sound(SoundType.WOOD)
			.ignitedByLava());
	Block STRIPPED_SEQUOIA_LOG = registerWithItem("stripped_sequoia_log", RotatedPillarBlock::new, Blocks.logProperties(MapColor.COLOR_RED, MapColor.COLOR_RED, SoundType.WOOD));
	Block STRIPPED_SEQUOIA_WOOD = registerWithItem("stripped_sequoia_wood", RotatedPillarBlock::new, of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sound(SoundType.WOOD)
			.ignitedByLava());
	Block STACKED_SEQUOIA_LOGS = registerWithItem("stacked_sequoia_logs", RotatedPillarBlock::new, Blocks.logProperties(MapColor.COLOR_RED, MapColor.COLOR_BROWN, SoundType.WOOD));
	Block SEQUOIA_LEAVES = registerWithItem("sequoia_leaves", settings -> new SequoiaLeavesBlock(0.01F, settings), Blocks.leavesProperties(SoundType.GRASS));
	Block SEQUOIA_PLANKS = registerWithItem("sequoia_planks", Block::new, of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.sound(SoundType.WOOD)
			.ignitedByLava()
	);
	Block SEQUOIA_STAIRS = registerWithItem("sequoia_stairs", settings -> new StairBlock(SEQUOIA_PLANKS.defaultBlockState(), settings), ofFullCopy(SEQUOIA_PLANKS));
	Block SEQUOIA_SLAB = registerWithItem("sequoia_slab", SlabBlock::new, of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.sound(SoundType.WOOD)
			.ignitedByLava()
	);
	Block SEQUOIA_FENCE = registerWithItem("sequoia_fence", FenceBlock::new, of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.ignitedByLava()
			.sound(SoundType.WOOD)
	);
	Block SEQUOIA_FENCE_GATE = registerWithItem("sequoia_fence_gate", settings -> new FenceGateBlock(SEQUOIA_WOOD_TYPE, settings), of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.ignitedByLava()
	);
	Block SEQUOIA_DOOR = register("sequoia_door", settings -> new DoorBlock(SEQUOIA_BLOCK_SET_TYPE, settings), of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.noOcclusion()
			.ignitedByLava()
			.pushReaction(PushReaction.DESTROY)
	);
	Block SEQUOIA_TRAPDOOR = registerWithItem("sequoia_trapdoor", settings -> new TrapDoorBlock(SEQUOIA_BLOCK_SET_TYPE, settings), of()
			.mapColor(MapColor.COLOR_RED)
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.noOcclusion()
			.isValidSpawn(Blocks::never)
			.ignitedByLava()
	);
	Block SEQUOIA_PRESSURE_PLATE = registerWithItem("sequoia_pressure_plate", settings -> new PressurePlateBlock(SEQUOIA_BLOCK_SET_TYPE, settings), of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(0.5F)
			.ignitedByLava()
			.pushReaction(PushReaction.DESTROY)
	);
	Block SEQUOIA_BUTTON = registerWithItem("sequoia_button", settings -> new ButtonBlock(SEQUOIA_BLOCK_SET_TYPE, 30, settings), Blocks.buttonProperties());
	Block SEQUOIA_SHELF = registerWithItem("sequoia_shelf", ShelfBlock::new, of()
			.mapColor(SEQUOIA_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.sound(SoundType.SHELF)
			.strength(2, 3)
			.ignitedByLava());
	Block SEQUOIA_SIGN = register("sequoia_sign", settings -> new StandingSignBlock(SEQUOIA_WOOD_TYPE, settings), of()
			.mapColor(SEQUOIA_LOG.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.ignitedByLava()
	);
	Block SEQUOIA_WALL_SIGN = register("sequoia_wall_sign", settings -> new WallSignBlock(SEQUOIA_WOOD_TYPE, settings), of()
			.mapColor(SEQUOIA_LOG.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.overrideLootTable(SEQUOIA_SIGN.getLootTable())
			.ignitedByLava()
	);
	Block SEQUOIA_HANGING_SIGN = register("sequoia_hanging_sign", settings -> new CeilingHangingSignBlock(SEQUOIA_WOOD_TYPE, settings), of()
			.mapColor(SEQUOIA_LOG.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.ignitedByLava()
	);
	Block SEQUOIA_WALL_HANGING_SIGN = register("sequoia_wall_hanging_sign", settings -> new WallHangingSignBlock(SEQUOIA_WOOD_TYPE, settings), of()
			.mapColor(MapColor.WOOD)
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1)
			.overrideLootTable(SEQUOIA_HANGING_SIGN.getLootTable())
			.ignitedByLava()
	);

	static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
		return Blocks.register(ResourceKey.create(Registries.BLOCK, Mariposa.id(name)), factory, settings);
	}

	static Block registerWithItem(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
		Block block = register(name, factory, settings);
		MariposaItems.register(name, itemSettings -> new BlockItem(block, itemSettings), new net.minecraft.world.item.Item.Properties().useBlockDescriptionPrefix());
		return block;
	}

	static void initialize() {
		StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
		StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_LOG, MariposaBlocks.STRIPPED_SEQUOIA_LOG);
		BlockEntityType.SHELF.addValidBlock(SEQUOIA_SHELF);
		BlockEntityType.SIGN.addValidBlock(MariposaBlocks.SEQUOIA_SIGN);
		BlockEntityType.SIGN.addValidBlock(MariposaBlocks.SEQUOIA_WALL_SIGN);
		BlockEntityType.HANGING_SIGN.addValidBlock(MariposaBlocks.SEQUOIA_HANGING_SIGN);
		BlockEntityType.HANGING_SIGN.addValidBlock(MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN);
	}
}
