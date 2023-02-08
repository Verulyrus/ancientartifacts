package net.murren.ancientartifacts.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class SaturationArtifactItem extends Item {

    public SaturationArtifactItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(new TranslatableComponent("item.ancientartifacts.saturation_artifact.tooltip").withStyle(ChatFormatting.DARK_BLUE).withStyle(ChatFormatting.BOLD) );
    }
    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl)
    {
        if(entity instanceof Player p && ((Player) entity).getFoodData().needsFood())
        {
            p.getFoodData().setFoodLevel(20);
        }
    }
}
