package com.korebit.view;

import com.korebit.model.Network;

import javax.swing.*;

public class ShowScreen extends JFrame {

    private Network network;

    public ShowScreen(Network network) {
        this.network = network;
        initComponents();
    }

    public void initComponents() {
        setTitle("Detalles de la red");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblName = new JLabel("Nombre: " + network.getName());
        JLabel lblIdentifier = new JLabel("Identificador: " + network.getIdentifier());

        JPanel panel = new JPanel();
        panel.add(lblName);
        panel.add(lblIdentifier);

        add(panel);
    }
}
