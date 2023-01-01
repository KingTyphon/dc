package net.objects.swords;

import net.DemonCraft;
import net.entity.projectiles.Shadow.EntityShadowball;
import net.entity.projectiles.Shadow.EntityShadowslash;
import net.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.networking.Client.ClientSlayer;
import net.networking.Networking;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.TechProvider;
import net.util.handlers.SoundHandler;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class ShadowSwords extends ItemSword {

    int tick = 0;
    public ShadowSwords(String name, ToolMaterial material)
    { super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);}


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
    ItemStack item = player.getHeldItem(handIn);
        if(!worldIn.isRemote){
            if (player.hasCapability(SlayerProvider.Breath_CAP, null)) {
                if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 4) {
                    EntityShadowball ball = new EntityShadowball(worldIn);
                    EntityShadowslash slash = new EntityShadowslash(worldIn);
                    float reach = 16f;
                    float mana = player.getCapability(SlayerProvider.Breath_CAP, null).getMana();

                    Vec3d eyepos = player.getPositionEyes(1f);
                    Vec3d lookangle = player.getLook(1f);
                    Vec3d vec = eyepos.addVector(lookangle.x*reach, lookangle.y*reach, lookangle.z*reach);
                    Vec3d lastVec = eyepos.addVector(lookangle.x, lookangle.y, lookangle.z);
                    Vec3d look =player.getLookVec();

                    if(tick >0){
                        player.sendMessage(new TextComponentString("Cooldown: " + tick ));
                    }
                    //Form 3
                    if(player.getCapability(TechProvider.TECH_CAP, null).getTech() == 3 && mana >= 25){
                    AxisAlignedBB AABB = new AxisAlignedBB(lastVec.x, lastVec.y, lastVec.z, vec.x, vec.y, vec.z);
                    for (Entity entity : worldIn.getEntitiesWithinAABBExcludingEntity(player, AABB)) {
                    if (entity instanceof EntityLivingBase){
                        EntityLivingBase living = (EntityLivingBase) entity;
                        living.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS,100, 1));
                        player.sendMessage(new TextComponentString("Shadow Breathing 3rd Form: Darkness of the Dawn"));
                        player.getCapability(SlayerProvider.Breath_CAP, null).setMana(mana - 25.0F);
                        Minecraft MINECRAFT = Minecraft.getMinecraft();
                        MINECRAFT.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, living.posX + 0.5D, living.posY+ 1.0D, living.posZ + 0.5D, 0, 0, 0);
                    break;
                            }
                        }
                    Networking.sendTo(new ClientSlayer(player.getCapability(SlayerProvider.Breath_CAP, null).getBreath(),player.getCapability(SlayerProvider.Breath_CAP, null).getMana(), player.getCapability(SlayerProvider.Breath_CAP, null).getXP(), player.getCapability(SlayerProvider.Breath_CAP, null).getLevel(), player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana()), (EntityPlayerMP) player );

                    }

                    //Form 1
                    if(player.getCapability(TechProvider.TECH_CAP, null).getTech() == 1 && mana >= 25) {
                        slash.setLocationAndAngles(player.posX + look.x * 2, player.posY + player.eyeHeight - 1, player.posZ + look.z * 2, player.rotationYaw, player.rotationYaw);
                        slash.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 3F, 0.0F);
                        worldIn.spawnEntity((Entity) slash);
                        player.spawnSweepParticles();
                        player.sendMessage(new TextComponentString("Shadow Breathing 1st Form: Shadow-Slice"));
                        player.getCapability(SlayerProvider.Breath_CAP, null).setMana(mana - 25.0F);
                        Networking.sendTo(new ClientSlayer(player.getCapability(SlayerProvider.Breath_CAP, null).getBreath(),player.getCapability(SlayerProvider.Breath_CAP, null).getMana(), player.getCapability(SlayerProvider.Breath_CAP, null).getXP(), player.getCapability(SlayerProvider.Breath_CAP, null).getLevel(), player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana()), (EntityPlayerMP) player );
                    }

                    //Form 5
                    if(player.getCapability(TechProvider.TECH_CAP, null).getTech() == 5 && mana >= 20) {
                        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 80, 1,true, false));
                        player.sendMessage(new TextComponentString("Shadow Breathing 5th Form: Blessing of the Dark"));
                        player.getCapability(SlayerProvider.Breath_CAP, null).setMana(mana - 20.0F);
                        Networking.sendTo(new ClientSlayer(player.getCapability(SlayerProvider.Breath_CAP, null).getBreath(),player.getCapability(SlayerProvider.Breath_CAP, null).getMana(), player.getCapability(SlayerProvider.Breath_CAP, null).getXP(), player.getCapability(SlayerProvider.Breath_CAP, null).getLevel(), player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana()), (EntityPlayerMP) player );
                        tick = 15;
                        }

                    //Curse of the Dark : Form 4
                    if(mana >= 25 && player.getCapability(TechProvider.TECH_CAP, null).getTech() == 4 && mana >= 25){
                        ball.posX = player.posX + look.x;
                        ball.posY= player.posY + player.eyeHeight -1;
                        ball.posZ=player.posZ + look.z;
                        ball.setRotationYawHead(player.rotationYawHead);
                        ball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 3F, 0.0F);
                        worldIn.spawnEntity((Entity) ball);
                        player.sendMessage(new TextComponentString("Shadow Breathing 4th Form: Curse of the Dark"));
                        player.getCapability(SlayerProvider.Breath_CAP, null).setMana(mana - 25.0F);
                        Networking.sendTo(new ClientSlayer(player.getCapability(SlayerProvider.Breath_CAP, null).getBreath(),player.getCapability(SlayerProvider.Breath_CAP, null).getMana(), player.getCapability(SlayerProvider.Breath_CAP, null).getXP(), player.getCapability(SlayerProvider.Breath_CAP, null).getLevel(), player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana()), (EntityPlayerMP) player );
                        tick=20;
                    }

                    else if (mana <= 24 || mana <= 19 && player.getCapability(TechProvider.TECH_CAP, null).getTech() == 5){
                        player.sendMessage(new TextComponentString("You Have Run Out of Breath"));
                    }

                }
            }else if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() > 4 || player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() < 4) {
                player.sendMessage(new TextComponentString("You Have To Learn ")
                        .appendSibling(new TextComponentString("Shadow Breathing").setStyle(new Style().setColor(TextFormatting.DARK_PURPLE)))
                        .appendSibling(new TextComponentString(" To Use This Sword.")));
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity player, int itemSlot, boolean isSelected)
    {
        EntityPlayer player1 = (EntityPlayer) player;
        if (this.tick == 20) {
            worldIn.playSound(player1, player.posX, player.posY, player.posZ, SoundHandler.SHADOW_AMBIENT, SoundCategory.AMBIENT, 1f, 1f);
        }
        if(this.tick == 15){
            player1.isInvisible();

        }
        this.tick--;
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
            tooltip.add("Sword which can only be activated by the ones who breath " + new TextComponentString("The Shadow").setStyle(new Style().setColor(TextFormatting.DARK_PURPLE)));
        else{
            tooltip.add("Press " + new TextComponentString("Shift").setStyle(new Style().setColor(TextFormatting.YELLOW)) + " to see more information");
        }
    }


}
