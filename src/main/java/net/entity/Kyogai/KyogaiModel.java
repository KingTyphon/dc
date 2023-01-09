package net.entity.Kyogai;

import net.DemonCraft;
import net.minecraft.util.ResourceLocation;
import net.util.handlers.Reference;
import software.bernie.geckolib3.model.AnimatedGeoModel;


public class KyogaiModel extends AnimatedGeoModel {
    public KyogaiModel() {
        }

        public ResourceLocation getAnimationFileLocation(Object entity) {
            return new ResourceLocation(Reference.MODID, "animations/model.animation.idle.json");
        }

        public ResourceLocation getModelLocation(Object entity) {
            return new ResourceLocation(Reference.MODID, "geo/kyogai.json");
        }

        public ResourceLocation getTextureLocation(Object entity) {
            return new ResourceLocation(Reference.MODID, "textures/entity/kyogai.png");
        }
    }