package com.korebit.view;

import com.korebit.service.Login;
import com.korebit.util.Const;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public LoginScreen() {
        createUIComponents();

        setTitle("Inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(Const.getIcon().getImage());

        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {

        Image logoImage = Const.getIcon("img/logo.png")
                .getImage();

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(
                BorderFactory.createEmptyBorder(30, 40, 30, 40)
        );

        loginPanel.setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel lblLogo = new JLabel();

        Image scaledLogo = logoImage.getScaledInstance(
                120,
                120,
                Image.SCALE_SMOOTH
        );

        lblLogo.setIcon(new ImageIcon(scaledLogo));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        loginPanel.add(lblLogo, gbc);

        JLabel lblTitle = new JLabel("Inicio de sesión");

        lblTitle.setFont(
                new Font("Tahoma", Font.BOLD, 24)
        );

        gbc.gridy = 1;

        loginPanel.add(lblTitle, gbc);

        JLabel lblUsername = new JLabel("Nombre de usuario:");

        txtUsername = new JTextField(20);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;

        loginPanel.add(lblUsername, gbc);

        gbc.gridx = 1;

        loginPanel.add(txtUsername, gbc);

        JLabel lblPassword = new JLabel("Contraseña:");

        txtPassword = new JPasswordField(20);

        gbc.gridx = 0;
        gbc.gridy = 3;

        loginPanel.add(lblPassword, gbc);

        gbc.gridx = 1;

        loginPanel.add(txtPassword, gbc);

        JButton btnLogin = new JButton("Iniciar sesión");

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 8, 8, 8);

        loginPanel.add(btnLogin, gbc);

        JButton btnReset = new JButton("Borrar");

        gbc.gridy = 5;
        gbc.insets = new Insets(8, 8, 8, 8);

        loginPanel.add(btnReset, gbc);

        btnReset.addActionListener(e -> {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocusInWindow();
        });

        btnLogin.addActionListener(e -> performLogin());

        setContentPane(loginPanel);
    }

    private void performLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (new Login().startSession(username, password)) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            new MainScreen().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}