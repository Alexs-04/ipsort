package com.korebit.view;

import com.korebit.model.Data;
import com.korebit.util.Const;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainScreen extends JFrame {

    private JPanel panel;

    private JButton btnNetworks;
    private JButton btnSorts;
    private JButton btnSearch;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnSpecialMenu;

    public MainScreen() {
        createUIComponents();

        setTitle("Menú principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(Const.getIcon(Const.ICON).getImage());

        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {

        panel = new JPanel(new BorderLayout());

        panel.setBorder(
                new EmptyBorder(30, 50, 30, 50)
        );

        JLabel lblTitle = new JLabel(
                "Menú principal",
                SwingConstants.CENTER
        );

        lblTitle.setFont(
                new Font("Tahoma", Font.BOLD, 24)
        );

        panel.add(lblTitle, BorderLayout.NORTH);

        JPanel appsPanel = new JPanel(
                new GridLayout(2, 3, 25, 25)
        );

        appsPanel.setBorder(
                new EmptyBorder(30, 40, 30, 40)
        );

        btnNetworks = createMenuButton(
                "Redes Registradas",
                Const.DATA_ICON
        );

        btnNetworks.addActionListener(e -> {
            DataScreen dataScreen = new DataScreen(Data.getNetworks());
            dataScreen.setVisible(true);
        });

        btnSorts = createMenuButton(
                "Ordenamientos",
                Const.SORT_ICON
        );

        btnSearch = createMenuButton(
                "Búsquedas",
                Const.SEARCH_ICON
        );

        btnAdd = createMenuButton(
                "Agregar",
                Const.ADD_ICON
        );

        btnDelete = createMenuButton(
                "Eliminar",
                Const.DELETE_ICON
        );

        btnSpecialMenu = createMenuButton(
                "Menú especial",
                Const.SPECIAL_MENU_ICON
        );

        appsPanel.add(btnNetworks);
        appsPanel.add(btnSorts);
        appsPanel.add(btnSearch);
        appsPanel.add(btnAdd);
        appsPanel.add(btnDelete);
        appsPanel.add(btnSpecialMenu);

        panel.add(appsPanel, BorderLayout.CENTER);

        setContentPane(panel);
    }

    private JButton createMenuButton(
            String text,
            String imagePath
    ) {
        JButton button = new JButton(text);

        button.setIcon(Const.getIcon(imagePath));

        button.setHorizontalTextPosition(
                SwingConstants.CENTER
        );

        button.setVerticalTextPosition(
                SwingConstants.BOTTOM
        );

        button.setFont(
                new Font("Tahoma", Font.PLAIN, 14)
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 220, 220)
                        ),
                        new EmptyBorder(15, 15, 15, 15)
                )
        );

        button.setBackground(Color.WHITE);
        button.setOpaque(true);

        return button;
    }
}