package net.util.handlers;

import net.entity.EntityDemon;
import net.entity.EntityHuman;
import net.entity.render.RenderDemon;
import net.entity.render.RenderHuman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
    public static void registerEntityRenderers(){
        RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, new IRenderFactory<EntityHuman>()
        {
            @Override
            public Render<? super EntityHuman> createRenderFor(RenderManager manager) {
                return new RenderHuman(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, new IRenderFactory<EntityDemon>()
        {
            @Override
            public Render<? super EntityDemon> createRenderFor(RenderManager manager) {
                return new RenderDemon(manager);
            }
        });
    }
}
