package net.init;

import net.DemonCraft;
import net.entity.EntityDemon;
import net.entity.EntityHuman;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.util.handlers.Reference;

import java.sql.Ref;


public class EntityInit {
    public static void registerEntities(){
        registerEntity("human", EntityHuman.class, Reference.ENTITY_HUMAN, 50, 000000, 16777215);
        registerEntity("demon", EntityDemon.class, Reference.ENTITY_DEMON, 50, 000000, 6619136);
    }
    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, DemonCraft.instance, range, 1, true, color1, color2);
    }
}