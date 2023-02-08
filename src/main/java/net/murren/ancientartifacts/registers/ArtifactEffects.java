package net.murren.ancientartifacts.registers;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.HealthBoostMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class ArtifactEffects {
    public static final MobEffect REACH_EFFECT;
    public static final MobEffect RANGE_EFFECT;

    static {
       REACH_EFFECT = register(45, "reach_boost", (new HealthBoostMobEffect(MobEffectCategory.BENEFICIAL, 445291)).addAttributeModifier(ReachEntityAttributes.REACH, "60f6aced-542d-48ca-bb68-716e0fd16fbf", 2d, AttributeModifier.Operation.ADDITION));
       RANGE_EFFECT = register(46, "range_boost", (new HealthBoostMobEffect(MobEffectCategory.BENEFICIAL, 445292)).addAttributeModifier(ReachEntityAttributes.REACH, "f63273c7-977d-49b1-8510-7b2d80f95ea2", 2d, AttributeModifier.Operation.ADDITION));
    }

    public static void registerArtifactEffects()
    {
    }

    private static MobEffect register(int i, String string, MobEffect mobEffect) {
        return Registry.registerMapping(Registry.MOB_EFFECT, i, string, mobEffect);
    }
}
