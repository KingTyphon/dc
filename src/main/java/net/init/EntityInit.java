package net.init;

import net.DemonCraft;
import net.entity.Demon.EntityDemon;
import net.entity.EntityHuman;
import net.entity.Kyogai.KyogaiEntity;
import net.entity.projectiles.Shadow.EntityShadowball;
import net.entity.projectiles.Shadow.EntityShadowslash;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.util.handlers.Reference;


public class EntityInit {
    public static void registerEntities(){
        registerEntity("human", EntityHuman.class, Reference.ENTITY_HUMAN, 50, 000000, 16777215);
        registerEntity("demon", EntityDemon.class, Reference.ENTITY_DEMON, 50, 000000, 6619136);
        registerEntity("kyogai", KyogaiEntity.class, 124, 50, 12632256, 10289152);
        registerProjectile("shadowball", Reference.ENTITY_SHADOWBALL, EntityShadowball.class, ItemInit.kaji_sword);
        registerProjectile("shadowslice", 123, EntityShadowslash.class, ItemInit.kaji_sword);
    }
    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, DemonCraft.instance, range, 1, true, color1, color2);
    }
    private static void registerProjectile(String name, int id, Class<? extends Entity> entity, Item item){
        EntityRegistry.registerModEntity(new ResourceLocation(name), entity, name, id, DemonCraft.instance, 64, 10, true);
    }
}