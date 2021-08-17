package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.item.ItemSword;

public class SoundSwords extends ItemSword {
    public SoundSwords(String name, ToolMaterial material)
    { super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);}
}