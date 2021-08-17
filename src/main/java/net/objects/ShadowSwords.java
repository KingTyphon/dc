package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.item.ItemSword;

public class ShadowSwords extends ItemSword {
    public ShadowSwords(String name, ToolMaterial material)
    { super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);}
}