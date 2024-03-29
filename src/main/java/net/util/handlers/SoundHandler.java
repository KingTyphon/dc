package net.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler {

    public static SoundEvent SHADOW_AMBIENT;
    public static SoundEvent NAGI_SOUND, TAKITUBO_SOUND,MINAMO_SOUND,KANTEN_SOUND,ENTEN_SOUND,SIRANUI_SOUND;
    public static SoundEvent KASUMI_SOUND,OBORO_SOUND;

    public static void registerSounds() {
        SHADOW_AMBIENT = registerSound("shadow_ambient");
        NAGI_SOUND = registerSound("nagi_sound");
        TAKITUBO_SOUND = registerSound("takitubo_sound");
        KANTEN_SOUND = registerSound("kanten_sound");
        MINAMO_SOUND = registerSound("minamo_sound");
        ENTEN_SOUND = registerSound("enten_sound");
        SIRANUI_SOUND = registerSound("siranui_sound");
        KASUMI_SOUND = registerSound("kasumi_sound");
        OBORO_SOUND = registerSound("oboro_sound");
    }

    public static SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }}