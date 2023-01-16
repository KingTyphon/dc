package net.networking.Client.tech;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.capabilities.techniquecapability.TechProvider;

public class ServerHandlerT implements IMessageHandler<TechMessage, IMessage> {
    @SideOnly(Side.SERVER)
    public IMessage onMessage(TechMessage message, MessageContext ctx) {
        EntityPlayerMP serverplayer = ctx.getServerHandler().player;
        int amount = message.tech;
        int sp = message.sp;
        int health = message.health;
        int speed = message.speed;
        int strength = message.strength;
        int manaPoint = message.manaPoint;
        int skill = message.skill;

        serverplayer.getServerWorld().addScheduledTask(()->{
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setTech(amount);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setSp(sp);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setHealth(health);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setSpeed(speed);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setStrength(strength);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setManaPoint(manaPoint);
            serverplayer.getCapability(TechProvider.TECH_CAP, null).setManaPoint(skill);

        });
        return null;
    }}

