package net.entity.render;

import net.entity.EntityHuman;
import net.entity.model.ModelHuman;
import net.util.handlers.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;


public class RenderHuman extends RenderLiving<EntityHuman>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/human.png");
    public RenderHuman(RenderManager manager)
    {
        super(manager, new ModelHuman(), 0.5F);
    }
    @Override
    protected ResourceLocation getEntityTexture(EntityHuman entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityHuman entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
