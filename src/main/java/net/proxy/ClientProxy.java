package net.proxy;

import net.DemonCraft;
import net.gui.GuiHandler;
import net.gui.GuiOverlayMoves;
import net.init.EntityInit;
import net.keys.KeyInputHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.lwjgl.input.Keyboard;



public class ClientProxy extends ServerProxy {

    public static final KeyBinding slayer = new KeyBinding("Slayer Gui", Keyboard.KEY_P, "key.categories.slayer");



    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
    @Override
    public void registerClientStuff(){
        EntityInit.registerEntities();
        ClientRegistry.registerKeyBinding(slayer);
        NetworkRegistry.INSTANCE.registerGuiHandler(DemonCraft.instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
        MinecraftForge.EVENT_BUS.register(new GuiOverlayMoves());
    }

}
