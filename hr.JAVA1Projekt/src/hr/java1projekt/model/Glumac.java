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
public class Glumac implements Comparable<Glumac> {

    @XmlAttribute
    private int idGlumac;
    private String imePrezime;

    public Glumac(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Glumac(int idGlumac, String imePrezime) {
        this.idGlumac = idGlumac;
        this.imePrezime = imePrezime;
    }

    public Glumac() {
    }

    public int getIdGlumac() {
        return idGlumac;
    }

    public void setIdGlumac(int idGlumac) {
        this.idGlumac = idGlumac;
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
    public int compareTo(Glumac o) {
        return idGlumac == o.idGlumac ? 0 : 1;
    }
    
}
