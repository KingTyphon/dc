package net.world;


import net.entity.Demon.EntityDemon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.networking.Client.ClientSlayer;
import net.networking.Client.tech.ClientTech;
import net.networking.Networking;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.capabilities.techniquecapability.TechProvider;

public class Events {

    Minecraft mc = Minecraft.getMinecraft();


    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event){

        //Capabilities
        EntityPlayerMP player = (EntityPlayerMP) event.getEntityPlayer();;

        //Gets the Old Player
        ISlayerCapability playerOld = event.getOriginal().getCapability(SlayerProvider.Breath_CAP, null);
        ISlayerCapability playerNew = player.getCapability(SlayerProvider.Breath_CAP, null);
        if (event.isWasDeath() && player != null && !player.world.isRemote) {
            player.getCapability(TechProvider.TECH_CAP, null).setTech(event.getOriginal().getCapability(TechProvider.TECH_CAP, null).getTech());
            Networking.sendTo(new ClientTech(event.getOriginal()), (EntityPlayerMP) player);

            //Sets the players current stats to match up with the stats they had before death

            playerNew.setBreath(playerOld.getBreath());
            playerNew.setXP(playerOld.getXP());
            playerNew.setLevel(playerOld.getLevel());
            playerNew.setMaxMana(playerOld.getMaxMana());
            playerNew.setMana(playerOld.getMaxMana());
            Networking.sendToServer(new ClientSlayer(playerNew.getBreath(), playerNew.getMana(), playerNew.getXP(), playerNew.getLevel(), playerNew.getMaxMana()));
            Networking.sendTo(new ClientSlayer(playerNew.getBreath(), playerNew.getMana(), playerNew.getXP(), playerNew.getLevel(), playerNew.getMaxMana()), player);

            //Sends the stats over if they have a breathing technique
            if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() > 0) {
                player.capabilities.setPlayerWalkSpeed(0.13f);
                if (!player.isInWater() && !player.isCreative()) player.addVelocity(0F, 0.01F, 0F);
                player.fallDistance = 0.0F;
                player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32);
                player.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(6);
                player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
            }
        }
        //Does this to make sure it copies the stats over
        if (!event.isWasDeath() && player != null) {
            Networking.sendToServer(new ClientSlayer(playerOld.getBreath(), playerOld.getMana(), playerOld.getXP(), playerOld.getLevel(), playerOld.getMaxMana()));
            Networking.sendTo(new ClientSlayer(playerOld.getBreath(), playerOld.getMana(), playerOld.getXP(), playerOld.getLevel(), playerOld.getMaxMana()), (EntityPlayerMP) player);
            playerNew.setBreath(playerOld.getBreath());
            playerNew.setXP(playerOld.getXP());
            playerNew.setMana(playerOld.getMaxMana());
            playerNew.setLevel(playerOld.getLevel());
            playerNew.setMaxMana(playerOld.getMaxMana());

            player.getCapability(TechProvider.TECH_CAP, null).setTech(event.getOriginal().getCapability(TechProvider.TECH_CAP, null).getTech());
            Networking.sendTo(new ClientTech(event.getOriginal()), (EntityPlayerMP) player);
        }

        Networking.sendToServer(new ClientSlayer(playerNew.getBreath(), playerNew.getMana(), playerNew.getXP(), playerNew.getLevel(), playerNew.getMaxMana()));
        Networking.sendTo(new ClientSlayer(playerNew.getBreath(), playerNew.getMana(), playerNew.getXP(), playerNew.getLevel(), playerNew.getMaxMana()), player);
    }
    @SubscribeEvent
    public void playerLoggedInEvent(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        World world = event.player.world;
        ISlayerCapability playerOld = event.player.getCapability(SlayerProvider.Breath_CAP, null);
        if(!world.isRemote) {
            Networking.sendTo(new ClientTech(event.player), (EntityPlayerMP) event.player);
            Networking.sendTo(new ClientSlayer(playerOld.getBreath(), playerOld.getMana(), playerOld.getXP(), playerOld.getLevel(), playerOld.getMaxMana()), (EntityPlayerMP) event.player);
        }
    }
    @SubscribeEvent
    public void playerChangeDim(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent event){
        ISlayerCapability playerOld = event.player.getCapability(SlayerProvider.Breath_CAP, null);

        Networking.sendTo(new ClientSlayer(playerOld.getBreath(), playerOld.getMana(), playerOld.getXP(), playerOld.getLevel(), playerOld.getMaxMana()), (EntityPlayerMP) event.player);

        Networking.sendTo(new ClientTech(event.player), (EntityPlayerMP) event.player);

    }
    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {

            //Positions the gui in the middle of the screen regardless of the players screen size
            int posX = event.getResolution().getScaledWidth() / 15 - 18;
            int posY = event.getResolution().getScaledHeight()-70;
            float mana = mc.player.getCapability(SlayerProvider.Breath_CAP, null).getMana();

            //Renders the Mana Amount
            mc.fontRenderer.drawString( "Mana: " + (int)mana, posX + 4, posY +20, 0x0191255);

        }

    }
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event){
        EntityPlayer player = event.player;
        World world = player.getEntityWorld();
            //if they have a breathing technique
            if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() >0) {

                if (!player.isInWater() && !player.isCreative()) player.addVelocity(0F, 0.01F, 0F);
                player.fallDistance = 0.0F;
                player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32);
                player.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1);
                player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
                player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.12D );//+(player.getCapability(TechProvider.TECH_CAP, null).get/100));
            } if(player.getCapability(SlayerProvider.Breath_CAP, null).getMana() < player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana()){
                player.getCapability(SlayerProvider.Breath_CAP, null).setMana(player.getCapability(SlayerProvider.Breath_CAP, null).getMana() + .025F);
        }
            if(!world.isRemote && player.hasCapability(SlayerProvider.Breath_CAP, null)){

            if (player.getCapability(SlayerProvider.Breath_CAP, null).getXP() >= (100+(player.getCapability(SlayerProvider.Breath_CAP, null).getLevel() * 40))) {
                player.getCapability(SlayerProvider.Breath_CAP, null).setXP(0);
                player.getCapability(SlayerProvider.Breath_CAP, null).setLevel(player.getCapability(SlayerProvider.Breath_CAP, null).getLevel() + 1);
                player.getCapability(TechProvider.TECH_CAP, null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() + 1);
                player.sendMessage(new TextComponentString("You are now Level " + player.getCapability(SlayerProvider.Breath_CAP, null).getLevel()));
            }
        }
    }

    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event){
        Entity entity = event.getSource().getTrueSource();
    if(event.getEntity() != entity){
        if(entity instanceof EntityPlayer) {
            entity.getCapability(SlayerProvider.Breath_CAP, null).setXP(entity.getCapability(SlayerProvider.Breath_CAP, null).getXP() + 2);

        }else if(event.getEntity() instanceof EntityMob){
            entity.getCapability(SlayerProvider.Breath_CAP, null).setXP(entity.getCapability(SlayerProvider.Breath_CAP, null).getXP() + 4);
        }else if (event.getEntity() instanceof EntityDemon) entity.getCapability(SlayerProvider.Breath_CAP, null).setXP(entity.getCapability(SlayerProvider.Breath_CAP, null).getXP() + 6);
        }
    }
}











