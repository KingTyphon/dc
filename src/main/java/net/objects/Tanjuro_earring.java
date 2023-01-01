package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.objects.models.ModelEarring;

public class Tanjuro_earring extends ItemArmor {
    public Tanjuro_earring(ItemArmor.ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String Name) {
        super(material, renderIndex, armorType);
        setUnlocalizedName(Name);
        setRegistryName(Name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack Stack, EntityEquipmentSlot armorSlot, ModelBiped _default){
        if(Stack != ItemStack.EMPTY){
           if(Stack.getItem() instanceof ItemArmor){
               ModelEarring model = new ModelEarring();
               model.bipedHead.showModel = armorSlot ==EntityEquipmentSlot.HEAD;
               model.isChild = _default.isChild;
               model.isRiding = _default.isRiding;
               model.isSneak = _default.isSneak;
               model.rightArmPose = _default.rightArmPose;
               model.leftArmPose = _default.leftArmPose;


               return model;
           }
        }
       return null;
    }
}
