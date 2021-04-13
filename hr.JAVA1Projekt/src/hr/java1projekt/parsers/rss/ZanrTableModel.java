/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.parsers.rss;

import hr.java1projekt.model.Zanr;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Franjo
 */
public class ZanrTableModel  extends AbstractTableModel {
        private static final String[] COLUMN_NAMES = {"IDZanr", "Naziv"};
    private List<Zanr> zanrovi;

    public ZanrTableModel(List<Zanr> zanrovi) {
        this.zanrovi = zanrovi;
    }

    public void setZanrovi(List<Zanr> zanrovi) {
        this.zanrovi = zanrovi;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return zanrovi.size();
    }

    @Override
    public int getColumnCount() {
        return Zanr.class.getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return zanrovi.get(rowIndex).getIdZanr();
            case 1:
                return zanrovi.get(rowIndex).getNaziv();
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
