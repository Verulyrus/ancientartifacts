package net.murren.ancientartifacts.registers;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class VanillaItems {
    static {
        FabricModelPredicateProviderRegistry.register(Items.BOW, new ResourceLocation("pull"), (itemStack, clientLevel, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                assert itemStack.getTag() != null;
                if(itemStack.getTag().contains("artifact"))
                {
                    if(itemStack.getTag().getBoolean("artifact"))
                    {
                        return livingEntity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 10.0F;
                    }
                }
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
    }
    public static void registerVanillaItems()
    {

    }
}
