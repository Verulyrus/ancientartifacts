package net.murren.ancientartifacts.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static net.murren.ancientartifacts.AncientArtifactsMod.MOD_ID;

public class TagKeys {
    public static final TagKey<Item> SHULKER_BOXES = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MOD_ID, "shulker_boxes"));
}
