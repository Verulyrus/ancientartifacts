package net.murren.ancientartifacts.util;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static net.murren.ancientartifacts.util.TagKeys.Items.SHULKER_BOXES;

public class InventoryItemFind {
    public static boolean findItemInInventory(Inventory inv, Item item)
    {
        for (int i = 0; i < inv.getContainerSize(); i++) {
            if (inv.getItem(i).getItem().equals(item)) {
                return true;
            }
            ItemStack stack1 = inv.getItem(i);
            if(stack1.is(SHULKER_BOXES) && stack1.hasTag())
            {
                NonNullList<ItemStack> box = NonNullList.withSize(27, ItemStack.EMPTY);
                CompoundTag tag = stack1.getTag();
                CompoundTag blockEntityTag = tag.getCompound("BlockEntityTag");
                ContainerHelper.loadAllItems(blockEntityTag, box);
                if(box.stream().anyMatch(stack -> stack.is(item)))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
