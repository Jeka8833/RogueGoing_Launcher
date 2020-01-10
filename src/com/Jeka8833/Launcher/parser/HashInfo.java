package com.Jeka8833.Launcher.parser;

import java.util.Map;

public class HashInfo {
    
    public String url;
    public Map<String, String> hash;
    
    public HashInfo(String url, Map<String, String> hash){
        this.url = url;
        this.hash = hash;
    }    
}
