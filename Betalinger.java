public class Betalinger {

    protected boolean betalt = true;
    protected double rabat = 0.75;
    protected int medlemsKontigent;
    protected boolean restance;

    public Betalinger() {
    }

    public Betalinger(boolean betalt, int rabat) {
        this.betalt = betalt;
        this.rabat = rabat;
    }

    public int udregnBetalinger(Medlem medlem) {
        int medlemsKontigent = 0;

        if (medlem.getMedlemsStatus().equalsIgnoreCase("Aktiv")) // Hvis medlemmmet er aktivt, går de igennem de her ifs
        {
            if (medlem.getAlderKatogori().equalsIgnoreCase("Junior")) {
                return medlemsKontigent = 1000;

            } else if (medlem.getAlderKatogori().equalsIgnoreCase("Senior")) {
                return medlemsKontigent = 1600;

            } else if (medlem.getAlderKatogori().equalsIgnoreCase("Senior") && medlem.getAlder() >= 60) {
                return medlemsKontigent = (int) (1600 * rabat); // 25% for seniors over 60 år.

            } else if(medlem.getMedlemsStatus().equalsIgnoreCase("Passiv"))
                return medlemsKontigent; // passive medlemmer
        }

        return medlemsKontigent = 500;
    }



    public int udregnRestance(Medlem medlem) {
        int medlemsKontigent = 0;

        if (medlem.getMedlemsStatus().equalsIgnoreCase("Aktiv")) // Hvis medlemmmet er aktivt, går de igennem de her ifs
        {
            if (medlem.getAlderKatogori().equalsIgnoreCase("Junior")) {
                return medlemsKontigent = -1000;
            } else if (medlem.getAlderKatogori().equalsIgnoreCase("Senior")) {
                return medlemsKontigent = -1600;
            } else if (medlem.getAlderKatogori().equalsIgnoreCase("Senior") && medlem.getAlder() >= 60) {
                return medlemsKontigent = (int) (-1600 * rabat); // 25% for seniors over 60 år.
            } else if(medlem.getMedlemsStatus().equalsIgnoreCase("Passiv"))

            return medlemsKontigent = -500; // passive medlemmer
        }

        return medlemsKontigent;


    }
}

