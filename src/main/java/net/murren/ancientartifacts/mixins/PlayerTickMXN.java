package net.murren.ancientartifacts.mixins;

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
    @Shadow public Inventory getInventory() {
        return null;
    }

    public abstract FoodData getHungerManager();

    @Inject(method = "tick", at = @At("HEAD"))
    private void onAttributes(CallbackInfo ci) {
        Inventory inv = getInventory();

        if (findItemInInventory(inv, saturation_artifact)) {
            if (getHungerManager().needsFood()) {
                getHungerManager().setFoodLevel(20);
            }
        }
        if (findItemInInventory(inv, toughness_artifact)) {
            //
        } else {
            //
        }

        if (inv.getSelected().getItem() instanceof BowItem || inv.getSelected().getItem() instanceof CrossbowItem);
        {
            if (inv.getSelected().getItem() instanceof BowItem) {
                if (findItemInInventory(inv, hunter_artifact)) {
                    inv.getSelected().getOrCreateTag().putBoolean("artifact", true);
                }
                else {
                    inv.getSelected().getOrCreateTag().putBoolean("artifact", false);
                }
            }
        }
    }
}

