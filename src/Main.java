import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");
        readFrench();
    }

    public static void writeToFrench(String word, String translation) {
        System.out.println("Writing");
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("French.txt", true));
            writer.println(word + ", " + translation);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFrench() throws FileNotFoundException {
        try {
            Scanner reader1 = new Scanner(Paths.get("FrenchWords"));
            Scanner reader2 = new Scanner(Paths.get("Translations"));
            while (reader1.hasNextLine()) {
                String line = reader1.nextLine();
                String line2 = reader2.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String word = line.trim();
                String word2 = line2.trim();
                writeToFrench(word, word2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}