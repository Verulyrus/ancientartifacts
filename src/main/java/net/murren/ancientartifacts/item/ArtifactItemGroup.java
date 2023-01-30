package net.murren.ancientartifacts.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.murren.ancientartifacts.Main;

public class ArtifactItemGroup
{
    public static CreativeModeTab ARTIFACTS = FabricItemGroupBuilder.build(new ResourceLocation(Main.MOD_ID, "artifacts"),
            () -> new ItemStack(ArtifactItems.empty_artifact));
}
