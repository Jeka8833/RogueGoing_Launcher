package com.Jeka8833.Launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        try {
            final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            final List<Path> paths = Files.walk(folder).filter(Files::isRegularFile).collect(Collectors.toList());
            Collections.sort(paths);
            for (Path path : paths) {
                stream.write(Files.readAllBytes(path));
            }
            return getCheckSum(stream.toByteArray());
        } catch (IOException ex) {
            log.error("Fail generate hash from folder", ex);
        }
        return 0;
    }

    @Contract(pure = true)
    public static int getCheckSum(@NotNull final byte[] arr) {
        int a = 0;
        int b = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            a += arr[i];
            b += a;
        }
        return (b << 16) | (a & 0xffff);
    }
}