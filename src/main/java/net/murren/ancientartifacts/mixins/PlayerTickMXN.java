package net.murren.ancientartifacts.mixins;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.murren.ancientartifacts.item.ArtifactItems.saturation_artifact;
import static net.murren.ancientartifacts.item.ArtifactItems.toughness_artifact;

@Mixin(PlayerEntity.class)
abstract class PlayerTickMXN
{
    @Shadow
    public PlayerInventory getInventory() {
        return null;
    }

    @Shadow public abstract HungerManager getHungerManager();

    @Inject(method = "getHungerManager", at = @At("HEAD"))
    private void onHunger(CallbackInfoReturnable<HungerManager> cir)
    {
        PlayerInventory inv = getInventory();
        for(int i = 0; i < inv.size(); i++)
        {
            if(inv.getStack(i).getItem().equals(saturation_artifact))
            {
                if (getHungerManager().isNotFull())
                {
                    getHungerManager().setFoodLevel(20);
                }
            }
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onAttributes(CallbackInfo ci)
    {
        boolean itemFound = false;
        PlayerInventory inv = getInventory();
        for(int i = 0; i < inv.size(); i++)
        {
            if(inv.getStack(i).getItem().equals(toughness_artifact))
            {
                itemFound = true;
            }
        }
        if(itemFound)
        {
            PlayerEntity.createPlayerAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 40f);
        }
        else
        {
            PlayerEntity.createPlayerAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20f);
        }
    }
}
