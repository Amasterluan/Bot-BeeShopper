package me.amaster.botbeeshopper.main;

import me.amaster.botbeeshopper.Token;
import me.amaster.botbeeshopper.commands.CommandAdmin;
import me.amaster.botbeeshopper.commands.CommandManager;
import me.amaster.botbeeshopper.commands.Prefix;
import me.amaster.botbeeshopper.commands.Roles;
import me.amaster.botbeeshopper.database.CRUD;
import me.amaster.botbeeshopper.database.Config;
import me.amaster.botbeeshopper.events.MemberJoin;
import me.amaster.botbeeshopper.events.MemberLeave;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class BeeShopper {

    public static JDA jda;
    public static Map<String, Character> prefixMap = new HashMap<>();
    public static Map<Long, Long> joinChannelMap = new HashMap<>();
    public static Map<Long, Long> leaveChannelMap = new HashMap<>();

    public static void main(String[] args) throws LoginException, InterruptedException, SQLException, IOException {

        Config.createFilesAndTable();

        Token token = new Token();

        jda = JDABuilder.create(token.setToken(),
                EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(
                new MemberJoin(),
                new MemberLeave(),
                new Prefix(),
                new CommandManager(),
                new CommandAdmin(),
                new Roles()
        );

        for (Guild guild: jda.awaitReady().getGuilds()) {
            prefixMap.put(guild.getId(), '!');
            joinChannelMap.put(guild.getIdLong(), null);
            leaveChannelMap.put(guild.getIdLong(), null);
            CRUD.select(guild.getId());

        }

        for (Guild guild: jda.awaitReady().getGuilds()) {
            CRUD.insert(guild.getId());
        }

        jda.getPresence().setActivity(Activity.playing("Amores para minha namorada!"));

    }

}
