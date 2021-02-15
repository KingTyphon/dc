package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.item.Item;
import net.util.IHasModel;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }
    public void registerModels()
    {
        DemonCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
