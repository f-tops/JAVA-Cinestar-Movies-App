/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.parsers.rss;

import hr.java1projekt.model.Redatelj;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Franjo
 */
public class RedateljTableModel extends AbstractTableModel{
    private static final String[] COLUMN_NAMES = {"IDRedatelj", "Ime_Prezime"};
    private List<Redatelj> redatelji;

    public RedateljTableModel(List<Redatelj> redatelji) {
        this.redatelji = redatelji;
    }

    public void setRedatelji(List<Redatelj> redatelji) {
        this.redatelji = redatelji;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return redatelji.size();
    }

    @Override
    public int getColumnCount() {
        return Redatelj.class.getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return redatelji.get(rowIndex).getIdRedatelj();
            case 1:
                return redatelji.get(rowIndex).getImePrezime();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
