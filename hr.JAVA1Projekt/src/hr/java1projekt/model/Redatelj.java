/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Franjo
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"imePrezime"})
public class Redatelj implements Comparable<Redatelj> {

    @XmlAttribute
    private int idRedatelj;
    private String imePrezime;

    public Redatelj(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Redatelj(int idRedatelj, String imePrezime) {
        this.idRedatelj = idRedatelj;
        this.imePrezime = imePrezime;
    }

    public Redatelj() {
    }

    public int getIdRedatelj() {
        return idRedatelj;
    }

    public void setIdRedatelj(int idRedatelj) {
        this.idRedatelj = idRedatelj;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

        @Override
    public int compareTo(Redatelj o) {
        return idRedatelj == o.idRedatelj ? 0 : 1;
    }
    
}
