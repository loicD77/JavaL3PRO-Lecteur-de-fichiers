import java.io.IOException; // Importation de la classe IOException

public class FileReaderApp {
    public static void main(String[] args) {
        // Mets à jour le chemin de mes fichiers
        String txtFilePath = "C:\\Java\\Mes projets\\textjava\\myFile.txt";
        String csvFilePath = "C:\\Java\\Mes projets\\textjava\\myFile.csv";
        String jsonFilePath = "C:\\Java\\Mes projets\\textjava\\myFile.json";

        // Création des lecteurs de fichiers
        TxtFileReader txtFileReader = new TxtFileReader(txtFilePath);
        CsvFileReader csvFileReader = new CsvFileReader(csvFilePath);
        JsonFileReader jsonFileReader = new JsonFileReader(jsonFilePath);

        // Comparer tous les fichiers
        boolean areEqualTxtCsv = txtFileReader.compareFiles(txtFilePath, csvFilePath);
        boolean areEqualCsvJson = csvFileReader.compareFiles(csvFilePath, jsonFilePath);
        boolean areEqualTxtJson = txtFileReader.compareFiles(txtFilePath, jsonFilePath);


        // Afficher les résultats de la comparaison
        System.out.println("Les fichiers TXT et CSV sont égaux : " + areEqualTxtCsv);
        System.out.println("Les fichiers CSV et JSON sont égaux : " + areEqualCsvJson);
        System.out.println("Les fichiers TXT et JSON sont égaux : " + areEqualTxtJson);

        System.out.println("------------------------------------------------------------");

        // Afficher les différences si les fichiers ne sont pas égaux
        if (!areEqualTxtCsv) {
            txtFileReader.showDifferences(txtFilePath, csvFilePath);
        }
        if (!areEqualCsvJson) {
            csvFileReader.showDifferences(csvFilePath, jsonFilePath);
        }
        if (!areEqualTxtJson) {
            txtFileReader.showDifferences(txtFilePath, jsonFilePath);
        }

        System.out.println("-------------------------------------------------------------");
        // Affichage des fichiers en modes normal, inversé et palindromique
        displayFileContents(txtFileReader, "TXT");
        displayFileContents(csvFileReader, "CSV");
        displayFileContents(jsonFileReader, "JSON");
    }

    // Méthode pour afficher le contenu d'un fichier
    private static void displayFileContents(FileReaderInterface reader, String fileType) {
        System.out.println("\nNormal Display of " + fileType + ":");
        reader.displayNormal();

        System.out.println("\nReverse Display of " + fileType + ":");
        reader.displayReverse();

        System.out.println("\nPalindromic Display of " + fileType + ":");
        reader.displayPalindromic();
    }
}
