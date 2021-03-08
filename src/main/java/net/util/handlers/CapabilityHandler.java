package net.util.handlers;

import net.util.capabilities.SlayerProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.util.capabilities.slayer.ISlayerCapability;


@Mod.EventBusSubscriber
public class CapabilityHandler {

    public static final ResourceLocation Breath_CAP = new ResourceLocation(Reference.MODID, "breath");


    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(Reference.MODID, "breath"), new SlayerProvider());}
    }
}
