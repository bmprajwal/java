package dsa.hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCustom {
    static class HashMap<K, V>{
        private class Node{
            K key;
            V val;

            Node(K key, V val){
                this.key = key;
                this.val = val;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }
        public void put(K key, V val){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){
                buckets[bi].add(new Node(key, val));
                n++;
            } else {
                buckets[bi].get(di).val = val;
            }

            double lambda = (double) n / N;

            if(lambda > 2){
                rehash();
            }

        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){
                return null;
            }

            return buckets[bi].get(di).val;
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di == -1){
                return null;
            }

            Node node = buckets[bi].remove(di);
            n--;
            return node.val;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> arrayList = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    arrayList.add(node.key);
                }
            }
            return arrayList;
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        public boolean isEmpty(){
            return n == 0;
        }

        @Override
        public String toString(){
            String str = "[";
            ArrayList<K> list = keySet();
            for(K key: list){
                str = str + key + ", ";
            }
            str += "]";
            return str;
        }

        private int hashFunction(K key){
            int hashValue = key.hashCode();
            return Math.abs(hashValue) % N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> list = buckets[bi];
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node>[] oldbucket = buckets;
            buckets = new LinkedList[N*2];
            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldbucket.length; i++) {
                LinkedList<Node> ll = oldbucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.val);
                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("China", 150);
        ArrayList<String> keys = map.keySet();
        for(String key: keys){
            System.out.println(key + " " + map.get(key));
        }
        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("US"));
        System.out.println(map.isEmpty());
        System.out.println(map);
        System.out.println(map.remove("India"));
        System.out.println(map.remove("China"));
        System.out.println(map.isEmpty());
        System.out.println(map.containsKey("India"));
        System.out.println(map);
    }
}
