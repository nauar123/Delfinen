import java.util.ArrayList;

public class Restance {

    ArrayList<Medlem> restanceListe = new ArrayList<>();

    public Restance(ArrayList<Medlem> restanceListe)
    {
        this.restanceListe = new ArrayList<>();
    }

    public ArrayList<Medlem> getRestanceListe()
    {
        return restanceListe;
    }

    public void addMedlemToRestance(Medlem medlem)
    {
        if(!restanceListe.contains(medlem))
        {
            restanceListe.add(medlem);
        }
    }

    public int udregnRestanceForMedlem(Medlem medlem)
    {
        return medlem.betalinger.udregnRestance(medlem);
    }

    public boolean erMedlemIRestance(Medlem medlem)
    {
        return restanceListe.contains(medlem);
    }
}

