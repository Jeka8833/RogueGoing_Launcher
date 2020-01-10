package com.Jeka8833.Launcher;

import java.io.*;
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

    public static String getString(final String url) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            String line;
            final StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        }
    }

    public static void downloadFile(final String url, final Path path) throws IOException {
        new FileOutputStream(path.toString()).getChannel().transferFrom(Channels.newChannel(new URL(url).openStream()),
                0, Long.MAX_VALUE);
    }

    public static void downloadAndExtract(final String url, final String path) throws IOException {
        final File destDir = new File(path);
        if (!destDir.exists())
            destDir.mkdir();
        try (ZipInputStream zipIn = new ZipInputStream(new URL(url).openConnection().getInputStream())) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                final String filePath = path + File.separator + entry.getName();
                if (!entry.isDirectory())
                    extractFile(zipIn, filePath);
                else new File(filePath).mkdir();
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            final byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }
}