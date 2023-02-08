package net.murren.ancientartifacts.mixins;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BowItem.class)
public abstract class BowItemMXN {

    @ModifyVariable(method = "releaseUsing", name = "bl", at = @At(value = "STORE"), ordinal = 0)
    public boolean ancientArtifacts$BEditbl(boolean bl, ItemStack itemStack, Level level, LivingEntity livingEntity, int i)
    {
        if (livingEntity instanceof Player player) {
            if(itemStack.getOrCreateTag().getBoolean("artifacts"))
            {
                return true;
            }
            else {
                bl = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, itemStack) > 0;
            }
            return bl;
        }
        return false;
    }
    @ModifyVariable(method = "releaseUsing", name = "bl2", at = @At(value = "STORE"), ordinal = 0)
    public boolean ancientArtifacts$BEditbl2(boolean bl2, ItemStack itemStack, Level level, LivingEntity livingEntity, int i)
    {
        if (livingEntity instanceof Player) {
            if(itemStack.getOrCreateTag().getBoolean("artifacts"))
            {
                return true;
            }
        }
        return bl2;
    }

    @Inject(at = @At("HEAD"), cancellable = true, method = "use(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResultHolder;")
    private void ancientArtifacts$B_FixArrow(Level level, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.getOrCreateTag().getBoolean("artifact")) {
            player.startUsingItem(hand);
            cir.setReturnValue(InteractionResultHolder.success(stack));
        }
    }

    @Inject(method = "getUseDuration", at = @At("HEAD"), cancellable = true)
    public void ancientArtifacts$B_UseDur(ItemStack itemStack, CallbackInfoReturnable<Integer> cir)
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

    @Inject(method = "getPowerForTime", at = @At("TAIL"), cancellable = true)
    private static void ancientArtifacts$B_GetPow(int i, CallbackInfoReturnable<Float> cir)
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
