package com.Jeka8833.Launcher;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

public class Hash {

     private static final Logger log = LogManager.getLogger(Hash.class);
    
    @Nullable
    public static String getHashFile(final Path file) {
        try {
            return getHash(Files.readAllBytes(file));
        } catch (IOException ex) {
            log.error("Fail generate hash from file", ex);
        }
        return null;
    }

    @Nullable
    public static String getHashFolder(final Path folder) {
        try {
            final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            for(Path file : Files.walk(folder).filter(Files::isRegularFile).sorted().collect(Collectors.toList())){
                stream.write(Files.readAllBytes(file));
            }
            return getHash(stream.toByteArray());
        } catch (IOException ex) {
            log.error("Fail generate hash from folder", ex);
        }
        return null;
    }

    @Nullable
    public static String getHash(final byte[] bytes){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            StringBuilder md5Hex = new StringBuilder(new BigInteger(1, messageDigest.digest()).toString(16));
            while (md5Hex.length() < 32) {
                md5Hex.insert(0, "0");
            }
            return md5Hex.toString();
        } catch (NoSuchAlgorithmException ex) {
            log.error("Fail generate hash", ex);
        }
        return null;
    }
}