package com.korebit.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class DesktopUtils {

    private DesktopUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void openExternalFile(String filePath) throws IOException {

        File file = new File(filePath);//Objects.requireNonNull(DesktopUtils.class.getClassLoader().getResource(filePath)).getPath());

        if (!Desktop.isDesktopSupported()) {
            System.err.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }

    private static Path extractResource(String resource) throws IOException {
        InputStream is = DesktopUtils.class
                .getClassLoader()
                .getResourceAsStream(resource);

        if (is == null) {
            throw new IOException("Resource not found: " + resource);
        }

        String suffix = resource.substring(resource.lastIndexOf('.'));

        Path tempFile = Files.createTempFile("resource_", suffix);

        Files.copy(is, tempFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

        is.close();
        return tempFile;
    }

    public static void openFile(String resourcePath) throws IOException {
        var tempFile = extractResource(resourcePath);

        tempFile.toFile().deleteOnExit();

        if (!Desktop.isDesktopSupported()) {
            throw new UnsupportedOperationException("Desktop not supported");
        }

        Desktop.getDesktop().open(tempFile.toFile());
    }

    public static void launchParrot() {
        String path = OSUtils.isWindows() ? "extra\\p.bat" : "extra/p.sh";
        try {
            executeScript(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeScript(String scriptPath) throws IOException {
        if (OSUtils.isWindows()) {
            new ProcessBuilder("cmd.exe", "/c", scriptPath).start();
        } else if (OSUtils.isUnix() || OSUtils.isLinux() || OSUtils.isMac()) {
            new ProcessBuilder("sh", scriptPath).start();
        }
    }
}