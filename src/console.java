public class console {
    public static void main(String[] args) {
        SymbolTable tablica = new SymbolTable();
        tablica.addSymbol("ABC","string");
        tablica.addSymbol("CBA","string");
        tablica.addSymbol("WL1","string");
        tablica.addSymbol("WL2","string");
        tablica.addSymbol("WL3","string");
        tablica.addSymbol("WL3","string2");
        tablica.printTable();

    }
}