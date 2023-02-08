package net.murren.ancientartifacts.util;

import net.minecraft.core.NonNullList;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static net.minecraft.world.item.Items.SHULKER_BOX;
import static net.murren.ancientartifacts.util.sendLog.logMessage;
import static net.murren.ancientartifacts.util.tagKeys.Items.SHULKER_BOXES;

public class InventoryItemFind {
    public static boolean findItemInInventory(Inventory inv, Item item)
    {
        for (int i = 0; i < inv.getContainerSize(); i++) {
            if (inv.getItem(i).getItem().equals(item)) {
                return true;
            }
            if(inv.getItem(i).is(SHULKER_BOX) && inv.getItem(i).hasTag())
            {
                logMessage("found shulker box with tag");
                NonNullList<ItemStack> box = NonNullList.create();
                ContainerHelper.loadAllItems(inv.getItem(i).getTag(), box);
                if(box.stream().anyMatch(stack -> stack.is(item)))
                {
                    logMessage("found shulker box containing item");
                    return true;
                }
            }
        }
        return false;
    }
}
