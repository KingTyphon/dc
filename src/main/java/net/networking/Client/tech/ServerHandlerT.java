package net.networking.Client.tech;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.util.capabilities.techniquecapability.TechProvider;

public class ServerHandlerT implements IMessageHandler<ClientTech, IMessage> {
    public IMessage onMessage(ClientTech message, MessageContext ctx) {
        EntityPlayerMP serverplayer = ctx.getServerHandler().player;
        int amount = message.tech;
        int sp = message.sp;
        int health = message.health;
        int speed = message.speed;
        int strength = message.strength;
        int manaPoint = message.manaPoint;

        serverplayer.getServerWorld().addScheduledTask(()->{
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setTech(amount);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setSp(sp);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setHealth(health);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setSpeed(speed);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setStrength(strength);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setManaPoint(manaPoint);
        });
        return null;
    }}
