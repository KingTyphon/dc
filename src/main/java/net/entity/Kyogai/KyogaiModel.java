package net.entity.Kyogai;

import net.DemonCraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.util.handlers.Reference;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;


public class KyogaiModel extends AnimatedGeoModel {
    public KyogaiModel() {
        }

        public ResourceLocation getAnimationFileLocation(Object entity) {
            return new ResourceLocation(Reference.MODID, "animations/model.kyogaanimations.json");
        }

        public ResourceLocation getModelLocation(Object entity) {
            return new ResourceLocation(Reference.MODID, "geo/kyogai.json");
        }

        public ResourceLocation getTextureLocation(Object entity) {
            return new ResourceLocation(Reference.MODID, "textures/entity/kyogai.png");
        }

    }