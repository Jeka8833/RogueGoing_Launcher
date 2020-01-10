package com.Jeka8833.Launcher.parser;

import java.util.List;

public class Windows {
    
    public List<HashInfo> x32;
    public List<HashInfo> x64;
    
    public Windows(List<HashInfo> x32, List<HashInfo> x64){
        this.x32 = x32;
        this.x64 = x64;
    }
}