package net.murren.ancientartifacts.util;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;

import static net.murren.ancientartifacts.AncientArtifactsMod.MOD_ID;

public class TagKeys {
    public static final Tag<Item> SHULKER_BOXES = TagFactory.ITEM.create(new ResourceLocation(MOD_ID, "shulker_boxes"));
}
