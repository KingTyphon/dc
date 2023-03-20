package net.objects.tokens;


import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.networking.messages.slayer.Slayer;
import net.networking.messages.tech.Tech;
import net.networking.Networking;
import net.util.capabilities.slayer.SlayerProvider;


import java.util.UUID;


public class SlayerToken extends Item {
    public final static UUID MODIFIER_UUID = UUID.fromString("294093da-54f0-4c1b-9dbb-13b77534a84c");
    public SlayerToken(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        final ItemStack stack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote && playerIn.hasCapability(SlayerProvider.Breath_CAP, null)) {
            int min = 1;
            int max = 16;
            int range = max - min + 1;
            int number = (int) (Math.random() * range) + min;

            if(playerIn.hasCapability(SlayerProvider.Breath_CAP, null)){
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setMaxMana(250);
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setLevel(1);
            }
            if (number == 1) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(1);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Flame Breathing").setStyle(new Style().setColor(TextFormatting.DARK_RED))));
                Networking.sendToServer(new Slayer(1, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(1, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);

            }
            if (number == 2) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(2);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Insect Breathing").setStyle(new Style().setColor(TextFormatting.DARK_GREEN))));
                Networking.sendToServer(new Slayer(2, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(2, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);
            }
            if (number == 3) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(3);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Thunder Breathing").setStyle(new Style().setColor(TextFormatting.YELLOW))));
                Networking.sendToServer(new Slayer(3, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(3, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);
            }
            if (number == 4) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(4);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Shadow Breathing").setStyle(new Style().setColor(TextFormatting.DARK_PURPLE))));
                Networking.sendToServer(new Slayer(4, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(4, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);
            }
            if (number == 5) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(5);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Mist Breathing").setStyle(new Style().setColor(TextFormatting.GRAY))));
                Networking.sendToServer(new Slayer(5, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(5, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);            }
            if (number == 6) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(6);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Sound Breathing").setStyle(new Style().setColor(TextFormatting.WHITE))));
                Networking.sendToServer(new Slayer(6, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(6, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);            }
            if (number == 7) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(7);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Beast Breathing").setStyle(new Style().setColor(TextFormatting.DARK_BLUE))));
                Networking.sendToServer(new Slayer(7, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(7, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);            }
            if (number == 8) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(8);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Wind Breathing").setStyle(new Style().setColor(TextFormatting.BLUE))));
                Networking.sendToServer(new Slayer(8, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(8, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);            }
            if (number == 9) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(9);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Ice Breathing").setStyle(new Style().setColor(TextFormatting.AQUA))));
                Networking.sendToServer(new Slayer(9, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(9, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);           }

            if (number == 10) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(10);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Special Breathing").setStyle(new Style().setColor(TextFormatting.BLACK))));
                Networking.sendToServer(new Slayer(10, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(10, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);
            }
            if (number == 11) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(11);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Water Breathing").setStyle(new Style().setColor(TextFormatting.DARK_AQUA))));
                Networking.sendToServer(new Slayer(11, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(11, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);            }
            if (number == 12) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(12);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Love Breathing").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE))));
                Networking.sendToServer(new Slayer(12, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(12, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);            }
            if (number == 13) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(13);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Flower Breathing").setStyle(new Style().setColor(TextFormatting.RED))));
                Networking.sendToServer(new Slayer(13, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(13, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);            }
            if (number == 14) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(14);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Sun Breathing").setStyle(new Style().setColor(TextFormatting.GOLD))));
                Networking.sendToServer(new Slayer(14, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(14, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);
            }
            if (number == 15) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(15);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Serpent Breathing").setStyle(new Style().setColor(TextFormatting.GREEN))));
                Networking.sendToServer(new Slayer(15, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(15, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);
            }
            if (number == 16) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(16);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Stone Breathing").setStyle(new Style().setColor(TextFormatting.DARK_GRAY))));
                Networking.sendToServer(new Slayer(16, 0.0F, 0, 1, 250));
                Networking.sendTo(new Slayer(16, 0.0F, 0, 1, 250), (EntityPlayerMP) playerIn);            }

            playerIn.fallDistance = 0;
            playerIn.getCapability(SlayerProvider.Breath_CAP, null).setMaxMana(250);
            Networking.sendTo(new Slayer(playerIn.getCapability(SlayerProvider.Breath_CAP, null)), (EntityPlayerMP) playerIn);
            Networking.sendToServer(new Slayer(playerIn.getCapability(SlayerProvider.Breath_CAP, null)));
            Networking.sendTo(new Tech(playerIn), (EntityPlayerMP) playerIn);
            
            stack.shrink(1);
        }

        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }
}
