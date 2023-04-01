import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
  private static  ArrayList<String> list =  new ArrayList<>();
    public static void main(String[] args) {

        final String menu = "A - Add D - Delete P - Print Q - Quit";
                boolean done = false;
                String itemAdded = "";
                int deletingItem = 0;
                boolean validItem = false;
                String command = "";
                Scanner in = new Scanner(System.in);
                DisplayList();

                do
                {

                    command = SafeInput.getRegexString(in,menu,"[AaDdPpQq]");
                    command = command.toUpperCase();
                    switch (command)
                    {
                        case "A":
                        itemAdded = SafeInput.getNonZeroLenString(in,"Enter a item to add to the list: ");
                            list.add(itemAdded);
                            DisplayList();
                            break;
                            case "D":
                                if (list.size() == 0)
                                {
                                    System.out.println("You can not delete anything from the list because it is empty. Add something first.");
                                }
                                else {
                                    deletingItem = SafeInput.getInt(in, "Enter the number of the item you would like to delete on the list");

                                    if (list.size() >= deletingItem && deletingItem > 0)
                                    {
                                        deletingItem = deletingItem - 1;
                                        list.remove(deletingItem);
                                    }
                                    else
                                    {
                                        do {
                                            System.out.println("You entered an invalid number: " + deletingItem + "." + " Please try again.");
                                            deletingItem = SafeInput.getInt(in, "Enter the number of the item you would like to delete on the list");

                                            if (list.size() >= deletingItem && deletingItem > 0)
                                            {
                                                deletingItem = deletingItem - 1;
                                                list.remove(deletingItem);
                                                validItem = true;
                                            }
                                        }while (!validItem);

                                    }
                                }
                            break;
                        case "P":
                            DisplayList();
                            break;
                        case "Q":
                            System.exit(0);
                            break;
                    }
                }while (!done);
            }
            private static void DisplayList () {
                        System.out.println("*****************************************************");
                if (list.size() != 0) {
                    for (int index = 0; index < list.size(); index++)
                    {
                        System.out.printf("\n%3d%35s", index + 1, list.get(index));
                    }
                }
                    else {
                        System.out.println("***             No Items in List                  ***");
                    }
                        System.out.println("\n*****************************************************");

            }

        }
