import java.io.*;

public class CaesarCipher {
    public static String encrypt(String input, int key) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        // Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        // Count from 0 to < length of encrypted, (call it i)
        for (int i = 0; i < encrypted.length(); i++) {
            // Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            // Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            // If currChar is in the alphabet
            if (idx != -1) {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                // If currChar is in lowercase, then newChar is lowercase
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
        }
        // Your answer is the String inside of encrypted
        return encrypted.toString();
    }

    // main function to test the CaesarCipher class
    public static void main(String[] args) {
        int key = 17;
        /* Read file to String using FileReader */
        try {
            FileReader fr = new FileReader("wordsLotsOfEs.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String message = "";
            while (line != null) {
                message += line;
                line = br.readLine();
            }
            System.out.println("Original message: " + message);
            String encrypted = encrypt(message, key);
            System.out.println("Encrypted message: " + encrypted);
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        testEncryptTwoKeys();

    }

    /* encryptTwoKeys */
    public static String encryptTwoKeys(String input, int key1, int key2) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        // Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        // Count from 0 to < length of encrypted, (call it i)
        for (int i = 0; i < encrypted.length(); i++) {
            // Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            // Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            // If currChar is in the alphabet
            if (idx != -1) {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar;
                if (i % 2 == 0) {
                    newChar = shiftedAlphabet1.charAt(idx);
                } else {
                    newChar = shiftedAlphabet2.charAt(idx);
                }
                // If currChar is in lowercase, then newChar is lowercase
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
        }
        // Your answer is the String inside of encrypted
        return encrypted.toString();
    }

    /* test encryptTwoKeys */
    public static void testEncryptTwoKeys() {
        String message = "First Legion";
        int key1 = 23;
        int key2 = 17;
        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println("Original message: " + message);
        System.out.println("Encrypted message: " + encrypted);
    }
}