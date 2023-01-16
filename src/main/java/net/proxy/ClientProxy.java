package net.proxy;

import net.DemonCraft;
import net.gui.GuiBreathBar;
import net.gui.GuiHandler;
import net.init.EntityInit;
import net.keys.KeyInputHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.handlers.EventHandler;
import net.util.handlers.RegistryHandler;
import org.lwjgl.input.Keyboard;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;


public class ClientProxy extends ServerProxy {

    //Sets the variable to the keybind
    public static final KeyBinding slayer = new KeyBinding("Slayer Gui", Keyboard.KEY_P, "key.categories.slayer");
    public static final KeyBinding tech = new KeyBinding("Change Form", Keyboard.KEY_C, "key.categories.slayer");
    public static final KeyBinding breath = new KeyBinding("Focus Breath", Keyboard.KEY_B, "key.categories.slayer");

    //Renders the Entities for projectiles
    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));

    }
    //@SidedProxy(CLIENT )
    @Override
    public void registerClientStuff(){
        EntityInit.registerEntities();


        //Keybind Registrations for the certain keys
        ClientRegistry.registerKeyBinding(tech);
        ClientRegistry.registerKeyBinding(slayer);
        ClientRegistry.registerKeyBinding(breath);

        NetworkRegistry.INSTANCE.registerGuiHandler(DemonCraft.instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
        MinecraftForge.EVENT_BUS.register(new GuiBreathBar());
        DemonCraft.proxy.render();
        EventHandler.registerEvents();
        RegistryHandler.initRegistries();
    }


}
