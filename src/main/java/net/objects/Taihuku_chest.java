package net.objects;

import net.DemonCraft;
import net.util.capabilities.SlayerProvider;
import net.init.ItemInit;
import net.minecraft.item.ItemArmor;
import net.util.IHasModel;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.logging.Logger;

public class Taihuku_chest
        extends ItemArmor implements IHasModel {
    int cnt = 0;
    public static Logger logger;
    int joutyuu_flag=0;
    public Taihuku_chest(ItemArmor.ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String Name) {
        super(material, renderIndex, armorType);
        setUnlocalizedName(Name);
        setRegistryName(Name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        super.onArmorTick(world, player, stack);

        if (player.inventory.armorInventory.get(0) != null
                && player.inventory.armorInventory.get(1) != null
                && player.inventory.armorInventory.get(2) != null)
        {
            if (((ItemStack)player.inventory.armorInventory.get(0)).getItem() == ItemInit.TAIHUKU_FEET
                    && ((ItemStack)player.inventory.armorInventory.get(1)).getItem() == ItemInit.TAIHUKU_LEGGINGS
                    && ((ItemStack)player.inventory.armorInventory.get(2)).getItem() == ItemInit.TAIHUKU_CHEST) {

                joutyuu_flag=1;

                if(player.getCapability(SlayerProvider.Breath_CAP, null).getBreath()==7){
                    for (EntityLivingBase i : world.getEntitiesWithinAABB(EntityLivingBase.class, player.getEntityBoundingBox().grow(60.0D))) {
                        if (i == player) continue;
                        i.addPotionEffect(new PotionEffect(Potion.getPotionById(24), 10, 0, false, true));
                    }
                }

                if(joutyuu_flag==1 ) {
                    player.capabilities.setPlayerWalkSpeed(0.17f);
                    player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
                    if(!player.isInWater() && !player.isCreative())player.addVelocity(0F, 0.01F, 0F);
                    player.fallDistance = 0.0F;
                    joutyuu_flag=0;
                }
            }else {
                player.capabilities.setPlayerWalkSpeed(0.1f);
                player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
            }
        }else {
            player.capabilities.setPlayerWalkSpeed(0.1f);
            player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        }
    }

    public void registerModels() {
        DemonCraft.proxy.registerItemRenderer((Item)this, 0, "inventory");
    }

}