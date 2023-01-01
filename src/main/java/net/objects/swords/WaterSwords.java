package net.objects.swords;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class WaterSwords extends ItemSword{
    public WaterSwords(String name, ToolMaterial material)
    { super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);}
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
            tooltip.add("Sword which can only be activated by the ones who breath " + new TextComponentString("The Beast").setStyle(new Style().setColor(TextFormatting.DARK_BLUE)));
        else {
            tooltip.add("Press " + new TextComponentString("Shift").setStyle(new Style().setColor(TextFormatting.YELLOW)) + " to see more information");
        }
    }
}


