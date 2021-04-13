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
@XmlType(propOrder = {"naziv"})
public class Zanr implements Comparable<Zanr> {

    @XmlAttribute
    private int idZanr;
    private String naziv;

    public int getIdZanr() {
        return idZanr;
    }

    public void setIdZanr(int idZanr) {
        this.idZanr = idZanr;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Zanr(int idZanr, String naziv) {
        this.idZanr = idZanr;
        this.naziv = naziv;
    }

    public Zanr(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int compareTo(Zanr o) {
        return idZanr == o.idZanr ? 0 : 1;
    }
}
