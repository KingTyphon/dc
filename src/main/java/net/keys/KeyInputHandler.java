package net.keys;

import net.Keybinds;
import net.gui.GuiTutorial;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event){
        if (Keybinds.slayer.isPressed()){
            Minecraft.getMinecraft().displayGuiScreen(new GuiTutorial());

        }
    }
}
