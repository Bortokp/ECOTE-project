import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        return 0;
    }

    public void addSymbol() {

    }

    public void printTable() {
        hashList.forEach(stringStringMap -> {
            stringStringMap.forEach((x, y) -> {
                System.out.println(x + " " + y);
            });
        });
    }
}
