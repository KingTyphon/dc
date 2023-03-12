package net.networking;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.networking.messages.slayer.*;
import net.networking.messages.tech.ClientHandlerT;
import net.networking.messages.tech.ServerHandlerT;
import net.networking.messages.tech.Tech;
import net.util.handlers.Reference;

public class Networking {
    public static SimpleNetworkWrapper INSTANCE;

public static void init(){
    INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
    //Client
    INSTANCE.registerMessage(ClientHandlerSlayer.class, SlayerMessage.class, 4, Side.CLIENT);
    INSTANCE.registerMessage(ClientHandlerS.class, Slayer.class, 0, Side.CLIENT);
    INSTANCE.registerMessage(ClientHandlerT.class, Tech.class, 3, Side.CLIENT);
    //Server
    INSTANCE.registerMessage(ServerHandlerS.class, Slayer.class, 1, Side.SERVER);
    INSTANCE.registerMessage(ServerHandlerT.class, Tech.class, 2, Side.SERVER);

}
//Server
public static void sendToServer(IMessage message){
    INSTANCE.sendToServer(message);
}
//Client
public static void sendTo(IMessage message, EntityPlayerMP player){
    INSTANCE.sendTo(message, player);
}
public static void sendToAll(IMessage message){
    INSTANCE.sendToAll(message);
}
}
