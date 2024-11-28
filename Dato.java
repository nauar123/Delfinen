import java.util.Scanner;
/**
 * @author Nauar
 * @version 30. August 2024
 */
public class Dato //navnet på klassen skal altid være stort bogstav; atrributter og alm. metoder med lille begyndelsesbogstav
{
    private int datoen;// format YYYYMMDD. dette er klassens attribut/data

    public Dato() // Når der står public er det en kontrukter, det kaldes det. Dette er en default contructor, og der skabes et tomt objekt
    {}
    public Dato (int enDato)

    {
        datoen = enDato;

    }
    //
    public int getDatoen()

    {
        return datoen; //værdien af attributten datoen (et heltal, da vi bruger int) retuneres her.

    }
    //  I følgende metode gør vi 2 ting i det at den først regner regnestykket ud og derefter retunere den, (at retunere det betyder at når vi
    // trykker oversæt kommer det frem der)

    // Opgave 1 Skriv en constructor, som tager tre parametre:
    //dag, måned og år.
    public Dato ( int enDag, int enMaaned, int etAar)

    {
        datoen = etAar * 10000 + enMaaned + 100 + enDag; // 20010000+900+11 = 20010911
    }

    public int getAar()

    {
        return datoen/10000; // vi dividere det med 10000, som er 4-cifret 0, idet at et år er 4-cifre

    }
    //  Under dette gøres der brug af 2 forskellige måder vi kan regne måneden ud på


    // 1 metode er således:

    public int  getMaaned()
    {
        int Maaned = 0; //  Man siger = 0 fordi "maneed" ska have en værdi, ellers tilskrives den ikke nogen værdi, og
        // der vil stå fejl når man oversætter den
        Maaned = datoen/100; // vi dividere med 100 fordi vi skal have fjernet DD fra selve datoen, det gør vi ved at dividere med 100, da der
        // er 2 cifre ved DD og derfor  dividere vi det med et 2 cifret 0 tal.
        Maaned = Maaned % 100; // % kaldes for modulus, man bruger modulus, når man skal have tallet foran, og man dividere når man skal have
        // tallet bagved ligesom med getAar og trin 1 i denne metode. vi skal have fat i de sidste 2 tal i måeden og derfor siger vi %100
        return Maaned; // Når man benytter sig af "int", skal der også være et "return", som spytter tallet ud på en måde.

        //Når vi gør brug af denne metode tildeler vi atributten en værdi og det kaldes assignment. vi heltals dividere den med 100 og giver den
        //først den værdi derefter overskriver vi værdien af maaneed med modulus % og giver den derefter en ny værdi. Der sker derfor 2 ting
        // i metoden.

    }
    public int getMaanedShort()
    {

        return datoen/100 %(100); // den her metode og måde at opsætte kodningen på er mere simpel, og kan skrives på en linje. Det er dog det
        // samme resulatet som den forrige.

    }
    public int getDag()

    {
        return datoen % 100;

    }
    public int getKvartal()
    {
        int maaned= getMaaned();
        return (maaned+2)/3;// eks. januar 1+2/3 = 1 , april (4+2)/3= 2. Janaur er i 1 kvartal, og april er i 2 kvartal, så derfor kan vi se det
        // rigtigt.

        // vi gør brug af getMaaned igen fordi man ikke behøver lave en ny værdi og så regne kvartalen ud. Det bedst at gøre brug af det der -
        // allerede er der.
    }


    // Vi skal i denne metode finde skudår retunerer true for skudår (fx 2024) og false for ikke skudår (fx 2023) 97/400
    public boolean skudAar() // når det er boolean skal man retunere noget.

    {
        int aar= getAar();

        if
        (aar% 4 !=0)
        // Det er for at fjerne 2023 osv 2022 osv, 4 går jo fx ikke op i 2023 eller 2022.
        // og && eller || ( alt i ) ikke ligmed  !.
        {
            return false;
        }
        else if (aar % 100 == 0 && aar % 400 != 0)

        //dem der divider bar med 100, men ikke med 400, det for at fjerne de  år som er dividerbar med 100
        // men ikke 400.  Når man skriver && så det fordi programmet tjekket første metode og derefter anden metode. Det for at dobbelt
        // tjekke for skudår. (der 3 år der går op i 100, men ikke 400. )
        {
            return false;
        }
        //else if (aar % 4!=0 || (aar % 100 == 0 && aar % 400 != 0))  smart line

        else
        {
            return true;
        }
    }
    //Skriv en metode, som kan afgøre im en dato er valid.
    //signatur public boolean

