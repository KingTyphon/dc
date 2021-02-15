package net.creativetabs;

import net.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class DemonCraftTab extends CreativeTabs
{
    public DemonCraftTab(String label)
    {
        super("demoncrafttab");
    }
    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemInit.scarlet_crimson_ingot);
    }

}
