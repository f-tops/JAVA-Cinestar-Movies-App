/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franjo
 */
public class Film {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private int iDFilm;
    private String naziv;
    private String opis;
    private String originalniNaziv;
    private String link;
    private String plakatPutanja;
    private String pocetak;
    private int trajanje;
    private LocalDateTime publishedDate;
    private List<Zanr> zanrovi;
    private List<Redatelj> redatelji;
    private List<Glumac> glumci;

    public List<Zanr> getZanrovi() {
        return zanrovi;
    }

    public void setZanrovi(List<Zanr> zanrovi) {
        this.zanrovi = zanrovi;
    }

    public List<Redatelj> getRedatelji() {
        return redatelji;
    }

    public void setRedatelji(List<Redatelj> redatelji) {
        this.redatelji = redatelji;
    }

    public List<Glumac> getGlumci() {
        return glumci;
    }

    public void setGlumci(List<Glumac> glumci) {
        this.glumci = glumci;
    }

    public Film() {
        zanrovi = new ArrayList<>();
        redatelji = new ArrayList<>();
        glumci = new ArrayList<>();
    }

    public Film(String naziv, String opis, String originalniNaziv, String link, String plakatPutanja, String pocetak, int trajanje, LocalDateTime publishedDate) {
        this.naziv = naziv;
        this.opis = opis;
        this.originalniNaziv = originalniNaziv;
        this.link = link;
        this.plakatPutanja = plakatPutanja;
        this.pocetak = pocetak;
        this.trajanje = trajanje;
        this.publishedDate = publishedDate;
        zanrovi = new ArrayList<>();
        redatelji = new ArrayList<>();
        glumci = new ArrayList<>();
    }

    public Film(int iDFilm, String naziv, String opis, String originalniNaziv, String link, String plakatPutanja, String pocetak, int trajanje, LocalDateTime publishedDate) {
        this(naziv, opis, originalniNaziv, link, plakatPutanja, pocetak, trajanje, publishedDate);
        this.iDFilm = iDFilm;
        zanrovi = new ArrayList<>();
        redatelji = new ArrayList<>();
        glumci = new ArrayList<>();
    }

    public Film(int idFilm, String naziv, String opis, String originalniNaziv, String link, String plakatPutanja, String pocetak, int trajanje, LocalDateTime publishedDate, List<Zanr> zanrovi, List<Redatelj> redatelji, List<Glumac> glumci) {
        this(idFilm, naziv, opis, originalniNaziv, link, plakatPutanja, pocetak, trajanje, publishedDate);
        this.zanrovi = zanrovi;
        this.redatelji = redatelji;
        this.glumci = glumci;
    }
    
        public Film(String naziv, String opis, String originalniNaziv, String link, String plakatPutanja, String pocetak, int trajanje, LocalDateTime publishedDate, List<Zanr> zanrovi, List<Redatelj> redatelji, List<Glumac> glumci) {
        this(naziv, opis, originalniNaziv, link, plakatPutanja, pocetak, trajanje, publishedDate);
        this.zanrovi = zanrovi;
        this.redatelji = redatelji;
        this.glumci = glumci;
    }

    public int getiDFilm() {
        return iDFilm;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOriginalniNaziv() {
        return originalniNaziv;
    }

    public void setOriginalniNaziv(String originalniNaziv) {
        this.originalniNaziv = originalniNaziv;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPlakatPutanja() {
        return plakatPutanja;
    }

    public void setPlakatPutanja(String plakatPutanja) {
        this.plakatPutanja = plakatPutanja;
    }

    public String getPocetak() {
        return pocetak;
    }

    public void setPocetak(String pocetak) {
        this.pocetak = pocetak;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return iDFilm + " - " + naziv;
    }

}
