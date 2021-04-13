/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.java1projekt.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Franjo
 */
@XmlRootElement(name = "redatelji")
@XmlAccessorType(XmlAccessType.FIELD)
public class RedateljKolekcija {
    @XmlElementWrapper
    @XmlElement(name = "redatelj")
    private List<Redatelj> redatelji;

    public RedateljKolekcija() {
    }

    public RedateljKolekcija(List<Redatelj> redatelji) {
        this.redatelji = redatelji;
    }
}
