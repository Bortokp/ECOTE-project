public class console {
    public static void main(String[] args) {
        SymbolTable tablica = new SymbolTable();
        tablica.getHashList().get(0).put("string1", "string");
        tablica.getHashList().get(0).put("string2", "string");
        tablica.getHashList().get(0).put("string3", "string");
        tablica.getHashList().get(0).put("string4", "string");
        tablica.printTable();
    }
}