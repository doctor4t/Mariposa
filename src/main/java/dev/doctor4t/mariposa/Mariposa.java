package dev.doctor4t.mariposa;

import dev.doctor4t.mariposa.index.MariposaBlocks;
import dev.doctor4t.mariposa.index.MariposaItems;
import dev.doctor4t.mariposa.index.MariposaWorldgenFeatures;
import dev.doctor4t.mariposa.world.gen.MariposaRegion;
import dev.doctor4t.mariposa.world.gen.MariposaSurfaceRuleData;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class Mariposa implements ModInitializer, TerraBlenderApi {
    public static final String MOD_ID = "mariposa";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String string) {
        return Identifier.of(MOD_ID, string);
    }

    @Override
    public void onInitialize() {
        MariposaItems.initialize();
        MariposaBlocks.initialize();
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