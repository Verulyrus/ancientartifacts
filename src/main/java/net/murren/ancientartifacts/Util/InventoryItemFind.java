package net.murren.ancientartifacts.Util;


import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;

public class InventoryItemFind {
    public static boolean findItemInInventory(Inventory inv, Item item)
    {
        for (int i = 0; i < inv.getContainerSize(); i++) {
            if (inv.getItem(i).getItem().equals(item)) {
                return true;
            }
        }
        return false;
    }
}
