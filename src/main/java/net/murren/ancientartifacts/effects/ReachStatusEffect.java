package net.murren.ancientartifacts.effects;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class ReachStatusEffect extends MobEffect
{
    AttributeModifier c = new AttributeModifier("reach", 2d, AttributeModifier.Operation.ADDITION);
    public ReachStatusEffect() {
        super(
                MobEffectCategory.BENEFICIAL,
                0x0000ff
        );
    }

    @Override
    public boolean isDurationEffectTick(int dur, int amp)
    {
        return true;
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier)
    {
        if (entity instanceof Player)
        {
            if(!entity.getAttributes().hasModifier(ReachEntityAttributes.REACH, c.getId())) {
            entity.getAttribute(ReachEntityAttributes.REACH).addTransientModifier(c);
            }
            if(!entity.getAttributes().hasModifier(ReachEntityAttributes.ATTACK_RANGE, c.getId())) {
                entity.getAttribute(ReachEntityAttributes.ATTACK_RANGE).addTransientModifier(c);
            }
        }
    }


}
