public class Main {
    public static void main(String[] args) {
        // Opret MedlemsOversigt objekt og generer medlemmer
        MedlemsOversigt medlemsOversigt = new MedlemsOversigt();

        // Opret MedlemPersistens objekt
        MedlemPersistens medlemPersistens = new MedlemPersistens();

        // Skriv alle medlemmerne til Medlempersistens
        medlemPersistens.writeMedlemPersistens(medlemsOversigt.getMedlemmerOversigt());




    }
}


