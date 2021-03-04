package net.objects;


import net.DemonCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.util.capabilities.SlayerProvider;

import javax.annotation.Nullable;
import java.awt.*;


public class SlayerToken extends ItemBase{



    public SlayerToken(String name) {
        super(name);
    }public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {
            int min = 1;
            int max = 16;
            int range = max - min + 1;
            int number = (int) (Math.random() * range) + min;
            if (number == 1) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(1);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Fire Breathing").setStyle(new Style().setColor(TextFormatting.DARK_RED))));
            }
            if (number == 2) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(2);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Insect Breathing").setStyle(new Style().setColor(TextFormatting.DARK_GREEN))));
            }
            if (number == 3) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(3);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Thunder Breathing").setStyle(new Style().setColor(TextFormatting.YELLOW))));
            }
            if (number == 4) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(4);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Shadow Breathing").setStyle(new Style().setColor(TextFormatting.DARK_PURPLE))));
            }
            if (number == 5) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(5);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Mist Breathing").setStyle(new Style().setColor(TextFormatting.GRAY))));
            }
            if (number == 6) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(6);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Sound Breathing").setStyle(new Style().setColor(TextFormatting.WHITE))));
            }
            if (number == 7) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(7);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Beast Breathing").setStyle(new Style().setColor(TextFormatting.DARK_BLUE))));
            }
            if (number == 8) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(8);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Wind Breathing").setStyle(new Style().setColor(TextFormatting.BLUE))));
            }
            if (number == 9) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(9);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Ice Breathing").setStyle(new Style().setColor(TextFormatting.AQUA))));
            }
            if (number == 10) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(10);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Special Breathing").setStyle(new Style().setColor(TextFormatting.BLACK))));
            }
            if (number == 11) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(11);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Water Breathing").setStyle(new Style().setColor(TextFormatting.DARK_AQUA))));
            }
            if (number == 12) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(12);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Love Breathing").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE))));
            }
            if (number == 13) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(13);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Flower Breathing").setStyle(new Style().setColor(TextFormatting.RED))));
            }
            if (number == 14) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(14);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Sun Breathing").setStyle(new Style().setColor(TextFormatting.GOLD))));
            }
            if (number == 15) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(15);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Serpent Breathing").setStyle(new Style().setColor(TextFormatting.GREEN))));
            }
            if (number == 16) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(16);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Stone Breathing").setStyle(new Style().setColor(TextFormatting.DARK_GRAY))));
            }


        }
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

    }


    public void registerModels()
    {
        DemonCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}

