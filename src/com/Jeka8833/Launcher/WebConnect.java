package com.Jeka8833.Launcher;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebConnect {

    private static final Logger log = LogManager.getLogger(WebConnect.class);

    public static boolean internetConnection = true;

    public static final String version = "https://github.com/Jeka8833/RogueGoing_File_Server/releases/download/Launcher/version.txt";
    public static final String url = "https://github.com/Jeka8833/RogueGoing_File_Server/releases/download/Main/run.json";
    public static final String language = "https://github.com/Jeka8833/RogueGoing_File_Server/releases/download/Language/list.json";

    @NotNull
    public static String getString(final String url) throws IOException {
        log.info("Read site: " + url);
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

    public static void downloadFile(final String url, @NotNull final Path path) throws IOException {
        log.info("Download from site: " + url);
        new FileOutputStream(path.toString()).getChannel().transferFrom(Channels.newChannel(new URL(url).openStream()),
                0, Long.MAX_VALUE);
    }

    public static void downloadAndExtract(final String url, final String path) throws IOException {
        log.info("Extract form site: " + url);
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

    private static void extractFile(@NotNull ZipInputStream zipIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            final byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }
}