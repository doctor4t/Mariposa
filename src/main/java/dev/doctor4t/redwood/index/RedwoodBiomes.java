package dev.doctor4t.redwood.index;

import dev.doctor4t.redwood.Redwood;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;

public interface RedwoodBiomes {
    RegistryKey<Biome> BLACKLIGHT_REEF = RegistryKey.of(RegistryKeys.BIOME, Redwood.id("blacklight_reef"));
    RegistryKey<Biome> COLD_SEEP = RegistryKey.of(RegistryKeys.BIOME, Redwood.id("cold_seep"));
}
