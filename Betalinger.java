public class Betalinger {

    protected String betalt;
    protected Restance restance;
    protected int rabat;


    public Betalinger() {
    }

    public Betalinger(String betalt, Restance restance, int rabat) {
        this.betalt = betalt;
        this.restance = restance;
        this.rabat = rabat;
    }

    public String getBetalt() {
        return betalt;
    }

    public Restance getRestance()
    {
        return restance;
    }

    public int getRabat()
    {
        return rabat;
    }

}