package com.korebit.view;

import com.korebit.model.Network;
import com.korebit.util.Const;
import com.korebit.model.NetworkTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DataScreen extends JFrame {

    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;

    public DataScreen(ArrayList<Network> networks) {

        createUIComponents(networks);

        setTitle("Redes Registradas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setIconImage(Const.getIcon(Const.ICON).getImage());

        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void createUIComponents(ArrayList<Network> networks) {

        panel = new JPanel(new BorderLayout(10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        NetworkTableModel model =
                new NetworkTableModel(networks);

        table = new JTable(model);

        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        table.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        table.getTableHeader().setReorderingAllowed(false);

        table.getColumnModel()
                .getColumn(7)
                .setPreferredWidth(60);

        table.getColumnModel()
                .getColumn(8)
                .setPreferredWidth(50);

        scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(panel);
    }
}