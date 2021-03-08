package net.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.util.capabilities.SlayerProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.handlers.Reference;

public class Events {

    Minecraft mc = Minecraft.getMinecraft();
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event){
        EntityPlayer player = event.getEntityPlayer();
        ISlayerCapability breathOld = event.getOriginal().getCapability(SlayerProvider.Breath_CAP, null);
        ISlayerCapability breathNew = player.getCapability(SlayerProvider.Breath_CAP, null);
        breathNew.setBreath(breathOld.getBreath());
    }    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE) {

            int posX = event.getResolution().getScaledWidth() / 2 + 10;
            int posY = event.getResolution().getScaledHeight() - 56;
            if (mc.player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 11) {
                mc.renderEngine.bindTexture(new ResourceLocation("demoncraft:textures/gui/watergui.png"));
                mc.ingameGUI.drawTexturedModalRect(posX, posY, 0, 0, 16, 16);
                mc.ingameGUI.drawTexturedModalRect(posY + 18, posY, 20, 0, 16, 16);
                mc.ingameGUI.drawTexturedModalRect(posX + 36, posY, 41, 0, 16, 16);
            }

        }

    }
}










