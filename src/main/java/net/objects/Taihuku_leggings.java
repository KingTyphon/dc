package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.util.IHasModel;

public class Taihuku_leggings extends ItemArmor implements IHasModel {
    public Taihuku_leggings(ItemArmor.ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String Name) {
        super(material, renderIndex, armorType);
        setUnlocalizedName(Name);
        setRegistryName(Name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        super.onArmorTick(world, player, stack);
    }

    public void registerModels() {
        DemonCraft.proxy.registerItemRenderer((Item)this, 0, "inventory");
    }
}