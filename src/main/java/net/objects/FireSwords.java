package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.util.IHasModel;

public class FireSwords extends ItemSword implements IHasModel{
    public FireSwords(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }
    public void registerModels() {
        DemonCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
            ItemStack item = playerIn.getHeldItem(handIn);
        playerIn.getCooldownTracker().setCooldown(this, 60);
        Vec3d aim = playerIn.getLookVec();
        EntityLargeFireball fireball = new EntityLargeFireball(worldIn, playerIn, 1, 1, 1);

        fireball.setPosition(playerIn.posX + aim.x * 1.5D, playerIn.posY + aim.y * 1.5D, playerIn.posZ + aim.z * 1.5D);
        fireball.accelerationX = aim.x * 0.1; fireball.accelerationY = aim.y * 0.1; fireball.accelerationZ = aim.z * 0.1;
        worldIn.spawnEntity(fireball);

        item.damageItem(0, playerIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item); }

}
