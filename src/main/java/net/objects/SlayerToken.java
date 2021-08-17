package net.objects;


import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.util.capabilities.SlayerProvider;


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
        if (!worldIn.isRemote) {
            int min = 1;
            int max = 16;
            int range = max - min + 1;
            int number = (int) (Math.random() * range) + min;
            IAttributeInstance healthattribute = playerIn.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
            if (number == 1) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(1);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Fire Breathing").setStyle(new Style().setColor(TextFormatting.DARK_RED))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 30.0D, 0).setSaved(true));

            }
            if (number == 2) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(2);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Insect Breathing").setStyle(new Style().setColor(TextFormatting.DARK_GREEN))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 23.0D, 0).setSaved(true));
                }
            if (number == 3) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(3);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Thunder Breathing").setStyle(new Style().setColor(TextFormatting.YELLOW))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 24.0D, 0).setSaved(true));

            }
            if (number == 4) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(4);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Shadow Breathing").setStyle(new Style().setColor(TextFormatting.DARK_PURPLE))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 26.0D, 0).setSaved(true));

            }
            if (number == 5) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(5);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Mist Breathing").setStyle(new Style().setColor(TextFormatting.GRAY))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 33.0D, 0).setSaved(true));

            }
            if (number == 6) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(6);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Sound Breathing").setStyle(new Style().setColor(TextFormatting.WHITE))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID, "SlayerHealth", 30.0D, 0).setSaved(true));

            }
            if (number == 7) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(7);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Beast Breathing").setStyle(new Style().setColor(TextFormatting.DARK_BLUE))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 40.0D, 0).setSaved(true));

            }
            if (number == 8) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(8);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Wind Breathing").setStyle(new Style().setColor(TextFormatting.BLUE))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 18.0D, 0).setSaved(true));

            }
            if (number == 9) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(9);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Ice Breathing").setStyle(new Style().setColor(TextFormatting.AQUA))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID, "SlayerHealth", 28.0D, 0).setSaved(true));
            }

            if (number == 10) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(10);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Special Breathing").setStyle(new Style().setColor(TextFormatting.BLACK))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 30.0D, 0).setSaved(true));

            }
            if (number == 11) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(11);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Water Breathing").setStyle(new Style().setColor(TextFormatting.DARK_AQUA))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 24.0D, 0).setSaved(true));

            }
            if (number == 12) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(12);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Love Breathing").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 15.0D, 0).setSaved(true));

            }
            if (number == 13) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(13);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Flower Breathing").setStyle(new Style().setColor(TextFormatting.RED))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 17.0D, 0).setSaved(true));

            }
            if (number == 14) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(14);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Sun Breathing").setStyle(new Style().setColor(TextFormatting.GOLD))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 20.0D, 0).setSaved(true));

            }
            if (number == 15) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(15);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Serpent Breathing").setStyle(new Style().setColor(TextFormatting.GREEN))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 22.0D, 0).setSaved(true));

            }
            if (number == 16) {
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setBreath(16);
                playerIn.sendMessage(new TextComponentString("You Have Learned ").appendSibling(new TextComponentString("Stone Breathing").setStyle(new Style().setColor(TextFormatting.DARK_GRAY))));
                healthattribute.applyModifier(new AttributeModifier(MODIFIER_UUID,"SlayerHealth", 26.0D, 0).setSaved(true));

            }

            
            
            stack.shrink(1);
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }
}
