import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class TraenerPersistens {

    protected ArrayList<Traener> traeners;

    public TraenerPersistens(ArrayList<Traener> traeners) {
        this.traeners = traeners;
    }


    public void writeTraenerToFile() {
        File traenerFile = new File("/Users/elev/Desktop/UNI/Programmering/InteliliJ/Delfinen/src/TraenerPersistens.txt");

        try (FileWriter writer = new FileWriter((traenerFile))) {
            writer.write("Liste over trænere:\n\n");

            for (int i = 0; i < traeners.size(); i++) {
                Traener t = traeners.get(i);
                writer.write(t.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}