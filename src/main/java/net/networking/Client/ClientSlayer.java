package net.networking.Client;

import com.sun.security.ntlm.Client;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.util.capabilities.SlayerProvider;

public class ClientSlayer implements IMessage {
    
    public ClientSlayer(){}
    public int Breath;
    public ClientSlayer(int Breath){
        this.Breath = Breath;
    }



    @Override public void toBytes(ByteBuf buf) {
        // Writes the int into the buf
        buf.writeInt(Breath);
    }

    @Override public void fromBytes(ByteBuf buf) {
        // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
        Breath = buf.readInt();
    }
} public class ClientHandler implements IMessageHandler<ClientSlayer, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(ClientSlayer message, MessageContext ctx) {
        EntityPlayer entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
        int Breath = message.Breath;
        entityClientPlayerMP.getCapability(SlayerProvider.Breath_CAP, null).setBreath(Breath);
        return null;
    }}
    public class ServerHandler implements IMessageHandler<ClientSlayer, IMessage> {
        public IMessage onMessage(ClientSlayer message, MessageContext ctx) {
            EntityPlayerMP serverplayer = ctx.getServerHandler().playerEntity;

            serverplayer.getServerWorld().addScheduledTask(()->{
                serverplayer.getCapability(SlayerProvider.Breath_CAP, null).getBreath();
            });
            return null;
        }}

