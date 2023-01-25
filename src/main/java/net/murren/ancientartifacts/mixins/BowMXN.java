package net.murren.ancientartifacts.mixins;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BowItem.class)
public class BowMXN
{
    @Inject(method = "getMaxUseTime", at = @At("HEAD"))
    private void maxUse(ItemStack stack, CallbackInfoReturnable<Integer> cir)
    {

    }
}
