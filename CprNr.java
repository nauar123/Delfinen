import java.time.LocalDate;

public class CprNr
{
    private String nummeret;

    public CprNr()
    {}

    public CprNr(String nummeret)
    {
        this.nummeret = nummeret;
    }

    public String getNummeret()
    {
        return nummeret;
    }

    public int getDag()
    {
        int d = Integer.parseInt(nummeret.substring(0,2));
        return d;
    }

    public int getMaaned()
    {
        int m = Integer.parseInt(nummeret.substring(2,4));
        return m;
    }

    public int getAar()
    {
        int aarhundrede = 0;
        if (nummeret.charAt(6) >= '0' && nummeret.charAt(6) <= '3')
            aarhundrede = 1900;
        else
        if (nummeret.charAt(6) == '4' || nummeret.charAt(6) == '5')
            aarhundrede = 1800;
        else
            aarhundrede = 2000;

        return aarhundrede + Integer.parseInt(nummeret.substring(4,6));
    }

    public Dato getFoedselsdato()
    {
        return new Dato(getDag(),getMaaned(),getAar());
    }






}

