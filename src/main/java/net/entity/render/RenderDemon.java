package net.entity.render;

import net.entity.EntityDemon;
import net.entity.model.ModelDemon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.util.handlers.Reference;

public class RenderDemon extends RenderLiving<EntityDemon>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/demon.png");
    public RenderDemon(RenderManager manager)
    {
        super(manager, new ModelDemon(), 0.5F);
    }
    @Override
    protected ResourceLocation getEntityTexture(net.entity.EntityDemon entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(net.entity.EntityDemon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}