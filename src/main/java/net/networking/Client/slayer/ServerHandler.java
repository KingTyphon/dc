package net.networking.Client.slayer;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.util.capabilities.slayer.SlayerProvider;

public class ServerHandler implements IMessageHandler<SlayerMessage, IMessage> {
    public IMessage onMessage(SlayerMessage message, MessageContext ctx) {
        EntityPlayerMP serverplayer = ctx.getServerHandler().player;
        int amount = message.Breath;
        float mana = message.Mana;
        int maxmana= message.MaxMana;
        int xp = message.XP;
        int level = message.Level;

        serverplayer.getServerWorld().addScheduledTask(()->{
            serverplayer.getCapability(SlayerProvider.Breath_CAP, null).setBreath(amount);
            serverplayer.getCapability(SlayerProvider.Breath_CAP, null).setMana(mana);
            serverplayer.getCapability(SlayerProvider.Breath_CAP, null).setMaxMana(maxmana);
            serverplayer.getCapability(SlayerProvider.Breath_CAP, null).setXP(xp);
            serverplayer.getCapability(SlayerProvider.Breath_CAP, null).setLevel(level);
        });
        return null;
    }}
