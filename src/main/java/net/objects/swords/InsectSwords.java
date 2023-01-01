package net.objects.swords;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.item.ItemSword;

public class InsectSwords extends ItemSword {
    public InsectSwords(String name, ToolMaterial material)
    { super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);}
}