package net.murren.ancientartifacts.mixins;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.murren.ancientartifacts.registers.ArtifactEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.world.item.Items.SHULKER_BOX;
import static net.murren.ancientartifacts.registers.ArtifactItems.*;

@Mixin(Item.class)
public class ShulkerBoxItemMXN {
    @Inject(method = "inventoryTick", at = @At("HEAD"))
    public void AncientArtifacts$ItemInventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl, CallbackInfo ci)
    {
        if(itemStack.is(SHULKER_BOX) && itemStack.hasTag() && entity instanceof Player p)
        {
                NonNullList<ItemStack> box = NonNullList.withSize(27, ItemStack.EMPTY);
                CompoundTag tag = itemStack.getTag();
                CompoundTag blockEntityTag = tag.getCompound("BlockEntityTag");
                ContainerHelper.loadAllItems(blockEntityTag, box);
                box.forEach(itemStack1 -> {
                    if(itemStack1.is(hunter_artifact))
                    {
                        if(p.getInventory().getSelected().getItem() instanceof BowItem || p.getInventory().getSelected().getItem() instanceof CrossbowItem) {
                            p.getInventory().getSelected().getOrCreateTag().putBoolean("artifact", true);
                        }
                    }
                    if(itemStack1.is(reach_artifact))
                    {
                        if(!level.isClientSide && level.getGameTime()%20==0)
                        {
                            p.addEffect(new MobEffectInstance(ArtifactEffects.REACH_EFFECT, 25, 0, true, true));
                            p.addEffect(new MobEffectInstance(ArtifactEffects.RANGE_EFFECT, 25, 0, true, true));
                        }
                    }
                    if(itemStack1.is(saturation_artifact))
                    {
                        if(p.getFoodData().needsFood())
                        {
                            p.getFoodData().setFoodLevel(20);
                        }
                    }
                    if(itemStack1.is(toughness_artifact))
                    {
                        if(!level.isClientSide && level.getGameTime()%20==0)
                        {
                            if(!p.hasEffect(MobEffects.HEALTH_BOOST)) {
                                p.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 12, true, true));
                            }
                            p.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 30, 4, true, true));
                        }
                    }
                });

        }
    }
}
