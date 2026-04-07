package dev.doctor4t.mariposa.common.tag;

import dev.doctor4t.mariposa.common.Mariposa;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface MariposaTags {
	TagKey<Block> SEQUOIA_LOGS = createBlockTag("sequoia_logs");
	TagKey<Item> SEQUOIA_LOGS_ITEM = createItemTag("sequoia_logs");

	private static TagKey<Block> createBlockTag(String id) {
		return TagKey.create(Registries.BLOCK, Mariposa.id(id));
	}

	private static TagKey<Item> createItemTag(String id) {
		return TagKey.create(Registries.ITEM, Mariposa.id(id));
	}
}
