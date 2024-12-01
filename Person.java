import java.time.LocalDate;

public abstract class Person {

    protected String navn;
    protected int foedelsdato;
    protected String mail;
    protected int tlfNr;


    public Person() {}

    public Person(String navn, int foedelsdato, String mail,int tlfNr)
    {
        this.navn = navn;
        this.foedelsdato = foedelsdato;
        this.mail = mail;
        this.tlfNr = tlfNr;

    }

    public String getNavn()
    {
        return navn;
    }

    public int getFoedelsdato()
    {
        return foedelsdato;
    }

    public String getMail()
    {
        return mail;
    }

    public int getTlfNr()
    {
        return tlfNr;
    }





}
