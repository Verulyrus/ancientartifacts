package net.murren.ancientartifacts.registers;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.HealthBoostMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import static net.murren.ancientartifacts.AncientArtifactsMod.MOD_ID;

public class ArtifactEffects {
    public static final MobEffect REACH_EFFECT;
    public static final MobEffect RANGE_EFFECT;

    static {
       REACH_EFFECT = register("reach_boost", (new HealthBoostMobEffect(MobEffectCategory.BENEFICIAL, 445291)).addAttributeModifier(ReachEntityAttributes.REACH, "60f6aced-542d-48ca-bb68-716e0fd16fbf", 1d, AttributeModifier.Operation.ADDITION));
       RANGE_EFFECT = register("range_boost", (new HealthBoostMobEffect(MobEffectCategory.BENEFICIAL, 445292)).addAttributeModifier(ReachEntityAttributes.REACH, "f63273c7-977d-49b1-8510-7b2d80f95ea2", 1d, AttributeModifier.Operation.ADDITION));
    }

    public static void registerArtifactEffects(){}

    private static MobEffect register(String string, MobEffect mobEffect) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(MOD_ID, string), mobEffect);
    }
}
