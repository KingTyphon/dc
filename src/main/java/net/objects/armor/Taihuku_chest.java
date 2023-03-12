package net.objects.armor;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.logging.Logger;

public class Taihuku_chest extends ItemArmor{
    public Taihuku_chest(ItemArmor.ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String Name) {
        super(material, renderIndex, armorType);
        setUnlocalizedName(Name);
        setRegistryName(Name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        super.onArmorTick(world, player, stack); }

    @Override
    public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack Stack,EntityEquipmentSlot armorSlot, ModelBiped _default){
     return super.getArmorModel(entity, Stack, armorSlot, _default);
    }
}