public abstract class  Medlemstype implements Medlemsstatus{

    protected String type;
    protected String aktivtetsform;

    public Medlemstype() {}

    public Medlemstype(String type, String aktivtetsform)
    {
        this.type = type;
        this.aktivtetsform = aktivtetsform;
    }

    public String getType()
    {
        return type;
    }

    public String getAktivtetsform()
    {
        return aktivtetsform;
    }

    @Override
    public String erAktiv()
    {
       return "Medlemstype er Aktiv";
    }

    public String erPassiv()
    {
      return "Medlemstype er Passiv";
    }
}
