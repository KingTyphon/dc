package net.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.networking.messages.tech.Tech;
import net.networking.Networking;
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


    @Override
    public void drawScreen(int mouseX, int mouseY, float partials) {

        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        String health = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getHealth());
        String speed = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getSpeed());
        String breath = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getManaPoint());
        String technique = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getTech());
        String Xp = Integer.toString(player.getCapability(SlayerProvider.Breath_CAP, null).getXP());
        String strength = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getStrength());
        String level =Integer.toString(player.getCapability(SlayerProvider.Breath_CAP, null).getLevel());
        String sp = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getSp());
        String mana = Float.toString(player.getCapability(SlayerProvider.Breath_CAP, null).getMana());
        String maxMana = Integer.toString(player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana());

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
        fontRenderer.drawString("Xp: " + Xp , centerX+10, centerY+160, 0);
        fontRenderer.drawString("SP: " + sp, centerX+55, centerY+145, 0);
        fontRenderer.drawString("Rank: ", centerX+ 110, centerY+ 20, 0);
        fontRenderer.drawString("Form: ", centerX + 110, centerY + 40, 0);
        fontRenderer.drawString(mana +"/" + maxMana, centerX + 110, centerY +60 ,0);
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
            text.add("CAW CAW CA-New Mission: Join The Discord!");
            text.add("CAW CAW CAW");
            drawHoveringText(text,mouseX, mouseY);
        }
        int breathNum = player.getCapability(SlayerProvider.Breath_CAP, null).getBreath();

        switch(breathNum){
            case 1:
                fontRenderer.drawString("Flame Breathing", centerX +110, centerY +50, 13828096);
                break;
            case 2:
                fontRenderer.drawString("Insect Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 3:
                fontRenderer.drawString("Thunder Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 4:
                fontRenderer.drawString("Shadow Breathing", centerX +110, centerY +50, 3021648);
                break;
            case 5:
                fontRenderer.drawString("Mist Breathing", centerX +110, centerY +50, 10527399);
                break;
            case 6:
                fontRenderer.drawString("Sound Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 7:
                fontRenderer.drawString("Beast Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 8:
                fontRenderer.drawString("Wind Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 9:
                fontRenderer.drawString("Ice Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 10:
                fontRenderer.drawString("Special Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 11:
                fontRenderer.drawString("Water Breathing", centerX +110, centerY +50, 44031);
                break;
            case 12:
                fontRenderer.drawString("Love Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 13:
                fontRenderer.drawString("Flower Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 14:fontRenderer.drawString("Sun Breathing", centerX +110, centerY +50, 16735521);
                break;
            case 15:
                fontRenderer.drawString("Serpent Breathing", centerX +110, centerY +50, 0x0191255);
                break;
            case 16:
                fontRenderer.drawString("Stone Breathing", centerX +110, centerY +50, 11448243);
                break;
        }

        button1.drawButton(mc, centerX+50,centerY+80, 0x0191255);


    }

    @Override
    public void initGui() {
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        this.buttonList.clear();
        this.buttonList.add(sword = new UpgradeButton(6, centerX,centerY+120, ""));
        this.buttonList.add(sword = new UpgradeButton(5, centerX,centerY+100, ""));
        this.buttonList.add(sword = new UpgradeButton(4, centerX,centerY+80, ""));
        this.buttonList.add(sword = new UpgradeButton(3, centerX,centerY+60, ""));
        this.buttonList.add(sword = new UpgradeButton(2, centerX,centerY+40, ""));
        this.buttonList.add(sword = new UpgradeButton(1, centerX,centerY+20, ""));
        this.buttonList.add(button1 = new GuiButton(0, centerX+guiWidth-82, centerY+guiHeight-20, 75, 20, "Skill Tree"));
        super.initGui();
    }


    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        //checks for the buttons
        if(player.getCapability(TechProvider.TECH_CAP,null).getSp() >0){
        switch (button.id){
            case 0:
                Minecraft.getMinecraft().displayGuiScreen(new SkillTreeGui());
                break;
            case 1:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("health", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));
                break;
            case 2:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("speed", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));
                break;
            case 3:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("mana", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));
                break;
            case 4:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("strength", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));
                break;
            case 5:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("durability", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));
                break;
            case 6:
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("technique", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));
                break;
            default:
                break;
        }
        }

        super.actionPerformed(button);
    }


}
