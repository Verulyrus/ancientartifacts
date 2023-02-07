package net.murren.ancientartifacts.mixins;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import static net.murren.ancientartifacts.util.attributeModifiers.c;

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


import static net.murren.ancientartifacts.util.InventoryItemFind.findItemInInventory;
import static net.murren.ancientartifacts.registers.ArtifactItems.*;

@Mixin(Player.class)
abstract class PlayerTickMXN {

    @Shadow public abstract Inventory getInventory();

    @Shadow public abstract FoodData getFoodData();

    @Inject(method = "tick", at = @At("HEAD"))
    private void ancientArtifacts$POnAttributes(CallbackInfo ci) {
        Inventory inv = getInventory();
        Player player = getInventory().player;

        //SATURATION ARTIFACT
        if (findItemInInventory(inv, saturation_artifact)) {
            if (getFoodData().needsFood()) {
                getFoodData().setFoodLevel(20);
            }
        }

        //TOUGHNESS ARTIFACT
        if (findItemInInventory(inv, toughness_artifact))
        {
            if(!player.hasEffect(MobEffects.HEALTH_BOOST)) {
                player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 999999999, 4, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 12, true, true));
            }
        }
        else {
            if(player.hasEffect(MobEffects.HEALTH_BOOST)) {
                player.removeEffect(MobEffects.HEALTH_BOOST);
            }
        }

        //HUNTERS ARTIFACT
        if (inv.getSelected().getItem() instanceof BowItem || inv.getSelected().getItem() instanceof CrossbowItem);
        {
            inv.getSelected().getOrCreateTag().putBoolean("artifact", findItemInInventory(inv, hunter_artifact));
        }

        //REACH ARTIFACT
        if(findItemInInventory(inv, reach_artifact))
        {
            if(!player.getAttributes().hasModifier(ReachEntityAttributes.REACH, c.getId())) {
                player.getAttribute(ReachEntityAttributes.REACH).addPermanentModifier(c);
            }
            if(!player.getAttributes().hasModifier(ReachEntityAttributes.ATTACK_RANGE, c.getId())) {
                player.getAttribute(ReachEntityAttributes.ATTACK_RANGE).addPermanentModifier(c);
            }
        } else {
            if(player.getAttributes().hasModifier(ReachEntityAttributes.REACH, c.getId())) {
                player.getAttribute(ReachEntityAttributes.REACH).removeModifier(c);
            }
            if(player.getAttributes().hasModifier(ReachEntityAttributes.ATTACK_RANGE, c.getId())) {
                player.getAttribute(ReachEntityAttributes.ATTACK_RANGE).removeModifier(c);
            }
        }

        //SNEAK ARTIFACT
        /*if(findItemInInventory(inv, sneak_artifact))
        {
            player.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), player,
                    new AABB(
                            player.position().x - 16,
                            player.position().y - 16,
                            player.position().z - 16,
                            player.position().x + 16,
                            player.position().y + 16,
                            player.position().z + 16)).forEach(e -> {
                                if(e.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                {
                                    if(!e.getAttributes().hasModifier(Attributes.FOLLOW_RANGE, d.getId()))
                                    {
                                        e.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(d);
                                    }
                                }
            });
        }*/
    }
}

