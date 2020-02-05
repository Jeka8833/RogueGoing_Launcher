package com.Jeka8833.Launcher.parser;

import java.util.Map;

public class HashInfo {
    
    public final String url;
    public final String rename;
    public final Map<String, Integer> hash;

    public HashInfo(final String url, String rename, final Map<String, Integer> hash){
        this.url = url;
        this.rename = rename;
        this.hash = hash;
    }
}
