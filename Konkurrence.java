import java.time.LocalDate;
import java.util.ArrayList;

public class Konkurrence {

    protected String staevne;
    protected String placering;
    protected LocalDate dagsDato;
    protected ArrayList<Medlem> deltagere = new ArrayList<>();

    public Konkurrence(){}

    public Konkurrence (String staevne, String placering, LocalDate dagsDato)
    {
        this.staevne = staevne;
        this.placering = placering;
        this.dagsDato = dagsDato;
    }

}
