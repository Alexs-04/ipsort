package com.korebit.view;

import com.korebit.util.Const;

import javax.swing.*;

public class MainScreen extends JFrame {

    private JPanel panel;
    private JButton btnNetworks;
    private JButton btnSorts;
    private JButton btnSearch;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnSpecialMenu;

    public MainScreen() {
        setTitle("Menú principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(Const.getIcon().getImage());

        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        btnNetworks = new JButton("Redes");
        btnSorts = new JButton("Ordenamientos");
        btnSearch = new JButton("Búsqueda");
        btnAdd = new JButton("Agregar");
        btnDelete = new JButton("Eliminar");
        btnSpecialMenu = new JButton("Menú Especial");
    }
}
