import java.util.*;

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
        if (!findSymbol(key)) {
            int index = this.hashFunction(key);
            this.hashList.get(index).put(key, value);
        } else {
            Scanner inputReader = new Scanner(System.in);
            System.out.println("Such symbol already exists do you wish to continue(y/n)");
            String userInput = inputReader.nextLine();
            while (!Objects.equals(userInput, "y") && !Objects.equals(userInput, "n")) {
                System.out.println("Wrong input please type y or n");
                userInput = inputReader.nextLine();
            }
            if (userInput.equals("y")) {
                int index = this.hashFunction(key);
                this.hashList.get(index).put(key, value);
            }
        }


    }

    public void removeSymbol(String key) {
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

            String y = this.hashList.get(index).get(key);
            System.out.println("Table index:" + index + ". Key: " + key + ", Value:" + y);

        } else {
            System.out.println(key + "Not found\nThere is no table entry with such key");
        }

    }

    public void printTable() {
        hashList.forEach(stringStringMap -> {
            stringStringMap.forEach((x, y) -> {
                System.out.println(x + " " + y);
            });
        });
    }
}
