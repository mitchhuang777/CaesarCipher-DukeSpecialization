import java.io.*;

public class WordLengths {
    /* Count word length */
    public static void countWordLengths(String message, int[] counts) {
        /* Split words to word */
        String[] words = message.split(" ");
        // for String word and word not empty

        for (String word : words) {
            if (!word.isEmpty()) {
                int wordLength = word.length();

                if (!Character.isLetter(word.charAt(wordLength - 1))) {
                    wordLength--;
                }
                if (!Character.isLetter(word.charAt(0))) {
                    wordLength--;
                }

                if (wordLength >= counts.length) {
                    counts[counts.length - 1]++;
                } else if (wordLength > 0) {
                    counts[wordLength]++;
                }
            }
        }
    }

    /* Index of the largest element in values */
    public static int indexOfMax(int[] values) {
        int maxIndex = 0;
        for (int k = 0; k < values.length; k++) {
            if (values[k] > values[maxIndex]) {
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    /* Test Count Word Length */
    public static void testCountWordLengths() {
        try {
            /* Read message from file */
            File file = new File("CharacterStuff\\errors.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String message = "";
            String line;
            while ((line = br.readLine()) != null) {
                message += line + "\n";
            }
            br.close();
            System.out.println(message);

            int[] counts = new int[31];
            countWordLengths(message, counts);

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    System.out.println(counts[i] + " words of length " + i);
                }
            }
            int maxIndex = indexOfMax(counts);
            System.out.println("Most common word length in the file is " + maxIndex);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }

    }

    public static void main(String[] args) {
        testCountWordLengths();
    }
}
