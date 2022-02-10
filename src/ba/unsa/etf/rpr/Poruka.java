package ba.unsa.etf.rpr;

import java.time.LocalDateTime;

public class Poruka {
    private Korisnik posiljalac, primalac;
    private LocalDateTime datumSlanja;
    private String tekst;
    private StatusPoruke statusPoruke;

    public Poruka(Korisnik posiljalac, Korisnik primalac, LocalDateTime datumSlanja, String tekst) throws NeispravanFormatPoruke {
        if (posiljalac == null)
            throw new NeispravanFormatPoruke("Pošiljalac ne smije biti null!");
        if (primalac == null)
            throw new NeispravanFormatPoruke("Primalac ne smije biti null!");
        if (tekst == null)
            throw new NeispravanFormatPoruke("Tekst ne smije biti null!");
        if (datumSlanja == null)
            throw new NeispravanFormatPoruke("Datum slanja ne smije biti null!");
        if (tekst.isEmpty())
            throw new NeispravanFormatPoruke("Tekst ne smije biti prazan!");
        this.statusPoruke = StatusPoruke.NEPROCITANA;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.datumSlanja = datumSlanja;
        this.tekst = tekst;
    }

    public Korisnik getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(Korisnik posiljalac) throws NeispravanFormatPoruke {
        if (posiljalac == null)
            throw new NeispravanFormatPoruke("Pošiljalac ne smije biti null!");
        this.posiljalac = posiljalac;
    }

    public Korisnik getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Korisnik primalac) throws NeispravanFormatPoruke {
        if (primalac == null)
            throw new NeispravanFormatPoruke("Primalac ne smije biti null!");
        this.primalac = primalac;
    }

    public LocalDateTime getDatumSlanja() {
        return datumSlanja;
    }

    public void setDatumSlanja(LocalDateTime datumSlanja) throws NeispravanFormatPoruke {
        if (datumSlanja == null)
            throw new NeispravanFormatPoruke("Datum slanja ne smije biti null!");
        this.datumSlanja = datumSlanja;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) throws NeispravanFormatPoruke {
        if (tekst == null)
            throw new NeispravanFormatPoruke("Tekst ne smije biti null!");
        if (tekst.isEmpty())
            throw new NeispravanFormatPoruke("Tekst ne smije biti prazan!");
        this.tekst = tekst;
    }

    public StatusPoruke getStatusPoruke() {
        return statusPoruke;
    }

    public void setStatusPoruke(StatusPoruke statusPoruke) {
        this.statusPoruke = statusPoruke;
    }

    @Override
    public String toString() {
        return "[od: " + posiljalac.toString() + " za: " + primalac.toString() + " tekst: " + tekst + "]";
    }
}
