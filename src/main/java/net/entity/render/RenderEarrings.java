package net.entity.render;

import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.objects.models.ModelEarring;

public class RenderEarrings extends RenderLivingBase<EntityLivingBase> {

        private final ModelEarring model = new ModelEarring();

        public RenderEarrings(RenderManager renderManager) {
            super(renderManager, new ModelEarring(), 0.5F);
        }

        @Override
        protected ResourceLocation getEntityTexture(EntityLivingBase entity) {
            return new ResourceLocation("demoncraft:items/slayer_feet");
        }

        @Override
        protected boolean canRenderName(EntityLivingBase entity) {
            return false;
        }
    }

