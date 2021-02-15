package net.util.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.util.capabilities.SlayerProvider;

@Mod.EventBusSubscriber
public class CapabilityHandler {

    public static final ResourceLocation Breath_CAP = new ResourceLocation(Reference.MODID, "mental");


    @SubscribeEvent

    public static void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof EntityPlayer)
        {
            event.addCapability(Breath_CAP, new SlayerProvider());
        }

    }
}