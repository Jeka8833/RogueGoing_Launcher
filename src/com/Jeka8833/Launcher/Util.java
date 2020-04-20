package com.Jeka8833.Launcher;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {

    public static final Path defaultPath;
    public static final OS os;
    public static final boolean isX64;

    static {
        final String operSys = System.getProperty("os.name").toLowerCase();
        if (operSys.contains("win")) os = OS.WINDOWS;
        else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) os = OS.LINUX;
        else if (operSys.contains("mac")) os = OS.MAC;
        else if (operSys.contains("sunos")) os = OS.SOLARIS;
        else os = OS.OTHER;
        switch (os) {
            case WINDOWS:
                defaultPath = Paths.get(System.getenv("AppData") + "\\RogueGoing\\");
                break;
            case MAC:
                defaultPath = Paths.get(System.getProperty("user.home") + "/Library/Application Support/RogueGoing/");
                break;
            case LINUX:
                defaultPath = Paths.get(System.getProperty("user.home") + "/.RogueGoing/");
                break;
            default:
                defaultPath = Paths.get(System.getProperty("user.home") + "/RogueGoing/");
        }
        if (os == OS.WINDOWS) isX64 = System.getenv("ProgramFiles(x86)") != null;
        else isX64 = System.getProperty("os.arch").contains("64");
    }

    public enum OS {
        WINDOWS, LINUX, MAC, SOLARIS, OTHER
    }
}