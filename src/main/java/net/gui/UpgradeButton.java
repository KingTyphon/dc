package net.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.util.handlers.Reference;

public class UpgradeButton extends GuiButton {
    protected final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/button.png");
    int buttonWidth = 22;
    int buttonHeight = 22;
    int u = 0;
    int v = 0;


    public UpgradeButton(int buttonId, int x, int y) {
        super(buttonId, x, y, 22, 22, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if(this.visible) {
            mc.getTextureManager().bindTexture(texture);
            this.drawTexturedModalRect(x, y, u, v, buttonWidth, buttonHeight);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        }

        }
    }

