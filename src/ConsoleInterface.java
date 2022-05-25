import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleInterface {
    public ConsoleInterface() {
    }

    public void printInterface() {
        System.out.println("1. Insert symbol\n" +
                "2. Read .txt file\n" +
                "3. Delete symbol\n" +
                "4. Get symbol\n" +
                "5. Print table (partially implemented)\n" +
                "6. Save table to text file(not implemented)\n" +
                "7. Clear table(not implemented)\n" +
                "8. Quit");
    }

    public void init(SymbolTable myObj, TokenizerClass myObj2) throws IOException {
        boolean bool = true;
        Scanner inputReader = new Scanner(System.in);
        int userInput;
        String userInputKey;
        String userInputValue;
        while (bool) {
            this.printInterface();
            userInput = Integer.parseInt(inputReader.nextLine());
            switch (userInput) {
                case 1:
                    System.out.println("Please insert KEY:");
                    userInputKey = inputReader.nextLine();
                    if (!myObj.findSymbol(userInputKey)) {
                        System.out.println("Please insert VALUE:");
                        userInputValue = inputReader.nextLine();
                        myObj.addSymbol(userInputKey, userInputValue);
                    } else {
                        System.out.println("Such symbol already exists, It's value will be overwritten do you wish to continue(y/n)");
                        String userInput2 = inputReader.nextLine();
                        while (!Objects.equals(userInput2, "y") && !Objects.equals(userInput2, "n")) {
                            System.out.println("Wrong input please type y or n");
                            userInput2 = inputReader.nextLine();
                        }
                        if (userInput2.equals("y")) {
                            System.out.println("Please insert VALUE:");
                            userInputValue = inputReader.nextLine();
                            myObj.addSymbol(userInputKey, userInputValue);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Please specify the path:");
                    userInputKey = inputReader.nextLine();
                    myObj2.tokenizer(myObj,userInputKey);
                    break;
                case 3:
                    System.out.println("Please insert KEY:");
                    userInputKey = inputReader.nextLine();
                    myObj.removeSymbol(userInputKey);
                    break;
                case 4:
                    System.out.println("Please insert KEY:");
                    userInputKey = inputReader.nextLine();
                    myObj.getSymbol(userInputKey);
                    break;
                case 5:
                    myObj.printTable();
                    break;
                case 6:
                case 7:
                case 8:
                    bool=false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;

            }

        }
    }
}
