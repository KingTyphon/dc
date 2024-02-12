package net.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.networking.Networking;
import net.networking.messages.tech.Tech;
import net.util.capabilities.techniquecapability.ITechCapability;
import net.util.capabilities.techniquecapability.TechProvider;

import javax.annotation.Nullable;

public class IncreaseSP extends CommandBase {

        @Override
        public String getName() {
            return "increaseSP";
        }

        @Override
        public String getUsage(ICommandSender sender) {
            return "/increaseSP <number>";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            ITechCapability tech = sender.getCommandSenderEntity().getCapability(TechProvider.TECH_CAP, null);
            if (args.length != 1) {
                throw new CommandException("Invalid usage. " + getUsage(sender));
            }

            try {
                int number = Integer.parseInt(args[0]);
                tech.setSp(tech.getSp() + number);
                sender.sendMessage(new TextComponentString("You gained: " + number + " SP"));
                Networking.sendTo(new Tech((EntityLivingBase) sender.getCommandSenderEntity()), (EntityPlayerMP) sender.getCommandSenderEntity());
            } catch (NumberFormatException e) {
                throw new CommandException("Invalid number format. " + getUsage(sender));
            }
        }

        @Override
        public int getRequiredPermissionLevel() {
            // Set the required permission level for the command (e.g., 0 for everyone)
            return 2;
        }
    }

