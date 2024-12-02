import java.time.LocalDate;

public abstract class Person {

    protected String navn;
    protected String mail;
    protected int tlfNr;
    protected CPR cprNr;

    public Person() {}

    public Person(String navn, String mail,int tlfNr, CPR cprNr)
    {
        this.navn = navn;
        this.mail = mail;
        this.tlfNr = tlfNr;
        this.cprNr = cprNr;
    }

    public String getNavn()
    {
        return navn;
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
