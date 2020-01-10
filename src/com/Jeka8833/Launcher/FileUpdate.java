package com.Jeka8833.Launcher;

import com.Jeka8833.Launcher.GUI.GUI;
import com.Jeka8833.Launcher.config.Config;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpdate implements Runnable{

    private final GUI form;
    
    public FileUpdate(GUI form){
        this.form = form;
    }
    
    @Override
    public void run() {
        final Path path = Paths.get(Config.config.gamePath);
        try {
            WebConnect.downloadFile(WebConnect.url, path.resolve("run.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Thread start(){
        final Thread th = new Thread(this);
        th.start();
        return th;
    }
}
