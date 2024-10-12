import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class CsvFileReader extends AbstractFileReader implements FileReaderInterface {

    public CsvFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line); // Ajouter chaque ligne au contenu
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }
    }

    @Override
    public List<String> getContent() {
        return content;  // Renvoie le contenu lu du fichier
    }
}
