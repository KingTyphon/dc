package net.keys;

import net.gui.GuiSlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.networking.Networking;
import net.networking.messages.PlayerManager;
import net.networking.messages.slayer.Slayer;
import net.networking.messages.tech.Tech;
import net.proxy.ClientProxy;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.capabilities.slayer.SlayerProvider;
import net.util.capabilities.techniquecapability.TechProvider;

public class KeyInputHandler {
    int i=0;
    static boolean isPressed =false;
    static int timePressed = 0;

    private String breathTechnique(int breath){
        String breathTech = "";
        switch(breath){
            case 1:
                break;
        }
        return breathTech;

    }
    private String breathChoice(int breathNum){
        String breath = "";
        switch(breathNum) {
            case 1:
                breath = "Flame Breathing";
                break;
            case 2:
                breath = "Insect Breathing";
                break;
            case 3:
                breath = "Thunder Breathing";
                break;
            case 4:
                breath = "Shadow Breathing";
                break;
            case 5:
                breath = "Mist Breathing";
                break;
            case 6:
                breath = "Sound Breathing";
                break;
            case 7:
                breath = "Beast Breathing";
                break;
            case 8:
                breath = "Wind Breathing";
                break;
            case 9:
                breath = "Ice Breathing";
                break;
            case 10:
                breath = "Special Breathing";
                break;
            case 11:
                breath = "Water Breathing";
                break;
            case 12:
                breath = "Love Breathing";
                break;
            case 13:
                breath = "Flower Breathing";
                break;
            case 14:
                breath = "Sun Breathing";
                break;
            case 15:
                breath = "Serpent Breathing";
                break;
            case 16:
                breath = "Stone Breathing";
                break;
        }
        return breath;
    }
    @SubscribeEvent
    public static void onClientTickEvent(TickEvent.ClientTickEvent event) {
        EntityPlayer player1 = Minecraft.getMinecraft().player;
        ISlayerCapability playerBreath = player1.getCapability(SlayerProvider.Breath_CAP, null);

        if(ClientProxy.breath.isKeyDown()) {
            isPressed =true;
            timePressed +=1;
        }else{
            isPressed = false;
            PlayerManager.increaseManaUpdater(player1, timePressed);
            timePressed = 0;
        }
    }
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {


        EntityPlayer player1 = Minecraft.getMinecraft().player;
        int playerBreath = player1.getCapability(SlayerProvider.Breath_CAP, null).getBreath();
        int playerTech = player1.getCapability(TechProvider.TECH_CAP, null).getTech();
        String breath = "";


        if (ClientProxy.slayer.isPressed()) {

            Networking.sendToServer(new Tech(player1));
            Networking.sendToServer(new Slayer(player1.getCapability(SlayerProvider.Breath_CAP, null).getBreath(), player1.getCapability(SlayerProvider.Breath_CAP, null).getMana(), player1.getCapability(SlayerProvider.Breath_CAP, null).getXP(), player1.getCapability(SlayerProvider.Breath_CAP, null).getLevel(), player1.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana()));

            Minecraft.getMinecraft().displayGuiScreen(new GuiSlayer());
        }
        if (ClientProxy.tech.isPressed()) {

            //Flame Breathing - Done 1,2,3,4,5,9
            if (playerTech < 5  && playerBreath == 1) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }if (playerTech == 9 && playerBreath == 1) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if (playerTech == 5  && playerBreath == 1) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 4);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }
            else if(playerTech >5 && playerTech < 9 && playerBreath == 1)player1.getCapability(TechProvider.TECH_CAP, null).setTech(9);
            else if(playerTech >9 && playerBreath == 1)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            //Insect Breathing - Done 1,2,3,4,
            if (playerTech < 4 && playerBreath == 2) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            } else if (playerTech == 4 && playerBreath == 2) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >5)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);


            //Thunder Breathing - Done 1,2,3,4,5,6,7
            if (playerTech < 7  && playerBreath == 3) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if (playerTech == 7 && playerBreath == 3) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            } else if(playerTech >7){
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }

            //Shadow Breathing
             if (playerTech < 5 && playerBreath == 4) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            } else if (playerTech == 5 && playerBreath == 4) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >5 && playerBreath == 4)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            //Mist Breathing - Done 1,2,3,4,5,6,7
            if (playerTech < 7 && playerBreath == 5) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            } else if (playerTech == 7 && playerBreath == 5) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >7 && playerBreath == 5)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            //Sound Breathing - Done 1,4,5
            if(playerTech == 1 && playerBreath == 6){
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(4);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }
            if (playerTech ==4  && playerBreath == 6) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if (playerTech == 5 && playerBreath == 6) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >11 && playerBreath == 6)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            //Beast Breathing - Done 1,2,3,4,5,6,7,8,9,10
            if (playerTech < 10  && playerBreath == 7) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if (playerTech == 10 && playerBreath == 7) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >11 && playerBreath == 7)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            //Wind Breathing - Done 1,2,3,4,5,6,7,8,9
            if (playerTech < 9  && playerBreath == 8) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if (playerTech == 9 && playerBreath == 8) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >10 && playerBreath == 8)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            //Ice Breathing - Done 1,2,3,4,5,6,7,8,9,10,11
            if (playerTech < 11  && playerBreath == 9) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if (playerTech == 11 && playerBreath == 9) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >11 && playerBreath == 9)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            //Special Breathing - Done 1,2,3,4,5,6,7,8,9,10,11
            if (playerTech < 11  && playerBreath == 10) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if (playerTech == 11 && playerBreath == 10) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >11 && playerBreath == 10)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            //Water Breathing - Done 1,2,3,4,5,6,7,8,9,10,11
            if (playerTech < 11  && playerBreath == 11) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if (playerTech == 11 && playerBreath == 11) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >11 && playerBreath == 11)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            //Love Breathing - Done 1,2,3,4,5,6,7,8,9,10,11
            if (playerTech < 11  && playerBreath == 12) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if (playerTech == 11 && playerBreath == 12) {
                breath = breathChoice(playerBreath);
                player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
                player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
            }else if(playerTech >11 && playerBreath == 12)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

            Networking.sendToServer(new Slayer(player1.getCapability(SlayerProvider.Breath_CAP, null).getBreath(), player1.getCapability(SlayerProvider.Breath_CAP, null).getMana(), player1.getCapability(SlayerProvider.Breath_CAP, null).getXP(), player1.getCapability(SlayerProvider.Breath_CAP, null).getLevel(), player1.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana()));
            Networking.sendToServer(new Tech(player1));


        //Flower Breathing - Done 2,4,5,6,7
        if (playerTech == 2 && playerBreath == 13) {
            breath = breathChoice(playerBreath);
            player1.getCapability(TechProvider.TECH_CAP, null).setTech(4);
            player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
        }else if (playerTech > 3 &&playerTech < 7  && playerBreath == 13) {
            breath = breathChoice(playerBreath);
            player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
            player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
        }else if (playerTech == 7 && playerBreath == 13) {
            breath = breathChoice(playerBreath);
            player1.getCapability(TechProvider.TECH_CAP, null).setTech(2);
            player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
        }else if(playerTech >11 || playerTech == 1 && playerBreath == 13)player1.getCapability(TechProvider.TECH_CAP, null).setTech(2);

        //Sun Breathing - Done 1,2,3,4,5,6,7,8,9,10,11,12,13
        if (playerTech < 13  && playerBreath == 14) {
            breath = breathChoice(playerBreath);
            player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
            player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
        }else if (playerTech == 13 && playerBreath == 14) {
            breath = breathChoice(playerBreath);
            player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
            player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
        }else if(playerTech >13 && playerBreath == 14)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

        //Serpent Breathing - Done 1,2,3,4,5
        if (playerTech < 5  && playerBreath == 15) {
            breath = breathChoice(playerBreath);
            player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
            player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
        }else if (playerTech == 5 && playerBreath == 15) {
            breath = breathChoice(playerBreath);
            player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
            player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
        }else if(playerTech >5 && playerBreath == 15)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);

        //Stone Breathing - Done 1,2,3,4,5
        if (playerTech < 5  && playerBreath == 16) {
            breath = breathChoice(playerBreath);
            player1.getCapability(TechProvider.TECH_CAP, null).setTech(playerTech + 1);
            player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
        }else if (playerTech == 5 && playerBreath == 16) {
            breath = breathChoice(playerBreath);
            player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
            player1.sendMessage(new TextComponentString(breath + " Form: " + player1.getCapability(TechProvider.TECH_CAP, null).getTech()));
        }else if(playerTech >5 && playerBreath == 16)player1.getCapability(TechProvider.TECH_CAP, null).setTech(1);
        /*     if(ClientProxy.breath.isKeyDown() && player1.getCapability(SlayerProvider.Breath_CAP, null).getMana() != player1.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana()){

        }*/
        }
    }
}




