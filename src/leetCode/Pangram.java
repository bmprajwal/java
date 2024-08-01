package leetCode;

public class Pangram {
    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
    static public boolean checkIfPangram(String sentence) {
        int[] count = new int[26];
        for(int i = 0; i < sentence.length(); i++){
            count[sentence.charAt(i) % 97]++;
        }
        for(int n: count){
            if(n == 0){
                return false;
            }
        }
        return true;
    }
}
