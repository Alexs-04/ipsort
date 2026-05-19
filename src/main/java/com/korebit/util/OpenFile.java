package com.korebit.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class OpenFile {
    public void openExternal(String filePath) throws IOException {

        File file = new File(Objects.requireNonNull(OpenFile.class.getClassLoader().getResource(filePath)).getPath());

        if (!Desktop.isDesktopSupported()) {
            System.err.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }

    public void parrotLive() {
        String path = OSUtils.isWindows() ? "extra\\p.bat" : "extra/p.sh";
        try {
            executeScript(path);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void executeScript(String scriptPath) throws IOException {
        if (OSUtils.isWindows()) {
            new ProcessBuilder("cmd.exe", "/c", scriptPath).start();
        } else if (OSUtils.isUnix() || OSUtils.isLinux() || OSUtils.isMac()) {
            new ProcessBuilder("sh", scriptPath).start();
        }
    }
}