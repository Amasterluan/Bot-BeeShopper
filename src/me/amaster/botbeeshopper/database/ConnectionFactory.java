package me.amaster.botbeeshopper.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConn(){
        String url = "jdbc:sqlite:C:/Users/Luan/Documents/Project Bot/BeeShopper/lib/beeshopper.db";

        try{
            return DriverManager.getConnection(url);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }


}
