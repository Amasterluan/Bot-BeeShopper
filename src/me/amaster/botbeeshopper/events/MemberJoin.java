package me.amaster.botbeeshopper.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoin extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        TextChannel textChannel= event.getGuild().getTextChannelById(1063078197249441832L);
        String username = event.getUser().getName();

        textChannel.sendMessage(username + "entrou no Servidor!").queue();

    }
}


