package net.keys;

import net.gui.GuiSlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.networking.Client.ClientSlayer;
import net.networking.Client.tech.ClientTech;
import net.networking.Networking;
import net.proxy.ClientProxy;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.TechProvider;

public class KeyInputHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event){
        int i = 0;
        EntityPlayer player1 = Minecraft.getMinecraft().player;
        if (ClientProxy.slayer.isPressed()){
            Minecraft.getMinecraft().displayGuiScreen(new GuiSlayer());
        }
        if (ClientProxy.tech.isPressed()){

            if(player1.getCapability(TechProvider.TECH_CAP, null).getTech() != 5 && player1.getCapability(SlayerProvider.Breath_CAP, null).getBreath()<=4) {
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(Minecraft.getMinecraft().player.getCapability(TechProvider.TECH_CAP, null).getTech() + 1);
                player1.sendMessage(new TextComponentString("Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }
            else if(player1.getCapability(TechProvider.TECH_CAP, null).getTech() == 5 && player1.getCapability(SlayerProvider.Breath_CAP, null).getBreath()==4){
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString("Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }

            Networking.sendToServer(new ClientTech(player1));
        }

        //Gets the Breathing for the player and increases it while its lower than the max
        if(ClientProxy.breath.isKeyDown()){
            if(player1.getCapability(SlayerProvider.Breath_CAP, null).getMana() != player1.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana()) {
                player1.getCapability(SlayerProvider.Breath_CAP, null).setMana((float) (player1.getCapability(SlayerProvider.Breath_CAP, null).getMana() + .05));
            }
        }

    }
}
