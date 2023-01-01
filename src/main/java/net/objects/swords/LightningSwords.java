package net.objects.swords;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class LightningSwords extends ItemSword {
    double tmpX,tmpZ;
	double prePosX,prePosY,prePosZ;
    double HprePosX,HprePosY,HprePosZ;

    public LightningSwords(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }


    @Override
    protected RayTraceResult rayTrace(World worldIn, EntityPlayer playerIn, boolean useLiquids) {
        return super.rayTrace(worldIn, playerIn, useLiquids);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.getCooldownTracker().setCooldown(this, 60);
        ItemStack item = playerIn.getHeldItem(handIn);
        Vec3d look = playerIn.getLookVec();
        this.tmpX = playerIn.motionX;
        this.tmpZ = playerIn.motionZ;
        if(!worldIn.isRemote){
        RayTraceResult result = this.rayTrace(worldIn,playerIn, false);
        int x = result.getBlockPos().getX();
        int y = result.getBlockPos().getY();
        int z = result.getBlockPos().getZ();

        EntityLightningBolt lightningBolt = new EntityLightningBolt(worldIn, x, y, z, false);
        worldIn.addWeatherEffect(lightningBolt);


        item.damageItem(0, playerIn);}
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item); }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
            tooltip.add("Sword which can only be activated by the ones who breath " + new TextComponentString("The Lightning").setStyle(new Style().setColor(TextFormatting.YELLOW)));
        else{
            tooltip.add("Press " + new TextComponentString("Shift").setStyle(new Style().setColor(TextFormatting.YELLOW)) + " to see more information");
        }}

}
