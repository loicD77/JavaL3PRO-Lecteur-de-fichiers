public class FileReaderApp {
    public static void main(String[] args) {
        // Mets à jour le chemin de tes fichiers
        String txtFilePath = "C:\\Users\\darra\\OneDrive\\Documents\\txtjava\\myFile.txt";
        String csvFilePath = "C:\\Users\\darra\\OneDrive\\Documents\\txtjava\\myFile.csv";

        // Création d'un lecteur de fichier texte pour un fichier donné
        FileReaderInterface txtReader = new TxtFileReader(txtFilePath);

        // Affichage du fichier TXT
        System.out.println("Normal Display of TXT:");
        txtReader.displayNormal();

        System.out.println("\nReverse Display of TXT:");
        txtReader.displayReverse();

        System.out.println("\nPalindromic Display of TXT:");
        txtReader.displayPalindromic();

        // Création d'un lecteur de fichier CSV
        FileReaderInterface csvReader = new CsvFileReader(csvFilePath);

        // Affichage du fichier CSV en mode normal, inversé et palindromique
        System.out.println("\nNormal Display of CSV:");
        csvReader.displayNormal();

        System.out.println("\nReverse Display of CSV:");
        csvReader.displayReverse();

        System.out.println("\nPalindromic Display of CSV:");
        csvReader.displayPalindromic();
    }
}
