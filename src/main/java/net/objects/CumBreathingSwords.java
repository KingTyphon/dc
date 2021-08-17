package net.objects;

import net.DemonCraft;
import com.google.common.collect.Multimap;
import net.util.capabilities.SlayerProvider;
import net.init.ItemInit;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class CumBreathingSwords extends ItemSword {
    public CumBreathingSwords(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
        }

        return multimap;
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        playerIn.getCooldownTracker().setCooldown(this, 60);
        Vec3d aim = playerIn.getLookVec();
        if(playerIn.hasCapability(SlayerProvider.Breath_CAP, null)){
            if (playerIn.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 10){
                EntityLargeFireball fireball = new EntityLargeFireball(worldIn, playerIn, 1, 1, 1);

                fireball.setPosition(playerIn.posX + aim.x * 1.5D, playerIn.posY + aim.y * 1.5D, playerIn.posZ + aim.z * 1.5D);
                fireball.accelerationX = aim.x * 0.1; fireball.accelerationY = aim.y * 0.1; fireball.accelerationZ = aim.z * 0.1;
                worldIn.spawnEntity(fireball);
            }
            if (playerIn.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 0 - 9 + 1){
                playerIn.sendMessage(new TextComponentString("You Have To Learn Fire Breathing To Use This Sword"));
            }
            if (playerIn.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 11 - 17 + 1){
                playerIn.sendMessage(new TextComponentString("You Have To Learn Fire Breathing To Use This Sword"));
            }}
        item.damageItem(0, playerIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item); }

}
