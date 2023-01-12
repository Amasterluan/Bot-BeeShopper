package me.amaster.botbeeshopper.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberLeave extends ListenerAdapter {

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {

        TextChannel textChannel= event.getGuild().getTextChannelById(1063078197249441832L);
        String username = event.getUser().getName();

        textChannel.sendMessage(username + "saiu do servidor!").queue();

    }
}



