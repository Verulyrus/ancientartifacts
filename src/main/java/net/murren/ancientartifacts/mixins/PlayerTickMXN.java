package net.murren.ancientartifacts.mixins;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


import static net.murren.ancientartifacts.util.InventoryItemFind.findItemInInventory;
import static net.murren.ancientartifacts.registers.ArtifactItems.*;

@Mixin(Player.class)
abstract class PlayerTickMXN {

    @Shadow public abstract Inventory getInventory();


    @Inject(method = "tick", at = @At("HEAD"))
    private void ancientArtifacts$POnAttributes(CallbackInfo ci) {
        Inventory inv = getInventory();

        //HUNTERS ARTIFACT
        if (inv.player.getMainHandItem().getItem() instanceof BowItem || inv.player.getMainHandItem().getItem() instanceof CrossbowItem);
        {
            if(findItemInInventory(inv, hunter_artifact)) {
                inv.player.getMainHandItem().getOrCreateTag().putBoolean("artifact", true);
            }
        }
    }
}

