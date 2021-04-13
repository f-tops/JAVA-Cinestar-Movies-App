/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt;

import hr.java1projekt.model.Korisnik;
import javax.swing.JFrame;

/**
 *
 * @author Franjo
 */
public class Logout {
    public static void logOut(JFrame context, LoginForm loginScreen){
        Korisnik.OdlogirajKorisnika();
        context.setVisible(false);
        loginScreen.setVisible(true);
    }
}
