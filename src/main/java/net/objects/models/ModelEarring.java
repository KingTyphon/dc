package net.objects.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelEarring extends ModelBiped {
    public ModelRenderer earring1;
    public ModelRenderer earring2;

    public ModelEarring() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.earring2 = new ModelRenderer(this, 0, 0);
        this.earring2.setRotationPoint(4.3F, 5.3F, 2.0F);
        this.earring2.addBox(-0.1F, -8.0F, -4.0F, 0, 2, 1, 0.0F);
        this.earring1 = new ModelRenderer(this, 0, 0);
        this.earring1.setRotationPoint(-4.1F, 5.3F, 2.0F);
        this.earring1.addBox(-0.1F, -8.0F, -4.0F, 0, 2, 1, 0.0F);

        this.bipedHead.addChild(earring1);
        this.bipedHead.addChild(earring2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableBlend();


    }


    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
