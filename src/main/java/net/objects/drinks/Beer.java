package net.objects.drinks;

import net.init.ItemInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Beer extends Item {
    public Beer(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);
        ItemInit.ITEMS.add(this);
        this.setMaxStackSize(1);
    }
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (!worldIn.isRemote){
            entityLiving.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 400, 1));
            entityLiving.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 400, 1));
            entityLiving.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 100, 1));
            entityLiving.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 4));
            entityLiving.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 400, 1));
            entityLiving.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 400, 2));

        }
        if (entityLiving instanceof EntityPlayerMP)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(entityplayermp, stack);
            entityplayermp.addStat(StatList.getObjectUseStats(this));
        }

        if (entityLiving instanceof EntityPlayer && !((EntityPlayer)entityLiving).capabilities.isCreativeMode)
        {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }public int getMaxItemUseDuration(ItemStack stack)
    {
        return 20;
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
}
