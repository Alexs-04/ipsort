package com.korebit.view;

import com.korebit.util.Const;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {

    private JPanel contentPane;
    private Image logoImage;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JButton btnLogin;
    private JButton btnReset;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    public LoginScreen() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Inicio de sesión");
        this.setBounds(100, 100, 800, 600);
        this.setIconImage(Const.getIcon().getImage());
        createUIComponents();
        this.setContentPane(contentPane);
    }

    private void createUIComponents() {
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        btnLogin = new JButton("Login");
        btnReset = new JButton("Reset");
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        contentPane = new JPanel();
        contentPane.add(lblUsername);
        contentPane.add(txtUsername);
        contentPane.add(lblPassword);
        contentPane.add(txtPassword);
        contentPane.add(btnLogin);
        contentPane.add(btnReset);
        contentPane.setBounds(0, 0, 800, 600);
    }
}
