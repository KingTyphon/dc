package net.objects;

import net.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Ramen extends ItemFood {
    public Ramen(String name, int amount, boolean isWolfFood) {
    super(amount, isWolfFood);
    setUnlocalizedName(name);
    setRegistryName(name);
    setCreativeTab(CreativeTabs.FOOD);

    ItemInit.ITEMS.add(this);
}
}
