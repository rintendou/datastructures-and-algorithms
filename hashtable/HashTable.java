package hashtable;

import java.util.NoSuchElementException;
import java.util.Objects;

public class HashTable {
    private int maxSize;
    private int count;
    Data[] table;

    public HashTable() { // Default constructor.
        table = new Data[2];
        maxSize = 2;
        count = 0;
    }

    public HashTable(int maxSize) { // Customizable Hash Table size.
        table = new Data[maxSize];
        this.maxSize = maxSize;
        count = 0;
    }

    public int hash(String key) { // Hash function.
        return Math.abs(key.hashCode() % maxSize);
    }

    public void add(String key, int val) {
        if (count == maxSize) { // If the table is full, we cannot add any more.
            System.out.println("The table is full.");
            return;
        }

        int bucket = hash(key); // Turning out key into hash.
        int i = bucket;
        Data data = new Data(key, val); // Create a new Data object with the key and val attached to it.
        
        while (table[i] != null) { // Worst case: O(n) | Best case: O(1) | Error located here.
            if (Objects.equals(table[i].key, key)) {
                System.out.println("Key already exists, updating value.");
                table[i].val = val;
                return;
            }

            i = (i + 1) % maxSize; // Goes to the next index, circularly.
        }

        table[i] = data;
        count++;
        System.out.println("Key: " + key + '\n' + "Value: " + val + '\n' + "Located at " + i + '\n' + "-----");
    }  

    public boolean exists(String key) {
        int bucket = hash(key);
        int i = bucket;

        while (table[i] != null) { // Worst case: O(n)
            if (table[i].key == key) { // Checking to see if the key exists.
                return true;
            } 

            i = (i + 1) % maxSize; // Circularly increment index by 1.

            if (i == bucket) { // If we return back to the original index, we have looped through the entire array and could not find the key.
                return false;
            }
        }

        return false;
    }

    public int get(String key) {
        int bucket = hash(key);
        int i = bucket;

        while (!Objects.equals(table[i].key, key)) { // If the key at the index does not equal the key we are looking for: 
            i = (i + 1) % maxSize; // Circularly increment.

            if (i == bucket) { // If we return back to original location, key does not exist since we visited all elements.
                System.out.println("Key does not exist.");
                throw new NoSuchElementException();
            }
        } // Worst case: O(n) | Best case: O(1)

        return table[i].val;
    }

    public void remove(String key) {
        int bucket = hash(key);
        int i = bucket;

        while (table[i].key != key) { // Checking to see if the key exists.
            i = (i + 1) % maxSize;

            if (i == bucket) {
                System.out.println("Key does not exist.");
                throw new NoSuchElementException();
            }
        }

        table[i] = null; // Setting the index to null.
        count--;
    }
}

