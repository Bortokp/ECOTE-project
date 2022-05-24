public class Main extends ConsoleInterface {
    public static void main(String[] args) {
        SymbolTable tablica = new SymbolTable();
        tablica.addSymbol("ABC","String");
        tablica.addSymbol("CBA","String");
        tablica.addSymbol("WL1","String");
        tablica.addSymbol("WL2","String");
        tablica.addSymbol("WL3","String");
        ConsoleInterface interfacee = new ConsoleInterface();
        interfacee.init(tablica);
    }
    }
