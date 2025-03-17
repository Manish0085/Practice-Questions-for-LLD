package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {

    static class HashMap<K, V> {  // Generic HashMap Implementation
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // Number of key-value pairs
        private int N; // Number of buckets
        private LinkedList<Node>[] bucket;

        public HashMap() {
            this.N = 4;
            bucket = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                bucket[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hash = key.hashCode();
            return Math.abs(hash) % N;
        }

        private int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> linkedList = bucket[bucketIndex];
            for (int i = 0; i < linkedList.size(); i++) {
                if (linkedList.get(i).key.equals(key)) { // Use equals() instead of ==
                    return i;
                }
            }
            return -1;
        }

        private void reHashing() {
            LinkedList<Node>[] oldBucket = bucket;
            N = 2 * N; // Update the size
            bucket = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                bucket[i] = new LinkedList<>();
            }

            for (LinkedList<Node> ll : oldBucket) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if (dataIndex == -1) {                                     // Key doesn't exist
                bucket[bucketIndex].add(new Node(key, value));
                n++;
            } else {                                                   // Key exists
                Node node = bucket[bucketIndex].get(dataIndex);
                node.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                reHashing();
            }
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if (dataIndex == -1) { // Key doesn't exist
                return null;
            } else { // Key exists
                return bucket[bucketIndex].get(dataIndex).value;
            }
        }

        public boolean containsKey(K key) {
            return searchInLL(key, hashFunction(key)) != -1;
        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if (dataIndex == -1) {                                       // Key doesn't exist
                return null;
            } else {                                                      // Key exists
                Node node = bucket[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }
        }

        public int size(){
            return n;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (LinkedList<Node> nodes : bucket) {
                for (Node node : nodes) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 400);
        map.put("Australia", 200);
        map.put("Canada", 150);
        map.put("SriLanka", 300);  // Fixed spelling

        ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }

        System.out.println("\n\n"+map.size()+"\n\n");
        System.out.println(map.remove("India"));

        System.out.println();
        ArrayList<String> set = map.keySet();
        for (String key : set) {
            System.out.println(key + " " + map.get(key));
        }
        System.out.println("\n\n"+map.size()+"\n\n");
    }
}
