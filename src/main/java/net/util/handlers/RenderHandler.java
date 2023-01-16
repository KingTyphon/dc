package net.util.handlers;

import net.entity.Demon.EntityDemon;
import net.entity.EntityHuman;
import net.entity.Kyogai.KyogaiEntity;
import net.entity.Kyogai.KyogaiRender;
import net.entity.projectiles.Shadow.EntityShadowball;
import net.entity.projectiles.Shadow.EntityShadowslash;
import net.entity.render.RenderDemon;
import net.entity.render.RenderHuman;
import net.entity.render.shadow.RenderShadowball;
import net.entity.render.shadow.RenderShadowslash;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
    public static void registerEntityRenderers(){
        RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, RenderHuman::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, RenderDemon::new);
        RenderingRegistry.registerEntityRenderingHandler(KyogaiEntity.class, KyogaiRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowball.class, RenderShadowball::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowslash.class, RenderShadowslash::new);
    }
}
