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
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@SideOnly(Side.CLIENT)
public class KyogaiRender extends GeoEntityRenderer<KyogaiEntity> {
    public KyogaiRender(RenderManager manager) {

        super(manager, new KyogaiModel());
        this.shadowSize = 0.3f;
    }


}

