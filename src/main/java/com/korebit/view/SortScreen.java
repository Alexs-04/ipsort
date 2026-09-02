package com.korebit.view;

import com.korebit.dto.SortResult;
import com.korebit.model.Network;
import com.korebit.util.AlphaUtils;
import com.korebit.util.Const;
import com.korebit.util.SortUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Comparator;

public class SortScreen extends JDialog {

    private static JLabel lblCurrentSort;
    private static JLabel lblTime;
    private static SortResult sortResult;

    public SortScreen(JFrame parent) {

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

        JPanel headerPanel = createHeaderPanel();

        contentPane.add(
                headerPanel,
                BorderLayout.NORTH
        );

        JPanel sortPanel = new JPanel(
                new GridLayout(
                        5,
                        1,
                        0,
                        12
                )
        );

        JButton btnSortByName = createSortButton(
                "Ordenar por nombre"
        );

        btnSortByName.addActionListener(e -> {
            sortResult = SortUtils.orchestratorComparativeSort(Comparator.comparing(Network::getName));
            updateSortInfo(sortResult.algorithm(), sortResult.executeTime());
            if (!SortUtils.comprobateSortByName) {
                SortUtils.resetSortFlags();
                SortUtils.comprobateSortByName = true;
                AlphaUtils.updateAlpha(sortResult.algorithm(), sortResult.executeTime());
            }
        });

        JButton btnSortByID = createSortButton(
                "Ordenar por ID"
        );

        btnSortByID.addActionListener(e -> {
            sortResult = SortUtils.orchestratorSortByIdentifier();
            updateSortInfo(sortResult.algorithm(), sortResult.executeTime());
            if (!SortUtils.comprobateSortByIdentifier) {
                SortUtils.resetSortFlags();
                SortUtils.comprobateSortByIdentifier = true;
                AlphaUtils.updateAlpha(sortResult.algorithm(), sortResult.executeTime());
            }
        });

        JButton btnSortByPrefix = createSortButton(
                "Ordenar por prefijo"
        );

        btnSortByPrefix.addActionListener(e -> {
            sortResult = Const.getRandomInt(0, 1) == 0
                    ? SortUtils.orchestratorComparativeSort(Comparator.comparing(Network::getPrefix))
                    : SortUtils.orchestratorNoComparativeSort(Network::getPrefix);

            if (!SortUtils.comprobateSortByPrefix) {
                SortUtils.resetSortFlags();
                SortUtils.comprobateSortByPrefix = true;
                AlphaUtils.updateAlpha(sortResult.algorithm(), sortResult.executeTime());
            }
            updateSortInfo(sortResult.algorithm(), sortResult.executeTime());
        });

        JButton btnSortByClass = createSortButton(
                "Ordenar por clase"
        );

        btnSortByClass.addActionListener(e -> {
            sortResult = SortUtils.orchestratorComparativeSort(Comparator.comparing(Network::getNetworkClassType));
            if (!SortUtils.comprobateSortByClass) {
                SortUtils.resetSortFlags();
                SortUtils.comprobateSortByClass = true;
                AlphaUtils.updateAlpha(sortResult.algorithm(), sortResult.executeTime());
            }
            updateSortInfo(sortResult.algorithm(), sortResult.executeTime());
        });

        JButton btnSortByStatus = createSortButton(
                "Ordenar por estado"
        );

        btnSortByStatus.addActionListener(e -> {
            sortResult = SortUtils.orchestratorComparativeSort(Comparator.comparing(Network::getStatus));
            if (!SortUtils.comprobateSortByStatus) {
                SortUtils.resetSortFlags();
                SortUtils.comprobateSortByStatus = true;
                AlphaUtils.updateAlpha(sortResult.algorithm(), sortResult.executeTime());
            }
            updateSortInfo(sortResult.algorithm(), sortResult.executeTime());
        });

        sortPanel.add(btnSortByName);
        sortPanel.add(btnSortByID);
        sortPanel.add(btnSortByPrefix);
        sortPanel.add(btnSortByClass);
        sortPanel.add(btnSortByStatus);

        contentPane.add(
                sortPanel,
                BorderLayout.CENTER
        );

        setContentPane(contentPane);
    }

    private static JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(
                new GridLayout(3, 1, 0, 8)
        );

        JLabel lblTitle = new JLabel(
                "Algoritmos de ordenamiento",
                SwingConstants.CENTER
        );

        lblTitle.setFont(
                new Font(
                        "Tahoma",
                        Font.BOLD,
                        20
                )
        );

        lblCurrentSort = new JLabel(
                "Orden actual: Ninguno",
                SwingConstants.CENTER
        );

        lblTime = new JLabel(
                "Tiempo de ejecución: 0 ms",
                SwingConstants.CENTER
        );

        headerPanel.add(lblTitle);
        headerPanel.add(lblCurrentSort);
        headerPanel.add(lblTime);
        return headerPanel;
    }

    private JButton createSortButton(String text) {

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

    private void updateSortInfo(String sortName, long timeTaken) {
        lblCurrentSort.setText("Orden actual: " + sortName);
        lblTime.setText("Tiempo de ejecución: " + timeTaken + " ms");
    }
}