import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {
        SymbolTable dupa = new SymbolTable();
        dupa.getHashList().get(0).put("string1","string");
        dupa.getHashList().get(0).put("string2","string");
        dupa.getHashList().get(0).put("string3","string");
        dupa.getHashList().get(0).put("string4","string");
        dupa.printTable();
    }
}