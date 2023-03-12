package net.networking.messages.slayer;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.capabilities.slayer.SlayerProvider;

public class SlayerMessage implements IMessage {

    ISlayerCapability capability;

    public SlayerMessage() {
    }

    public SlayerMessage(ISlayerCapability slayer) {
        this.capability = slayer;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        String s = ByteBufUtils.readUTF8String(buf);
        this.capability = SlayerProvider.stringtoSlayer(s);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        String s = SlayerProvider.slayerToString(capability);
        ByteBufUtils.writeUTF8String(buf, s);
    }

}

