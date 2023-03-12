package net.networking.messages.tech;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.capabilities.techniquecapability.TechProvider;

public class ClientHandlerT implements IMessageHandler<Tech, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(Tech message, MessageContext ctx) {
        //Player
        EntityPlayer entityClientPlayerMP = (Minecraft.getMinecraft()).player;

        //Numbers to hold the stats
        int tech = message.tech;
        int sp = message.sp;
        int health = message.health;
        int speed = message.speed;
        int strength = message.strength;
        //Sets the Players Stats
        Minecraft.getMinecraft().addScheduledTask(()->{
        entityClientPlayerMP.getCapability(TechProvider.TECH_CAP, null).setTech(tech);
        entityClientPlayerMP.getCapability(TechProvider.TECH_CAP, null).setSp(sp);
        entityClientPlayerMP.getCapability(TechProvider.TECH_CAP, null).setHealth(health);
        entityClientPlayerMP.getCapability(TechProvider.TECH_CAP, null).setSpeed(speed);
        entityClientPlayerMP.getCapability(TechProvider.TECH_CAP, null).setStrength(strength);});
        return null;
    }
}