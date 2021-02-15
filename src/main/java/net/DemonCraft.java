package net;

import net.creativetabs.DemonCraftTab;
import net.init.EntityInit;
import net.keys.KeyInputHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.proxy.CommonProxy;
import net.util.capabilities.IStorage;
import net.util.capabilities.slayer.SlayerCapability;
import net.util.handlers.Reference;
import net.util.handlers.RenderHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class DemonCraft
{
    public static final CreativeTabs demoncrafttab = new DemonCraftTab("demon_craft_tab");

    @Instance
    public static DemonCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        Keybinds.register();
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenderers();
        CapabilityManager.INSTANCE.register(SlayerCapability.class, new IStorage(), SlayerCapability::new);

        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
    }
    @EventHandler
    public static void init(FMLInitializationEvent event) {}
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }
}
