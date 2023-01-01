package net.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.TechProvider;
import net.util.handlers.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiSlayer extends GuiScreen {

    public static final int ID = 0;

    final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/maingui.png");

    int guiWidth = 200;
    int guiHeight = 178;

    UpgradeButton sword;
    GuiButton button1;
    EntityPlayer player = Minecraft.getMinecraft().player;
    final int BUTTON1 = 0; int SWORD=1;


    @Override
    public void drawScreen(int mouseX, int mouseY, float partials) {

        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        String health = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getHealth());
        String speed = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getHealth());
        String breath = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getManaPoint());
        String technique = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getTech());
        String exp = Integer.toString(player.getCapability(SlayerProvider.Breath_CAP, null).getXP());
        String strength = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getStrength());
        String level =Integer.toString(player.getCapability(SlayerProvider.Breath_CAP, null).getLevel());
        String sp = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getSp());

        drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
        drawTexturedModalRect(centerX+166,centerY-29,200,0,40,32);

        //Displays the users stats
        drawHoveringText("Slayer Info", centerX+100,centerY+10);
        fontRenderer.drawString("Health: " + health, centerX+10, centerY+20, 0);
        fontRenderer.drawString("Speed: " + speed, centerX+10, centerY+40, 0);
        if(player.hasCapability(SlayerProvider.Breath_CAP, null))fontRenderer.drawString("Breath: " + breath, centerX+10, centerY+60, 0);
        else fontRenderer.drawString("Mana: " + breath, centerX+10, centerY+60, 0);
        fontRenderer.drawString("Strength: "+ strength, centerX+10, centerY+80, 0);
        fontRenderer.drawString("Durability: ", centerX+10, centerY+100, 0);
        fontRenderer.drawString("Technique: "+ technique, centerX+10, centerY+120, 0);
        fontRenderer.drawString("Exp: " + exp , centerX+10, centerY+160, 0);
        fontRenderer.drawString("SP: " + sp, centerX+55, centerY+145, 0);
        fontRenderer.drawString("Rank: ", centerX+ 110, centerY+ 20, 0);
        fontRenderer.drawString("Form: ", centerX + 110, centerY + 40, 0);
        if(player.getCapability(TechProvider.TECH_CAP, null).getSp() >= 1){
            sword.drawButton(mc, centerX, centerY + 20, 0x0191255);
            sword.drawButton(mc, centerX, centerY +40, 0x0191255);
            sword.drawButton(mc, centerX, centerY +60, 0x0191255);
            sword.drawButton(mc, centerX, centerY +80, 0x0191255);
            sword.drawButton(mc, centerX, centerY +100, 0x0191255);
            sword.drawButton(mc, centerX, centerY +120, 0x0191255);
        }
        fontRenderer.drawString("Lvl: " + level, centerX+ 10, centerY+145, 0);

        //Bird mouse hover overlay
        if(mouseX >= centerX+166 && mouseX <= centerX+ 206 && mouseY >= centerY-32 && mouseY <= centerY){
            List<String> text = new ArrayList<String>();
            text.add("CAW CA-New Mission: Join The Discord");
            drawHoveringText(text,mouseX, mouseY);
        }
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 1) {
            fontRenderer.drawString("Flame Breathing", centerX +110, centerY +50, 13828096);
        }if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 2) {
            fontRenderer.drawString("Insect Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 3) {
            fontRenderer.drawString("Thunder Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 4) {
            fontRenderer.drawString("Shadow Breathing", centerX +110, centerY +50, 3021648);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 5) {
            fontRenderer.drawString("Mist Breathing", centerX +110, centerY +50, 10527399);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 6) {
            fontRenderer.drawString("Sound Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 7) {
            fontRenderer.drawString("Beast Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 8) {
            fontRenderer.drawString("Wind Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 9) {
            fontRenderer.drawString("Ice Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 10) {
            fontRenderer.drawString("Special Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 11) {
            fontRenderer.drawString("Water Breathing", centerX +110, centerY +50, 44031);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 12) {
            fontRenderer.drawString("Love Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 13) {
            fontRenderer.drawString("Flower Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 14) {
            fontRenderer.drawString("Sun Breathing", centerX +110, centerY +50, 16735521);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 15) {
            fontRenderer.drawString("Serpent Breathing", centerX +110, centerY +50, 0x0191255);}
        if (player.getCapability(SlayerProvider.Breath_CAP, null).getBreath() == 16) {
            fontRenderer.drawString("Stone Breathing", centerX +110, centerY +50, 11448243);}
        button1.drawButton(mc, centerX+50,centerY+80, 0x0191255);


    }

    @Override
    public void initGui() {
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        buttonList.clear();
        buttonList.add(sword = new UpgradeButton(6, centerX,centerY +120, ""));
        buttonList.add(sword = new UpgradeButton(5, centerX,centerY +100, ""));
        buttonList.add(sword = new UpgradeButton(4, centerX,centerY +80, ""));
        buttonList.add(sword = new UpgradeButton(3, centerX,centerY +60, ""));
        buttonList.add(sword = new UpgradeButton(2, centerX,centerY +40, ""));
        buttonList.add(sword = new UpgradeButton(1, centerX,centerY +20, ""));
        buttonList.add(button1 = new GuiButton(0, centerX+guiWidth-82, centerY+guiHeight-20, 75, 20, "Skill Tree"));
        super.initGui();
    }


    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        //checks for the buttons
        switch (button.id){
            case 0:
                Minecraft.getMinecraft().displayGuiScreen(new SkillTreeGui());
                break;
            case 1:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("health", 1);
                break;
            case 2:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("speed", 1);
                break;
            case 3:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("mana", 1);
                break;
            case 4:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("strength", 1);
                break;
            case 5:
                //player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("durability", 1);
                break;
            case 6:
                //player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("technique", 1);
                break;
            default:
                break;
        }

        super.actionPerformed(button);
    }


}