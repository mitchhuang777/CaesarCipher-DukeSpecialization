public class WordPlay {
    /* isVowel */
    public static boolean isVowel(char ch){
        String vowels = "aeiouAEIOU";
        if(vowels.indexOf(ch) != -1){
            return true;
        }
        return false;
    }

    /* replaceVowels */
    public static String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        for(int i=0; i<phrase.length(); i++){
            char currChar = phrase.charAt(i);
            if(isVowel(currChar)){
                sb.setCharAt(i, ch);
            }
        }
        return sb.toString();
    }
    /* emphasize */
    public static String emphasize(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        for(int i=0; i<phrase.length(); i++){
            char currChar = phrase.charAt(i);
            if(Character.toLowerCase(currChar) == Character.toLowerCase(ch)){
                if(i%2 == 0){
                    sb.setCharAt(i, '*');
                }
                else{
                    sb.setCharAt(i, '+');
                }
            }
        }
        return sb.toString();
    }
    /* main function to test the WordPlay class */
    public static void main(String[] args){
        char ch = 'F';
        System.out.println(isVowel(ch));
        String phrase = "Hello World";
        System.out.println(replaceVowels(phrase, '*'));
        String phrase2 = "Mary Bella Abracadabra";
        System.out.println(emphasize(phrase2, 'a'));
    }
    
}
