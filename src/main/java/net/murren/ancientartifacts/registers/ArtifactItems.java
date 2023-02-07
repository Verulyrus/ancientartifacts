package net.murren.ancientartifacts.registers;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.murren.ancientartifacts.Main;
import net.murren.ancientartifacts.items.*;

import static net.murren.ancientartifacts.Main.MOD_ID;

public class ArtifactItems
{
    public static final Item empty_artifact = registerItem("empty_artifact",
            new EmptyArtifactItem(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(64).rarity(Rarity.RARE)));
    public static final Item toughness_artifact = registerItem("toughness_artifact",
            new ToughnessArtifactItem(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(1).rarity(Rarity.EPIC)));
    public static final Item saturation_artifact = registerItem("saturation_artifact",
            new SaturationArtifactItem(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(1).rarity(Rarity.EPIC)));
    public static final Item hunter_artifact = registerItem("hunter_artifact",
            new HunterArtifactItem(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(1).rarity(Rarity.EPIC)));
    public static final Item sneak_artifact = registerItem("sneak_artifact",
            new SneakArtifactItem(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(1).rarity(Rarity.EPIC)));
    public static final Item reach_artifact = registerItem("reach_artifact",
            new ReachArtifactItem(new FabricItemSettings().group(ArtifactItemGroup.ARTIFACTS).maxCount(1).rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, name), item);
    }

    public static void registerItems()
    {
        Main.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
