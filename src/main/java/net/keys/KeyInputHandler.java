package net.keys;

import net.gui.GuiTutorial;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.proxy.ClientProxy;

public class KeyInputHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event){
        if (ClientProxy.slayer.isPressed()){
            Minecraft.getMinecraft().displayGuiScreen(new GuiTutorial());

        }
    }
}
