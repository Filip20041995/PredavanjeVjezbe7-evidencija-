/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffos.evidencija;

import ffos.zarucnik.Unos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Korisnik
 */
public class Start {

    private List<Evidencija> evidencije;

    public Start() {
        evidencije = new ArrayList<>();
        do {
            unosEvidencije();
        } while (!Unos.unosString("X za kraj").equals("X"));
        rezultati();
    }

    private void rezultati() {
    
        Map<String, Integer> slusanePjesme = new HashMap<>();

        for (Evidencija e : evidencije) {
            for (Pjesma p : e.getPjesme()) {
                if (slusanePjesme.containsKey(p.getNaziv())) {
                    slusanePjesme.put(p.getNaziv(),
                            slusanePjesme.get(p.getNaziv()) + 1
                    );
                } else {
                    slusanePjesme.put(p.getNaziv(), 1);
                }
            }
        }

        for (String s : slusanePjesme.keySet()) {
            if(slusanePjesme.get(s)>=2){
                 System.out.println(izvodac(s) + ": " + s + " ("
                    + slusanePjesme.get(s) + ")");
            }
           
        }

    }

    private String izvodac(String pjesma) {
        for (Evidencija e : evidencije) {
            for (Pjesma p : e.getPjesme()) {
                if (p.getNaziv().equals(pjesma)) {
                    return p.getIzvodac();
                }
            }

        }
        return "";
    }

    private void unosEvidencije() {
        Evidencija e = new Evidencija();
        e.setNaziv(Unos.unosString("Unesi naziv evidencije"));
        e.setOsoba(Unos.unosString("Unesi ime osobe koja sluša"));
        e.setPjesme(unosPjesama());
        evidencije.add(e);
    }

    private List<Pjesma> unosPjesama() {
        List<Pjesma> pjesme = new ArrayList<>();
        Pjesma p;
        boolean postoji;
        do {
            p = unosPjesme();
            postoji=false;
            for(Pjesma pj : pjesme){
                if(pj.getNaziv().equals(p.getNaziv()) && 
                        pj.getIzvodac().equals(p.getIzvodac())){
                    postoji=true;
                    break;
                }
            }
            if(!postoji){
                pjesme.add(p);
            }
            
        } while (!Unos.unosString("X za kraj").equals("X"));
        return pjesme;
    }

    private Pjesma unosPjesme() {
        Pjesma p = new Pjesma();
        p.setIzvodac(Unos.unosString("Unesi izvođača"));
        p.setNaziv(Unos.unosString("Unesi naziv pjesme"));
        return p;
    }

    public static void main(String[] args) {
        new Start();
    }

}
