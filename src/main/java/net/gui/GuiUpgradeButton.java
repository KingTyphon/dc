package net.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.util.handlers.Reference;

public class GuiUpgradeButton extends GuiButton {
    final ResourceLocation texture1 = new ResourceLocation(Reference.MODID, "textures/gui/button.png");
    int buttonWidth = 22;
    int ButtonHeight = 22;
    int u = 0;
    int v = 0;

    public GuiUpgradeButton(int buttonId, int x, int y, String buttonText) {
        super(buttonId, x, y, 22, 22, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (visible) {
            mc.getTextureManager().bindTexture(texture1);
            drawTexturedModalRect(x-22,y+10,u,v,buttonWidth,ButtonHeight);
            drawTexturedModalRect(x-22,y+32,u,v,buttonWidth,ButtonHeight);
            drawTexturedModalRect(x-22,y+54,u,v,buttonWidth,ButtonHeight);
        }}
    }

