package net.entity.Kyogai;

import net.entity.Kyogai.KyogaiEntity;
import net.entity.Kyogai.KyogaiModel;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.handlers.Reference;

@SideOnly(Side.CLIENT)
public class KyogaiRender extends RenderLiving<KyogaiEntity> {
    public static final ResourceLocation textures = new ResourceLocation(Reference.MODID + ":textures/entity/kyogai.png");


    public KyogaiRender(RenderManager manager) {
        super(manager, new KyogaiModel(), 0.5F);
    }

    public void doRender(KyogaiEntity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    @Override
    protected ResourceLocation getEntityTexture(KyogaiEntity entity) {
        return textures;
    }


    protected void applyRotations(KyogaiEntity entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}

