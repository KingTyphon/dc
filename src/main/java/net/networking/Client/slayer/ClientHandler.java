package net.networking.Client.slayer;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.util.capabilities.slayer.SlayerProvider;

public class ClientHandler implements IMessageHandler<SlayerMessage, IMessage> {

    @Override
    public IMessage onMessage(SlayerMessage message, MessageContext ctx) {
        EntityPlayer entityClientPlayerMP = (Minecraft.getMinecraft()).player;

        //Numbers
        int level = message.Level;
        int xp = message.XP;
        float mana = message.Mana;
        int breath = message.Breath;
        int maxmana = message.MaxMana;

        //Sets the Players Stats

        entityClientPlayerMP.getCapability(SlayerProvider.Breath_CAP, null).setBreath(breath);
        entityClientPlayerMP.getCapability(SlayerProvider.Breath_CAP, null).setMana(mana);
        entityClientPlayerMP.getCapability(SlayerProvider.Breath_CAP, null).setXP(xp);
        entityClientPlayerMP.getCapability(SlayerProvider.Breath_CAP, null).setLevel(level);
        entityClientPlayerMP.getCapability(SlayerProvider.Breath_CAP, null).setMaxMana(maxmana);

        return null;
    }}