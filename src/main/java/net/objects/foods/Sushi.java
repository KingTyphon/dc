package net.objects.foods;

import net.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class Sushi extends ItemFood {
    public Sushi(String name, int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);

        ItemInit.ITEMS.add(this);
    }
}
