package net.murren.ancientartifacts.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.murren.ancientartifacts.registers.ArtifactEffects;

import java.util.List;

public class ReachArtifactItem extends Item {

    public ReachArtifactItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(new TranslatableComponent("item.ancientartifacts.reach_artifact.tooltip").withStyle(ChatFormatting.DARK_BLUE).withStyle(ChatFormatting.BOLD) );
    }
    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl)
    {
        if(entity instanceof Player p && !level.isClientSide && level.getGameTime()%20==0)
        {
            p.addEffect(new MobEffectInstance(ArtifactEffects.REACH_EFFECT, 25, 1, true, true));
            p.addEffect(new MobEffectInstance(ArtifactEffects.RANGE_EFFECT, 25, 1, true, true));
        }
    }
}
