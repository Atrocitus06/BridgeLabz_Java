package datastructure.stackqueuehashmap;
class HashNode {
    int key, value;
    HashNode next;

    HashNode(int k, int v) {
        key = k;
        value = v;
    }
}

public class CustomHashMap {
    private HashNode[] table = new HashNode[10];

    void put(int key, int value) {
        int index = key % table.length;
        HashNode node = new HashNode(key, value);

        if (table[index] == null) {
            table[index] = node;
            return;
        }

        HashNode temp = table[index];
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    int get(int key) {
        int index = key % table.length;
        HashNode temp = table[index];

        while (temp != null) {
            if (temp.key == key)
                return temp.value;
            temp = temp.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 100);
        map.put(11, 200);
        System.out.println(map.get(11));
    }
}

