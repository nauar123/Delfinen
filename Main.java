

public class Main {
    public static void main(String[] args) {

        MedlemsOversigt medlemsOversigt = new MedlemsOversigt();
        System.out.println(medlemsOversigt);


        MedlemPersistens medlemPersistens = new MedlemPersistens();

        medlemPersistens.writeMedlemPersistens(medlemsOversigt);
    }
}