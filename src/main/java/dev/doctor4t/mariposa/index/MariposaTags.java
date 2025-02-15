package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public interface MariposaTags {
    TagKey<Block> SEQUOIA_LOGS = createBlockTag("sequoia_logs");
    TagKey<Item> SEQUOIA_LOGS_ITEM = createItemTag("sequoia_logs");

    private static TagKey<Block> createBlockTag(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Mariposa.id(id));
    }

    private static TagKey<Item> createItemTag(String id) {
        return TagKey.of(RegistryKeys.ITEM, Mariposa.id(id));
    }
}
