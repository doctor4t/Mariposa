package dev.doctor4t.mariposa.common;

import dev.doctor4t.mariposa.common.init.MariposaBlocks;
import dev.doctor4t.mariposa.common.init.MariposaEntityTypes;
import dev.doctor4t.mariposa.common.init.MariposaFeatureTypes;
import dev.doctor4t.mariposa.common.init.MariposaItems;
import dev.doctor4t.mariposa.common.world.level.levelgen.MariposaMaterialRuleData;
import dev.doctor4t.mariposa.common.world.level.levelgen.MariposaRegion;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import terrablender.api.MaterialRuleManager;
import terrablender.api.Regions;

public class Mariposa implements ModInitializer {
	public static final String MOD_ID = "mariposa";

	public static Identifier id(String string) {
		return Identifier.fromNamespaceAndPath(MOD_ID, string);
	}

	@Override
	public void onInitialize() {
		MariposaItems.initialize();
		MariposaBlocks.initialize();
		MariposaEntityTypes.initialize();
		MariposaFeatureTypes.initialize();
		MariposaService.INSTANCE.initTerraBlender();
	}

	public static void initTerraBlender() {
		// Weights are kept intentionally low as we add minimal biomes
		Regions.register(new MariposaRegion(id("overworld"), 4));

		// Register our surface rules
		MaterialRuleManager.addRules(MaterialRuleManager.RuleCategory.OVERWORLD, MOD_ID, MariposaMaterialRuleData::makeRules);
	}
}
