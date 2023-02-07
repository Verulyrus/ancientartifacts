package net.murren.ancientartifacts.mixins;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
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
import static net.murren.ancientartifacts.Registers.ArtifactItems.*;

@Mixin(Player.class)
abstract class PlayerTickMXN {
    AttributeModifier c = new AttributeModifier("reach", 2d, AttributeModifier.Operation.ADDITION);

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
            player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1, 4, true, true));
            player.setHealth(player.getHealth());
        }

        //HUNTERS ARTIFACT
        if (inv.getSelected().getItem() instanceof BowItem || inv.getSelected().getItem() instanceof CrossbowItem);
        {
                inv.getSelected().getOrCreateTag().putBoolean("artifact", findItemInInventory(inv, hunter_artifact));
        }

        //REACH ARTIFACT
        if(findItemInInventory(inv, reach_artifact))
        {

        } else {
            if(player.getAttributes().hasModifier(ReachEntityAttributes.REACH, c.getId())) {
                player.getAttribute(ReachEntityAttributes.REACH).removeModifier(c);
            }
            if(player.getAttributes().hasModifier(ReachEntityAttributes.ATTACK_RANGE, c.getId())) {
                player.getAttribute(ReachEntityAttributes.ATTACK_RANGE).removeModifier(c);
            }
        }
    }
}

