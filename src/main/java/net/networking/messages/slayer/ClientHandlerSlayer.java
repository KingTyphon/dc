package net.networking.messages.slayer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.capabilities.slayer.SlayerProvider;

public class ClientHandlerSlayer implements IMessageHandler<SlayerMessage, IMessage> {


    @SideOnly(Side.CLIENT)
    @Override
    public IMessage onMessage(SlayerMessage message, MessageContext ctx) {

        Minecraft mc = Minecraft.getMinecraft();
        mc.addScheduledTask(() -> {
            EntityPlayerSP player = mc.player;
            ISlayerCapability slayer = player.getCapability(SlayerProvider.Breath_CAP, null);
            ISlayerCapability slayerUpdate = message.capability;
            if (player != null && slayer != null) {
                slayer.copyFrom(slayerUpdate);
            }
        });
        return null;
    }

}
