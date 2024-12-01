import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;

public class Medlem extends Person {

    protected ArrayList<Person> person = new ArrayList();
    protected LocalDate oprettelsesDato;
    protected int medlemsId;
    protected boolean erAktiv;


    public Medlem( String navn, int foedselsdato, String mail, int tlfNr, LocalDate dato, int medlemsId, boolean erAktiv)
    {
        super(navn,foedselsdato, mail, tlfNr);
        this.oprettelsesDato = dato;
        this.medlemsId = medlemsId;
        this.erAktiv = erAktiv;
    }

    public ArrayList<Person> getPerson()
    {
        return person;
    }
    public LocalDate getOprettelsesDato()
    {
        return oprettelsesDato;
    }

    public int getMedlemsId()
    {
        return medlemsId;
    }

    public boolean isErAktiv()
    {
        return erAktiv;
    }

    public String toString ()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // beskriver, hvordan datoer skal vises.

        return "Medlem: " + navn +  " \n" +
                "Fødselsdag:" + foedelsdato  + "\n" +
                "Mail:" + mail + "\n" +
                "TelefonNr:" + tlfNr + "\n" +
                "Oprettelsesdato:" + oprettelsesDato + "\n" +
                "Medlemdsid:" + medlemsId + "\n";
    }
}
