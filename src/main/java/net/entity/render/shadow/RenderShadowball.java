package net.entity.render.shadow;

import net.entity.model.ModelShadowball;
import net.entity.projectiles.Shadow.EntityShadowball;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.handlers.Reference;

@SideOnly(Side.CLIENT)
public class RenderShadowball extends Render{
    private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/shadowball.png");
    private ModelShadowball model = new ModelShadowball();

    public RenderShadowball(RenderManager RM)
    {
        super(RM);
    }

    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTick)
    {
        super.doRender(entity, x, y, z, yaw, partialTick);
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        bindEntityTexture(entity);
        this.model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GlStateManager.popMatrix();
    }
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
   }


