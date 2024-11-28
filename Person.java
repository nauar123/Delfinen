public abstract class Person {

    protected String navn;
    protected int foedselsDato;
    protected String mail;
    protected int tlfNr;


    public Person() {}

    public Person(String navn, int foedselsDato, String mail,int tlfNr)
    {
        this.navn = navn;
        this.foedselsDato = foedselsDato;
        this.mail = mail;
        this.tlfNr = tlfNr;
    }

    public String getNavn()
    {
        return navn;
    }

    public int getFoedselsDato()
    {
        return foedselsDato;
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
