import java.io.IOException;

public class Main extends ConsoleInterface {
    public static void main(String[] args) throws IOException {
        SymbolTable tablica = new SymbolTable();
        TokenizerClass tokenizer = new TokenizerClass();
        ConsoleInterface interfacee = new ConsoleInterface();
        interfacee.init(tablica, tokenizer);
    }
    }
