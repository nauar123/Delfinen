import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Traener extends Person {

    protected ArrayList<Person> trner = new ArrayList<>();
    protected String diciplin;

    public Traener() {}

    public Traener(String navn,   String mail, int tlfNr, CPR cpr, String diciplin)
    {
        super(navn, mail, tlfNr, cpr);
        this.diciplin = diciplin;
    }

    public String getDiciplin()
    {
        return diciplin;
    }

    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return "Træners navn:" + navn + "\n" +
                "Træners mail:" + mail + "\n" +
                "Træners TelefonNr:" + tlfNr + "\n" +
                "Træners diciplin:" + diciplin + "\n";
    }
}
