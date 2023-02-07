package net.murren.ancientartifacts.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
}
