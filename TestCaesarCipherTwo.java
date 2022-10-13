import java.io.*;;

public class TestCaesarCipherTwo{
    // halfOfString method
    public static String halfOfString(String message, int start) {
        StringBuilder half = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            half.append(message.charAt(i));
        }
        return half.toString();
    }
    // Count letters method
    public static int[] countLetters(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alphabet.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    // Max index method
    public static int maxIndex(int[] vals) {
        int maxDex = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] > vals[maxDex]) {
                maxDex = i;
            }
        }
        return maxDex;
    }
    // Simple test of the CaesarCipherTwoClass
    public static void simpleTests() {
        String message = "";
        String line = "";
        try {
            /* Read message from file */
            File file = new File("CharacterStuff\\message1.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            /* Read file line by line and store into the message */
            
            while ((line = br.readLine()) != null) {
                message += line + "\n";
            }
            br.close();

        } catch (IOException e) {
        }
        System.out.println("Message: " + message);
        CaesarCipherTwoClass cc = new CaesarCipherTwoClass(17, 3);
        String encrypted = cc.encrypt(message);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println(decrypted);
    }
    // Break Caesar Cipher method
    public static void breakCaesarCipher(String input) {
        String s1 = halfOfString(input, 0);
        String s2 = halfOfString(input, 1);
        int key1 = maxIndex(countLetters(s1));
        int key2 = maxIndex(countLetters(s2));
        System.out.println("Key1: " + key1 + " Key2: " + key2);
        CaesarCipherTwoClass cc = new CaesarCipherTwoClass(key1, key2);
        System.out.println(cc.decrypt(input));
    }

    // main method
    public static void main(String[] args) {
        breakCaesarCipher("");
    }

}