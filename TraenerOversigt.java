import java.util.ArrayList;
import java.util.Random;

public class TraenerOversigt {

    protected ArrayList<Traener> traenerArrayList = new ArrayList<Traener>();
    protected String diciplin;



    public TraenerOversigt()
    {
        this.traenerArrayList = new ArrayList<>();
        this.diciplin = diciplin;
        createTraenerOversigt();
    }


    public void createTraenerOversigt()
    {
        Random random = new Random();
        for(int i = 0; i < 10; i++)
        {
            CPR cpr = new CPR();


            String[] traenerDFornavn = {"Magnus", "Kasper", "Henrik", "Niels", "Jonas", "Asger" };
            String[] traenerPFornavn = {"Lotte", "Pia", "Birgitte", "Katrine" };
            String[] traenerEfternavn = {"Møller", "Sørensen", "Petersen", "Kristensen", "Hansen", "Lauridsen", "Jakobsen", "Friis", "Thomsen", "Bæk" };
            String[] discipliner = {"Svømning", "Butterfly", "Freestyle", "Rygcrawl", "Brystsvømning" };



            int lastDigit = cpr.getGender();
            boolean isOdd = (lastDigit % 2 != 0);


            String fornavn;

            if (isOdd)
            {
                fornavn = traenerDFornavn[random.nextInt(traenerDFornavn.length)];
            } else
            {
                fornavn = traenerPFornavn[random.nextInt(traenerPFornavn.length)];
            }

            String efternavn = traenerEfternavn[random.nextInt(traenerEfternavn.length)];
            String navn = fornavn + " " + efternavn;


            int telNr = 10000000 + random.nextInt(90000000); // Generer telefonnummer
            String mail = fornavn.toLowerCase() + efternavn.toLowerCase() + "@mail.com";
            String diciplin = discipliner[random.nextInt(discipliner.length)];


            traenerArrayList.add(new Traener(navn, mail, telNr, cpr, diciplin));

        }
    }

    public ArrayList<Traener> getTraenerArrayList()
    {
        return traenerArrayList;
    }

        public void addTraenerToTraenerOversigt(Traener t)
     {
       traenerArrayList.add(t);
     }

     public String toString()
     {
         return "Diciplin: " + diciplin + "\n";
     }

}
