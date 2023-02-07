package net.murren.ancientartifacts.Registers;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.murren.ancientartifacts.Main;

import static net.murren.ancientartifacts.Main.MOD_ID;

public class ArtifactEffects {
    public static final MobEffect REACHEFFECT = registerEffect("reach_effect");

    private static MobEffect registerEffect(String name)
    {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(MOD_ID, name), REACHEFFECT);
    }

    public static void registerItems()
    {
        Main.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
