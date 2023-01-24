package net.murren.ancientartifacts.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.murren.ancientartifacts.Main;

public class ArtifactItemGroup
{
    public static ItemGroup ARTIFACTS = FabricItemGroupBuilder.build(new Identifier(Main.MOD_ID, "Artifacts"),
            () -> new ItemStack(ArtifactItems.empty_artifact));
}
