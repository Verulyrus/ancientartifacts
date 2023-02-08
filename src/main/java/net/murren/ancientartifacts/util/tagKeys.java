package net.murren.ancientartifacts.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class tagKeys {
    public static class Blocks {

    }

    public static class Items {
        public static final TagKey<Item> SHULKER_BOXES = createTag("shulker_boxes");

        private static TagKey<Item> createTag(String name)
        {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("ancientartifacts", name));
        }
    }
}
