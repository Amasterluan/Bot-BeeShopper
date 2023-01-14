package me.amaster.botbeeshopper.commands;

import me.amaster.botbeeshopper.main.BeeShopper;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Roles extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        short roleIndexes = 0;

        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(BeeShopper.prefixMap.get(event.getGuild().getId())+"autorole")){

            StringBuilder stringBuilder = new StringBuilder();

            for (Role role: event.getGuild().getRoles()) {

                if(!role.isPublicRole()){
                    stringBuilder
                            .append(roleIndexes)
                            .append(" - ")
                            .append(role.getName())
                            .append("\n");
                    roleIndexes++;
                }

            }

            event.getChannel().sendMessage(stringBuilder).queue();
        }

    }
}
