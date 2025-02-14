package dev.doctor4t.redwood;

import dev.doctor4t.redwood.index.RedwoodBlocks;
import dev.doctor4t.redwood.index.RedwoodItems;
import dev.doctor4t.redwood.index.RedwoodWorldgenFeatures;
import dev.doctor4t.redwood.world.gen.RedwoodRegion;
import dev.doctor4t.redwood.world.gen.RedwoodSurfaceRuleData;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class Redwood implements ModInitializer, TerraBlenderApi {
    public static final String MOD_ID = "redwood";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String string) {
        return Identifier.of(MOD_ID, string);
    }

    @Override
    public void onInitialize() {
        RedwoodItems.initialize();
        RedwoodBlocks.initialize();
        RedwoodWorldgenFeatures.initialize();
    }

    @Override
    public void onTerraBlenderInitialized() {
        // Weights are kept intentionally low as we add minimal biomes
        Regions.register(new RedwoodRegion(id("overworld"), 4));

        // Register our surface rules
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, RedwoodSurfaceRuleData.makeRules());
    }
}