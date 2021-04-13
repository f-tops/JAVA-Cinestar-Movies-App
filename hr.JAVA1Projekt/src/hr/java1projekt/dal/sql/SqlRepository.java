/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.dal.sql;

import hr.java1projekt.dal.Repository;
import hr.java1projekt.model.Film;
import hr.java1projekt.model.Glumac;
import hr.java1projekt.model.Korisnik;
import hr.java1projekt.model.Redatelj;
import hr.java1projekt.model.Zanr;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Franjo
 */
public class SqlRepository implements Repository {

    //KORISNIK
    private static final String IDKORISNIK = "IDKorisnik";
    private static final String IME = "Ime";
    private static final String PREZIME = "Prezime";
    private static final String TIPKORISNIKAID = "TipKorisnikaID";

    private static final String LOGIN_KORISNIKA = "{ CALL loginKorisnika (?,?,?) }";
    private static final String REGISTRACIJA_KORISNIKA = "{ CALL registracijaKorisnika (?,?,?,?,?,?) }";

    //FILM
    private static final String ID_FILM = "IDFilm";
    private static final String NAZIV = "Naziv";
    private static final String OPIS = "Opis";
    private static final String ORIGINALNINAZIV = "OriginalniNaziv";
    private static final String LINK = "Link";
    private static final String PLAKATPUTANJA = "PlakatPutanja";
    private static final String POCETAK = "Pocetak";
    private static final String TRAJANJE = "Trajanje";
    private static final String PUBLISHED_DATE = "PublishedDate";

    private static final String SELECT_FILM = "{CALL selectFilm(?)}";
    private static final String DELETE_FILM = "{CALL deleteFilm(?)}";
    private static final String UPDATE_FILM = "{CALL updateFilm(?,?,?,?,?,?,?,?,?)}";
    private static final String SELECT_FILMOVI = "{ CALL selectFilmovi }";
    private static final String DELETE_FILMOVA = "{ CALL DeletePodataka }";
    private static final String CREATE_FILM = "{ CALL createFilm (?,?,?,?,?,?,?,?,?) }";

    //ZANR
    private static final String ID_ZANR = "IDZanr";

    private static final String CREATE_ZANR = "{CALL createZanr(?)}";
    private static final String CREATE_ZANROVI = "{CALL createZanrovi(?,?)}";
    private static final String CREATE_ZANRFILM = "{CALL createZanrFilm(?, ?)}";
    private static final String SELECT_ZANR_BY_FILM_ID = "{CALL selectZanrbyFilmID(?)}";
    private static final String SELECT_ZANROVI = "{CALL selectZanrovi}";
    private static final String SELECT_ZANR = "{CALL selectZanr(?)}";
    private static final String DELETE_ZANR = "{CALL deleteZanr(?)}";
    private static final String UPDATE_ZANR = "{CALL updateZanr(?,?)}";

    //REDATELJ
    private static final String ID_REDATELJ = "IDRedatelj";
    private static final String IME_PREZIME = "Ime_Prezime";

    private static final String CREATE_REDATELJ = "{CALL createRedatelj(?)}";
    private static final String CREATE_REDATELJI = "{CALL createRedatelji(?,?)}";
    private static final String CREATE_REDATELJ_FILM = "{CALL createRedateljFilm(?, ?)}";
    private static final String SELECT_REDATELJI = "{CALL selectRedatelji}";
    private static final String SELECT_REDATELJ = "{CALL selectRedatelj(?)}";
    private static final String DELETE_REDATELJ = "{CALL deleteRedatelj(?)}";
    private static final String UPDATE_REDATELJ = "{CALL updateRedatelj(?,?)}";
    private static final String SELECT_REDATELJ_BY_FILM_ID = "{CALL selectRedateljByFilmID(?)}";

    //GLUMAC
    private static final String ID_GLUMAC = "IDGlumac";

