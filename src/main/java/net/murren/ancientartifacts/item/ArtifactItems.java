package net.murren.ancientartifacts.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.murren.ancientartifacts.Main;

public class ArtifactItems
{
    public static final Item empty_artifact = registerItem("empty_artifact",
            new Item(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(64).rarity(Rarity.RARE)));
    public static final Item toughness_artifact = registerItem("toughness_artifact",
            new Item(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(1).rarity(Rarity.EPIC)));
    public static final Item saturation_artifact = registerItem("saturation_artifact",
            new Item(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(1).rarity(Rarity.EPIC)));
    public static final Item hunter_artifact = registerItem("hunter_artifact",
            new Item(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(1).rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, name), item);
    }

    public static void registerItems()
    {
        Main.LOGGER.info("Registering Mod Items for " + Main.MOD_ID);
    }
}
