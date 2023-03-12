package net.networking.messages.slayer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.capabilities.slayer.SlayerProvider;

public class ClientHandlerS implements IMessageHandler<Slayer, IMessage> {

    @SideOnly(Side.CLIENT)
    @Override
    public IMessage onMessage(Slayer message, MessageContext ctx) {
        //Player
        Minecraft mc = Minecraft.getMinecraft();

        //Numbers
        int amount = message.Breath;
        float mana = message.Mana;
        int maxmana= message.MaxMana;
        int xp = message.XP;
        int level = message.Level;

        //Sets the Players Stats
        Minecraft.getMinecraft().addScheduledTask(()->{

        EntityPlayerSP player = mc.player;
        if(player != null){
            player.getCapability(SlayerProvider.Breath_CAP, null).setBreath(amount);
            player.getCapability(SlayerProvider.Breath_CAP, null).setMana(mana);
            player.getCapability(SlayerProvider.Breath_CAP, null).setMaxMana(maxmana);
            player.getCapability(SlayerProvider.Breath_CAP, null).setXP(xp);
            player.getCapability(SlayerProvider.Breath_CAP, null).setLevel(level);

        }});

        return null;
    }
}