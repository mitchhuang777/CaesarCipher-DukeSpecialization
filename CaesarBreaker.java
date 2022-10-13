import java.io.*;

public class CaesarBreaker {
    /* CountLetters */
    public static int[] countLetters(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alphabet.indexOf(ch);
            if (dex != -1) {
                counts[dex]++;
            }
        }
        return counts;
    }

    /* MaxIndex */
    public static int maxIndex(int[] values) {
        int maxDex = 0;
        for (int k = 0; k < values.length; k++) {
            if (values[k] > values[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }

    /* Decrypt */
    public static String decrypt(String encrypted) {
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return CaesarCipher.encrypt(encrypted, 26 - dkey);
    }

    /* test Decrypt */
    public static void testDecrypt() {
        try {
            /* Read message from file */
            File file = new File("CharacterStuff\\wordsLotsOfEs.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            /* Read file line by line and store into the message */
            String message = "";
            String line = "";
            while ((line = br.readLine()) != null) {
                message += line + "\n";
            }
            br.close();
            String decrypted = decrypt(message);
            System.out.println(decrypted);
        } catch (IOException e) {
        }
    }

    /* HalfOfString */
    public static String halfOfString(String message, int start) {
        String half = "";
        for (int k = start; k < message.length(); k += 2) {
            half += message.charAt(k);
        }
        return half;
    }

    /* test HalfOfString */
    public static void testHalfOfString() {
        String message = "Qbkm Zgis";
        String half = halfOfString(message, 0);
        System.out.println(half);
        half = halfOfString(message, 1);
        System.out.println(half);
    }

    /* getKey */
    public static int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }

    /* decryptTwoKeys */
    public static String decryptTwoKeys(String encrypted) {
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        // int key1 = 14;
        // int key2 = 24;
        System.out.println("key1 = " + key1 + ", key2 = " + key2);
        return CaesarCipher.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
    }

    /* test decryptTwoKeys */
    public static void testDecryptTwoKeys() {
        try {
            /* Read message from file */
            File file = new File("CharacterStuff\\mysteryTwoKeysQuiz.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            /* Read file line by line and store into the message */
            String message = "";
            String line = "";
            while ((line = br.readLine()) != null) {
                message += line + "\n";
            }
            br.close();
            String decrypted = decryptTwoKeys(message);
            System.out.println(decrypted);
        } catch (IOException e) {
        }
    }

    /* main */
    public static void main(String[] args) {
        testDecrypt();
        testHalfOfString();
        testDecryptTwoKeys();
    }
}
