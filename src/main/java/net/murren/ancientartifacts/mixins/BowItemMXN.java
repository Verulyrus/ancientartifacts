package net.murren.ancientartifacts.mixins;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BowItem.class)
public abstract class BowItemMXN {


    @Inject(method = "getUseDuration", at = @At("HEAD"))
    public void useDur(ItemStack itemStack, CallbackInfoReturnable<Integer> cir)
    {
        if(itemStack.getOrCreateTag().contains("artifact"))
        {
            if(itemStack.getTag().getBoolean("artifact"))
            {
                cir.setReturnValue(144000);
            }
            else cir.setReturnValue(60000);
        }
    }

    @Inject(method = "getPowerForTime", at = @At("TAIL"))
    private static void getPow(int i, CallbackInfoReturnable<Float> cir)
    {
        if(i > 70000)
        {
            float k = (float)i / 10.0F;
            k = (k * k + k * 2.0F) / 3.0F;
            if (k > 1.0F) {
                k = 1.0F;
            }

            cir.setReturnValue(k);
        }
    }



}
