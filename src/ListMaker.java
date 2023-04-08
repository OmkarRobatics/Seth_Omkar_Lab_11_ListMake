import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static final ArrayList<String> list = new ArrayList<>(); // declaration of array list
    private static Scanner in = new Scanner(System.in); // sets up scanner class

    public static void main(String[] args) {
        // var declarations
        final String MENU = "A - Add D - Delete P - Print Q - Quit"; // menu options
        boolean done = false; // var to end program
        String command = ""; // option the user chooses from the menu
        do {
            displayList(); // displays list
            command = SafeInput.getRegexString(in, MENU, "[AaDdPpQq]"); // displays menu
            command = command.toUpperCase(); // makes the letter entered uppercase
            switch (command) {
                case "A":
                    addItem(); // adds item
                    break;
                case "D":
                    deleteItem(); // deletes item
                    break;
                case "P":
                    // nothing happens in this case as list will be shown any ways
                    break;
                case "Q":
                    done = SafeInput.getYNConfirm(in, "Are you sure you want to quit? Enter Y for yes and N for no: "); // prompts user if they want to quit for sure.
                    break;
            }
        } while (!done); // ends loop if user wants to quit for sure
    }

    private static void displayList() {
        System.out.println("*****************************************************"); // border on top
        if (list.size() != 0) // if list has values in it
        {
            for (int index = 0; index < list.size(); index++) {
                System.out.printf("\n%3d%35s", index + 1, list.get(index)); // enters item user wants to add with numbers
            }
        } else {
            System.out.println("\n***             No Items in List                  ***"); // tells user that there are no items in list
        }
        System.out.println("\n*****************************************************"); // border on bottom

    }
    private static void addItem() {
      String itemAdded = SafeInput.getNonZeroLenString(in, "Enter a item to add to the list: "); // inputs item to add to the list
        list.add(itemAdded); // adds item to list

    }
    private static void deleteItem() {
        int deletingItem = 0; // the number of the item to be deleted
        if (list.size() == 0) // checks if list is empty
        {
            System.out.println("You can not delete anything from the list because it is empty. Add something first."); // outputs message that list is empty and deleting an item is not possible
        } else {
            deletingItem = SafeInput.getRangedInt(in, "Enter the number of the item you would like to delete on the list", 1, list.size()); // if list is not empty the number of the item to delete is inputted with safe input
            deletingItem = deletingItem - 1; // subtracts one from the number so that the number entered can become an index
            list.remove(deletingItem); // deletes the item from list
        }
    }

}
