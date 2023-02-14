package net.murren.ancientartifacts.mixins;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;


@Mixin(CrossbowItem.class)
public abstract class CrossBowItemMXN {
      /*@ModifyVariable(method = "tryLoadProjectiles", name = "bl", at = @At(value = "STORE"), ordinal = 0)
  private static boolean ancientArtifacts$CB_Editbl(boolean bl, LivingEntity livingEntity, ItemStack itemStack)
    {
        if(itemStack.getOrCreateTag().getBoolean("artifact") && livingEntity instanceof Player)
        {
            return true;
        }
        return livingEntity instanceof Player && ((Player)livingEntity).getAbilities().instabuild;
    }
    @Inject(method = "performShooting", at = @At(value = "HEAD"))
    private static void ancientArtifacts$CB_performShooting(Level level, LivingEntity shooter, InteractionHand usedHand, ItemStack crossbowStack, float velocity, float inaccuracy, CallbackInfo ci)
    {
        if(shooter.getItemInHand(usedHand).getOrCreateTag().getBoolean("artifact") && shooter instanceof Player)
        {

        }
    }

    @Inject(method = "loadProjectile", at = @At(value = "HEAD"), cancellable = true)
    private static void ancientArtifacts$CB_Editbl3(LivingEntity livingEntity, ItemStack itemStack, ItemStack itemStack2, boolean bl, boolean bl2, CallbackInfoReturnable<Boolean> cir)
    {
        if(itemStack.getOrCreateTag().getBoolean("artifact") && livingEntity instanceof Player)
        {
            cir.setReturnValue(true);
        }
    }*/

    @Inject(method = "getChargeDuration", at = @At("HEAD"), cancellable = true)
    private static void ancientArtifacts$CB_FixChargeDur(ItemStack itemStack, CallbackInfoReturnable<Integer> cir)
    {
        if(itemStack.getOrCreateTag().getBoolean("artifact"))
        {
            int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, itemStack);
            cir.setReturnValue(i == 0 ? 15 : 15 - 3 * i);
        }
    }
}
