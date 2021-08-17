package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.item.ItemSword;

public class BeastSwords extends ItemSword {
    public BeastSwords(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);}
}
