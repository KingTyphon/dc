package net.util.handlers;

import net.minecraftforge.common.MinecraftForge;
import net.world.Events;

public class EventHandler {
    public static void registerEvents(){
        Events events = new Events();

        MinecraftForge.EVENT_BUS.register(events);
    }
}
