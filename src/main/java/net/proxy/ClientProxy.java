package net.proxy;

import net.DemonCraft;
import net.entity.projectiles.Fire.FifthForm.enkoHIT_head;
import net.entity.projectiles.Fire.FifthForm.enko_head;
import net.entity.projectiles.Fire.FirstForm.siranui;
import net.entity.projectiles.Fire.NinthForm.HIT_rengoku;
import net.entity.projectiles.Fire.NinthForm.rengoku;
import net.entity.projectiles.Fire.SecondForm.enten;
import net.entity.projectiles.Fire.SecondForm.enten_HIT;
import net.entity.projectiles.Shadow.EntityShadowball;
import net.entity.projectiles.Shadow.EntityShadowslash;
import net.entity.projectiles.Thunder.lightning.customLightning;
import net.entity.projectiles.Wind.Form6.kokuhuu_hit;
import net.entity.projectiles.Wind.itaden.idaten;
import net.entity.projectiles.Wind.sinato;
import net.entity.projectiles.Wind.sinato_hit;
import net.entity.projectiles.Wind.sogi.HIT_sogi;
import net.entity.projectiles.Wind.sogi.sogi;
import net.entity.render.Flame.FifthForm.Render_enko_hit;
import net.entity.render.Flame.FifthForm.Render_head_enko;
import net.entity.render.Flame.*;
import net.entity.render.RenderEarrings;
import net.entity.render.shadow.RenderShadowball;
import net.entity.render.shadow.RenderShadowslash;
import net.entity.render.thunder.Render_Lbolt;
import net.entity.render.wind.*;
import net.gui.GuiBreathBar;
import net.gui.GuiHandler;
import net.gui.MoveSetGui;
import net.init.EntityInit;
import net.keys.KeyInputHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.util.handlers.EventHandler;
import net.util.handlers.RegistryHandler;
import org.lwjgl.input.Keyboard;




public class ClientProxy extends ServerProxy {

    public static final KeyBinding slayer = new KeyBinding("Slayer Gui", Keyboard.KEY_P, "key.categories.slayer");
    public static final KeyBinding tech = new KeyBinding("Change Form", Keyboard.KEY_C, "key.categories.slayer");
    public static final KeyBinding breath = new KeyBinding("Focus Breath", Keyboard.KEY_B, "key.categories.slayer");



    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowball.class, RenderShadowball::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowslash.class, RenderShadowslash::new);
        RenderingRegistry.registerEntityRenderingHandler(customLightning.class, Render_Lbolt::new);
        RenderingRegistry.registerEntityRenderingHandler(HIT_rengoku.class, Render_rengoku::new);
        RenderingRegistry.registerEntityRenderingHandler(enten_HIT.class, Render_enten_hit::new);
        RenderingRegistry.registerEntityRenderingHandler(enten.class, Render_enten::new);
        RenderingRegistry.registerEntityRenderingHandler(enko_head.class, Render_head_enko::new);
        RenderingRegistry.registerEntityRenderingHandler(enkoHIT_head.class, Render_enko_hit::new);
        RenderingRegistry.registerEntityRenderingHandler(rengoku.class, Render_rengoku2::new);
        RenderingRegistry.registerEntityRenderingHandler(siranui.class, Render_siranui::new);
        RenderingRegistry.registerEntityRenderingHandler(kokuhuu_hit.class, Render_kokuhuu_hit::new);
        RenderingRegistry.registerEntityRenderingHandler(HIT_sogi.class, Render_sogi::new);
        RenderingRegistry.registerEntityRenderingHandler(sogi.class, Render_sogi2::new);
        RenderingRegistry.registerEntityRenderingHandler(idaten.class, Render_idaten::new);
        RenderingRegistry.registerEntityRenderingHandler(sinato.class, Render_sinato::new);
        RenderingRegistry.registerEntityRenderingHandler(sinato_hit.class, Render_sinato_hit::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLivingBase.class, new RenderEarrings(Minecraft.getMinecraft().getRenderManager()));

        /*RenderingRegistry.registerEntityRenderingHandler(Takitubo.class, Render_takitubo::new);
        RenderingRegistry.registerEntityRenderingHandler(Nagi.class, Render_nagi::new);
        RenderingRegistry.registerEntityRenderingHandler(Kanten.class, Render_kanten::new);
        RenderingRegistry.registerEntityRenderingHandler(Seisei.class, Render_seisei::new);
        RenderingRegistry.registerEntityRenderingHandler(Sei_head.class, Render_head_seisei::new);
        RenderingRegistry.registerEntityRenderingHandler(HIT_minamo.class, Render_minamo::new);
        RenderingRegistry.registerEntityRenderingHandler(minamo.class, Render_minamo2::new);
        RenderingRegistry.registerEntityRenderingHandler(lightning_custom.class, Render_lightning::new);
        RenderingRegistry.registerEntityRenderingHandler(lightning_custom2.class, Render_lightning2::new);



        RenderingRegistry.registerEntityRenderingHandler(kasumi.class, Render_kasumi::new);
        RenderingRegistry.registerEntityRenderingHandler(kasumi_HIT.class, Render_kasumi_HIT::new);
        RenderingRegistry.registerEntityRenderingHandler(oboro.class,Render_oboro_slash::new);
        RenderingRegistry.registerEntityRenderingHandler(nejire.class, Render_nejire::new);

        RenderingRegistry.registerEntityRenderingHandler(kokuhuu.class, Render_kokuhuu::new);



        RenderingRegistry.registerEntityRenderingHandler(HIT_hekireki.class, Render_HIT_hekireki::new);
        RenderingRegistry.registerEntityRenderingHandler(tawamure.class, Render_tawamure::new);
        RenderingRegistry.registerEntityRenderingHandler(moon.class, Rendermoon::new);
        RenderingRegistry.registerEntityRenderingHandler(kataware_hit.class, Renderkataware_hit::new);
        RenderingRegistry.registerEntityRenderingHandler(kataware.class, Renderkataware::new);
        RenderingRegistry.registerEntityRenderingHandler(kataware_hit.class, Renderkataware_hit::new);
        RenderingRegistry.registerEntityRenderingHandler(kataware.class, Renderkataware::new);
        RenderingRegistry.registerEntityRenderingHandler(tukibae_hit.class, Rendertukibae_hit::new);
        RenderingRegistry.registerEntityRenderingHandler(tukibae.class, Rendertukibae::new);
        RenderingRegistry.registerEntityRenderingHandler(rinbi.class, Renderrinbi::new);*/
   }
    @Override
    public void registerClientStuff(){
        EntityInit.registerEntities();


        //Keybind Registration
        ClientRegistry.registerKeyBinding(tech);
        ClientRegistry.registerKeyBinding(slayer);
        ClientRegistry.registerKeyBinding(breath);

        NetworkRegistry.INSTANCE.registerGuiHandler(DemonCraft.instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
        MinecraftForge.EVENT_BUS.register(new GuiBreathBar());
        MinecraftForge.EVENT_BUS.register(new MoveSetGui());
        DemonCraft.proxy.render();
        EventHandler.registerEvents();
        RegistryHandler.initRegistries();
    }


}
