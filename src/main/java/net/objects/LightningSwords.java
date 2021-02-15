package net.objects;

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
import net.minecraft.world.World;
import net.util.IHasModel;

import javax.annotation.Nullable;
import java.util.List;

public class LightningSwords extends ItemSword implements IHasModel{


    public LightningSwords(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    protected RayTraceResult rayTrace(World worldIn, EntityPlayer playerIn, boolean useLiquids) {
        return super.rayTrace(worldIn, playerIn, useLiquids);
    }


    public void registerModels() {
        DemonCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.getCooldownTracker().setCooldown(this, 60);
        ItemStack item = playerIn.getHeldItem(handIn);
        Vec3d aim = playerIn.getLookVec();
        if(!worldIn.isRemote){
        RayTraceResult result = this.rayTrace(worldIn,playerIn, false);
        int x = result.getBlockPos().getX();
        int y = result.getBlockPos().getY();
        int z = result.getBlockPos().getZ();

        EntityLightningBolt lightningBolt = new EntityLightningBolt(worldIn, x, y, z, false);
        worldIn.addWeatherEffect(lightningBolt);


        item.damageItem(0, playerIn);}
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item); }

     {
    }

    {
    }

}
