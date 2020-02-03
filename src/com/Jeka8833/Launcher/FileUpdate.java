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

public class FileUpdate implements Runnable {

    private static final Logger log = LogManager.getLogger(FileUpdate.class);

    private final GUI form;

    public FileUpdate(GUI form) {
        this.form = form;
    }

    @Override
    public void run() {
        form.ProgressBar.setVisible(true);
        form.ProgressBar.setIndeterminate(true);
        form.ProgressBar.setString("Downloading file list");
        final Path path = Paths.get(Config.getGamePath()).resolve("run.json");
        try {
            WebConnect.downloadFile(WebConnect.url, path);
        } catch (IOException e) {
            log.warn("Connection fail", e);
        }
        if (!Files.isRegularFile(path)) {
            log.error("Hash file not found");
            form.ProgressBar.setString("File check error");
            form.ProgressBar.setIndeterminate(false);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            form.ProgressBar.setVisible(false);
            return;
        }
        FileConst run = null;
        try {
            run = new Gson().fromJson(new String(Files.readAllBytes(path)), FileConst.class);
        } catch (IOException e) {
            log.error("File parse error", e);
        }
        final List<HashInfo> hashInfos = getFileList(run);
        form.ProgressBar.setMaximum(hashInfos.size());
        for (HashInfo hashInfo : hashInfos)
            if (!checkFiles(hashInfo.hash)) {
                form.ProgressBar.setString("Download: " + hashInfo.url);
                try {
                    WebConnect.downloadAndExtract(hashInfo.url, Config.getGamePath());
                } catch (IOException e) {
                    log.error("Download error", e);
                }
            }
        form.ProgressBar.setValue(form.ProgressBar.getValue() + 1);
        form.ProgressBar.setString("Run game");
        try {
            rumGame(Util.getOS(), run);
            System.exit(0);
        } catch (IOException e) {
            log.error("Fail run game", e);
            form.ProgressBar.setString("Fail run game");
        }
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
                hashInfos.add(new HashInfo(lang.url, lang.hashs));
        return hashInfos;
    }

    private boolean checkFiles(@NotNull final Map<String, String> files) {
        final String path = Config.getGamePath();
        for (Map.Entry<String, String> file : files.entrySet()) {
            final Path filePath = Paths.get(path + file.getKey());
            form.ProgressBar.setString("Check file: " + file.getKey());
            if (file.getKey().endsWith("\\")) {
                if (!Files.isDirectory(filePath) || !Objects.requireNonNull(Hash.getHashFolder(filePath)).equals(file.getValue())) {
                    log.info("Folder " + filePath.toString() + " deleted");
                    try {
                        Files.walk(filePath)
                                .sorted(Comparator.reverseOrder())
                                .map(Path::toFile)
                                .forEach(File::delete);
                    } catch (IOException e) {
                        log.error("File delete error", e);
                    }
                    return false;
                }
            } else if (!Files.isRegularFile(filePath) || !Objects.equals(Hash.getHashFile(filePath), file.getValue()))
                return false;
        }
        return true;
    }

    private static void rumGame(@NotNull Util.OS os, FileConst run) throws IOException, NullPointerException {
        switch (os) {
            case WINDOWS:
                final String javaw = Config.config.javaPath.isEmpty() ? Config.getGamePath() + "\\jre\\bin\\javaw.exe" : Config.config.javaPath;
                Runtime.getRuntime().exec(run.windowsRun.replace("%java%", javaw)
                        .replace("%option%", Config.config.JVMOp).replace("%path%", Config.getGamePath())
                        .replace("%user%", Config.config.userName).split(" "));
                break;
            case LINUX:
            case MAC:
                final String java = Config.config.javaPath.isEmpty() ? Config.getGamePath() + "/jre/bin/java" : Config.config.javaPath;
                Runtime.getRuntime().exec(run.linuxRun.replace("%java%", java)
                        .replace("%option%", Config.config.JVMOp).replace("%path%", Config.getGamePath())
                        .replace("%user%", Config.config.userName).split(" "));
                break;
            default:
                throw new NullPointerException("Unknown Os");
        }
    }

    public Thread start() {
        final Thread th = new Thread(this);
        th.start();
        return th;
    }
}