    public boolean valid()
    {
        if
        (datoen < 17000301) // vi skriver hvis datoen er mindre end 17000301, så vil den return falsk.
            //Datoer før 1. marts 1700 anses for ikke valide
            return false;

        else if (getDag() < 1 || getDag()> 31)   // parentensen skal være der, fordi ellers vil metoden tro at det er en atrribut
            //og ikke en metode.  max. 31 dage i en måned.
            return false;

        else if (getMaaned() <1 || getMaaned() >12)
            // max 12 måneder i et år. så ikke mindre end 1 og større end 12

            return false;

        else if ((getMaaned()==4 ||getMaaned()==6|| getMaaned()==9 ||getMaaned()==11) && getDag()>30)
            return false;

        //kun 30 dage i april.
        // april, juni, september og november har 30 dage i måneden.


        //2017 er ikke et skudår.
        if (skudAar() && getMaaned () == 2 && getDag() >29)

            return false;

        else if (!skudAar() && getMaaned() == 2 && getDag()> 28)
            return false;
        return true;

    }
    public int dagIAar()
    { int skudDag =0;

        {  if (skudAar ())
            skudDag = 1;

            if (getMaaned () ==1)

                return getDag();
            if (getMaaned () ==2)

                return 31+ getDag()+ skudDag;
            if (getMaaned () == 3)

                return 59 + getDag() + skudDag;
            if (getMaaned () == 4)
                return 90 + getDag() + skudDag;
            if (getMaaned () == 5)
                return 120 + getDag() + skudDag;
            if (getMaaned () == 6)
                return 151 + getDag() + skudDag;
            if (getMaaned () == 7)
                return 182 + getDag() + skudDag;
            if (getMaaned () == 8)
                return 212 + getDag() + skudDag;
            if (getMaaned () == 9)
                return 243 + getDag() + skudDag;
            if (getMaaned () == 10)
                return 273 + getDag() + skudDag;
            if (getMaaned () == 11)
                return 304 + getDag() + skudDag;

            return 334 + getDag() + skudDag;
        }
    }   //31+28+31+30+31+30+31+31+30+31+30+31 tallene plusset sammen.
    // I denne opgave skal vi finde dag i året.
    public int getIAarShort()
    {
        int skudDag = 0;
        if (skudAar() && getMaaned() > 2)
            skudDag = 1;

        int[] sumDage = new int [12];
        sumDage[0] = 0;
        sumDage[1] = 0;
        sumDage[2] = 31;
        sumDage[3] = 59;
        sumDage[4] = 90;
        sumDage[5] = 120;
        sumDage[6] = 151;
        sumDage[7] = 182;
        sumDage[8] = 212;
        sumDage[9] = 243;
        sumDage[10] = 273;
        sumDage[11] = 304;
        sumDage[12] = 334;

        // kan også skrives int[] sumDage = { 0,0,31,59,90,120,151,182,212,243,273,304,334}

        return getDag()+ skudDag + sumDage [getMaaned()]; // man retunere  getdag + skuddagen som er blevet defineret i øverige opgave. + sumdage,
        //som vi har defineret deroppe. Man kan derfor se fx i måned sumdage 3 er det januar + februar= 59.
    }
    //Opgave 2 Skriv en metode, som kan sætte datoen lig med den næste valide dato 20240630 -> 20240701. setDatoPlusEn()
    public int setDatoPlusEn()
    {   datoen++;
        while (!valid())
        {
            datoen++; //man skal lægge noget til den for at se om den er valid, derfor skriver man datoen++; 2 gange
        }
        return datoen;
    }
    //Opgave 3 Skriv en metode, som kan sætte datoen lig med den forrige valide dato 20000101 -> 19991231. setDatoMinusEn().
    public int setDatoMinusEn()
    {   datoen--;
        while (!valid())
        {
            datoen--;
        }
        return datoen;
    }

    //Opgave 4. Skriv en metode, som kan beregne forskellen i dage mellem to datoer uden at ændre på indholdet af datoerne.
    // Eksempel: 20240609 og 20240714; forskel 35 dage.
    public int forskelIDage(Dato enDato)
    {
        int antalDage = 0;

        Dato kopiDato = new Dato(); // Dette er en deafult konstruktør altså et tomt kontruktør. Det gør vi for at sikre os java ik snyder os
        kopiDato.datoen = datoen; // det oppe i toppen ændrer ikke værdi, så jeg laver en kopi af dem kopidato. så bruger jeg den.
        //så ideen er at retunere forskellen og så den glemt. og ændrer ikke de andre ting.

        if(kopiDato.datoen < enDato.datoen) // her er kopidatoen mindre end enDato.datoen

            while(kopiDato.datoen !=enDato.datoen)   // While ( boolean expression ). det true indtil de ligmed hinanden så det ikke længere true.

            // Metoden vil blive ved at tælle op indtil de er ligmed hinanden, vi tjekker op på om kopidatoen ikke er lig med enDato.
            // Når den er ligmed hinandne er den ikke længere true og metoden er sluttet. Antal forskelidage er derfor fundet.
            {
                kopiDato.setDatoPlusEn();
                antalDage++;
            }

        else
        if ( kopiDato.datoen > enDato.datoen) // her gør vi det omvendt og tjekker om kopidatoen er størst.

            while(kopiDato.datoen !=enDato.datoen)
            {
                kopiDato.setDatoMinusEn();
                antalDage--;
            }
        return antalDage;
    }

    // Opgave 5. man skal have en basis vores basis er at forskellen mellem 1 marts 1700 som var en mandag og en anden uge. Hvis det regnes ud
    // så tallet der kommer ud kan man sige modulus 7 til og så kommer der et tal som er mellem 1 og 7
    public int ugeDag()
    {
        // Vi definere et ny dato vi vil bruge i metoden. Vi kalder den nyDato.
        Dato nyDato = new Dato();
        nyDato.datoen = 17000301;


        return  nyDato.forskelIDage(this)%7+1;
        // this betyder den aktuelle objekt  vi siger modulus 7 fordi der 7 dage på en uge.
        //og vi lægger 1 fordi mandag er jo lig med 1 og tirsdag 2 så det skal gå op.
        // når man siger modulus er der rest, derfor skriver vi +1 så den går op

    }
    // Opgave 5 men bare med tekst istedet.

    // den hedder final siden den ikke bliver ændret på.
    static final String [] ugeDag = {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"};
    public String ugeDagTekst()

    {
        return ugeDag [ugeDag() -1];
        // ugedage returnere 1 -7, men i array strater den fra 0, så man skal sige -1 så den returnere 1 til 7.
        // man kan også sige " " istedet for at sige -1. i arrayen.   man bruger metoden ovenpå "ugeDag" til at lave denne opgave.
    }
}

