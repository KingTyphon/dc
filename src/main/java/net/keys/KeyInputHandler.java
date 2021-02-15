package net.keys;

import net.DemonCraft;
import net.Keybinds;
import net.gui.GuiTutorial;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import static net.minecraftforge.fml.common.network.internal.FMLNetworkHandler.openGui;

public class KeyInputHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event){
        if (Keybinds.slayer.isPressed()){
            Minecraft.getMinecraft().displayGuiScreen(new GuiTutorial());

        }
    }
}
