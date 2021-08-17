package net.gui;

import net.minecraft.client.gui.FontRenderer;
import net.util.handlers.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.awt.font.FontRenderContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiTutorial extends GuiScreen {

    public static final int ID = 0;

    final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/maingui.png");

    int guiWidth = 200;
    int guiHeight = 178;

    GuiUpgradeButton sword;
    GuiButton button1;

    final int BUTTON1 = 0; int SWORD=1;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partials) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
        drawTexturedModalRect(centerX+166,centerY-29,200,0,40,32);
        drawHoveringText("Slayer Info", centerX+100,centerY+10);
        fontRenderer.drawString("Health:", centerX+10, centerY+20, 00000);
        fontRenderer.drawString("Speed:", centerX+10, centerY+40, 00000);
        fontRenderer.drawString("Breath:", centerX+10, centerY+60, 00000);
        fontRenderer.drawString("Strength:", centerX+10, centerY+80, 00000);
        fontRenderer.drawString("Durability:", centerX+10, centerY+100, 00000);
        fontRenderer.drawString("Technique:", centerX+10, centerY+120, 00000);
        fontRenderer.drawString("Exp:", centerX+10, centerY+160, 00000);
        fontRenderer.drawString("SP:", centerX+55, centerY+145, 00000);
        fontRenderer.drawString("Rank:", centerX+ 110, centerY+ 20, 0000);
        fontRenderer.drawString("Form:", centerX + 110, centerY + 40, 0000);
        fontRenderer.drawString("Lvl:", centerX+ 10, centerY+145,0000);
        if(mouseX >= centerX+166 && mouseX <= centerX+ 206 && mouseY >= centerY-32 && mouseY <= centerY){
            List<String> text = new ArrayList<String>();
            text.add("CAW CA-New Mission: Join The Discord");
            drawHoveringText(text,mouseX, mouseY);
        }
        sword.drawButton(mc, mouseX, mouseY, partials);
        button1.drawButton(mc,mouseX,mouseY, partials);
    }

    @Override
    public void initGui() {
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        buttonList.clear();
        buttonList.add(sword = new GuiUpgradeButton(SWORD, centerX,centerY, ""));
        buttonList.add(button1 = new GuiButton(0, centerX+guiWidth-82, centerY+guiHeight-20, 75, 15, "Skill Tree"));
        super.initGui();
    }



    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id){
            case BUTTON1:

                break;
        }
        super.actionPerformed(button);
    }


}
