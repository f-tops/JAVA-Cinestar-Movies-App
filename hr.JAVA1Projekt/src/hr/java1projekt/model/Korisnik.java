/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.model;

/**
 *
 * @author Franjo
 */
public class Korisnik {
    private static int IDKorisnik;
    private static String Ime;
    private static String Prezime;
    private static String KorisnickoIme;
    private static String Lozinka;
    private static int TipKorisnikaID;
    private static boolean JeUlogiran = false;
    
    public static int getIDKorisnik() {
        return IDKorisnik;
    }

    public static void setIDKorisnik(int IDKorisnik) {
        Korisnik.IDKorisnik = IDKorisnik;
    }

    public static String getIme() {
        return Ime;
    }

    public static void setIme(String Ime) {
        Korisnik.Ime = Ime;
    }

    public static String getPrezime() {
        return Prezime;
    }

    public static void setPrezime(String Prezime) {
        Korisnik.Prezime = Prezime;
    }

    public static String getKorisnickoIme() {
        return KorisnickoIme;
    }

    public static void setKorisnickoIme(String KorisnickoIme) {
        Korisnik.KorisnickoIme = KorisnickoIme;
    }

    public static String getLozinka() {
        return Lozinka;
    }

    public static void setLozinka(String Lozinka) {
        Korisnik.Lozinka = Lozinka;
    }

    public static int getTipKorisnikaID() {
        return TipKorisnikaID;
    }

    public static void setTipKorisnikaID(int TipKorisnikaID) {
        Korisnik.TipKorisnikaID = TipKorisnikaID;
    }

    
    public static void LogirajKorisnika(){
        JeUlogiran = true;
    }
    
    public static void OdlogirajKorisnika(){
        JeUlogiran = false;
    }
    
    
}
