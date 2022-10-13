public class CaesarCipherTwoClass {
    // Private fields for the alphabet and shiftedAlphabet1, shiftedAlphabet2
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;
    // Constructor
    public CaesarCipherTwoClass(int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        this.key1 = key1;
        this.key2 = key2;
    }
    // Encrypt method
    public String encrypt(String input) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
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
    // Decrypt method
    public String decrypt(String input) {
        CaesarCipherTwoClass cc = new CaesarCipherTwoClass(26 - key1, 26 - key2);
        return cc.encrypt(input);
    }
    // main method
    public static void main(String[] args) {
        CaesarCipherTwoClass cc = new CaesarCipherTwoClass(21, 8);
        String encrypted = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println(encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println(decrypted);
    }
}

