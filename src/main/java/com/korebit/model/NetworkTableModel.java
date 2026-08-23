package com.korebit.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class NetworkTableModel extends AbstractTableModel {

    private final String[] columns = {
            "Nombre",
            "Clase",
            "Máscara",
            "Dirección",
            "Broadcast",
            "Estado",
            "Rango",
            "Prefijo",
            "ID"
    };

    private final List<Network> networks;

    public NetworkTableModel(List<Network> networks) {
        this.networks = new ArrayList<>(networks);
    }

    @Override
    public int getRowCount() {
        return networks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Network network = networks.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> network.getName();
            case 1 -> network.getNetworkClassType();
            case 2 -> network.getMask();
            case 3 -> network.getNetDirection();
            case 4 -> network.getBroadcast();
            case 5 -> network.getStatus();
            case 6 -> network.getRange();
            case 7 -> network.getPrefix();
            case 8 -> network.getIdentifier();
            default -> null;
        };
    }

    public Network getNetworkAt(int rowIndex) {
        return networks.get(rowIndex);
    }
}