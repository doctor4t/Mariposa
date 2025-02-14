package dev.doctor4t.redwood.index;

import dev.doctor4t.redwood.Redwood;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public interface RedwoodTags {
    TagKey<Block> SEQUOIA_LOGS = createBlockTag("sequoia_logs");
    TagKey<Item> SEQUOIA_LOGS_ITEM = createItemTag("sequoia_logs");

    private static TagKey<Block> createBlockTag(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Redwood.id(id));
    }

    private static TagKey<Item> createItemTag(String id) {
        return TagKey.of(RegistryKeys.ITEM, Redwood.id(id));
    }
}
