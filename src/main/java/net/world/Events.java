package net.world;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.util.capabilities.SlayerProvider;

public class Events {

    Minecraft mc = Minecraft.getMinecraft();
    @SubscribeEvent
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
        }}}










