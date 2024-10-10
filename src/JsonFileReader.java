import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class JsonFileReader extends AbstractFileReader {

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
            // Simple parsing of the JSON-like content
            Map<String, String> jsonData = parseJson(jsonContent.toString());
            content.add(jsonData.toString()); // Ajouter le contenu à la liste

        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
        }
    }

    // Méthode de parsing très basique pour des JSON simples (clé-valeur)
    private Map<String, String> parseJson(String jsonString) {
        Map<String, String> map = new HashMap<>();

        jsonString = jsonString.replaceAll("[{}\"]", ""); // Retirer les accolades et les guillemets
        String[] keyValuePairs = jsonString.split(",");

        for (String pair : keyValuePairs) {
            String[] entry = pair.split(":");
            if (entry.length == 2) {
                String key = entry[0].trim();
                String value = entry[1].trim();
                map.put(key, value);
            }
        }
        return map;
    }
}