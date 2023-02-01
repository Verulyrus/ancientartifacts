package net.murren.ancientartifacts.mixins;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


import static net.murren.ancientartifacts.Util.InventoryItemFind.findItemInInventory;
import static net.murren.ancientartifacts.item.ArtifactItems.*;

@Mixin(Player.class)
abstract class PlayerTickMXN {
    AttributeModifier a = new AttributeModifier("max_health", 2, AttributeModifier.Operation.MULTIPLY_BASE);
    AttributeModifier b = new AttributeModifier("reach", 0.5, AttributeModifier.Operation.MULTIPLY_BASE);

    @Shadow public abstract Inventory getInventory();

    @Shadow public abstract FoodData getFoodData();

    @Inject(method = "tick", at = @At("HEAD"))
    private void ancientArtifacts$POnAttributes(CallbackInfo ci) {
        Inventory inv = getInventory();

        if (findItemInInventory(inv, saturation_artifact)) {
            if (getFoodData().needsFood()) {
                getFoodData().setFoodLevel(20);
            }
        }
        if (findItemInInventory(inv, toughness_artifact))
        {
            if(!getInventory().player.getAttributes().hasModifier(Attributes.MAX_HEALTH, a.getId()) && getInventory().player.getMaxHealth() < 30)
            {
                getInventory().player.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(a);
                getInventory().player.setHealth(getInventory().player.getHealth());
            }
        } else
        {
            if(getInventory().player.getAttributes().hasModifier(Attributes.MAX_HEALTH, a.getId()))
            {
                getInventory().player.getAttribute(Attributes.MAX_HEALTH).removeModifier(a.getId());
                getInventory().player.setHealth(getInventory().player.getHealth());
            }
        }

        if (inv.getSelected().getItem() instanceof BowItem || inv.getSelected().getItem() instanceof CrossbowItem);
        {
                inv.getSelected().getOrCreateTag().putBoolean("artifact", findItemInInventory(inv, hunter_artifact));
        }

        if(findItemInInventory(inv, sneak_artifact))
        {
            if(!getInventory().player.getAttributes().hasModifier(Attributes.FOLLOW_RANGE, b.getId()))
            {
                getInventory().player.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(b);
                getInventory().player.setHealth(getInventory().player.getHealth());
            }
        } else
        {
            if(getInventory().player.getAttributes().hasModifier(Attributes.FOLLOW_RANGE, b.getId()))
            {
                getInventory().player.getAttribute(Attributes.FOLLOW_RANGE).removeModifier(b.getId());
                getInventory().player.setHealth(getInventory().player.getHealth());
            }
        }
    }
}

