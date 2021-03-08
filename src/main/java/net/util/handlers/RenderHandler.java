package net.util.handlers;

import net.entity.EntityDemon;
import net.entity.render.RenderDemon;
import net.entity.EntityHuman;
import net.entity.render.RenderHuman;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
    public static void registerEntityRenderers(){
        RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, RenderHuman::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, RenderDemon::new);
    }
}
