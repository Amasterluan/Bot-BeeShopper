package me.amaster.botbeeshopper.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CRUD {

    public static void createTable() throws SQLException{

        String sql = """
                create table tb_guild
                (
                    id integer not null primary key autoincrement unique,
                    guild_id text not null unique
                )""";

        PreparedStatement statement = ConnectionFactory.getConn().prepareStatement(sql);
        statement.execute();
        statement.close();
        ConnectionFactory.getConn().close();
    }

    public static void select(String guildId) throws SQLException {

        String sql = """
              select *from tb_guild where guild_id = ?
              """;

        PreparedStatement statement = ConnectionFactory.getConn().prepareStatement(sql);
        statement.setString(1, guildId);
        statement.execute();
        statement.close();
        ConnectionFactory.getConn().close();

    }



    public static void insert(String guildId) throws SQLException{

        String sql = """
              INSERT OR IGNORE INTO tb_guild values (null, ?)
              """;

        PreparedStatement statement = ConnectionFactory.getConn().prepareStatement(sql);
        statement.setString(1, guildId);

        statement.execute();
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        while (resultSet.next()){
//            BeeShopper.prefixMap.put(guildId, resultSet.getString("prefix").c);
//        }

        statement.close();
        ConnectionFactory.getConn().close();

    }




}
