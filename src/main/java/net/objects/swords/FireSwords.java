package net.objects.swords;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.capabilities.slayer.SlayerProvider;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;


public class FireSwords extends ItemSword{
    int tick = 0;


    public FireSwords(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }



    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {

        ItemStack item = player.getHeldItem(handIn);
        Vec3d look = player.getLookVec();
        if(!worldIn.isRemote){
            if (player.hasCapability(SlayerProvider.Breath_CAP, null)) {
                if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 1) {
                    if(player.onGround == true) {
                        player.motionX = 6.8D * look.x;
                        player.motionZ = 6.8D * look.z;
                    }else {
                        player.motionX += 1.35D * look.x;
                        player.motionZ += 1.35D * look.z;
                    }
                } else if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() > 2) {
                    player.sendMessage(new TextComponentString("You Have To Learn ")
                            .appendSibling(new TextComponentString("Fire Breathing").setStyle(new Style().setColor(TextFormatting.DARK_RED)))
                            .appendSibling(new TextComponentString(" To Use This Sword.")));
                }}}
        item.damageItem(0, player);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);}

    public void onUpdate(){
        tick+= 1;
        if(tick==20){

        }
    }
    @SideOnly(CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        String color = TextFormatting.DARK_RED.toString();
        String reset = TextFormatting.RESET.toString();
        if(GuiScreen.isShiftKeyDown()){
            tooltip.add("Sword which can only be activated by the ones who breath " + color + "Fire");
        }
        else{
            tooltip.add("Press" + color + " Shift " + reset + "to see more information");
        }
    }

}
