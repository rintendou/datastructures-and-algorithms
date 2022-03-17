package hashtable;

public class Data { // Creating data class. Will be stored in every index of an array.
    public String key;
    public int val;

    /* 
        The purpose of the flag is to mark whether or not data exists.
        If the flag is equal to 0, data does not exist.
        If the flag is equal to 1, data does exist.
    */

    public Data(String key, int val) { // Creates a data object that stores the key and val.
        this.key = key;
        this.val = val;
    }
    
}
