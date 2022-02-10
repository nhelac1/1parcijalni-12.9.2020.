package ba.unsa.etf.rpr;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Messenger {
    private List<Poruka> poruke;

    public Messenger() {
        this.poruke = new ArrayList<>();
    }
    public List<Poruka> dajSvePoruke() {
        return poruke;
    }
    public void posaljiPoruku(Korisnik posiljac, Korisnik primalac, String tekst) throws NeispravanFormatPoruke {
        LocalDateTime trenutnoStanje = LocalDateTime.now();
        Poruka poruka = new Poruka (posiljac, primalac, trenutnoStanje, tekst);
        poruke.add(poruka);
    }
    public void posaljiPoruku (Poruka p) {
        poruke.add(p);
    }
    public void posaljiPoruke (List<Poruka> listaPoruka) {
        for (Poruka p : listaPoruka) {
            poruke.add(p);
        }
    }
    public void ponistiSlanje (Poruka p) throws NeispravnaAkcija{
        for (Poruka poruka : poruke) {
            if (poruka.equals(p) && p.getStatusPoruke() == StatusPoruke.NEPROCITANA) {
                poruke.remove(p);
            } else if (p.getStatusPoruke() == StatusPoruke.PROCITANA){
                throw new NeispravnaAkcija("Nije moguće poništiti slanje poruke koja je već pročitana!");
            } else if (poruka != p){
                throw new NeispravnaAkcija("Nije moguće poništiti slanje poruke koja nije nikada poslana!");
            }
        }
    }
    public void procitajPoruku (Poruka p) throws NeispravnaAkcija {
        int brojac=0;
        for (Poruka poruka : poruke) {
           if (poruka != p)
               brojac = brojac + 1;
           else
               poruka.setStatusPoruke(StatusPoruke.PROCITANA);
        }
        if (brojac == poruke.size())
            throw new NeispravnaAkcija("Nije moguće pročitati poruku koja nije nikada poslana!");
    }

    public List<Poruka> dajPorukeZaKorisnika(Korisnik korisnik1, StatusPoruke neprocitana) {
        return poruke;
    }

    public List<Poruka> dajStarijeOd(Korisnik korisnik1, LocalDateTime datum) {
        return poruke;
    }

    public List<Poruka> dajPristiglePorukeZaKorisnika(Korisnik korisnik1) {
        return poruke;
    }

    public Map<Korisnik, List<Poruka>> dajNeprocitanePoruke() {
        Map<Korisnik, List<Poruka>> mapa = new HashMap<>();
        return mapa;
    }

    public void oznaciKaoNeprocitano(List<Poruka> porukas) {
    }
    public List<Poruka> filtrirajPoruke(Predicate<Poruka> kriterij){
        return poruke
                .stream()
                .filter(kriterij)
                .collect(Collectors.toList());
    }
}
