package net.objects.swords;

import net.DemonCraft;
import net.entity.projectiles.Beast.Ugatinuki.ugatinuki;
import net.init.ItemInit;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
import net.networking.Networking;
import net.networking.messages.slayer.Slayer;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.TechProvider;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

public class BeastSwords extends ItemSword {
    int tick = 0, tick2 = 0;
    float x=0f;
    EntityPlayer player_;
    EnumHand hand_;
    World world_;
    double tmpX,tmpZ;
    double prePosX,prePosY,prePosZ;
    double HprePosX,HprePosY,HprePosZ;
    int ugatinuki_flag=0;

    public BeastSwords(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);}
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
        ItemStack item = player.getHeldItem(handIn);
        Vec3d look = player.getLookVec();
        player_=player;
        hand_=handIn;
        world_=world;
		this.tmpX = player.motionX;
		this.tmpZ = player.motionZ;
        float mana = player.getCapability(SlayerProvider.Breath_CAP, null).getMana();

		if(player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 7){
		if (player.getCapability(TechProvider.TECH_CAP, null).getTech() == 2 && mana >= 25) {

            if(tick==0) {
                tick=20; tick2=1;
                ugatinuki_flag =1;
            }
        if(tick2>0) {
            harm_on(world, player, handIn);
            if (player.onGround) {
                player.motionX += 3.8D * look.x;
                player.motionZ += 3.8D * look.z;
            } else {
                player.motionX += 1.1D * look.x;
                player.motionZ += 1.1D * look.z;
            }
            }
            player.getCapability(SlayerProvider.Breath_CAP, null).setMana(mana - 25.0F);
		}
		if (player.getCapability(TechProvider.TECH_CAP, null).getTech() == 7) {

        }
		if (player.getCapability(TechProvider.TECH_CAP, null).getTech() == 2 && mana < 25.0F) {
            player.sendMessage(new TextComponentString("You Have Run Out of Breath"));
		}
		}
		else{
		    player.sendMessage(new TextComponentString("You Have To Learn ")
                .appendSibling(new TextComponentString("Beast Breathing").setStyle(new Style().setColor(TextFormatting.DARK_BLUE)))
                .appendSibling(new TextComponentString(" To Use This Sword.")));
        }


		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

}
    @SideOnly(CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        String color = TextFormatting.DARK_BLUE.toString();
        String reset = TextFormatting.RESET.toString();
        if(GuiScreen.isShiftKeyDown())
            tooltip.add("Sword which can only be activated by the ones who breath " + color + "Beast");
        else{
            tooltip.add("Press" + color + " Shift " + reset + "to see more information");
        }
    }


    public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean B) {

        if(tick<=0) {
            tick=0;
            x=0;
            ugatinuki_flag=0;
        }

        if (this.tick > 0.0F) {
            this.tick--;

            //Seventh Move
            if (ugatinuki_flag!=0) {
                if(tick>17)ugatinuki_action2(world,player_,hand_,2,1f);

                ugatinuki_action(world,player_,hand_,0,1f);
                ugatinuki_action(world,player_,hand_,1,1f);
                ugatinuki_action(world,player_,hand_,2,1f);
                ugatinuki_action(world,player_,hand_,0,0.78f);
                ugatinuki_action(world,player_,hand_,1,0.78f);
                ugatinuki_action(world,player_,hand_,2,0.78f);
                ugatinuki_action(world,player_,hand_,0,-0.78f);
                ugatinuki_action(world,player_,hand_,1,-0.78f);
                ugatinuki_action(world,player_,hand_,2,-0.78f);
                if(tick>=0)ugatinuki_action(world,player_,hand_,6-tick,1f);
                if(tick<=3)ugatinuki_action(world,player_,hand_,6-tick,-1f);
                if(tick==1)harm_off(world_,player_,hand_);
            }
        }
    }

    //------------------------------------------------------------------------------------------

    public void ugatinuki_action(World world, EntityPlayer player, EnumHand handIn, int e, float d) {
        Vec3d look = player.getLookVec();
        Vec3d look2 = look.rotateYaw(0.1f * 0.4f);
        Vec3d look3 = look.rotateYaw(-0.1f * 0.4f);
        ugatinuki slash_1 = new ugatinuki(world);
        ugatinuki slash_2 = new ugatinuki(world);
        ugatinuki slash_3 = new ugatinuki(world);
        slash_3.shootingEntity=player;
        slash_2.shootingEntity=player;
        slash_1.shootingEntity=player;
        slash_1.setPosition(player.posX + look.x * e*d, player.posY +5.2D, player.posZ + look.z *e*d);
        slash_1.accelerationX = 0;slash_1.accelerationY = -8;slash_1.accelerationZ = 0;
        world.spawnEntity((Entity)slash_1);
        slash_2.setPosition(player.posX + look2.x * e*d , player.posY +5.2D, player.posZ + look2.z *e*d);
        slash_2.accelerationX = 0;slash_2.accelerationY = -8;slash_2.accelerationZ = 0;
        world.spawnEntity((Entity)slash_2);
        slash_3.setPosition(player.posX + look3.x * e*d , player.posY +5.2D, player.posZ + look3.z *e*d);
        slash_3.accelerationX = 0;slash_3.accelerationY = -8;slash_3.accelerationZ = 0;
        world.spawnEntity((Entity)slash_3);
    }

    public void ugatinuki_action2(World world, EntityPlayer player, EnumHand handIn, int e, float d) {
        Vec3d look = player.getLookVec();
        ugatinuki slash_1 = new ugatinuki(world);
        ugatinuki slash_2 = new ugatinuki(world);
        ugatinuki slash_3 = new ugatinuki(world);
        slash_3.shootingEntity=player;
        slash_2.shootingEntity=player;
        slash_1.shootingEntity=player;
        slash_2.setPosition(player.posX + look.x *1.4 , player.posY+look.y+1.2, player.posZ + look.z *1.4);
        slash_2.accelerationX = look.x*6;slash_2.accelerationY = look.y*5 ;slash_3.accelerationZ = look.z*6;
        world.spawnEntity((Entity)slash_2);
        slash_3.setPosition(player.posX + look.x *1.4 , player.posY+look.y+1.7, player.posZ + look.z *1.4);
        slash_3.accelerationX = look.x*6;slash_3.accelerationY = look.y*5 ;slash_3.accelerationZ = look.z*6;
        world.spawnEntity((Entity)slash_3);
        slash_1.setPosition(player.posX + look.x *1.4 , player.posY+look.y+1.7, player.posZ + look.z *1.4);
        slash_1.accelerationX = look.x*6;slash_1.accelerationY = look.y*5 ;slash_1.accelerationZ = look.z*6;
        world.spawnEntity((Entity)slash_1);
    }

//------------------------------------------------------------------------------------------

    public ActionResult<ItemStack> harm_on(World world, EntityPlayer player, EnumHand handIn){
        if(!world.isRemote){
            player.capabilities.disableDamage = true;
        }
        ItemStack item = player.getHeldItem(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    public ActionResult<ItemStack> harm_off(World world,EntityPlayer player,EnumHand handIn){
        if(!world.isRemote){
            if(!player.isCreative())
                player.capabilities.disableDamage = false;
        }
        ItemStack item = player.getHeldItem(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

}

