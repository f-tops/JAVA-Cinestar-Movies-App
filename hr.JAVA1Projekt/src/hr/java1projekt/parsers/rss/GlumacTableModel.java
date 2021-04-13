/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.parsers.rss;

import hr.java1projekt.model.Glumac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Franjo
 */
public class GlumacTableModel extends AbstractTableModel  {
    private static final String[] COLUMN_NAMES = {"IDGlumac", "Ime_Prezime"};
    private List<Glumac> glumci;

    public GlumacTableModel(List<Glumac> glumci) {
        this.glumci = glumci;
    }

    public void setGlumci(List<Glumac> glumci) {
        this.glumci = glumci;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return glumci.size();
    }

    @Override
    public int getColumnCount() {
        return Glumac.class.getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return glumci.get(rowIndex).getIdGlumac();
            case 1:
                return glumci.get(rowIndex).getImePrezime();
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
