package net.objects.swords;

import net.DemonCraft;
import net.entity.projectiles.Mist.Kasumi.kasumi;
import net.entity.projectiles.Mist.Kasumi.kasumi_HIT;
import net.entity.projectiles.Mist.SeventhForm.oboro;
import net.init.ItemInit;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.TechProvider;
import net.util.handlers.SoundHandler;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;


public class MistSwords extends ItemSword {

    int tick=0;
    EntityPlayer player_;
    EnumHand hand_;
    World world_;
    boolean kasumi_flag=false,oboro_flag=false;

    public MistSwords(String name, ToolMaterial material) {

        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
        ItemStack item = player.getHeldItem(handIn);
        player_= player;
        hand_ = handIn;
        world_ = worldIn;
        if(!worldIn.isRemote){
            if (player.hasCapability(SlayerProvider.Breath_CAP, null)) {
                if(tick >0){
                    player.sendMessage(new TextComponentString("Cooldown: " + tick ));
                }

                else if(player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 5){
                    if(player.getCapability(TechProvider.TECH_CAP, null).getTech() ==4)
                        worldIn.playSound(player, player.posX, player.posY, player.posZ,  SoundHandler.KASUMI_SOUND, SoundCategory.AMBIENT, 1f, 1f);
                        tick = 70;
                        kasumi_flag = true;
                    if(player.getCapability(TechProvider.TECH_CAP, null).getTech() ==7)
                        worldIn.playSound(player, player.posX, player.posY, player.posZ,  SoundHandler.KASUMI_SOUND, SoundCategory.AMBIENT, 1f, 1f);
                        tick = 60;
                        oboro_flag =true;
                    }
                }
            }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    //---------------------------------------------------------------------------

    public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean B) {

        if(tick<=0) {
            tick=0;
            kasumi_flag = oboro_flag= false;
        }

        if (this.tick > 0) {
            this.tick--;


            if(kasumi_flag) {
                if(tick% 6==1 && tick > 35)iryuu_kasumi(world_,player_,hand_,(float) ((30-tick)*0.4),2);
                if(tick==65) {player_.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 40, 4, false, false));}
                if(tick<70 && tick %3 ==1)iryuu_kasumi_hit(world_,player_,hand_);
            }


            if(oboro_flag) {
                if(tick%6 ==1 && tick >30)oboro_kasumi(world_,player_,hand_,(float) ((30-tick)*0.4));
                if(tick<=13)oboro_kasumi_hit(world_,player_,hand_,(float) 13.5-tick);

            }

            if(tick==0) {
                invincible_off(world_,player_,hand_);
            }
        }
    }
    //---------------------------------------------------------------------------

    public void oboro_kasumi(World world, EntityPlayer player, EnumHand handIn, float dist) {
        Vec3d look = player.getLookVec();
        for(int i=0;i<4;i++) {
            for(int j=0;j<17;j++) {
                Vec3d look2 = look.rotateYaw(42f * j);
                kasumi slash = new kasumi(world);
                slash.shootingEntity=player;
                if(look.y<0){slash.setPosition(player.posX+look2.x * dist , player.posY + look.y + 0.2+i , player.posZ + look2.z * dist);}
                else {slash.setPosition(player.posX+look2.x * dist , player.posY + look.y * dist *0.2+i ,player.posZ + look2.z * dist);}
                slash.accelerationX = 0;slash.accelerationY = 0;slash.accelerationZ = 0;
                world.spawnEntity((Entity)slash);
            }
        }
    }

    public void oboro_kasumi_hit(World world, EntityPlayer player, EnumHand handIn, float dist) {
        Vec3d look = player.getLookVec();
        for(int i=0;i<210;i++) {
            Vec3d look2 = look.rotateYaw(0.03f * i);
            oboro slash = new oboro(world);
            slash.shootingEntity=player;
            if(look.y<0) {slash.setPosition(player.posX+look2.x * dist , player.posY + 0.4 , player.posZ + look2.z * dist);}
            else {slash.setPosition(player.posX+look2.x * dist , player.posY + look.y + 0.6 ,player.posZ + look2.z * dist);}
            slash.accelerationX = look2.x*0.35; slash.accelerationY = 0;slash.accelerationZ =look2.z* 0.35;
            world.spawnEntity((Entity)slash);
        }
    }

    //---------------------------------------------------------------------------

    public void iryuu_kasumi(World world, EntityPlayer player, EnumHand handIn, float e,int x) {
        Vec3d look = player.getLookVec();
        for(int k=0;k<4;k++) {
            for(int i=0;i<17;i++) {
                kasumi slash = new kasumi(world);
                Vec3d look2 = look.rotateYaw(042f * i);
                slash.shootingEntity=player;
                slash.accelerationX = 0;slash.accelerationY = 0;slash.accelerationZ = 0;
                if(look.y<0) {slash.setPosition(player.posX+look.x*16+look2.x * e , player.posY + look.y + 0.2+k , player.posZ+look.z * 16 + look2.z * e);}
                else {slash.setPosition(player.posX+look.x*16+look2.x * e , player.posY + look.y * e*0.2+k ,player.posZ+ look.z * 16 + look2.z * e);}
                world.spawnEntity((Entity)slash);
            }
        }
    }

    public void iryuu_kasumi_hit(World world, EntityPlayer player, EnumHand hand) {
        Vec3d look = player.getLookVec();
        for(int i=0;i<14;i++) {
            kasumi_HIT slash = new kasumi_HIT(world);
            Vec3d look2 = look.rotateYaw(0.32f * i);
            slash.shootingEntity=player;
            slash.accelerationX = look2.x*0.7 ;slash.accelerationY = look2.y*0.7 ;slash.accelerationZ = look2.z*0.7;
            slash.setPosition(player.posX+look2.x*1, player.posY+1.1,player.posZ+look2.z*1);
            world.spawnEntity((Entity)slash);
        }
    }

    //---------------------------------------------------------------------------

    public ActionResult<ItemStack> invincible_on(World world,EntityPlayer player,EnumHand handIn){
        if(!world.isRemote){
            player.capabilities.disableDamage = true;
        }
        ItemStack item = player.getHeldItem(handIn);

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    public ActionResult<ItemStack> invincible_off(World world,EntityPlayer player,EnumHand handIn){
        if(!world.isRemote){
            if(!player.isCreative())
                player.capabilities.disableDamage = false;
        }
        ItemStack item = player.getHeldItem(handIn);

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }


    @SideOnly(CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        String color = TextFormatting.GRAY.toString();
        String reset = TextFormatting.RESET.toString();
        if (GuiScreen.isShiftKeyDown())
            tooltip.add("Sword which can only be activated by the ones who breath " + color + "Mist");
        else {
            tooltip.add("Press" + color + " Shift " + reset + "to see more information");
        }
    }
}