package com.Jeka8833.Launcher.config;

import com.Jeka8833.Launcher.Util;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    public static Data config = new Data();

    private static final Gson json = new Gson();
    private static final Path path = Util.defaultPath.resolve("launcher.json");

    public static void writeConfig() {
        try {
            checkNull();
            Files.write(path, json.toJson(config).getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readConfig() {
        try {
            config = json.fromJson(new String(Files.readAllBytes(path)), Data.class);
            checkNull();
        } catch (IOException ex) {
            writeConfig();
        }
    }

    public static String getGamePath() {
        return config.gamePath.isEmpty() ? Util.defaultPath.toString() : config.gamePath;
    }

    public static String getJavaPath() {
        if (Util.os == Util.OS.WINDOWS)
            return config.javaPath.isEmpty() ? getGamePath() + "\\jre\\bin\\javaw.exe" : config.javaPath;
        return config.javaPath.isEmpty() ? getGamePath() + "/jre/bin/java" : config.javaPath;
    }

    private static void checkNull() {
        final Data data = new Data();
        if (config.language.isEmpty())
            config.language = data.language;
        if (config.userName.isEmpty())
            config.userName = data.userName;
    }
}