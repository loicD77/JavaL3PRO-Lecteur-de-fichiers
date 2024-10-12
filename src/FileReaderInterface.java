import java.util.List;

public interface FileReaderInterface {
    void readFile();  // Méthode pour lire le fichier
    void displayNormal();  // Affiche le contenu
    void displayReverse();  // Affiche le contenu en inversé
    void displayPalindromic();  // Affiche chaque ligne inversée
    boolean compareFiles(String filePath1, String filePath2);  // Compare deux fichiers
    List<String> getContent();  // Renvoie le contenu du fichier
}
