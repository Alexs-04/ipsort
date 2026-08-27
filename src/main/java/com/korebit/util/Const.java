package com.korebit.util;

import javax.swing.ImageIcon;
import java.util.Objects;
import java.util.Random;

public final class Const {

    public static final Random RANDOM = new Random();
    public static final String ICON = "img/icon.png";
    public static final String LOGO = "img/logo.png";
    public static final String ADD_ICON = "img/add.png";
    public static final String DELETE_ICON = "img/delete.png";
    public static final String SEARCH_ICON = "img/search.png";
    public static final String SORT_ICON = "img/sort.png";
    public static final String DATA_ICON = "img/dir.png";
    public static final String SPECIAL_MENU_ICON = "img/special_menu.png";
    public static final String NAME_APP = "img/name.png";

    private Const() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static ImageIcon getIcon(String path) {
        return new ImageIcon(Objects.requireNonNull(
                Objects.requireNonNull(
                        Const.class.getClassLoader().getResource(path)).getPath()));
    }

    public static int getRandomInt(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
