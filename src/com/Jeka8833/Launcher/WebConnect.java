package com.Jeka8833.Launcher;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class WebConnect {
    public static final String version = "https://github.com/Jeka8833/RogueGoing_File_Server/releases/download/Launcher/version.txt";
    public static final String url = "https://github.com/Jeka8833/RogueGoing_File_Server/releases/download/Main/hash.json";


    public static boolean downloadFile(final Path path, final String url) {
        try {
            new FileOutputStream(path.toString()).getChannel().transferFrom(Channels.newChannel(new URL(url).openStream()), 0, Long.MAX_VALUE);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static void downloadAndExtract(final String url, final String path) {
        try {
            File destDir = new File(path);
            if (!destDir.exists()) {
                destDir.mkdir();
            }

            try (ZipInputStream zipIn = new ZipInputStream(new URL(url).openConnection().getInputStream())) {
                ZipEntry entry = zipIn.getNextEntry();
                while (entry != null) {
                    String filePath = path + File.separator + entry.getName();
                    if (!entry.isDirectory()) {
                        extractFile(zipIn, filePath);
                    } else {
                        File dir = new File(filePath);
                        dir.mkdir();
                    }
                    zipIn.closeEntry();
                    entry = zipIn.getNextEntry();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(WebConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }
}