package net.networking.Client.demon;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.util.capabilities.demon.DemonProvider;
import net.util.capabilities.slayer.SlayerProvider;

public class ClientHandlerD implements IMessageHandler<DemonMessage, IMessage>

    {
        @Override
        public IMessage onMessage(DemonMessage message, MessageContext ctx) {
        EntityPlayer entityClientPlayerMP = (Minecraft.getMinecraft()).player;

        //Numbers
        int level = message.Level;
        int xp = message.XP;
        float mana = message.Mana;
        int art = message.Art;
        int maxmana = message.MaxMana;

        //Sets the Players Stats

        entityClientPlayerMP.getCapability(DemonProvider.DEMON_CAP, null).setArt(art);
        entityClientPlayerMP.getCapability(DemonProvider.DEMON_CAP, null).setMana(mana);
        entityClientPlayerMP.getCapability(DemonProvider.DEMON_CAP, null).setXP(xp);
        entityClientPlayerMP.getCapability(DemonProvider.DEMON_CAP, null).setLevel(level);
        entityClientPlayerMP.getCapability(DemonProvider.DEMON_CAP, null).setMaxMana(maxmana);

        return null;
        }
    }

