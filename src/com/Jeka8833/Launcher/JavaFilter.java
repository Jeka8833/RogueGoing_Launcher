package com.Jeka8833.Launcher;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class JavaFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            final String format = s.substring(i).toLowerCase();
            switch (Util.getOS()) {
                case WINDOWS:
                    return format.equals(".exe");
                case LINUX:
                case MAC:
                    return format.equals("");
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        if (Util.getOS() == Util.OS.WINDOWS) {
            return "Exe file(.exe)";
        }
        return "Java file";
    }
}
