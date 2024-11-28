import java.time.LocalDate;

public class CprNr
{
    String nummeret;

    public CprNr()
    {}

    public CprNr(String etCprNr)
    {
        nummeret = etCprNr;
    }

    public String getCprNr()
    {
        return nummeret;
    }

    public void setCprNr(String etCprNr)
    {
        nummeret = etCprNr;
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

    // Precondition: nummeret indeholder en korrekt dato
    public Dato getDato()
    {
        Dato d = new Dato(getAar(),getMaaned(),getDag());

        return d;
    }

    public int getAlder()
    {
        LocalDate dd = LocalDate.now();
        Dato iDag = new Dato(dd.getYear(),dd.getMonthValue(),dd.getDayOfMonth());
        return (iDag.getDatoen() - getDato().getDatoen()) / 10000;
    }

    public boolean erMand()
    {
        int n = Integer.parseInt(nummeret.substring(9,10));
        return n % 2 == 1;
    }

    public boolean erKvinde()
    {
        return !erMand();
    }




}

