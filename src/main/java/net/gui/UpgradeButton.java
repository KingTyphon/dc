package net.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.util.handlers.Reference;

public class UpgradeButton extends GuiButton {
    protected final ResourceLocation texture1 = new ResourceLocation(Reference.MODID, "textures/gui/button.png");
    int buttonWidth = 22;
    int ButtonHeight = 22;
    int u = 0;
    int v = 0;


    public UpgradeButton(int buttonId, int x, int y, String buttonText) {
        super(buttonId, x, y, 22, 22, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if(this.visible == true) {
            mc.getTextureManager().bindTexture(texture1);
            this.drawTexturedModalRect(x, y, u, v, buttonWidth, ButtonHeight);


        }

        }
    }

