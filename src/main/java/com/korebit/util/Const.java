package com.korebit.util;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public final class Const {

    public static final Random RANDOM = new Random();

    private Const() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static ImageIcon getIcon() {
        return new ImageIcon(Objects.requireNonNull(
                Objects.requireNonNull(
                        Const.class.getClassLoader().getResource("img/icon.png")).getPath()));
    }

    public static ImageIcon getIcon(String path) {
        return new ImageIcon(Objects.requireNonNull(
                Objects.requireNonNull(
                        Const.class.getClassLoader().getResource(path)).getPath()));
    }
}
