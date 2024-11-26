public class Person {

    protected String navn;
    protected int alder;
    protected String mail;
    protected int tlfNr;


    public Person() {}

    public Person(String navn, int alder, String mail,int tlfNr)
    {
        this.navn = navn;
        this.alder = alder;
        this.mail = mail;
        this.tlfNr = tlfNr;
    }

    public String getNavn()
    {
        return navn;
    }

    public int getAlder()
    {
        return alder;
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
