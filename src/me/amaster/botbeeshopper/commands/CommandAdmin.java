package me.amaster.botbeeshopper.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class CommandAdmin extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();

        if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            if (command.equals("")) {
                event.reply("").queue();
            } else if (command.equals("")) {

            }
        }
    }

    //Guild Command - Update Instantanio (max 100)

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        //commandData.add(Commands.slash("", ""));
        //commandData.add(Commands.slash("roles", ""));
        event.getGuild().updateCommands().addCommands(commandData).queue();

        if (event.getGuild().getIdLong() == 874390100572770364L);
    }

    //Global Command - Update em algumas horas (ilimitado)
    @Override
    public void onReady(ReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        //commandData.add(Commands.slash("ping", "Seu ping com o bot."));
        event.getJDA().updateCommands().addCommands(commandData).queue();
    }
}


