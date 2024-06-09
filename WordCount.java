import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) throws IOException {
        // Specify the file to read
        String fileName = "C:\\example.txt";

        // Create a HashMap to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        // Read the file and count word occurrences
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words (ignoring punctuation and whitespace)
                String[] words = line.split("\\W+");

                // Count the occurrences of each word
                for (String word : words) {
                    word = word.toLowerCase(); // Ignore case sensitivity
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Create a TreeMap to store word counts in alphabetical order
        Map<String, Integer> sortedWordCounts = new TreeMap<>(wordCounts);

        // Display the word count for each unique word
        for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}