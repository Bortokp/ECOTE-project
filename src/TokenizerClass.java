import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TokenizerClass {
    private String path;

    public TokenizerClass() {
        //this.path=pathToFile;
    }

    public void tokenizer(SymbolTable myObj, String pathToFile) throws IOException {
        this.path = pathToFile;
        File f = new File(path);
        long lenOfFile = f.length();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        BufferedReader br2 = new BufferedReader(fr);
        int c = 0;
        int d = 0;
        String buffer = "";
        String keyBuffer = "";
        String valueBuffer="";
        int counter = 0;
        while (d < lenOfFile) {
            c = br.read();
            if (c==-1){
                if ((++counter % 2) == 0) {
                    myObj.addSymbol(keyBuffer, valueBuffer);
                    break;}
                break;
            }
            if (c == 59) {
                if ((++counter % 2) == 0) {
                    valueBuffer = buffer;
                    buffer = "";
                    //System.out.println(valueBuffer);
                    myObj.addSymbol(keyBuffer, valueBuffer);
                    keyBuffer = "";
                    valueBuffer ="";
                } else {
                    keyBuffer = buffer;
                    buffer = "";
                    //System.out.println(keyBuffer);
                }
            }
            if (c == 59) {
                while (d < lenOfFile) {
                    c=br.read();
                    if (c != 32) {
                        char character = (char) c;
                        if (c != 10 && c != 13) {
                            buffer += character;
                            break;
                        }
                    }
                }

            } else {
                char character = (char) c;
                buffer += character;
            }
            d++;
        }
    }
}
