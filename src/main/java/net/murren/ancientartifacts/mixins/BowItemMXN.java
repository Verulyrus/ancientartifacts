package net.murren.ancientartifacts.mixins;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BowItem.class)
public abstract class BowItemMXN {


    @Inject(method = "releaseUsing", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/item/BowItem;getPowerForTime(I)F"), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void doublef(ItemStack itemStack, Level level, LivingEntity livingEntity, int i, CallbackInfo ci, float f)
    {
        assert itemStack.getTag() != null;
        if(itemStack.getTag().contains("artifact"))
        {
            if(itemStack.getTag().getBoolean("artifact")) {
                f = 2 * f;
            }
        }
    }
}
