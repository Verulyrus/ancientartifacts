package net.murren.ancientartifacts.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class ToughnessArtifactItem extends Item {

    public ToughnessArtifactItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(new TranslatableComponent("item.ancientartifacts.toughness_artifact.tooltip").withStyle(ChatFormatting.DARK_BLUE).withStyle(ChatFormatting.BOLD) );
    }
    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl)
    {
        if(entity instanceof Player p && !level.isClientSide && level.getGameTime()%20==0)
        {
            if(!p.hasEffect(MobEffects.HEALTH_BOOST)) {
                p.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 12, true, true));
            }
            float a = p.getHealth();
            p.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 45, 4, true, true));
            p.setHealth(a);
        }
    }
}
