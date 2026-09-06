package com.korebit.view;

import com.korebit.util.Const;

import javax.swing.*;

public class AddScreen extends JDialog {
    private void createUIComponents() {
        JLabel lblTitle = new JLabel(
                "Agregar red",
                SwingConstants.CENTER
        );

        JLabel lblName = new JLabel(
                "Nombre de la red:",
                SwingConstants.LEFT
        );

        JLabel lblIdentifier = new JLabel(
                "Identificador de la red:",
                SwingConstants.LEFT
        );



        JPanel panel = new JPanel();
        add(panel);
    }

    public AddScreen(JFrame parent) {
        super(
                parent,
                "Agregar red",
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
}
