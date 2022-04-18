/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffos.evidencija;

import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Evidencija {
    
    private String naziv;
    private String osoba;
    private List<Pjesma> pjesme;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOsoba() {
        return osoba;
    }

    public void setOsoba(String osoba) {
        this.osoba = osoba;
    }

    public List<Pjesma> getPjesme() {
        return pjesme;
    }

    public void setPjesme(List<Pjesma> pjesme) {
        this.pjesme = pjesme;
    }
    
    
}
