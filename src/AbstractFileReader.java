import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public abstract class AbstractFileReader {
    protected String filePath;
    protected List<String> content;

    public AbstractFileReader(String filePath) {
        this.filePath = filePath;
        this.content = new ArrayList<>();
        readFile();  // Appel de la méthode pour lire le fichier
    }

    // Méthode abstraite pour la lecture de fichier, à implémenter par les sous-classes
    public abstract void readFile();

    // Afficher le contenu du fichier normalement
    public void displayNormal() {
        content.forEach(System.out::println);
    }

    // Afficher le contenu du fichier à l'envers
    public void displayReverse() {
        for (int i = content.size() - 1; i >= 0; i--) {
            System.out.println(content.get(i));
        }
    }

    // Afficher le contenu du fichier de manière palindromique
    public void displayPalindromic() {
        content.forEach(line -> System.out.println(new StringBuilder(line).reverse().toString()));
    }

    // Comparer deux fichiers par leurs contenus
    public boolean compareFiles(String filePath1, String filePath2) {
        try {
            // Lire les lignes des deux fichiers
            List<String> contentFile1 = Files.readAllLines(Paths.get(filePath1));
            List<String> contentFile2 = Files.readAllLines(Paths.get(filePath2));

            // Comparer le contenu des deux fichiers
            return contentFile1.equals(contentFile2);
        } catch (IOException e) {
            e.printStackTrace();
            return false;  // Retourne false en cas d'erreur de lecture
        }
    }
}
