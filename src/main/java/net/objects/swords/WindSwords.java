package net.objects.swords;

import net.DemonCraft;
import net.entity.projectiles.Wind.Form6.kokuhuu;
import net.entity.projectiles.Wind.Form6.kokuhuu_hit;
import net.entity.projectiles.Wind.itaden.idaten;
import net.entity.projectiles.Wind.sinato;
import net.entity.projectiles.Wind.sinato_hit;
import net.entity.projectiles.Wind.sogi.HIT_sogi;
import net.entity.projectiles.Wind.sogi.sogi;
import net.init.ItemInit;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import net.util.capabilities.techniquecapability.TechProvider;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

public class WindSwords extends ItemSword{

    int tick = 0;

    int tick2 = 0;

    float x = 0.0F;

    EntityPlayer player_;

    EnumHand hand;

    World world_;

    double tmpX;

    double tmpZ;

    double prePosX;

    double prePosY;

    double prePosZ;

    double HprePosX;

    double HprePosY;

    double HprePosZ;

    int sogi_flag = 0, kokuhuu_flag = 0, idaten_flag = 0, sinato_flag = 0;

    public WindSwords(String name, ToolMaterial material)
    { super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
        ItemStack item = player.getHeldItem(handIn);
        this.player_ = player;
        this.hand = handIn;
        this.world_ = world;
        int form = player.getCapability(TechProvider.TECH_CAP, null).getTech();

        if(player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 5){
        if (form == 1 && this.tick == 0) {
            this.tick = 70;
            this.sogi_flag = 1;
            harm_on(world, player, handIn);
            this.tmpX = player.motionX;
            this.tmpZ = player.motionZ;
            player.getCapability(SlayerProvider.Breath_CAP, null).useMana(25);
        }
        if (form == 2 && this.tick == 0){
            this.tick = 50;
            this.sinato_flag = 1;
            player.getCapability(SlayerProvider.Breath_CAP, null).useMana(25);
        }
        if (form == 6 && this.tick == 0 ){
            this.player_ = player;
            this.tick = 60;
            this.kokuhuu_flag = 1;
            harm_on(world, player, handIn);
            player.getCapability(SlayerProvider.Breath_CAP, null).useMana(40);
        }
        if (form == 9 && this.tick == 0) {
            player.addVelocity(0.0D, 1.1D, 0.0D);
            this.tick = 60;
            this.idaten_flag = 1;
            harm_on(world, player, handIn);
            player.getCapability(SlayerProvider.Breath_CAP, null).useMana(60);
        }
        else if ( player.getCapability(SlayerProvider.Breath_CAP, null).getMana()<= 24){
            player.sendMessage(new TextComponentString("You Have Run Out of Breath"));
        }
        }else if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() > 4 || player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() < 4) {
        player.sendMessage(new TextComponentString("You Have To Learn ")
        .appendSibling(new TextComponentString("Wind Breathing").setStyle(new Style().setColor(TextFormatting.GRAY)))
        .appendSibling(new TextComponentString(" To Use This Sword.")));
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    public void func_77663_a(ItemStack itemstack, World world, Entity entity, int i, boolean B) {
        if (this.tick <= 0) {
            this.tick = 0;
            this.tick2 = 0;
            this.sogi_flag = this.kokuhuu_flag = this.idaten_flag = this.sinato_flag = 0;
        }
        if (this.tick > 0) {
            this.tick--;
            if (this.sogi_flag != 0) {
                if (this.tick % 2 == 1) {
                    float i0;
                    for (i0 = 0.0F; i0 < 4.0F; i0 = (float)(i0 + 0.3D)) {
                        float i1;
                        for (i1 = 0.5F; i1 < 5.0F; ) {
                            sogi_action(world, this.player_, this.hand, i1, i0, 70 - this.tick);
                            i1 = (float)(i1 + 0.8D);
                        }
                    }
                    for (i0 = 0.0F; i0 < 3.0F; i0++) {
                        float i1;
                        for (i1 = 0.5F; i1 < 5.0F; ) {
                            sogi_action_HIT(world, this.player_, this.hand, i1, i0, 70 - this.tick);
                            i1 = (float)(i1 + 1.8D);
                        }
                    }
                }
                if (this.tick == 0)
                    harm_off(this.world_, this.player_, this.hand);
            }
            if (this.sinato_flag != 0 &&
                    this.tick <= 44 && this.tick % 2 == 1) {
                sinato_action(world, this.player_, this.hand, 1.2F, (44 - this.tick));
                sinato_action(world, this.player_, this.hand, 3.0F, (44 - this.tick));
                sinato_action2(world, this.player_, this.hand, 1.2F, (44 - this.tick));
                sinato_action2(world, this.player_, this.hand, 3.0F, (44 - this.tick));
            }
            if (this.kokuhuu_flag != 0) {
                harm_on(world, this.player_, this.hand);
                if (this.tick % 10 == 1 && this.tick > 35)
                    kokuhuu_action1(world, this.player_, this.hand, (float)((60 - this.tick) * 0.15D), 2);
                if (this.tick % 4 == 1 && this.tick > 35)
                    kokuhuu_action2(world, this.player_, this.hand, (float)((60 - this.tick) * 0.1D), 2);
                if (this.tick == 0) {
                    harm_off(this.world_, this.player_, this.hand);
                    speedDown(world, this.player_, this.hand);
                }
            }
            if (this.idaten_flag != 0) {
                harm_on(world, this.player_, this.hand);
                if (this.tick % 4 == 1)
                    idaten_action1(world, this.player_, this.hand, (float)((60 - this.tick) * 0.2D), 2);
                if (this.tick == 0) {
                    harm_off(this.world_, this.player_, this.hand);
                    speedDown(world, this.player_, this.hand);
                }
            }
        }
    }

    public void kokuhuu_action1(World world, EntityPlayer player, EnumHand handIn, float e, int x) {
        Vec3d look = player.getLookVec();
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 17; i++) {
                Vec3d look2 = look.rotateYaw(42.0F * i);
                kokuhuu slash = new kokuhuu(world);
                slash.shootingEntity = (EntityLivingBase)player;
                if (look.y < 0.0D) {
                    slash.setPosition(player.posX + look.x * 6.0D + look2.x * e, player.posY + look.y + 0.2D + k, player.posZ + look.z * 6.0D + look2.z * e);
                } else {
                    slash.setPosition(player.posX + look.x * 6.0D + look2.x * e, player.posY + look.y * e * 0.2D + k, player.posZ + look.z * 6.0D + look2.z * e);
                }
                slash.accelerationX = 0.0D;
                slash.accelerationY = 0.0D;
                slash.accelerationZ = 0.0D;
                world.spawnEntity((Entity)slash);
            }
        }
    }

    public void kokuhuu_action2(World world, EntityPlayer player, EnumHand handIn, float e, int x) {
        Vec3d look = player.getLookVec();
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 17; i++) {
                Vec3d look2 = look.rotateYaw(42.0F * i);
                kokuhuu_hit slash = new kokuhuu_hit(world);
                slash.shootingEntity = (EntityLivingBase)player;
                if (look.y < 0.0D) {
                    slash.setPosition(player.posX + look.x * 6.0D + look2.x * e, player.posY + look.y + 0.2D + k, player.posZ + look.z * 6.0D + look2.z * e);
                } else {
                    slash.setPosition(player.posX + look.x * 6.0D + look2.x * e, player.posY + look.y * e * 0.2D + k, player.posZ + look.z * 6.0D + look2.z * e);
                }
                slash.accelerationX = 0.0D;
                slash.accelerationY = -2.0D;
                slash.accelerationZ = 0.0D;
                world.spawnEntity((Entity)slash);
            }
        }
    }

    public void idaten_action1(World world, EntityPlayer player, EnumHand handIn, float e, int x) {
        Vec3d look = player.getLookVec();
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 17; i++) {
                Vec3d look2 = look.rotateYaw(42.0F * i);
                idaten slash = new idaten(world);
                slash.shootingEntity = (EntityLivingBase)player;
                if (look.y < 0.0D) {
                    slash.setPosition(player.posX + look.x + look2.x * e, player.posY + look.y + 0.2D + k, player.posZ + look.z + look2.z * e);
                } else {
                    slash.setPosition(player.posX + look.x + look2.x * e, player.posY + look.y * e * 0.2D + k, player.posZ + look.z + look2.z * e);
                }
                slash.accelerationX = look2.x;
                slash.accelerationY = -3.0D;
                slash.accelerationZ = look2.z;
                world.spawnEntity((Entity)slash);
            }
        }
    }

    public void sinato_action(World world, EntityPlayer player, EnumHand handIn, float d, float e) {
        Vec3d look = player.getLookVec();
        Vec3d look2 = look.rotateYaw(0.1F * d);
        Vec3d look3 = look.rotateYaw(-0.1F * d);
        sinato slash_2 = new sinato(world);
        sinato slash_3 = new sinato(world);
        slash_2.shootingEntity = (EntityLivingBase)player;
        slash_3.shootingEntity = (EntityLivingBase)player;
        if (look2.y < 0.0D) {
            slash_2.setPosition(player.posX + look2.x * e, player.posY + 1.0D, player.posZ + look2.z * e);
            slash_3.setPosition(player.posX + look3.x * e, player.posY + 1.0D, player.posZ + look3.z * e);
        } else {
            slash_2.setPosition(player.posX + look2.x * e, player.posY + look2.y * e + 0.6D, player.posZ + look2.z * e);
            slash_3.setPosition(player.posX + look3.x * e, player.posY + look2.y * e + 0.6D, player.posZ + look3.z * e);
        }
        slash_2.accelerationX = 0.0D;
        slash_2.accelerationY = -3.2D;
        slash_2.accelerationZ = 0.0D;
        slash_3.accelerationX = 0.0D;
        slash_3.accelerationY = -3.2D;
        slash_3.accelerationZ = 0.0D;
        world.spawnEntity((Entity)slash_2);
        world.spawnEntity((Entity)slash_3);
    }

    public void sinato_action2(World world, EntityPlayer player, EnumHand handIn, float d, float e) {
        Vec3d look = player.getLookVec();
        Vec3d look2 = look.rotateYaw(0.1F * d);
        Vec3d look3 = look.rotateYaw(-0.1F * d);
        sinato_hit slash_2 = new sinato_hit(world);
        sinato_hit slash_3 = new sinato_hit(world);
        slash_2.shootingEntity = (EntityLivingBase)player;
        slash_3.shootingEntity = (EntityLivingBase)player;
        if (look2.y < 0.0D) {
            slash_2.setPosition(player.posX + look2.x * e, player.posY + 1.0D, player.posZ + look2.z * e);
            slash_3.setPosition(player.posX + look3.x * e, player.posY + 1.0D, player.posZ + look3.z * e);
        } else {
            slash_2.setPosition(player.posX + look2.x * e, player.posY + look2.y * e + 0.6D, player.posZ + look2.z * e);
            slash_3.setPosition(player.posX + look3.x * e, player.posY + look3.y * e + 0.6D, player.posZ + look3.z * e);
        }
        slash_2.accelerationX = 0.0D;
        slash_2.accelerationY = -4.0D;
        slash_2.accelerationZ = 0.0D;
        world.spawnEntity((Entity)slash_2);
        slash_3.accelerationX = 0.0D;
        slash_3.accelerationY = -4.0D;
        slash_3.accelerationZ = 0.0D;
        world.spawnEntity((Entity)slash_3);
    }

    public void sogi_action_HIT(World world, EntityPlayer player, EnumHand handIn, float i1, float d, int e) {
        Vec3d look = player.getLookVec();
        Vec3d look1 = look.rotateYaw(0.1F * d);
        Vec3d look2 = look.rotateYaw(-0.1F * d);
        HIT_sogi sogi_0 = new HIT_sogi(world);
        HIT_sogi sogi_1 = new HIT_sogi(world);
        HIT_sogi sogi_2 = new HIT_sogi(world);
        sogi_0.shootingEntity = (EntityLivingBase)player;
        sogi_1.shootingEntity = (EntityLivingBase)player;
        sogi_2.shootingEntity = (EntityLivingBase)player;
        sogi_0.setPosition(player.posX + look.x * 0.8D * e, player.posY + look.y * e + i1, player.posZ + look.z * 0.8D * e);
        sogi_0.accelerationX = 0.0D;
        sogi_0.accelerationY = -7.0D;
        sogi_0.accelerationZ = 0.0D;
        world.spawnEntity((Entity)sogi_0);
        sogi_1.setPosition(player.posX + look1.x * 0.8D * e, player.posY + look1.y * e + i1, player.posZ + look1.z * 0.8D * e);
        sogi_1.accelerationX = 0.0D;
        sogi_1.accelerationY = -7.0D;
        sogi_1.accelerationZ = 0.0D;
        world.spawnEntity((Entity)sogi_1);
        sogi_2.setPosition(player.posX + look2.x * 0.8D * e, player.posY + look2.y * e + i1, player.posZ + look2.z * 0.8D * e);
        sogi_2.accelerationX = 0.0D;
        sogi_2.accelerationY = -7.0D;
        sogi_2.accelerationZ = 0.0D;
        world.spawnEntity((Entity)sogi_2);
    }

    public void sogi_action(World world, EntityPlayer player, EnumHand handIn, float i1, float d, int e) {
        Vec3d look = player.getLookVec();
        Vec3d look1 = look.rotateYaw(0.1F * d);
        Vec3d look2 = look.rotateYaw(-0.1F * d);
        sogi sogi_0 = new sogi(world);
        sogi sogi_1 = new sogi(world);
        sogi sogi_2 = new sogi(world);
        sogi_0.shootingEntity = (EntityLivingBase)player;
        sogi_1.shootingEntity = (EntityLivingBase)player;
        sogi_2.shootingEntity = (EntityLivingBase)player;
        sogi_0.setPosition(player.posX + look.x * 0.8D * e, player.posY + look.y * e + i1, player.posZ + look.z * 0.8D * e);
        sogi_0.accelerationX = look.x * 3.0D;
        sogi_0.accelerationY = look.y;
        sogi_0.accelerationZ = look.z * 3.0D;
        world.spawnEntity((Entity)sogi_0);
        sogi_1.setPosition(player.posX + look1.x * 0.8D * e, player.posY + look1.y * e + i1, player.posZ + look1.z * 0.8D * e);
        sogi_1.accelerationX = look1.x * 3.0D;
        sogi_1.accelerationY = look1.y;
        sogi_1.accelerationZ = look1.z * 3.0D;
        world.spawnEntity((Entity)sogi_1);
        sogi_2.setPosition(player.posX + look2.x * 0.8D * e, player.posY + look2.y * e + i1, player.posZ + look2.z * 0.8D * e);
        sogi_2.accelerationX = look2.x * 3.0D;
        sogi_2.accelerationY = look2.y;
        sogi_2.accelerationZ = look2.z * 3.0D;
        world.spawnEntity((Entity)sogi_2);
    }

    public ActionResult<ItemStack> harm_on(World world, EntityPlayer player, EnumHand handIn) {
        if (!world.isRemote)
            player.capabilities.disableDamage = true;
        ItemStack item = player.getHeldItem(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    public ActionResult<ItemStack> harm_off(World world, EntityPlayer player, EnumHand handIn) {
        if (!world.isRemote &&
                !player.isCreative())
            player.capabilities.disableDamage = false;
        ItemStack item = player.getHeldItem(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    public ActionResult<ItemStack> speedUP__(World world, EntityPlayer player, EnumHand handIn) {
        System.out.println("Right-clicked2222");
        Vec3d look = player.getLookVec();
        player.motionX += 5.8D * look.x;
        player.motionZ += 5.8D * look.z;
        ItemStack item = player.getHeldItem(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }

    public ActionResult<ItemStack> speedDown(World world, EntityPlayer player, EnumHand handIn) {
        if (!world.isRemote) {
            player.motionX = this.tmpX;
            player.motionZ = this.tmpZ;
        }
        ItemStack item = player.getHeldItem(handIn);
        System.out.println("Right-1");
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }
    @SideOnly(CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        String color = TextFormatting.BLUE.toString();
        String reset = TextFormatting.RESET.toString();
        if(GuiScreen.isShiftKeyDown())
            tooltip.add("Sword which can only be activated by the ones who breath " + color + "Wind");
        else{
            tooltip.add("Press" + color + " Shift " + reset + "to see more information");
        }
    }
}