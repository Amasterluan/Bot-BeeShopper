package me.amaster.botbeeshopper.main;

import gnu.trove.map.hash.THashMap;
import me.amaster.botbeeshopper.commands.Ping;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;
import java.util.Map;

public class BeeShopper {

    public static JDA jda;
    public static Map<Long, String> mapNameGuild = new THashMap<>();

    public static void main(String[] args) throws LoginException, InterruptedException {

        jda = JDABuilder.create("MTA2Mjg4ODUyNzQ1ODc0MjMwMw.GfdFDh.2AvXmVsLcuh9A9wBS38t05H7B2zDo7QuH9BhMQ",
                EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new Ping());


        for (Guild guild: jda.awaitReady().getGuilds()) {
            mapNameGuild.put(guild.getIdLong(), guild.getName());

            System.out.println(mapNameGuild.get(guild.getIdLong()));

        }

    }

}
