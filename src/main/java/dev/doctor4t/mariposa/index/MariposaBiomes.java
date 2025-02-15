package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;

public interface MariposaBiomes {
    RegistryKey<Biome> BLACKLIGHT_REEF = RegistryKey.of(RegistryKeys.BIOME, Mariposa.id("blacklight_reef"));
    RegistryKey<Biome> COLD_SEEP = RegistryKey.of(RegistryKeys.BIOME, Mariposa.id("cold_seep"));
}
