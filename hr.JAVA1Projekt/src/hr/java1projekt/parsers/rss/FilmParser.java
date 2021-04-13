/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.parsers.rss;

import hr.java1projekt.model.Film;
import hr.java1projekt.utils.FileUtils;
import hr.java1projekt.factory.ParserFactory;
import hr.java1projekt.factory.UrlConnectionFactory;
import hr.java1projekt.model.Glumac;
import hr.java1projekt.model.Redatelj;
import hr.java1projekt.model.Zanr;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author dnlbe
 */
public class FilmParser {

    private static final String RSS_URL = "https://www.blitz-cinestar.hr/rss.aspx?najava=1";
    private static final int TIMEOUT = 10000;
    private static final String REQUEST_METHOD = "GET";
    public static final String FOLDER_PATH = "src\\hr\\java1projekt\\assets\\plakati";
    private static final String EXT_JPG = ".jpg";
    private static final String EXT_JPEG = ".jpeg";
    private static final String DELIMITER = "\\,";
    private static final String STRREGEX = "<[^>]*>";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.RFC_1123_DATE_TIME;
    private static final Random RANDOM = new Random();

    public static List<Film> parse() throws IOException, XMLStreamException {
        List<Film> filmovi = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL, TIMEOUT, REQUEST_METHOD);
        XMLEventReader reader = ParserFactory.createStaxParser(con.getInputStream());

        List<Zanr> zanrovi = null;
        List<Redatelj> redatelji = null;
        List<Glumac> glumci = null;


        Optional<TagType> tagType = Optional.empty();
        Film film = null;
        StartElement startElement = null;
        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    startElement = event.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    tagType = TagType.from(qName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (tagType.isPresent()) {
                        Characters characters = event.asCharacters();

                        String data = characters.getData().trim();
                        switch (tagType.get()) {
                            case ITEM:
                                    zanrovi = new ArrayList<>();
                                    glumci = new ArrayList<>();
                                    redatelji = new ArrayList<>();

                                    film = new Film();
                                    film.setZanrovi(zanrovi);
                                    film.setGlumci(glumci);
                                    film.setRedatelji(redatelji);

                                    filmovi.add(film);
                                    break;
                                

                            case TITLE:
                                if (film != null && !data.isEmpty()) {
                                    film.setNaziv(data);
                                }
                                break;
                            case DESCRIPTION:
                                if (film != null && !data.isEmpty()) {
                                    film.setOpis(data.replaceAll(STRREGEX, ""));
                                }
                                break;
                            case LINK:
                                if (film != null && !data.isEmpty()) {
                                    film.setLink(data);
                                }
                                break;
                            case ORIGNAZIV:
                                if (film != null && !data.isEmpty()) {
                                    film.setOriginalniNaziv(data);
                                }
                                break;
                            case REDATELJ:
                                if (film != null && !data.isEmpty()) {
                                    String[] rssRedatelji = data.split(DELIMITER);
                                    for (String redatelj : rssRedatelji) {
                                            redatelji.add(new Redatelj(redatelj.trim()));
                                        
                                    }
                                }
                                break;
                            case GLUMCI:
                                if (film != null && !data.isEmpty()) {
                                    String[] rssGlumci = data.split(DELIMITER);
                                    for (String glumac : rssGlumci) {
                                            glumci.add(new Glumac(glumac.trim()));
                                    }
                                }
                                break;
                            case TRAJANJE:
                                if (film != null && !data.isEmpty()) {
                                    film.setTrajanje(Integer.parseInt(data));
                                }
                                break;
                            case ZANR:
                                if (film != null && !data.isEmpty()) {
                                    String[] rssZanrovi = data.split(DELIMITER);
                                    for (String zanr : rssZanrovi) {

                                        zanrovi.add(new Zanr(zanr.trim()));

                                    }
                                }
                            case POCETAK:
                                if (film != null && !data.isEmpty()) {
                                    film.setPocetak(data);
                                }
                                break;
                            case PLAKAT:
                                if (film != null && !data.isEmpty()) {
                                    handlePicture(film, data, FOLDER_PATH);
                                }
                                break;

                            case PUB_DATE:
                                if (film != null && !data.isEmpty()) {
                                    LocalDateTime publishedDate = LocalDateTime.parse(data, DATE_FORMATTER);
                                    film.setPublishedDate(publishedDate);
                                }
                                break;
                        }
                    }
                    break;
            }
        }
        return filmovi;
    }

    private static void handlePicture(Film film, String pictureUrl, String folderPath) throws IOException {

        String ext = pictureUrl.substring(pictureUrl.lastIndexOf("."));
        if (ext.length() > 4 && ext.equals(EXT_JPEG)) {
            ext = EXT_JPEG;
        } else {
            ext = EXT_JPG;
        }
        String pictureName = Math.abs(RANDOM.nextInt()) + ext;
        String localPicturePath = folderPath + File.separator + pictureName;
        FileUtils.copyFromUrl(pictureUrl, localPicturePath);
        film.setPlakatPutanja(localPicturePath);
    }

    private enum TagType {

        ITEM("item"),
        TITLE("title"),
        LINK("link"),
        DESCRIPTION("description"),
        ORIGNAZIV("orignaziv"),
        REDATELJ("redatelj"),
        GLUMCI("glumci"),
        TRAJANJE("trajanje"),
        ZANR("zanr"),
        PLAKAT("plakat"),
        POCETAK("pocetak"),
        PUB_DATE("pubDate");

        private final String name;

        private TagType(String name) {
            this.name = name;
        }

        private static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        }
    }

}
