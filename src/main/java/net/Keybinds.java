package net;

import net.gui.GuiHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.lwjgl.input.Keyboard;


public class Keybinds {
    public static KeyBinding slayer;
    public static void register(){
        slayer = new KeyBinding("Slayer Gui", Keyboard.KEY_P, "key.categories.slayer");

        ClientRegistry.registerKeyBinding(slayer);
    }
    public void init(FMLInitializationEvent e){
        NetworkRegistry.INSTANCE.registerGuiHandler(DemonCraft.instance, new GuiHandler());
}
    public static void preInit(FMLPreInitializationEvent event)
    {
        Keybinds.register();
    }
}
