import java.util.ArrayList;
import java.util.Scanner;


final public class Main {

    // Mapping of digits to letters (like a phone keypad)
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "ABC",  // 2
        "DEF",  // 3
        "GHI",  // 4
        "JKL",  // 5
        "MNO",  // 6
        "PQRS", // 7
        "TUV",  // 8
        "WXYZ"  // 9
    };

    // Public method called by the user
    public static ArrayList<String> listMnemonics(String phoneNumber) {
        ArrayList<String> result = new ArrayList<>();
        if (phoneNumber == null || phoneNumber.length() == 0) {
            return result;
        }
        helper(phoneNumber, 0, "", result);
        return result;
    }

    // Recursive helper method
    private static void helper(String phoneNumber, int index,
                               String current, ArrayList<String> result) {

        // Base case: full combination created
        if (index == phoneNumber.length()) {
            result.add(current);
            return;
        }

        int digit = phoneNumber.charAt(index) - '0';
        String letters = KEYPAD[digit];

        // Try each letter for the current digit
        for (int i = 0; i < letters.length(); i++) {
            helper(phoneNumber, index + 1,
                   current + letters.charAt(i), result);
        }
    }

    // Test the program
    public static void main(String[] args) {
        boolean inputError = true;
        Scanner userInput = new Scanner(System.in);
        System.out.println("This program generates all possible letter combinations corresponding to numbers on a phone number from an inputted int number string.");
        System.out.println("Enter Phone Number: ");
        String stringOfNumbers = userInput.nextLine();

        while (inputError == true) {
            try {
                int numbersAsInt = Integer.parseInt(stringOfNumbers);
                inputError = false;
                break;
            } catch (NumberFormatException e) {
                System.out.printf("Error! Please enter a valid input!");
            }
            System.out.println("Enter Phone Number: ");
            stringOfNumbers = userInput.nextLine();

        }

        ArrayList<String> result = listMnemonics(stringOfNumbers);
        for (String s : result) {
            System.out.print(s + " ");
        }

        System.out.println("\nDone! :)");
        userInput.close();

    }
}
