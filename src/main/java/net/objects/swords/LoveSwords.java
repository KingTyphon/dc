package net.objects.swords;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.item.ItemSword;

public class LoveSwords extends ItemSword {
    public LoveSwords(String name, ToolMaterial material)
    { super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);}
}