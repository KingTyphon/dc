package net.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.TechProvider;
import net.util.handlers.Reference;

public class MoveSetGui extends Gui {

    private final ResourceLocation insect = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation thunder = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation shadow = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation mist = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation sound = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation beast = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation wind = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation ice = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation flower = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation special = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation water = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation love = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation sun = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation serpent = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation stone = new ResourceLocation(Reference.MODID, "textures/gui/widgets.png");
    private final ResourceLocation flame = new ResourceLocation(Reference.MODID, "textures/gui/breathingmoves/Flame/flamegui.png");

    @SubscribeEvent
    public void renderSkills(RenderGameOverlayEvent event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            Minecraft mc = Minecraft.getMinecraft();
            int breath = mc.player.getCapability(SlayerProvider.Breath_CAP, null).getBreath();
            int tech = mc.player.getCapability(TechProvider.TECH_CAP, null).getTech();
            int posX = event.getResolution().getScaledWidth() / 15 - 18;
            int posY = event.getResolution().getScaledHeight()-30;
            switch(breath) {
                    case 1:
                        //Flame
                        if (tech >0) {
                            mc.renderEngine.bindTexture(flame);
                            drawModalRectWithCustomSizedTexture(posX + 200, posY + 50, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 2:
                        //Insect
                        if (tech >0) {
                            mc.renderEngine.bindTexture(insect);
                            drawModalRectWithCustomSizedTexture(posX + 200, posY + 50, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 3:
                        //Thunder
                        if (tech >0) {
                            mc.renderEngine.bindTexture(thunder);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }

                        break;
                    case 4:
                        //Shadow
                        if (tech >0) {
                            mc.renderEngine.bindTexture(shadow);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 5:
                        //Mist
                        if (tech >0) {
                            mc.renderEngine.bindTexture(mist);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 6:
                        //Sound
                        if (tech >0) {
                            mc.renderEngine.bindTexture(sound);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 7:
                        //Beast
                        if (tech >0) {
                            mc.renderEngine.bindTexture(beast);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 8:
                        //Wind
                        if (tech >0) {
                            mc.renderEngine.bindTexture(wind);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 9:
                        //Ice
                        if (tech >0) {
                            mc.renderEngine.bindTexture(ice);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 10:
                        //special
                        if (tech >0) {
                            mc.renderEngine.bindTexture(special);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 256.0F, 256.0F);
                        }
                        break;
                    case 11:
                        if (tech >0) {
                            mc.renderEngine.bindTexture(water);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 256.0F, 256.0F);
                        }
                        //water
                        break;
                    case 12:
                        //love
                        if (tech >0) {
                            mc.renderEngine.bindTexture(love);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 256.0F, 256.0F);
                        }
                        break;
                    case 13:
                        //flower
                        if (tech >0) {
                            mc.renderEngine.bindTexture(flower);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 14:
                        //Sun
                        if (tech >0) {
                            mc.renderEngine.bindTexture(sun);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 15:
                        //Serpent
                        if (tech >0) {
                            mc.renderEngine.bindTexture(serpent);
                            drawModalRectWithCustomSizedTexture(posX + 200, posY + 50, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    case 16:
                        //Stone
                        if (tech >0) {
                            mc.renderEngine.bindTexture(stone);
                            drawModalRectWithCustomSizedTexture(posX + 2, posY + 2, 0, 0, 16, 16, 32, 32);
                        }
                        break;
                    default:
                        break;
                }
            drawTexturedModalRect(posX, posY+200, 0, 0, 22, 22);
            drawTexturedModalRect(posX-22 , posY+200, 23, 0, 22, 22);
            drawTexturedModalRect(posX+22 , posY+200, 23, 0, 22, 22);


        }}

}

