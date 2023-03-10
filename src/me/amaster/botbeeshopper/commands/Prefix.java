package me.amaster.botbeeshopper.commands;

import me.amaster.botbeeshopper.main.BeeShopper;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Prefix extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        TextChannel textChannel = event.getChannel().asTextChannel();

        if(args[0].equalsIgnoreCase(BeeShopper.prefixMap.get(event.getGuild().getId())+ "prefix")){

            textChannel.sendMessage( "O prefixo para este servidor é: "+ BeeShopper.prefixMap.get(event.getGuild().getId())).queue();

            BeeShopper.prefixMap.replace(event.getGuild().getId(), '!');

        }

    }
}
