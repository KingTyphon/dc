package net.util.capabilities;

import net.util.capabilities.demon.DemonProvider;
import net.util.capabilities.slayer.SlayerProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.util.capabilities.techniquecapability.TechProvider;
import net.util.handlers.Reference;


@Mod.EventBusSubscriber
public class CapabilityHandler {

    public static final ResourceLocation Breath_CAP = new ResourceLocation(Reference.MODID, "breath");
    public static final ResourceLocation TECH_CAP = new ResourceLocation(Reference.MODID, "tech");
    public static final ResourceLocation DEMON_CAP = new ResourceLocation(Reference.MODID, "demon");

    //Attatches the Capabilities to the Certain
    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(Reference.MODID, "breath"), new SlayerProvider());
            event.addCapability(new ResourceLocation(Reference.MODID, "tech"), new TechProvider());
            event.addCapability(new ResourceLocation(Reference.MODID, "demon"), new DemonProvider());
        }
    }
}
