package com.korebit.util;

public final class OSUtils {
    private OSUtils() {
    }

    public static boolean isWindows() {
        return System.getProperty("os.name")
                .toLowerCase()
                .contains("win");
    }

    public static boolean isMac() {
        return System.getProperty("os.name")
                .toLowerCase()
                .contains("mac");
    }

    public static boolean isUnix() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("nix") || os.contains("nux") || os.contains("aix");
    }

    public static boolean isLinux() {
        return System.getProperty("os.name")
                .toLowerCase()
                .contains("linux");
    }
}
