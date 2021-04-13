/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.dal;

import hr.java1projekt.model.Film;
import hr.java1projekt.model.Glumac;
import hr.java1projekt.model.Redatelj;
import hr.java1projekt.model.Zanr;
import java.util.List;
import java.util.Optional;
import javax.swing.JFrame;

/**
 *
 * @author Franjo
 */
public interface Repository {

    //KORISNIK
    public boolean loginKorisnik(String korisnickoIme, String zaporka, int tipKorisnikaID, JFrame frame) throws Exception;

    public int registracijaKorisnik(String korisnickoIme, String zaporka, int tipKorisnikaID, String ime, String prezime, JFrame frame) throws Exception;

    //FILM
    List<Film> selectFilmovi() throws Exception;

    Optional<Film> selectFilm(int selectedFilmID) throws Exception;

    void createFilmovi(List<Film> filmovi) throws Exception;

    void createFilm(Film film) throws Exception;

    void deleteFilmova() throws Exception;

    void deleteFilm(int id) throws Exception;

    void updateFilm(Film selectedFilm) throws Exception;

    //GLUMAC
    List<Glumac> selectGlumci() throws Exception;

    Optional<Glumac> selectGlumac(int selectedGlumacID) throws Exception;

    void updateGlumac(Glumac selectedGlumac) throws Exception;

    void deleteGlumac(int id) throws Exception;

    void createGlumac(Glumac glumac) throws Exception;

    void createGlumci(int filmID, List<Glumac> glumci) throws Exception;

    void createGlumciFilm(int filmID, int glumacID) throws Exception;

    List<Glumac> selectGlumciByFilmID(int id) throws Exception;

    //ZANR
    void createZanr(Zanr zanr) throws Exception;

    void createZanrovi(int filmID, List<Zanr> zanrovi) throws Exception;

    void createZanrFilm(int filmID, int ID) throws Exception;

    List<Zanr> selectZanrByFilmID(int id) throws Exception;

    List<Zanr> selectZanrovi() throws Exception;

    Optional<Zanr> selectZanr(int selectedZanrID) throws Exception;

    void deleteZanr(int id) throws Exception;

    void updateZanr(Zanr selectedZanr) throws Exception;

    //REDATELJ
    void createRedatelj(Redatelj redatelj) throws Exception;

    void createRedatelji(int filmID, List<Redatelj> redatelji) throws Exception;

    void createRedateljFilm(int filmID, int redateljID) throws Exception;

    List<Redatelj> selectRedateljiByFilmID(int id) throws Exception;

    List<Redatelj> selectRedatelji() throws Exception;

    Optional<Redatelj> selectRedatelj(int selectedRedateljID) throws Exception;

    void deleteRedatelj(int id) throws Exception;

    void updateRedatelj(Redatelj selectedRedatelj) throws Exception;
}
