package net.murren.ancientartifacts.mixins;

import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CrossbowItem.class)
public abstract class CrossBowItemMXN {

    @Inject(method = "getChargeDuration", at = @At("HEAD"), cancellable = true)
    private static void fixChargeDur(ItemStack itemStack, CallbackInfoReturnable<Integer> cir)
    {
        if(itemStack.getOrCreateTag().getBoolean("artifact"))
        {
            int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, itemStack);
            cir.setReturnValue(i == 0 ? 15 : 15 - 3 * i);
        }
    }
}
