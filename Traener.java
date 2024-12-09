import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Traener extends Person {

    protected ArrayList<Person> trner = new ArrayList<>();
    protected String Diciplin;


    public Traener() {}

    public Traener(String navn,String mail, int tlfNr, CPR cpr, String diciplin)
    {
        super(navn, mail, tlfNr, cpr);

    }

    public String getDiciplin()
    {
        return Diciplin;
    }


    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return "Træners navn:" + getNavn() + "\n" +
                "CPR: " + cprNr + "\n" +
                "Træners mail:" + getMail() + "\n" +
                "Træners TelefonNr:" +getTlfNr() + "\n" +
                "Træners diciplin:" + getDiciplin() + "\n";
    }
}
