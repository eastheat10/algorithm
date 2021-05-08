package fastcampus.datastructure.hashtable;

public class MyHashTable {

    public Slot[] hashTable;

    public MyHashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        public Slot(String value) {
            this.value = value;
        }
    }

    public int hashFunction(String key) {
        return ((int)(key.charAt(0))) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = this.hashFunction(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
            return false;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        int address = this.hashFunction(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashTable ht = new MyHashTable(20);
        ht.saveData("sudal", "4543");
        ht.saveData("dong", "1813");
        ht.saveData("hollys", "hallo");
        String sudal = ht.getData("sudal");
        System.out.println(sudal);
    }

}
