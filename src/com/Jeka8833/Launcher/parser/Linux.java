package com.Jeka8833.Launcher.parser;

import java.util.List;

public class Linux {

    public List<HashInfo> x32;
    public List<HashInfo> x64;

    public Linux(List<HashInfo> x32, List<HashInfo> x64) {
        this.x32 = x32;
        this.x64 = x64;
    }
}
