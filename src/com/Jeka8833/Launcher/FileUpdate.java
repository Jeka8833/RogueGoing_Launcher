package com.Jeka8833.Launcher;

import com.Jeka8833.Launcher.GUI.GUI;
import com.Jeka8833.Launcher.config.Config;
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
        final boolean isInternet = WebConnect.downloadFile(path.resolve("run.json"), WebConnect.url);
    }
    
    public Thread start(){
        final Thread th = new Thread(this);
        th.start();
        return th;
    }
}
