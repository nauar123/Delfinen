import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;

public class Medlem extends Person {

    protected ArrayList<Person> person = new ArrayList();
    protected LocalDate oprettelsesDato;
    protected int medlemsId;
    protected boolean aktivStatus;
    protected boolean erMotionist;
    protected Betalinger betalinger;
    protected boolean erRestance = false;


    public Medlem(String navn, String mail, int tlfNr, CPR cprNr, LocalDate dato, int medlemsId,boolean aktivStatus, boolean erMotionist, Betalinger betalinger, boolean erRestance) {
        super(navn, mail, tlfNr, cprNr);
        this.oprettelsesDato = dato;
        this.medlemsId = medlemsId;
        this.aktivStatus = aktivStatus;
        this.erMotionist = erMotionist;
        this.betalinger = betalinger;
        this.erRestance = erRestance;
    }

    public int getMedlemsId()
    {
        return medlemsId;
    }

    public LocalDate getOprettelsesDato()
    {
        return oprettelsesDato;
    }

    public Boolean getRestance()
    {
        return erRestance;
    }

    public String getMedlemsStatus()
    {
        if (aktivStatus == true)
        {
            return "Aktiv";
        }
        {
            return "Passiv";
        }
    }

    public String getMedlemsType()
    {
        if(erMotionist == true)
        {
            return "Er Motionist";
        }
        return "Er konkurrence deltager";
    }

    public int getAlder()
    {
        return cprNr.getAlder();
    }

    public String getAlderKatogori() {
        int alder = cprNr.getAlder();
        if (alder < 18) {
            return "Junior";
        } else {
            return "Senior";
        }


    }
    public String toString ()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // beskriver, hvordan datoer skal vises.

        return "Medlem: " + navn +  " \n" +
                "CPR:" + cprNr +  " \n" +
                "Alder:" + cprNr.getAlder() +  " \n" +
                " Junior/Senior:" + getAlderKatogori() + "\n" +
                "Mail:" + mail + "\n" +
                "TelefonNr:" + tlfNr + "\n" +
                "Oprettelsesdato:" + oprettelsesDato + "\n" +
                "Medlemdsid:" + medlemsId + "\n" +
                "Aktivtivesstatus:" + getMedlemsStatus() + "\n" +
                "Motionists/Kokurrence deltager:" + getMedlemsType() + "\n" +
                "Skal betale:" + betalinger.udregnBetalinger(this) + "DKK" + " \n " +
                "Skylder:" + betalinger.udregnRestance(this) + "DDK" + "\n\n";


    }


}
