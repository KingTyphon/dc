package net.gui;

import net.DemonCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.util.handlers.Reference;

import java.io.IOException;

public class GuiTutorial extends GuiScreen {

    public static final int ID = 0;

    final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/maingui.png");

    int guiWidth = 256;
    int guiHeight = 256;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partials) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
        drawString(fontRenderer, "Demon Craft", centerX, centerY, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partials);
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
    }


}
