package net.networking;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.networking.Client.ClientHandler;
import net.networking.Client.ClientSlayer;
import net.networking.Client.ServerHandler;
import net.util.handlers.Reference;

public class Networking {
    public static SimpleNetworkWrapper INSTANCE;

public static void init(){
    INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
    //Client
    INSTANCE.registerMessage(ClientHandler.class, ClientSlayer.class, 0, Side.CLIENT);
    //Server
    INSTANCE.registerMessage(ServerHandler.class, ClientSlayer.class, 1, Side.SERVER);
}
public static void sendToServer(IMessage message){
    INSTANCE.sendToServer(message);
}
public static void sendTo(IMessage message, EntityPlayerMP player){
    INSTANCE.sendTo(message, player);
}
public static void sendToAll(IMessage message){
    INSTANCE.sendToAll(message);
}
}
