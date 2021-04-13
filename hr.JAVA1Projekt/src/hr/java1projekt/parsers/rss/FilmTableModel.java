/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.parsers.rss;

import hr.java1projekt.model.Film;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Franjo
 */
public class FilmTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"IDFilm", "Naziv", "Opis", "OriginalniNaziv", "Link", "PlakatPutanja", "Pocetak", "Trajanje", "PublishedDate"};

    private List<Film> filmovi;

    public FilmTableModel(List<Film> filmovi) {
        this.filmovi = filmovi;
    }

    public void setFilmovi(List<Film> filmovi) {
        this.filmovi = filmovi;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return filmovi.size();
    }

    @Override
    public int getColumnCount() {
        return Film.class.getDeclaredFields().length - 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return filmovi.get(rowIndex).getiDFilm();
            case 1:
                return filmovi.get(rowIndex).getNaziv();
            case 2:
                return filmovi.get(rowIndex).getOpis();
            case 3:
                return filmovi.get(rowIndex).getOriginalniNaziv();
            case 4:
                return filmovi.get(rowIndex).getLink();
            case 5:
                return filmovi.get(rowIndex).getPlakatPutanja();
            case 6:
                return filmovi.get(rowIndex).getPocetak();
            case 7:
                return filmovi.get(rowIndex).getTrajanje();
            case 8:
                return filmovi.get(rowIndex).getPublishedDate().format(Film.DATE_FORMATTER);
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex);
    }

}
