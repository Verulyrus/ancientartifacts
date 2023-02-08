package net.murren.ancientartifacts.registers;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.murren.ancientartifacts.AncientArtifactsMod;

public class ArtifactItemGroup
{
    public static CreativeModeTab ARTIFACTS = FabricItemGroupBuilder.build(new ResourceLocation(AncientArtifactsMod.MOD_ID, "artifacts"),
            () -> new ItemStack(ArtifactItems.empty_artifact));
}
