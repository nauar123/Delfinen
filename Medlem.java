import java.util.ArrayList;
import java.time.LocalDate;

public class Medlem extends Person {

    protected ArrayList<Person> person = new ArrayList();
    protected LocalDate oprettelsesDato;
    protected int medlemsId;
    protected boolean erAktiv;

    public Medlem() {}


    public Medlem( LocalDate dato, int medlemsId, boolean erAktiv)
    {

        this.oprettelsesDato = dato;
        this.medlemsId = medlemsId;
        this.erAktiv = erAktiv;
    }

    public int getMedlemsId()
    {
        return medlemsId;
    }






}
