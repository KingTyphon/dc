package net.entity.render;

import net.entity.Demon.EntityDemon;
import net.entity.Demon.ModelDemon;
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
    protected ResourceLocation getEntityTexture(EntityDemon entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityDemon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}