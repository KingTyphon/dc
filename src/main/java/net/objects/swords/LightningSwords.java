package net.objects.swords;

import net.DemonCraft;
import net.entity.projectiles.Thunder.FirstForm.HIT_hekireki;
import net.entity.projectiles.Thunder.lightning.customLightning;
import net.init.ItemInit;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.networking.messages.slayer.Slayer;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.ITechCapability;
import net.util.capabilities.techniquecapability.TechProvider;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

public class LightningSwords extends ItemSword {
    int tick = 0;
    EntityPlayer player_;
    EnumHand hand_;
    World world_;
    double tmpX, tmpZ;
    double prePosX, prePosY, prePosZ;
    boolean hekireki_flag = false, speedup_on = false;

    public LightningSwords(String name, ToolMaterial material) {
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
        ItemStack item = playerIn.getHeldItem(handIn);
        player_ = playerIn;
        hand_ = handIn;
        world_= worldIn;
        float mana = playerIn.getCapability(SlayerProvider.Breath_CAP, null).getMana();
        this.tmpX = playerIn.motionX;
        this.tmpZ = playerIn.motionZ;

        ITechCapability techcap = playerIn.getCapability(TechProvider.TECH_CAP, null);
        //First Form: Thunderclap and Flash
        if (techcap.getTech() == 1 && mana >= 25 && playerIn.getCapability(SlayerProvider.Breath_CAP, null).getBreath() ==3) {
                tick = 70;
                hekireki_flag = true;
                speedup_on = false;
                playerIn.getCapability(SlayerProvider.Breath_CAP, null).setMana(mana - 25.0F);
                playerIn.sendMessage(new TextComponentString("First Form: Thunderclap and Flash"));
        }
        if(playerIn.getCapability(TechProvider.TECH_CAP, null).getTech() == 1 && mana < 25.0F){
            playerIn.sendMessage(new TextComponentString("You Have Run Out of Breath"));
        }if (playerIn.getCapability(SlayerProvider.Breath_CAP, null).getBreath() > 3 || playerIn.getCapability(SlayerProvider.Breath_CAP, null).getBreath() < 3) {
            playerIn.sendMessage(new TextComponentString("You Have To Learn ")
                    .appendSibling(new TextComponentString("Lightning Breathing").setStyle(new Style().setColor(TextFormatting.YELLOW)))
                    .appendSibling(new TextComponentString(" To Use This Sword.")));
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean b) {
        //EntityPlayer player1 = (EntityPlayer) entity;
    if(tick<=0 ) {
        tick = 0;
        hekireki_flag = false;
    }
    if (this.tick > 0) {
        this.tick--;

        if(hekireki_flag) {

            if(tick >65 && tick < 70){
                blindness(world_, player_,hand_);
            }

            if(tick <= 15){
                Vec3d look = entity.getLookVec();
                entity.playSound(SoundEvents.ENTITY_LIGHTNING_THUNDER, 0.7F, 1.6F + (player_.getRNG().nextFloat() - player_.getRNG().nextFloat()) * 0.4F);

                if(speedup_on == false) {
                    if (entity.onGround) {
                        entity.motionX += 9.8D * look.x;
                        entity.motionZ += 9.8D * look.z;
                    } else {
                        entity.motionX += 3.2D * look.x;
                        entity.motionY += 3.2D * look.y;
                        entity.motionZ += 3.2D * look.z;
                    }speedup_on = true;
                }
            }

            if( tick>=0 && tick<20 && tick%3==0) {

                if(world.isRemote) {
                    hekireki_action(world_,player_,hand_,0,1f);
                    hekireki_action(world_,player_,hand_,1,1f);
                    hekireki_action(world_,player_,hand_,-1,1f);
                    hekireki_action(world_,player_,hand_,2,1f);
                    hekireki_action(world_,player_,hand_,6-tick,1f);
                }
                hekireki_hit(world_,player_,hand_);

                if(tick==0) {
                    unblindness(world_, player_,hand_);
                    speedDown(world_,player_,hand_);
                }
            }
        }
    }

}

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        String color = TextFormatting.YELLOW.toString();
        String reset = TextFormatting.RESET.toString();
        if(GuiScreen.isShiftKeyDown())
            tooltip.add("Sword which can only be activated by the ones who breath " + color + "Lightning");
        else{
            tooltip.add("Press" + color + " Shift " + reset + "to see more information");
        }
    }
    public void hekireki_hit(World world, EntityPlayer player, EnumHand handIn) {
        Vec3d look = player.getLookVec();
        HIT_hekireki slash_1 = new HIT_hekireki(world);
        HIT_hekireki slash_2 = new HIT_hekireki(world);
        HIT_hekireki slash_3 = new HIT_hekireki(world);
        slash_1.shootingEntity=player;
        slash_2.shootingEntity=player;
        slash_3.shootingEntity=player;
        slash_1.setPosition(player.posX + look.x *1.4 , player.posY+look.y+1.2, player.posZ + look.z *1.4);
        slash_2.setPosition(player.posX + look.x *1.4 , player.posY+look.y+1.7, player.posZ + look.z *1.4);
        slash_3.setPosition(player.posX + look.x *1.5 , player.posY+look.y+1.7, player.posZ + look.z *1.5);
        slash_1.accelerationX = look.x*6;slash_1.accelerationY = look.y*3 ;slash_1.accelerationZ = look.z*6;
        slash_2.accelerationX = look.x*6;slash_2.accelerationY = look.y*5 ;slash_2.accelerationZ = look.z*6;
        slash_3.accelerationX = look.x*9;slash_3.accelerationY = 0 ;slash_3.accelerationZ = look.z*9;
        world.spawnEntity((Entity)slash_1);
        world.spawnEntity((Entity)slash_2);
        world.spawnEntity((Entity)slash_3);
    }

    public void hekireki_action(World world, EntityPlayer player, EnumHand handIn, int e, float d) {
        customLightning slash = new customLightning(world ,player.posX ,player.posY ,player.posZ ,false);
        world.spawnEntity((Entity)slash);
    }

    public ActionResult<ItemStack> speedDown(World world,EntityPlayer player,EnumHand handIn){
        if(!world.isRemote){
            player.motionX = this.tmpX;
            player.motionZ = this.tmpZ;
        }
        ItemStack item = player.getHeldItem(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

    }

    public ActionResult<ItemStack> blindness(World world,EntityPlayer player,EnumHand handIn){
        if(!world.isRemote){
            player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 45, 0, false, false));
        }
        ItemStack item = player.getHeldItem(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    public ActionResult<ItemStack> unblindness(World world,EntityPlayer player,EnumHand handIn){
        if(!world.isRemote){
            player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 1, 0, false, false));
        }
        ItemStack item = player.getHeldItem(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }


}
