import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader extends AbstractFileReader implements FileReaderInterface {

    public JsonFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public void readFile() {
        StringBuilder jsonContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
            // Parsing du contenu JSON
            Map<String, String> jsonData = parseJson(jsonContent.toString());
            // Ajouter chaque valeur au contenu
            content.addAll(jsonData.values());  // Ajoute toutes les valeurs à la liste

        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
        }
    }

    // Méthode de parsing pour des JSON simples (clé-valeur)
    private Map<String, String> parseJson(String jsonString) {
        Map<String, String> map = new HashMap<>();
        jsonString = jsonString.replaceAll("[{}]", ""); // Retirer les accolades

        String[] keyValuePairs = jsonString.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // Ignore les virgules entre guillemets

        for (String pair : keyValuePairs) {
            String[] entry = pair.split(":", 2); // 2 signifie que l'on divise au premier ":"
            if (entry.length == 2) {
                String key = entry[0].trim().replaceAll("\"", ""); // Retire les guillemets
                String value = entry[1].trim().replaceAll("\"", ""); // Retire les guillemets
                map.put(key, value); // Ajoute la paire clé-valeur au map
            }
        }
        return map;
    }

    @Override
    public List<String> getContent() {
        return content;  // Renvoie le contenu lu du fichier
    }

    // Modifier la signature ici
    @Override
    public boolean compareFiles(String filePath1, String filePath2) {
        try {
            // Lire les lignes des deux fichiers
            List<String> contentFile1 = Files.readAllLines(Paths.get(filePath1));
            List<String> contentFile2 = Files.readAllLines(Paths.get(filePath2));

            // Vérifier que les deux fichiers ont le même contenu
            boolean areEqual = contentFile1.equals(contentFile2);

            if (!areEqual) {
                // Affiche les différences
                showDifferences(filePath1, filePath2);
            }

            return areEqual;

        } catch (Exception e) {
            e.printStackTrace();
            return false; // Retourne false en cas d'erreur de lecture
        }
    }

    @Override
    public void displayNormal() {
        super.displayNormal();
    }

    @Override
    public void displayReverse() {
        super.displayReverse();
    }

    @Override
    public void displayPalindromic() {
        super.displayPalindromic();
    }
}
