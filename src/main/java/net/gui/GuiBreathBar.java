package net.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.handlers.Reference;

public class GuiBreathBar extends Gui {

private final ResourceLocation bar = new ResourceLocation(Reference.MODID, "textures/gui/breathbar.png");
private final int tex_width = 102, tex_height = 8, bar_width = 100, bar_height = 6,bubble_height = 7, bubble_width = 12;
    EntityPlayer player = Minecraft.getMinecraft().player;

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event){

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            Minecraft mc = Minecraft.getMinecraft();
            int posX = event.getResolution().getScaledWidth() / 15 - 18;
            int posY = event.getResolution().getScaledHeight()-30;
            float mana = mc.player.getCapability(SlayerProvider.Breath_CAP, null).getMana();
            int maxmana = mc.player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana();
            int width = (int) (bar_width * (mana/ maxmana));
            int breath = mc.player.getCapability(SlayerProvider.Breath_CAP, null).getBreath();


            mc.renderEngine.bindTexture(bar);
            drawTexturedModalRect( posX, posY, 0, 0, tex_width, tex_height);
            drawTexturedModalRect(posX+1,posY+1,0, tex_height, width, bar_height);
            drawTexturedModalRect(posX-8, posY-2, 0, tex_height+bar_height, bubble_width, bubble_height);

            switch(breath){
                case 1:
                    //Flame
                    break;
                case 2:
                    //Insect
                    break;
                case 3:
                    //Thunder
                    break;
                case 4:
                    //Shadow
                    break;
                case 5:
                    //Mist
                    break;
                case 6:
                    //Sound
                    break;
                case 7:
                    //Beast
                    break;
                case 8:
                    //Wind
                    break;
                case 9:
                    //Ice
                    break;
                case 10:
                    //special
                    break;
                case 11:
                    //water
                    break;
                case 12:
                    //love
                    break;
                case 13:
                    //flower
                    break;
                case 14:
                    //Sun
                    break;
                case 15:
                    //Serpent
                    break;
                case 16:
                    //Stone
                    break;
                default:
                    break;
            }
    }
}}
