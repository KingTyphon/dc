package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.item.ItemSword;
import net.util.IHasModel;

public class ToolSword extends ItemSword implements IHasModel {
    public ToolSword(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }
    public void registerModels() {
        DemonCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}


