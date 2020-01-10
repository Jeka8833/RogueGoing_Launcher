package com.Jeka8833.Launcher;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {

    public enum OS {
        WINDOWS, LINUX, MAC, SOLARIS, OTHER
    };

    public enum BIT {
        B_64, B_32, OTHER
    };

    public static OS getOS() {
        final String operSys = System.getProperty("os.name").toLowerCase();
        if (operSys.contains("win")) {
            return OS.WINDOWS;
        } else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {
            return OS.LINUX;
        } else if (operSys.contains("mac")) {
            return OS.MAC;
        } else if (operSys.contains("sunos")) {
            return OS.SOLARIS;
        }
        return OS.OTHER;
    }

    public static BIT getBitness() {
        switch (System.getProperty("sun.arch.data.model")) {
            case "64":
                return BIT.B_64;
            case "32":
                return BIT.B_32;
            default:
                return BIT.OTHER;
        }
    }

    public static Path defaultPath() {
        switch (getOS()) {
            case WINDOWS:
                return Paths.get(System.getenv("AppData") + "\\RogueGoing\\");
            case MAC:
                return Paths.get(System.getProperty("user.home") + "/Library/Application Support/RogueGoing/");
            case LINUX:
                return Paths.get(System.getProperty("user.home") + "/.RogueGoing/");
            default:
                return Paths.get(System.getProperty("user.home") + "/RogueGoing/");
        }
    }
}
