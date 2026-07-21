/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

/**
 * Copyright (C) Glitchfiend
 * <p>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public interface MariposaBiomes {
	ResourceKey<Biome> REDWOOD_FOREST = key("redwood_forest");
	ResourceKey<Biome> SNOWY_REDWOOD_FOREST = key("snowy_redwood_forest");

	private static ResourceKey<Biome> key(String name) {
		return ResourceKey.create(Registries.BIOME, Mariposa.id(name));
	}

	private static Biome redwoodForest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> carvers, boolean snowy) {
		MobSpawnSettings.Builder mobs = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobs);
		BiomeDefaultFeatures.farmAnimals(mobs);
		mobs.addSpawn(MobCategory.CREATURE, 8, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 4, 4));
		mobs.addSpawn(MobCategory.CREATURE, 4, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 3));
		mobs.addSpawn(MobCategory.CREATURE, 8, new MobSpawnSettings.SpawnerData(EntityType.FOX, 2, 4));

		BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(placedFeatures, carvers);
		OverworldBiomes.globalOverworldGeneration(generation);
		BiomeDefaultFeatures.addMossyStoneBlock(generation);
		BiomeDefaultFeatures.addFerns(generation);
		BiomeDefaultFeatures.addDefaultOres(generation);
		BiomeDefaultFeatures.addDefaultSoftDisks(generation);
		BiomeDefaultFeatures.addDefaultFlowers(generation);
		BiomeDefaultFeatures.addGiantTaigaVegetation(generation);
		BiomeDefaultFeatures.addDefaultMushrooms(generation);
		generation.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MariposaPlacedFeatures.GIANT_SEQUOIA_TREE);
		generation.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MariposaPlacedFeatures.FALLEN_SEQUOIA_LOG);
		if (!snowy) {
			generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_FIREFLY_BUSH_NEAR_WATER);
		}
		generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, snowy ? MariposaPlacedFeatures.TREES_SNOWY_REDWOOD_FOREST : MariposaPlacedFeatures.TREES_REDWOOD_FOREST);
		return OverworldBiomes.baseBiome(snowy ? -0.5F : 0.5F, 0.8F)
				.setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA))
				.mobSpawnSettings(mobs.build())
				.generationSettings(generation.build())
				.build();
	}

	static void bootstrap(BootstrapContext<Biome> registry) {
		HolderGetter<PlacedFeature> placedFeatures = registry.lookup(Registries.PLACED_FEATURE);
		HolderGetter<ConfiguredWorldCarver<?>> carvers = registry.lookup(Registries.CONFIGURED_CARVER);
		registry.register(REDWOOD_FOREST, redwoodForest(placedFeatures, carvers, false));
		registry.register(SNOWY_REDWOOD_FOREST, redwoodForest(placedFeatures, carvers, true));
	}
}
