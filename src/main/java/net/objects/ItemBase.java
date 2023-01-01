package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }

}