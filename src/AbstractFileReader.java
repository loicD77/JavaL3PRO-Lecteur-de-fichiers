import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    // Comparer trois fichiers par leurs contenus
    public boolean compareFiles(String filePath1, String filePath2) {
        try {
            List<String> contentFile1 = Files.readAllLines(Paths.get(filePath1));
            List<String> contentFile2 = Files.readAllLines(Paths.get(filePath2));

            return contentFile1.equals(contentFile2);
        } catch (IOException e) {
            e.printStackTrace();
            return false;  // Retourne false en cas d'erreur de lecture
        }
    }


    // Méthode pour afficher les différences entre deux fichiers
    public void showDifferences(String filePath1, String filePath2) {
        try {
            List<String> contentFile1 = Files.readAllLines(Paths.get(filePath1));
            List<String> contentFile2 = Files.readAllLines(Paths.get(filePath2));

            System.out.println("Différences entre les fichiers :");
            for (int i = 0; i < Math.max(contentFile1.size(), contentFile2.size()); i++) {
                String line1 = i < contentFile1.size() ? contentFile1.get(i) : "Ligne manquante";
                String line2 = i < contentFile2.size() ? contentFile2.get(i) : "Ligne manquante";
                if (!line1.equals(line2)) {
                    System.out.println("Ligne " + (i + 1) + ":");
                    System.out.println("  Fichier 1 : " + line1);
                    System.out.println("  Fichier 2 : " + line2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
