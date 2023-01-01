package net.entity.render.shadow;

import net.entity.model.ModelShadowslash;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.util.handlers.Reference;

public class RenderShadowslash extends Render {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/shadowslash.png");
    private ModelShadowslash model = new ModelShadowslash();

    public RenderShadowslash(RenderManager RM)
    {
        super(RM);
    }

    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTick)
    {
        super.doRender(entity, x, y, z, yaw, partialTick);
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        bindEntityTexture(entity);
        model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GlStateManager.popMatrix();

    }
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}
