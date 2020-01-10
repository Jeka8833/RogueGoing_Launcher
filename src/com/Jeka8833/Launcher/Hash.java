package com.Jeka8833.Launcher;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;

public class Hash {

    public static String getHashFile(final Path file) {
        try {
            return getHash(Files.readAllBytes(file));
        } catch (IOException ex) {
            return null;
        }
    }

    public static String getHashFolder(final Path folder) {
        try {
            final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            for(Path file : Files.walk(folder).filter(Files::isRegularFile).sorted().collect(Collectors.toList())){
                stream.write(Files.readAllBytes(file));
            }
            return getHash(stream.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }

    private static String getHash(final byte[] bytes){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            String md5Hex = new BigInteger(1, messageDigest.digest()).toString(16);
            while (md5Hex.length() < 32) {
                md5Hex = "0" + md5Hex;
            }
            return md5Hex;
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
}