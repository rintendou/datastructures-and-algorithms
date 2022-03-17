package hashtable;

public class HashTableTester {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        hashTable.add("Danny", 19);
        hashTable.add("Sister", 21);
        hashTable.add("Dad", 56);
        hashTable.add("Mom", 49);
        hashTable.add("Grandma", 70);

        System.out.println(hashTable.exists("Grandma"));

        hashTable.remove("Sister");
        System.out.println(hashTable.exists("Sister"));
        System.out.println(hashTable.get("Danny"));


    }
}
