package net.entity.render.Flame;

import net.entity.model.Model_transparent;
import net.entity.projectiles.Fire.SecondForm.enten;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Render_enten extends Render<enten> {
    private final Model_transparent model = new Model_transparent();

    private static ResourceLocation TEXTURE = new ResourceLocation("demoncraft:textures/entity/takitubo_model.png");

    public Render_enten(RenderManager renderManager) {
        super(renderManager);
    }

    public void doRender(enten entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);

        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        super.bindEntityTexture(entity);
        this.model.render((Entity)entity, partialTicks, 0.0F, -1.0F, 0.0F, 0.0F, 0.05F);
        GlStateManager.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(enten entity) {
        return TEXTURE;
    }
}