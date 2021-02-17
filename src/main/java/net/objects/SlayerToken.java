package net.objects;


import net.DemonCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.util.capabilities.SlayerProvider;

import javax.annotation.Nullable;


public class SlayerToken extends ItemBase{



    public SlayerToken(String name) {
        super(name);
    }public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {
            int min = 1;
            int max = 17;
            int range = max - min + 1;
            int number = (int) (Math.random() * range) + min;
            if (number == 1) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(1);
                playerIn.sendMessage(new TextComponentString("You Have Learned Fire Breathing"));
            }
            if (number == 2) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(2);
                playerIn.sendMessage(new TextComponentString("You Have Learned Insect Breathing"));
            }
            if (number == 3) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(3);
                playerIn.sendMessage(new TextComponentString("You Have Learned Thunder Breathing"));
            }
            if (number == 4) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(4);
                playerIn.sendMessage(new TextComponentString("You Have Learned Moon Breathing"));
            }
            if (number == 5) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(5);
                playerIn.sendMessage(new TextComponentString("You Have Learned Mist Breathing"));
            }
            if (number == 6) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(6);
                playerIn.sendMessage(new TextComponentString("You Have Learned Sound Breathing"));
            }
            if (number == 7) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(7);
                playerIn.sendMessage(new TextComponentString("You Have Learned Beast Breathing"));
            }
            if (number == 8) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(8);
                playerIn.sendMessage(new TextComponentString("You Have Learned Wind Breathing"));
            }
            if (number == 9) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(9);
                playerIn.sendMessage(new TextComponentString("You Have Learned Ice Breathing"));
            }
            if (number == 10) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(10);
                playerIn.sendMessage(new TextComponentString("You Have Learned Special Breathing"));
            }
            if (number == 11) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(11);
                playerIn.sendMessage(new TextComponentString("You Have Learned Water Breathing"));
            }
            if (number == 12) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(12);
                playerIn.sendMessage(new TextComponentString("You Have Learned Love Breathing"));
            }
            if (number == 13) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(13);
                playerIn.sendMessage(new TextComponentString("You Have Learned Flower Breathing"));
            }
            if (number == 14) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(14);
                playerIn.sendMessage(new TextComponentString("You Have Learned Sun Breathing"));
            }
            if (number == 15) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(15);
                playerIn.sendMessage(new TextComponentString("You Have Learned Serpent Breathing"));
            }
            if (number == 16) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(16);
                playerIn.sendMessage(new TextComponentString("You Have Learned Stone Breathing"));
            }
            if (number == 17) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(17);
                playerIn.sendMessage(new TextComponentString("You Have Learned Shadow Breathing"));
            }



        }
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

    }


    public void registerModels()
    {
        DemonCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}

