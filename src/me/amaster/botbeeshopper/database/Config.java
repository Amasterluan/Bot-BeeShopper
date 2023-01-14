package me.amaster.botbeeshopper.database;

import me.amaster.botbeeshopper.main.BeeShopper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

public class Config {

    public static final File parentJarLocation = new File(
            BeeShopper.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();

    public static File databaseFile = new File ("C:/Users/Luan/Documents/Project Bot/BeeShopper/lib/beeshopper.db");

    public static void createFilesAndTable() throws IOException, SQLException{

        if(Files.notExists(databaseFile.toPath())){
            Files.createFile(databaseFile.toPath());
            CRUD.createTable();
        }

    }
}
