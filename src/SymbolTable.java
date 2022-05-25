import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SymbolTable {
    private final List<Map<String, String>> hashList;

    public SymbolTable() {
        this.hashList = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            this.hashList.add(new LinkedHashMap<>());
        }
    }

    public List<Map<String, String>> getHashList() {
        return hashList;
    }

    private int hashFunction(String symbol) {
        int hashedSymbol = 0;
        for (int i = 0; i < symbol.length(); i++) {
            int asciiCharVal = symbol.charAt(i);
            hashedSymbol += asciiCharVal;
        }
        hashedSymbol = hashedSymbol % 8;
        return hashedSymbol;
    }

    public void addSymbol(String key, String value) {
        int index = this.hashFunction(key);
        this.hashList.get(index).put(key, value);
    }

    public void removeSymbol(String key) {
        if (findSymbol(key)) {
            int index = hashFunction(key);
            this.hashList.get(index).remove(key);
            System.out.println("Removal successful\n");
        } else {
            System.out.println(key + " Not found\nThere is no table entry with such key");
        }
    }

    public boolean findSymbol(String key) {
        int index = this.hashFunction(key);
        for (int i = 0; i < this.hashList.get(index).size(); i++) {
            if (this.hashList.get(index).containsKey(key)) {
                return true;
            }
        }
        return false;
    }

    public void getSymbol(String key) {
        if (findSymbol(key)) {
            int index = hashFunction(key);
            System.out.println("Table index " + index + ": Key: " + key + ", Value: " + this.hashList.get(index).get(key));

        } else {
            System.out.println(key + "Not found\nThere is no table entry with such key\n");
        }

    }

    public void printTable() {
        /*hashList.forEach(stringStringMap -> {
            stringStringMap.forEach((x, y) -> {
                System.out.println("Table index:" + hashFunction(x) + ". Key: " + x + ", Value:" + y);
            });
        });*/
        for (int i = 0; i < 8; i++) {
            if (this.hashList.get(i).isEmpty()) System.out.print("Table index " + i + ": NULL");
            else System.out.print("Table index " + i + ": ");
            AtomicInteger j= new AtomicInteger();
            this.hashList.get(i).forEach((x, y) -> {

                System.out.print(j+". Key: " + x + ", Value: " + y+" ");
                j.getAndIncrement();
            });
            System.out.println("\n");
        }
    }
}
