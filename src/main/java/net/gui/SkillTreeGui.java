package net.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.ITechCapability;
import net.util.capabilities.techniquecapability.TechProvider;
import net.util.handlers.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SkillTreeGui extends GuiScreen {
    public static int ID = 1;
    final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/skilltreegui.png");
    int guiWidth = 200;
    int guiHeight = 178;
    int lastMouseX;
    int lastMouseY;
    boolean isDragging = false;
    float scrollFactor = 0.0f;
    private final List<String> waterSkillTooltips;

    public SkillTreeGui() {
        waterSkillTooltips = new ArrayList<>();
        initializeWaterSkillTooltips();
    }
    private void initializeWaterSkillTooltips() {
        // Add tooltips for each water skill level
        waterSkillTooltips.add("First Form: Water Surface Slash ( Ichi no kata: Minamo Giri?)[5] - The user releases a singular, horizontal slash aiming to decapitate their target.");
        waterSkillTooltips.add("Second Form: Water Wheel ( Ni no kata: Mizu Guruma?)[6] - The user leaps forward into the air and performs a front flip, releasing a singular vertical slash in a circular motion");
        waterSkillTooltips.add("Third Form: Flowing Dance ( San no kata: Ryūryū Mai?)[8] - The user swings and bends their blade in a winding motion along with their body and dances in a flowing pattern, slicing everything in its path.");
        waterSkillTooltips.add("Fourth Form: Striking Tide ( Shi no kata: Uchishio?)[9] - The user performs a multitude of slashes in a flowing fashion to release multiple consecutive slashes.");
        waterSkillTooltips.add("Fifth Form: Blessed Rain After the Drought (Go no kata: Kanten no Jiu?)[11] - The user changes the grip on their sword and decapitates the opponent in a single flowing strike that causes little to no pain. It is a “sword strike of kindness” utilized when the enemy willingly surrenders.");
        waterSkillTooltips.add("Sixth Form: Whirlpool ( Roku no kata: Nejire Uzu?)[12] - The user twists their body, using their blade to perform a fierce whirling motion which generates a whirlpool of air to shred apart anything caught within its current like a giant sharp blade. Its effect and efficiency is enhanced underwater, where the user can draw water around their weapon to create whirling currents that enhance their slashes.");
        waterSkillTooltips.add("Seventh Form: Drop Ripple Thrust ( Shichi no kata: Shizuku Hamon Tsuki?)[14] - The user performs a precise, fast and accurate thrust with their blade.");
        waterSkillTooltips.add("Eighth Form: Waterfall Basin (Hachi no kata: Takitsubo?)[16] - The user cuts the target vertically in a flowing motion which is most effective when they are falling downward.");
        waterSkillTooltips.add("Ninth Form: Splashing Water Flow, Turbulent (Ku no kata: Suiryū Shibuki - Ran?)[17] - The user changes their footwork in a way that minimizes the landing time and surface needed when landing, allowing the user to move without limits. Ideal when fighting in a place with no solid foothold.");
        waterSkillTooltips.add("Tenth Form: Constant Flux (Jū no kata: Seisei Ruten?)[18] - The user charges toward the target whilst performing a continuous flowing attack with their blade which increases in strength and speed over time using momentum.");
        waterSkillTooltips.add("Eleventh Form: Dead Calm (Jū Ichi no kata: Nagi?)[19] - The personal creation of the current Water Hashira, Giyu Tomioka. The user ceases all body movements and enters a state of complete tranquility, deflecting, blocking and cutting any incoming attacks with imperceptible speed with their blade. However, its effectiveness is limited as fast and numerous attacks can break through.");

    }private void drawSkillIcon(int x, int y, int skillNumber, int level) {
        String iconName = level + "water";
        ResourceLocation skillIcon = new ResourceLocation(Reference.MODID, "textures/gui/" + iconName + ".png");

        // Draw the skill icon at the specified position
        drawTexturedModalRect(x, y, 0, 0, 32, 32);


        String skillName = getSkillName(skillNumber);
        fontRenderer.drawString(skillName, x, y - 10, 0xFFFFFF);
    }
    private String getSkillName(int skillNumber) {
        ISlayerCapability slayerCapability = Minecraft.getMinecraft().player.getCapability(SlayerProvider.Breath_CAP, null);

        // Check if the skill number is within a valid range
        if (skillNumber >= 1 && skillNumber <= SkillNames.skillNames.size()) {
            String skillName = SkillNames.skillNames.get(skillNumber - 1);

            // Check the player's breath capability to determine if the skill is learned or locked
            if (slayerCapability != null && slayerCapability.getBreath() >= skillNumber) {
                return "You have learned " + skillName + ".";
            } else {
                return "You need to learn " + skillName + " first.";
            }
        } else {
            return "Invalid Skill Number";
        }
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (isDragging) {
            int deltaY = mouseY - lastMouseY;
            // Adjust the scroll factor based on vertical dragging movement
            scrollFactor += deltaY * 0.01f;
            lastMouseY = mouseY;
        }

        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        centerY += scrollFactor; // Adjust the vertical position based on scroll factor
        drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);

        EntityPlayer player = Minecraft.getMinecraft().player;
        ISlayerCapability slayerCapability = player.getCapability(SlayerProvider.Breath_CAP, null);
        ITechCapability techCapability = player.getCapability(TechProvider.TECH_CAP, null);

        for (int i = 1; i <= slayerCapability.getLevel(); i += 5) {
            int currentLevel = i;
            if (currentLevel <= slayerCapability.getLevel()) {
            if (slayerCapability.getBreath() == 1) {
                drawSkillIcon(centerX + 120 + (10*i), centerY + 40 + (10*i), slayerCapability.getBreath(), i);
            }
        }
    }}

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        if (mouseButton == 1) { // Right-click
            lastMouseY = mouseY;
            isDragging = true;
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        if (state == 1) { // Right-click release
            isDragging = false;
        }
    }
}