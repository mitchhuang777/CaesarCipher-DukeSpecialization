public class CaesarCipherClass {
    /* Private fields for the alphabet and shiftedAlphabet */
    private String alphabet;
    private String shiftedAlphabet;
    private String key;
    /* Constructor */
    public CaesarCipherClass(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        this.key = String.valueOf(key);
    }
    /* encrypt */
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
    /* decrypt */
    public String decrypt(String input) {
        CaesarCipherClass cc = new CaesarCipherClass(26 - Integer.parseInt(key));
        return cc.encrypt(input);
    }

    /* test encrypt */
    public static void testEncrypt() {
        CaesarCipherClass cc = new CaesarCipherClass(15);
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = cc.encrypt(message);
        System.out.println("Original message: " + message);
        System.out.println("Encrypted message: " + encrypted);
        System.out.println("Decrypted message: " + cc.decrypt(encrypted));
    }
    /* main */
    public static void main(String[] args) {
        testEncrypt();
    }
}

