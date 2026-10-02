import java.util.*;

public class Stop_Word_Filtered_Word_Frequency {

    static void printFilteredWordFrequency(String feedback) {

        // Stop words
        Set<String> stopWords = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
        );

        // Convert to lowercase and remove punctuation
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        // Split into words
        String[] words = cleaned.split("\\s+");

        // Count frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            frequency.put(
                word,
                frequency.getOrDefault(word, 0) + 1
            );
        }

        // Sort by count in descending order
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort(
            (a, b) -> b.getValue().compareTo(a.getValue())
        );

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}