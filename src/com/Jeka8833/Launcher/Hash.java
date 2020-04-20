package com.Jeka8833.Launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class Hash {

    private static final Logger log = LogManager.getLogger(Hash.class);

    public static int getHashFile(final Path file) {
        try {
            return getCheckSum(Files.readAllBytes(file));
        } catch (IOException ex) {
            log.error("Fail generate hash from file", ex);
        }
        return 0;
    }

    public static int getHashFolder(final Path folder) {
        int out = 0;
        try {
            final Iterator<Path> it = Files.walk(folder).filter(Files::isRegularFile).sorted().iterator();
            while (it.hasNext())
                out ^= getCheckSum(Files.readAllBytes(it.next()));
        } catch (IOException ex) {
            log.error("Fail generate hash from folder", ex);
        }
        return out;
    }

    public static int getCheckSum(final byte[] arr) {
        int a = 0;
        int b = 0;
        for (byte value : arr)
            b += (a += value);
        return (b << 16) | (a & 0xffff);
    }
}