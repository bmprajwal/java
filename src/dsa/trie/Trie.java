package dsa.trie;

public class Trie {

    static class Node{
        Node[] children;
        boolean eow;
        public Node(){
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }

    }
    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            if(i == word.length() - 1){
                curr.children[index].eow = true;
            }
            curr = curr.children[index];
        }
    }

    public static boolean search(String key){ // O(L) L-> key.length()
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            Node node = curr.children[index];
            if(node == null){
                return false;
            }
            if(i == key.length() - 1 && !node.eow){
                return false;
            }
            curr = node;
        }
        return true;
    }
    public static boolean startsWith(String key){ // O(L) L-> key.length()
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            Node node = curr.children[index];
            if(node == null){
                return false;
            }
            curr = node;
        }
        return true;
    }
    public static boolean wordbreak(String key){
        if(key.isEmpty()){
            return true;
        }
        int n = key.length();
        for(int i = 1; i<=n; i++){
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i, n);
            if(search(firstPart) && wordbreak(secondPart)){
                return true;
            }
        }
        return false;
    }

    public static int countNode(Node root){
        if(root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null){
                count += countNode(root.children[i]);
            }
        }
        return count + 1;
    }
    static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].eow){
                temp.append((char)(i + 'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }

                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
    public static void main(String[] args) {
//        String[] words = {"their", "any", "and", "thor", "they", "some"};
//        for (String word : words) {
//            insert(word);
//        }
//
//        System.out.println(startsWith("a"));
//        String word = "apple";
//        for (int i = 0; i < word.length(); i++) {
//            insert(word.substring(i));
//        }
//
//        System.out.println(countNode(root));

        String[] words = {"a", "ap", "app", "banana", "appl", "apply"};
        for (String word : words) {
            insert(word);
        }
        longestWord(root, new StringBuilder());
        System.out.println(ans);

    }
}
