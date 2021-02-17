package net.util.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.util.capabilities.SlayerProvider;
import net.util.capabilities.slayer.ISlayerCapability;

import static net.util.handlers.Reference.MODID;



@Mod.EventBusSubscriber
public class CapabilityHandler {

    public static final ResourceLocation Breath_CAP = new ResourceLocation(MODID, "breath");


    @SubscribeEvent
    public static void attachChunkCap(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(MODID, "breath"), new SlayerProvider());}
    }
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event){
        if (event.isWasDeath()){
        EntityPlayer player = event.getEntityPlayer();
        ISlayerCapability breathOld = event.getOriginal().getCapability(SlayerProvider.Breath_CAP, null);
        ISlayerCapability breathNew = player.getCapability(SlayerProvider.Breath_CAP, null);
        breathNew.setBreath(breathOld.getBreath());
        }
    }

}
