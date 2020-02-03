package com.Jeka8833.Launcher;

import com.Jeka8833.Launcher.config.Config;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.NotNull;

public class Language implements Comparable<Language> {

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Language.class);

    public static final List<Language> lang = new ArrayList<>();

    public transient boolean downloaded;

    public final String name;
    public final String select;
    public final String selected;
    public final String url;
    public final Map<String, String> hashs;

    public Language(final String name, final String select, final String selected, final boolean downloaded) {
        url = "";
        hashs = new HashMap<>();
        this.name = name;
        this.select = select;
        this.selected = selected;
        this.downloaded = downloaded;
    }

    @Override
    public int compareTo(@NotNull Language o) {
        return name.compareTo(o.name);
    }

    public static void getLanguages() {
        try {
            for (Path path : Files.list(Paths.get(Config.getGamePath() + File.separator + "lang"))
                    .filter(Files::isRegularFile).collect(Collectors.toList())) {
                try {
                    String name = "";
                    String select = "";
                    String selected = "";
                    for (String line : Files.readAllLines(path)) {
                        final String[] args = line.split(": ");
                        switch (args[0]) {
                            case "name":
                                name = args[1];
                                break;
                            case "select":
                                select = args[1];
                                break;
                            case "selected":
                                selected = args[1];
                        }
                        if (!name.isEmpty() && !select.isEmpty() && !selected.isEmpty()) {
                            break;
                        }
                    }
                    if (isElement(name)) {
                        continue;
                    }
                    lang.add(new Language(name, select, selected, true));
                } catch (IOException ex) {
                    log.error("Fail open file", ex);
                }
            }
        } catch (IOException ex) {
            log.warn("Path error", ex);
        }
    }

    public static void init() {
        try {
            Collections.addAll(lang, new Gson().fromJson(WebConnect.getString(WebConnect.language), Language[].class));
        } catch (Exception ex) {
            WebConnect.internetConnection = false;
            log.warn("Parse fail", ex);
        }
        getLanguages();
        Collections.sort(lang);
    }

    private static boolean isElement(final String name) {
        for (Language lan : lang) {
            if (lan.name.equals(name)) {
                lan.downloaded = true;
                return true;
            }
        }
        return false;
    }
}