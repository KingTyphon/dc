package net.networking;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.networking.Client.slayer.ClientHandler;
import net.networking.Client.slayer.SlayerMessage;
import net.networking.Client.slayer.ServerHandler;
import net.networking.Client.tech.ClientHandlerT;
import net.networking.Client.tech.TechMessage;
import net.networking.Client.tech.ServerHandlerT;
import net.util.handlers.Reference;

public class Networking {
    public static SimpleNetworkWrapper INSTANCE;

public static void init(){
    INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
    //Client
    INSTANCE.registerMessage(ClientHandler.class, SlayerMessage.class, 0, Side.CLIENT);
    INSTANCE.registerMessage(ClientHandlerT.class, TechMessage.class, 3, Side.CLIENT);
    //Server
    INSTANCE.registerMessage(ServerHandler.class, SlayerMessage.class, 1, Side.SERVER);
    INSTANCE.registerMessage(ServerHandlerT.class, TechMessage.class, 2, Side.SERVER);
}

//Client -> Server
public static void sendToServer(IMessage message){INSTANCE.sendToServer(message);}
//Server -> Client
public static void sendTo(IMessage message, EntityPlayerMP player){
    INSTANCE.sendTo(message, player);
}
public static void sendToAll(IMessage message){
    INSTANCE.sendToAll(message);
}
}
