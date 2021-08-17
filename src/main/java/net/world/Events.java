package net.world;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.util.capabilities.SlayerProvider;
import net.util.capabilities.slayer.ISlayerCapability;

import static net.minecraft.entity.SharedMonsterAttributes.MAX_HEALTH;

public class Events {

    Minecraft mc = Minecraft.getMinecraft();
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event){
        EntityPlayer player = event.getEntityPlayer();
        ISlayerCapability breathOld = event.getOriginal().getCapability(SlayerProvider.Breath_CAP, null);
        ISlayerCapability breathNew = player.getCapability(SlayerProvider.Breath_CAP, null);
        breathNew.setBreath(breathOld.getBreath());
        double oldhealth = event.getOriginal().getEntityAttribute(MAX_HEALTH).getAttributeValue();
        IAttributeInstance newhealth = player.getEntityAttribute(MAX_HEALTH);
        newhealth.setBaseValue(oldhealth);
    }    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {

            int posX = event.getResolution().getScaledWidth() / 15 - 18;
            int posY = event.getResolution().getScaledHeight()-70;

                mc.renderEngine.bindTexture(new ResourceLocation("demoncraft:textures/gui/watergui.png"));
                mc.ingameGUI.drawTexturedModalRect(posX, posY, 0, 0, 88, 33);


        }

    }
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event){
        EntityPlayer player = event.player;
        World world = player.getEntityWorld();
            if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() <20){
                player.capabilities.setPlayerWalkSpeed(0.15f);
                if(!player.isInWater() && !player.isCreative())player.addVelocity(0F, 0.01F, 0F);
                player.fallDistance = 0.0F;
            } else {
                if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath()==7){
                    for (EntityLivingBase i : Minecraft.getMinecraft().player.world.getEntitiesWithinAABB(EntityLivingBase.class, player.getEntityBoundingBox().grow(60.0D))) {
                        if (i == player) continue;
                        i.addPotionEffect(new PotionEffect(Potion.getPotionById(24), 10, 0, false, true));
                    } } } }
}










