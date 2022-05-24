import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    private List<Map<String, String>> hashList;

    public List<Map<String, String>> getHashList() {
        return hashList;
    }

    public SymbolTable() {
        this.hashList = new ArrayList<>(8);
        for(int i=0;i<8;i++ ){
            this.hashList.add(new LinkedHashMap<>());
        }
    }
    public void addSymbol(){

    }
    public void printTable() {
        hashList.forEach(stringStringMap -> {
            stringStringMap.forEach((x, y) -> {
                System.out.println(x + " " + y);
            });
        });
    }
}