    private static final String CREATE_GLUMAC = "{CALL createGlumac(?)}";
    private static final String CREATE_GLUMCI = "{CALL createGlumci(?,?)}";
    private static final String CREATE_GLUMAC_FILM = "{CALL createGlumacFilm(?, ?)}";
    private static final String SELECT_GLUMCI = "{CALL selectGlumci}";
    private static final String SELECT_GLUMAC = "{CALL selectGlumac(?)}";
    private static final String DELETE_GLUMAC = "{CALL deleteGlumac(?)}";
    private static final String UPDATE_GLUMAC = "{CALL updateGlumac(?,?)}";
    private static final String SELECT_GLUMAC_BY_FILM_ID = "{CALL selectGlumacByFilmID(?)}";

    @Override
    public boolean loginKorisnik(String korisnickoIme, String lozinka, int tipKorisnikaID, JFrame frame) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(LOGIN_KORISNIKA)) {

            stmt.setString(1, korisnickoIme);
            stmt.setString(2, lozinka);
            stmt.setInt(3, tipKorisnikaID);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Korisnik.setIDKorisnik(resultSet.getInt(IDKORISNIK));
                Korisnik.setIme(resultSet.getString(IME));
                Korisnik.setPrezime(resultSet.getString(PREZIME));
                Korisnik.setTipKorisnikaID(resultSet.getInt(TIPKORISNIKAID));

                return true;
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame, "Greška baze podataka: " + exception.getMessage());

        }

        return false;
    }

    @Override
    public int registracijaKorisnik(String korisnickoIme, String lozinka, int tipKorisnikaID, String ime, String prezime, JFrame frame) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(REGISTRACIJA_KORISNIKA)) {

            stmt.setString(1, korisnickoIme);
            stmt.setString(2, lozinka);
            stmt.setInt(3, tipKorisnikaID);
            stmt.setString(4, ime);
            stmt.setString(5, prezime);
            stmt.registerOutParameter(6, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(6);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame, "Greška baze podataka: " + exception.getMessage());
        }
        return 0;
    }

    @Override
    public List<Film> selectFilmovi() throws Exception {
        List<Film> filmovi = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_FILMOVI);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                filmovi.add(new Film(
                        rs.getInt(ID_FILM),
                        rs.getString(NAZIV),
                        rs.getString(OPIS),
                        rs.getString(ORIGINALNINAZIV),
                        rs.getString(LINK),
                        rs.getString(PLAKATPUTANJA),
                        rs.getString(POCETAK),
                        rs.getInt(TRAJANJE),
                        LocalDateTime.parse(rs.getString(PUBLISHED_DATE), Film.DATE_FORMATTER)));
                
            }
        }
        return filmovi;
    }

    @Override
    public void createFilmovi(List<Film> filmovi) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_FILM)) {

            for (Film film : filmovi) {
                stmt.setString(1, film.getNaziv());
                stmt.setString(2, film.getOpis());
                stmt.setString(3, film.getOriginalniNaziv());
                stmt.setString(4, film.getLink());
                stmt.setString(5, film.getPlakatPutanja());
                stmt.setString(6, film.getPocetak());
                stmt.setInt(7, film.getTrajanje());
                stmt.setString(8, film.getPublishedDate().format(Film.DATE_FORMATTER));
                stmt.registerOutParameter(9, Types.INTEGER);
                stmt.execute();
                int filmID = stmt.getInt(9);
                if(filmID >0){
                    createGlumci(filmID, film.getGlumci());
                    createRedatelji(filmID, film.getRedatelji());
                    createZanrovi(filmID, film.getZanrovi());
                }

                
            }
        }
    }

    @Override
    public void deleteFilmova() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_FILMOVA)) {

            stmt.execute();

        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public Optional<Film> selectFilm(int selectedFilmID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_FILM)) {
            stmt.setInt(1, selectedFilmID);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Film(
                            rs.getInt(ID_FILM),
                            rs.getString(NAZIV),
                            rs.getString(OPIS),
                            rs.getString(ORIGINALNINAZIV),
                            rs.getString(LINK),
                            rs.getString(PLAKATPUTANJA),
                            rs.getString(POCETAK),
                            rs.getInt(TRAJANJE),
                            LocalDateTime.parse(rs.getString(PUBLISHED_DATE)),
                            selectZanrByFilmID(selectedFilmID),
                            (List<Redatelj>) (List<?>) selectRedateljiByFilmID(selectedFilmID),
                            (List<Glumac>) (List<?>) selectGlumciByFilmID(selectedFilmID)
                    ));
                }
            }
        }
        return Optional.empty();

    }

    @Override
    public void createFilm(Film film) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_FILM)) {

            stmt.setString(1, film.getNaziv());
            stmt.setString(2, film.getOpis());
            stmt.setString(3, film.getOriginalniNaziv());
            stmt.setString(4, film.getLink());
            stmt.setString(5, film.getPlakatPutanja());
            stmt.setString(6, film.getPocetak());
            stmt.setInt(7, film.getTrajanje());
            stmt.setString(8, film.getPublishedDate().format(Film.DATE_FORMATTER));
            stmt.registerOutParameter(9, Types.INTEGER);

            stmt.execute();
        }
    }

    @Override
    public void deleteFilm(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_FILM)) {

            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    @Override
    public void updateFilm(Film film) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_FILM)) {

            stmt.setInt(1,film.getiDFilm());
            stmt.setString(2, film.getNaziv());
            stmt.setString(3, film.getOpis());
            stmt.setString(4, film.getOriginalniNaziv());
            stmt.setString(5, film.getLink());
            stmt.setString(6, film.getPlakatPutanja());
            stmt.setString(7, film.getPocetak());
            stmt.setInt(8, film.getTrajanje());
            stmt.setString(9, film.getPublishedDate().format(Film.DATE_FORMATTER));

            stmt.execute();
        }

        if (!film.getGlumci().isEmpty()) {
            createGlumci(film.getiDFilm(), film.getGlumci());
        }

        if (!film.getRedatelji().isEmpty()) {
            createRedatelji(film.getiDFilm(), film.getRedatelji());
        }

        if (!film.getZanrovi().isEmpty()) {
            createZanrovi(film.getiDFilm(), film.getZanrovi());
        }
    }

    @Override
    public List<Glumac> selectGlumci() throws Exception {
        List<Glumac> glumci = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_GLUMCI);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                glumci.add(new Glumac(
                        rs.getInt(ID_GLUMAC),
                        rs.getString(IME_PREZIME)));
            }
        }
        return glumci;

    }

    @Override
    public Optional<Glumac> selectGlumac(int selectedGlumacID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_GLUMAC)) {
            stmt.setInt(1, selectedGlumacID);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Glumac(
                            rs.getInt(ID_GLUMAC),
                            rs.getString(IME_PREZIME)
                    ));
                }
            }
        }
        return Optional.empty();

    }

    @Override
    public void updateGlumac(Glumac selectedGlumac) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_GLUMAC)) {

            stmt.setInt(1, selectedGlumac.getIdGlumac());
            stmt.setString(2, selectedGlumac.getImePrezime());
            stmt.execute();
        }
    }

    @Override
    public void deleteGlumac(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_GLUMAC)) {

            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    @Override
    public void createGlumac(Glumac glumac) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_GLUMAC)) {

            stmt.setString(1, glumac.getImePrezime());
            stmt.execute();
        }
    }

    @Override
    public void createGlumci(int filmID, List<Glumac> glumci) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_GLUMCI)) {
            for (Glumac glumac : glumci) {
                stmt.setString(1, glumac.getImePrezime());
                stmt.registerOutParameter(2, Types.INTEGER);
                stmt.execute();

                
                int glumacID = stmt.getInt(2);
                createGlumciFilm(filmID, glumacID);
            }
        }catch(Exception e){
            System.out.println(e.toString() + "createGlumci");
        }
    }

    @Override
    public void createGlumciFilm(int filmID, int glumacID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_GLUMAC_FILM)) {
            stmt.setInt(1, filmID);
            stmt.setInt(2, glumacID);
            stmt.execute();
        }catch(Exception e){
            System.out.println(e.toString() + "createGLumciFilm");
        }
    }

    @Override
    public List<Glumac> selectGlumciByFilmID(int id) throws Exception {
        List<Glumac> glumci = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_GLUMAC_BY_FILM_ID)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    glumci.add(new Glumac(rs.getInt(ID_GLUMAC), rs.getString(IME_PREZIME)));
                }
            }
        }
        return glumci;
    }

    @Override
    public void createZanr(Zanr zanr) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_ZANR)) {

            stmt.setString(1, zanr.getNaziv());
            stmt.execute();
        }
    }

    @Override
    public void createZanrovi(int filmID, List<Zanr> zanrovi) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_ZANROVI)) {
            for (Zanr zanr : zanrovi) {
                stmt.setString(1, zanr.getNaziv());
                stmt.registerOutParameter(2, Types.INTEGER);
                stmt.execute();

                int zanrID = stmt.getInt(2);
                createZanrFilm(filmID, zanrID);
            }
        }
    }

    @Override
    public void createZanrFilm(int filmID, int ID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_ZANRFILM)) {
            stmt.setInt(1, filmID);
            stmt.setInt(2, ID);
            stmt.execute();
        }
    }

    @Override
    public List<Zanr> selectZanrByFilmID(int id) throws Exception {
        List<Zanr> zanrovi = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ZANR_BY_FILM_ID)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    zanrovi.add(new Zanr(rs.getInt(ID_ZANR), rs.getString(NAZIV)));
                }
            }
        }
        return zanrovi;

    }

    @Override
    public List<Zanr> selectZanrovi() throws Exception {
        List<Zanr> zanrovi = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ZANROVI); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                zanrovi.add(new Zanr(
                        rs.getInt(ID_ZANR),
                        rs.getString(NAZIV)
                ));
            }
        }
        return zanrovi;
    }

    @Override
    public Optional<Zanr> selectZanr(int selectedZanrID) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ZANR)) {
            stmt.setInt(1, selectedZanrID);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Zanr(
                            rs.getInt(ID_ZANR),
                            rs.getString(NAZIV)
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteZanr(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ZANR)) {

            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    @Override
    public void updateZanr(Zanr selectedZanr) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_ZANR)) {

            stmt.setInt(1, selectedZanr.getIdZanr());
            stmt.setString(2, selectedZanr.getNaziv());
            stmt.execute();
        }
    }

    @Override
    public void createRedatelj(Redatelj redatelj) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_REDATELJ)) {

            stmt.setString(1, redatelj.getImePrezime());
            stmt.execute();
        }
    }

    @Override
    public void createRedatelji(int filmID, List<Redatelj> redatelji) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_REDATELJI)) {
            for (Redatelj redatelj : redatelji) {
                stmt.setString(1, redatelj.getImePrezime());
                stmt.registerOutParameter(2, Types.INTEGER);
                stmt.execute();

                int redateljID = stmt.getInt(2);
                createRedateljFilm(filmID, redateljID);
            }
        }
    }

    @Override
    public void createRedateljFilm(int filmID, int redateljID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_REDATELJ_FILM)) {
            stmt.setInt(1, filmID);
            stmt.setInt(2, redateljID);
            stmt.execute();
        }
    }

    @Override
    public List<Redatelj> selectRedateljiByFilmID(int id) throws Exception {
        List<Redatelj> redatelji = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_REDATELJ_BY_FILM_ID)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    redatelji.add(new Redatelj(rs.getInt(ID_REDATELJ), rs.getString(IME_PREZIME)));
                }
            }
        }
        return redatelji;
    }

    @Override
    public List<Redatelj> selectRedatelji() throws Exception {
        List<Redatelj> redatelji = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_REDATELJI); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                redatelji.add(new Redatelj(
                        rs.getInt(ID_REDATELJ),
                        rs.getString(IME_PREZIME)
                ));
            }
        }
        return redatelji;
    }

    @Override
    public Optional<Redatelj> selectRedatelj(int selectedRedateljID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_REDATELJ)) {
            stmt.setInt(1, selectedRedateljID);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Redatelj(
                            rs.getInt(ID_REDATELJ),
                            rs.getString(IME_PREZIME)
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteRedatelj(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_REDATELJ)) {

            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    @Override
    public void updateRedatelj(Redatelj selectedRedatelj) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_REDATELJ)) {

            stmt.setInt(1, selectedRedatelj.getIdRedatelj());
            stmt.setString(2, selectedRedatelj.getImePrezime());
            stmt.execute();
        }
    }

}
