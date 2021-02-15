package net.objects;


import net.DemonCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.util.capabilities.SlayerProvider;


public class SlayerToken extends ItemBase{



    public SlayerToken(String name) {
        super(name);
    }public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
        ItemStack item = playerIn.getHeldItem(handIn);
        int min = 1;
        int max = 11;
        int range=max-min +1;
        int number = (int)(Math.random()*range )+min;
        if(number == 1) {
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(1);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Fire Breathing"), false);
        }
        if(number == 2){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(2);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Insect Breathing"), false);
        }
        if(number == 3){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(3);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Lightning Breathing"), false);
        }
        if(number == 4){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(4);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Moon Breathing"), false);
        }
        if(number == 5){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(5);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Mist Breathing"), false);
        }
        if(number == 6){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(6);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Sound Breathing"), false);
        }
        if(number == 7){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(7);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Beast Breathing"), false);
        }
        if(number == 8){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(8);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Wind Breathing"), false);
        }
        if(number == 9){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(9);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Ice Breathing"), false);
        }
        if(number == 10){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(10);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Special Breathing"), false);
        }
        if(number == 11){
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(11);
            playerIn.sendStatusMessage(new TextComponentString("You Have Learned Water Breathing"), false);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }



    public void registerModels()
    {
        DemonCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}

