package net.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.networking.Networking;
import net.networking.messages.tech.Tech;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.TechProvider;
import net.util.handlers.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiSlayer extends GuiScreen {

    public static final int ID = 0;
    private static final int[] UPGRADE_BUTTON_IDS = {1, 2, 3, 4, 5, 6};


    final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/maingui.png");

    int guiWidth = 200;
    int guiHeight = 178;

    EntityPlayer player = Minecraft.getMinecraft().player;


    @Override
    public void drawScreen(int mouseX, int mouseY, float partials) {

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        String health = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getHealth());
        String speed = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getSpeed());
        String breath = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getManaPoint());
        String technique = Integer.toString(player.getCapability(TechProvider.TECH_CAP, null).getTechnique());
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
        fontRenderer.drawString("Health: " + health, centerX+10, centerY+5, 0);
        fontRenderer.drawString("Speed: " + speed, centerX+10, centerY+30, 0);
        if(player.hasCapability(SlayerProvider.Breath_CAP, null))fontRenderer.drawString("Breath: " + breath, centerX+10, centerY+55, 0);
        else fontRenderer.drawString("Mana: " + breath, centerX+10, centerY+55, 0);
        fontRenderer.drawString("Strength: "+ strength, centerX+10, centerY+80, 0);
        fontRenderer.drawString("Durability: ", centerX+10, centerY+105, 0);
        fontRenderer.drawString("Technique: "+ technique, centerX+10, centerY+130, 0);
        fontRenderer.drawString("Xp: " + Xp , centerX+10, centerY+160, 0);
        fontRenderer.drawString("SP: " + sp, centerX+55, centerY+145, 0);
        fontRenderer.drawString("Rank: ", centerX+ 110, centerY+ 20, 0);
        fontRenderer.drawString("Form: ", centerX + 110, centerY + 40, 0);
        fontRenderer.drawString(mana +"/" + maxMana, centerX + 110, centerY +60 ,0);
        fontRenderer.drawString("Lvl: " + level, centerX+ 10, centerY+145, 0);


        int breathNum = player.getCapability(SlayerProvider.Breath_CAP, null).getBreath();


        //Depending on the
        switch(breathNum){
            case 1:
                fontRenderer.drawString("Flame Breathing", centerX +110, centerY +50, 0);
                break;
            case 2:
                fontRenderer.drawString("Insect Breathing", centerX +110, centerY +50, 0);
                break;
            case 3:
                fontRenderer.drawString("Thunder Breathing", centerX +110, centerY +50, 0);
                break;
            case 4:
                fontRenderer.drawString("Shadow Breathing", centerX +110, centerY +50, 0);
                break;
            case 5:
                fontRenderer.drawString("Mist Breathing", centerX +110, centerY +50, 0);
                break;
            case 6:
                fontRenderer.drawString("Sound Breathing", centerX +110, centerY +50, 0);
                break;
            case 7:
                fontRenderer.drawString("Beast Breathing", centerX +110, centerY +50, 0);
                break;
            case 8:
                fontRenderer.drawString("Wind Breathing", centerX +110, centerY +50, 0);
                break;
            case 9:
                fontRenderer.drawString("Ice Breathing", centerX +110, centerY +50, 0);
                break;
            case 10:
                fontRenderer.drawString("Special Breathing", centerX +110, centerY +50, 0);
                break;
            case 11:
                fontRenderer.drawString("Water Breathing", centerX +110, centerY +50, 44031);
                break;
            case 12:
                fontRenderer.drawString("Love Breathing", centerX +110, centerY +50, 0);
                break;
            case 13:
                fontRenderer.drawString("Flower Breathing", centerX +110, centerY +50, 0);
                break;
            case 14:fontRenderer.drawString("Sun Breathing", centerX +110, centerY +50, 16735521);
                break;
            case 15:
                fontRenderer.drawString("Serpent Breathing", centerX +110, centerY +50, 0);
                break;
            case 16:
                fontRenderer.drawString("Stone Breathing", centerX +110, centerY +50, 11448243);
                break;
        }
        super.drawScreen(mouseX, mouseY, partials);
        if(mouseX >= centerX+166 && mouseX <= centerX+ 206 && mouseY >= centerY-32 && mouseY <= centerY){
            List<String> text = new ArrayList<String>();
            text.add("CAW CAW CA-New Mission: Join The Discord!");
            text.add("CAW CAW CAW");
            drawHoveringText(text,mouseX, mouseY);
        }
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;

        //Upgrade Buttons for the Gui stat management
        for (int i = 0; i < UPGRADE_BUTTON_IDS.length; i++) {
            UpgradeButton button = new UpgradeButton(UPGRADE_BUTTON_IDS[i], centerX - 20, centerY + i * 25);
            this.addButton(button);

            // Set the button enabled state
            button.enabled = true;
        }
        GuiButton skillTree = new GuiButton(ID, centerX + guiWidth - 82, centerY + guiHeight - 20, 75, 20, "Skill Tree");
        this.addButton(skillTree);
        skillTree.enabled = true;
        super.initGui();
    }

    //Button Action Corresponse
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        //checks for the buttons
        switch (button.id){
            case 0:
                Minecraft.getMinecraft().displayGuiScreen(new SkillTreeGui());
                break;
            case 1:
                if(player.getCapability(TechProvider.TECH_CAP,null).getSp() >0){
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("health", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));
                }
                break;
            case 2:
                if(player.getCapability(TechProvider.TECH_CAP,null).getSp() >0){
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("speed", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));
                }
                break;
            case 3:
                if(player.getCapability(TechProvider.TECH_CAP,null).getSp() >0){
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("mana", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));}
                break;
            case 4:
                if(player.getCapability(TechProvider.TECH_CAP,null).getSp() >0){
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("strength", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));}
                break;
            case 5:
                if(player.getCapability(TechProvider.TECH_CAP,null).getSp() >0){
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("durability", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));}
                break;
            case 6:
                if(player.getCapability(TechProvider.TECH_CAP,null).getSp() >0){
                player.getCapability(TechProvider.TECH_CAP,null).upgradeStat("technique", 1);
                player.getCapability(TechProvider.TECH_CAP,null).setSp(player.getCapability(TechProvider.TECH_CAP, null).getSp() - 1);
                Networking.sendToServer(new Tech(player));}
                break;
            default:
                break;
        }

        super.actionPerformed(button);
    }


}
