/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common;

import dev.doctor4t.mariposa.common.init.MariposaBlocks;
import dev.doctor4t.mariposa.common.init.MariposaEntityTypes;
import dev.doctor4t.mariposa.common.init.MariposaItems;
import dev.doctor4t.mariposa.common.init.MariposaWorldgenFeatures;
import dev.doctor4t.mariposa.common.world.level.levelgen.MariposaRegion;
import dev.doctor4t.mariposa.common.world.level.levelgen.MariposaSurfaceRuleData;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class Mariposa implements ModInitializer, TerraBlenderApi {
	public static final String MOD_ID = "mariposa";

	public static Identifier id(String string) {
		return Identifier.fromNamespaceAndPath(MOD_ID, string);
	}

	@Override
	public void onInitialize() {
		MariposaItems.initialize();
		MariposaBlocks.initialize();
		MariposaEntityTypes.initialize();
		MariposaWorldgenFeatures.initialize();
	}

	@Override
	public void onTerraBlenderInitialized() {
		// Weights are kept intentionally low as we add minimal biomes
		Regions.register(new MariposaRegion(id("overworld"), 4));

		// Register our surface rules
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, MariposaSurfaceRuleData.makeRules());
	}
}