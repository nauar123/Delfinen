import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MedlemPersistens {


    public void writeMedlemPersistens(Medlem medlem) {
        File medlemsListe = new File("/Users/elev/Desktop/UNI/Programmering/InteliliJ/Delfinen/src/MedlemPersistens.txt");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH.mm");
        LocalDate currentDate = LocalDate.now();

        try (FileWriter writer = new FileWriter(medlemsListe, true))
        {


            String formattedDate = dateFormatter.format(currentDate);
            String formattedTime = timeFormatter.format(currentDate);


            writer.write("Navn:" + medlem.getNavn() + "\n");
            writer.write("Email:" + medlem.getMail() + "\n");
            writer.write("TelefonNr:" + medlem.getTlfNr() + "\n");
            writer.write("Oprettelsesdato:" + medlem.oprettelsesDato + "\n");
            writer.write()


        } catch (IOException e) {
            e.printStackTrace();

        }

        }

    }
