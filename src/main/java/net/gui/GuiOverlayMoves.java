package net.gui;

import net.util.handlers.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiOverlayMoves extends Gui {

private final ResourceLocation bar = new ResourceLocation(Reference.MODID, "textures/gui/breathbar.png");
private final int tex_width = 102, tex_height = 8, bar_width = 100, bar_height = 6;

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            Minecraft mc = Minecraft.getMinecraft();
            mc.renderEngine.bindTexture(bar);
            drawTexturedModalRect( 0, 0, 0, 0, tex_width, tex_height);
            drawTexturedModalRect(0,0,0, tex_height, bar_width, bar_height);
        }
    }
}
