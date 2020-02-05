package com.Jeka8833.Launcher;

import com.Jeka8833.Launcher.GUI.GUI;
import com.Jeka8833.Launcher.config.Config;
import com.Jeka8833.Launcher.parser.FileConst;
import com.Jeka8833.Launcher.parser.HashInfo;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileUpdate {

    private static final Logger log = LogManager.getLogger(FileUpdate.class);

    private static GUI form;

    public static void checkAndRun(final GUI form) {
        FileUpdate.form = form;
        new Thread(() -> {
            form.ProgressBar.setVisible(true);
            form.ProgressBar.setIndeterminate(true);
            form.ProgressBar.setString("Downloading file list");

            final Path path = Paths.get(Config.getGamePath()).resolve("run.json");
            if (WebConnect.internetConnection) {
                try {
                    WebConnect.downloadFile(WebConnect.url, path);
                } catch (IOException e) {
                    log.warn("Connection fail", e);
                }
            }
            if (!Files.isRegularFile(path)) {
                closeBar("File check error");
                return;
            }

            List<HashInfo> hashInfos;
            FileConst run;
            try {
                hashInfos = getFileList(run = new Gson().fromJson(new String(Files.readAllBytes(path)), FileConst.class));
            } catch (IOException | NullPointerException e) {
                closeBar("File parse error");
                return;
            }
            form.ProgressBar.setIndeterminate(false);
            form.ProgressBar.setMaximum(hashInfos.size());
            form.ProgressBar.setValue(0);
            for (HashInfo hashInfo : hashInfos) {
                if (!checkFiles(hashInfo.hash)) {
                    form.ProgressBar.setString("Download: " + hashInfo.url);
                    if (WebConnect.internetConnection) {
                        try {
                            WebConnect.downloadAndExtract(hashInfo.url, Config.getGamePath(), hashInfo.rename);
                        } catch (IOException e) {
                            log.error("Download error", e);
                        }
                    } else {
                        closeBar("No internet connection");
                        return;
                    }
                }
                form.ProgressBar.setValue(form.ProgressBar.getValue() + 1);
            }
            runGame(run);
        }).start();
    }

    @NotNull
    private static List<HashInfo> getFileList(final FileConst file) throws NullPointerException {
        final List<HashInfo> hashInfos = new ArrayList<>();
        switch (Util.getBitness()) {
            case B_64:
                switch (Util.getOS()) {
                    case WINDOWS:
                        hashInfos.addAll(file.windows.x64);
                        break;
                    case LINUX:
                        hashInfos.addAll(file.linux.x64);
                        break;
                    case MAC:
                        hashInfos.addAll(file.macos.x64);
                        break;
                    default:
                        throw new NullPointerException("Unknown OS");
                }
                break;
            case B_32:
                switch (Util.getOS()) {
                    case WINDOWS:
                        hashInfos.addAll(file.windows.x32);
                        break;
                    case LINUX:
                        hashInfos.addAll(file.linux.x32);
                        break;
                    default:
                        throw new NullPointerException("Unknown OS");
                }
                break;
            default:
                throw new NullPointerException("Unknown bitness");
        }
        hashInfos.addAll(file.files);
        for (Language lang : Language.lang)
            if (Config.config.language.equals(lang.name) && !lang.url.isEmpty())
                hashInfos.add(new HashInfo(lang.url, "", lang.hashs));
        return hashInfos;
    }

    private static boolean checkFiles(@NotNull final Map<String, Integer> files) {
        final String path = Config.getGamePath();
        for (Map.Entry<String, Integer> file : files.entrySet()) {
            final Path filePath = Paths.get(path + file.getKey());
            form.ProgressBar.setString("Check file: " + file.getKey());
            if (file.getKey().endsWith("\\")) {
                if (!Files.isDirectory(filePath) || Hash.getHashFolder(filePath) != file.getValue()) {
                    log.info("Folder " + filePath.toString() + " deleted");
                    try {
                        if (Files.exists(filePath))
                            Files.walk(filePath)
                                    .sorted(Comparator.reverseOrder())
                                    .map(Path::toFile)
                                    .forEach(File::delete);
                    } catch (IOException e) {
                        log.warn("File delete error", e);
                    }
                    return false;
                }
            } else if (!Files.isRegularFile(filePath) || Hash.getHashFile(filePath) != file.getValue())
                return false;
        }
        return true;
    }

    private static void runGame(final FileConst run) {
        form.ProgressBar.setString("Run game");
        try {
            String command = "";
            switch (Util.getOS()) {
                case WINDOWS:
                    command = run.windowsRun.replace("%java%", Config.getJavaPath())
                            .replace("%option%", Config.config.JVMOp).replace("%path%", Config.getGamePath())
                            .replace("%user%", Config.config.userName);
                    break;
                case MAC:
                    command = run.macosRun.replace("%java%", Config.getJavaPath())
                            .replace("%option%", Config.config.JVMOp).replace("%path%", Config.getGamePath())
                            .replace("%user%", Config.config.userName);
                    break;
                case LINUX:
                    command = run.linuxRun.replace("%java%", Config.getJavaPath())
                            .replace("%option%", Config.config.JVMOp).replace("%path%", Config.getGamePath())
                            .replace("%user%", Config.config.userName);
                    break;
                default:
                    throw new NullPointerException("Unknown OS");
            }
            log.debug(command);
            Runtime.getRuntime().exec(command);
            System.exit(0);
        } catch (IOException | NullPointerException e) {
            closeBar("Fail run game");
        }
    }

    private static void closeBar(final String text) {
        form.ProgressBar.setIndeterminate(false);
        form.ProgressBar.setString(text);
        form.ProgressBar.setValue(0);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("Thread sleep error", e);
        }
        form.ProgressBar.setVisible(false);
    }
}