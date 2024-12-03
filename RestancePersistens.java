import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class RestancePersistens {

    protected Betalinger betalinger;
    protected MedlemsOversigt medlemsOversigt;

    public RestancePersistens(MedlemsOversigt medlemsOversigt)
    {
        this.medlemsOversigt = medlemsOversigt;
        this.betalinger = new Betalinger();
    }

    public void writeRestancePersistens()
    {
        // Fjern den ekstra afsluttende " i filstien
        File restancePersistens = new File("/Users/elev/Desktop/UNI/Programmering/InteliliJ/Delfinen/src/RestancePersistens.txt");

        try (FileWriter writer = new FileWriter(restancePersistens, false)) {
            // Hvis filen er tom, skriv en overskrift
            if (restancePersistens.length() == 0) {
                writer.write("Liste over medlemmere i restance: \n\n");
            }

            // Gør klar til at tilføje medlemmer til restancelisten
            medlemsOversigt.addAlleMedlemmeretoRestanceList();  // Sørg for at denne metode eksisterer
            ArrayList<Medlem> restanceList = medlemsOversigt.getRestance().getRestanceListe();

            // Iterer over listen af medlemmer i restance
            for (int i = 0; i < restanceList.size(); i++) {
                Medlem m = restanceList.get(i);

                // Brug korrekt String.format og writer.append
                writer.append(String.format(
                        "Medlem: %s\n" +
                                "CPR: %s\n" +
                                "Alder: %d\n" +
                                "Aktiv/Passiv: %s\n" +
                                "Skylder: %d DKK\n\n",
                        m.getNavn(),
                        m.cprNr.getCprNr(),
                        m.getAlder(),
                        m.getMedlemsStatus(),
                        betalinger.udregnRestance(m)
                ));

                writer.append(System.lineSeparator());  // Tilføj en ny linje efter hvert medlem
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
