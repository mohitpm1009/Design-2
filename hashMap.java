//Used array and Node implemetation 
//Time complexity for put(key, value)
//                   Avg time - O(1) - when distribution of keys are good
//                   Worst case - O(n) - when the nodes are placed in the same index
// Time complexity for get(key)
//                   Avg time - O(1) - when distribution of keys are good and they are placed in different indices
//                   Worst case - O(n) - when nodes are placed in the same index
// Time complexity for remove(key)
//                   Avg time - O(1) - when distribution of keys are good and they are placed in different indices
//                   Worst case - O(n) - when nodes are placed in the same index 
// Space complexity - O(n) - because - for array - O[SIZE] + for Node O(n) because n nodes are created if we add O(SIZE+n) = O(n) because SIZE is constant


class MyHashMap {

    private static final int SIZE = 1000;
    private Node[] map;

    private class Node {
        int key;
        int value;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.value = val;
            this.next = null;
        }
    }
    public MyHashMap() {
        map = new Node[SIZE];
    }

    private int getIndex(int key) {
        return Math.abs(Integer.hashCode(key)) % SIZE;
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        Node current = map[index];
        if (current == null) {
            map[index] = new Node(key, value);
            return;
        }

        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            if (current.next == null) break;
            current = current.next;
        }

        current.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = getIndex(key);
        Node current = map[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Node current = map[index];
        Node previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    map[index] = current.next;
                } 
                else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */