package me.amaster.botbeeshopper;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class BeeShopper {

    public static void main(String[] args) throws LoginException {

        JDA jda = JDABuilder.create(EnumSet.allOf(GatewayIntent.class)).build();

    }

}
