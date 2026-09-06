package com.korebit.view;

import com.korebit.util.Const;

import javax.swing.*;

public class SearchScreen extends JDialog {

    public SearchScreen(JFrame parent) {
        super(
                parent,
                "Algoritmos de ordenamiento",
                true
        );

        createUIComponents();

        setDefaultCloseOperation(
                DISPOSE_ON_CLOSE
        );

        setResizable(false);
        setIconImage(
                Const.getIcon(Const.ICON).getImage()
        );

        setSize(400, 600);
        setLocationRelativeTo(parent);
    }

    private void createUIComponents() {

    }
}
