package dev.doctor4t.mariposa.common.world.level.levelgen;

import dev.doctor4t.mariposa.common.init.MariposaBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.material.condition.MaterialCondition;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class MariposaMaterialRuleData {
	private static final MaterialRule DIRT = makeStateRule(Blocks.DIRT);
	private static final MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
	private static final MaterialRule PODZOL = makeStateRule(Blocks.PODZOL);
	private static final MaterialRule COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
	private static final MaterialRule SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
	private static final MaterialCondition ON_FLOOR = MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR);
	private static final MaterialCondition STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH = MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR);

	public static MaterialRule makeRules(HolderGetter<Biome> biomes) {
		return MaterialRules.sequence(
				// redwood forest
				MaterialRules.ifTrue(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH,
						MaterialRules.ifTrue(MaterialRules.isBiome(biomes, MariposaBiomes.REDWOOD_FOREST),
								MaterialRules.ifTrue(surfaceNoiseThreshold(1.75), COARSE_DIRT))),
				MaterialRules.ifTrue(ON_FLOOR,
						MaterialRules.ifTrue(MaterialRules.waterBlockCheck(0, 0),
								MaterialRules.ifTrue(MaterialRules.isBiome(biomes, MariposaBiomes.REDWOOD_FOREST), MaterialRules.sequence(
										MaterialRules.ifTrue(surfaceNoiseThreshold(-.95), PODZOL),
										GRASS_BLOCK
								)))),
				MaterialRules.ifTrue(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH, MaterialRules.ifTrue(MaterialRules.isBiome(biomes, MariposaBiomes.REDWOOD_FOREST), DIRT)),

				// snowy redwood forest
				MaterialRules.ifTrue(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH,
						MaterialRules.ifTrue(MaterialRules.isBiome(biomes, MariposaBiomes.SNOWY_REDWOOD_FOREST),
								MaterialRules.ifTrue(surfaceNoiseThreshold(1.75), SNOW_BLOCK))),
				MaterialRules.ifTrue(ON_FLOOR,
						MaterialRules.ifTrue(MaterialRules.waterBlockCheck(0, 0),
								MaterialRules.ifTrue(MaterialRules.isBiome(biomes, MariposaBiomes.SNOWY_REDWOOD_FOREST), MaterialRules.sequence(
										MaterialRules.ifTrue(surfaceNoiseThreshold(-.95), SNOW_BLOCK),
										GRASS_BLOCK
								)))),
				MaterialRules.ifTrue(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH, MaterialRules.ifTrue(MaterialRules.isBiome(biomes, MariposaBiomes.SNOWY_REDWOOD_FOREST), DIRT))
		);
	}

	private static MaterialRule makeStateRule(Block block) {
		return MaterialRules.state(block.defaultBlockState());
	}

	private static MaterialCondition surfaceNoiseThreshold(double min) {
		return MaterialRules.noiseCondition2d(Noises.SURFACE, min / 8.25);
	}
}
