package com.korebit.view;

import com.korebit.util.Const;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchScreen extends JDialog {

    private JLabel lblCurrentSearch;

    private JButton btnSearchByName;
    private JButton btnSearchByID;

    public SearchScreen(JFrame parent) {

        super(
                parent,
                "Algoritmos de búsqueda",
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

        setSize(400, 400);
        setLocationRelativeTo(parent);
    }

    private void createUIComponents() {


        JPanel contentPane = new JPanel(
                new BorderLayout(15, 15)
        );

        contentPane.setBorder(
                new EmptyBorder(
                        30,
                        35,
                        30,
                        35
                )
        );

        JPanel headerPanel = new JPanel(
                new GridLayout(2, 1, 0, 8)
        );

        JLabel lblTitle = new JLabel(
                "Buscador de redes",
                SwingConstants.CENTER
        );

        lblTitle.setFont(
                new Font(
                        "Tahoma",
                        Font.BOLD,
                        20
                )
        );

        lblCurrentSearch = new JLabel(
                "Búsqueda actual: Ninguna",
                SwingConstants.CENTER
        );

        headerPanel.add(lblTitle);
        headerPanel.add(lblCurrentSearch);

        contentPane.add(
                headerPanel,
                BorderLayout.NORTH
        );

        JPanel searchPanel = new JPanel(
                new GridLayout(
                        5,
                        1,
                        0,
                        12
                )
        );

        btnSearchByName = createSearchButton(
                "Buscar por nombre"
        );

        btnSearchByName.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(
                    this,
                    "Ingrese el nombre de la red:",
                    "Buscar por nombre",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (name != null && !name.trim().isEmpty()) {
                lblCurrentSearch.setText(
                        "Búsqueda actual: Nombre = " + name.trim()
                );
            } else {
                lblCurrentSearch.setText(
                        "Búsqueda actual: Ninguna"
                );
            }
        });

        btnSearchByID = createSearchButton(
                "Buscar por ID"
        );

        searchPanel.add(btnSearchByName);
        searchPanel.add(btnSearchByID);

        contentPane.add(
                searchPanel,
                BorderLayout.CENTER
        );

        setContentPane(contentPane);
    }

    private JButton createSearchButton(String text) {

        JButton button = new JButton(text);

        button.setFont(
                new Font(
                        "Tahoma",
                        Font.PLAIN,
                        14
                )
        );

        button.setFocusPainted(false);

        return button;
    }
}