import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ArrayListMaster {


    public static void main(String[] args) {
        boolean completed = false;
        ArrayList<String> valuesList = new ArrayList<String>();
        Scanner userSelector = new Scanner(System.in);
        String userSelection;
        // As long as you haven't noted to quit
        while (!(completed)) {
            // List all options
            System.out.println("Would you like to \n" +
                    "\'A\' to add to the end.\n" +
                    "\'I\' to insert in the middle.\n" +
                    "\'D\' to delete a value.\n" +
                    "\'P\' to print all of the values.\n" +
                    "\'Q\' to quit.\n");
            // Take in an option from the user
            userSelection = userSelector.next();
            userSelector.nextLine();
            // If "A", call the add method
            if (userSelection.equals("A"))
                addToArrayList(valuesList, userSelector);

            // If "I", call the insert method
            if (userSelection.equals("I"))
                insertIntoArrayList(valuesList, userSelector);

            // If"D", call the delete method
            if (userSelection.equals("D"))
                deleteFromArrayList(valuesList, userSelector);

            // If "P", call the print method
            if (userSelection.equals("P"))
                printArrayList(valuesList);
            // If "Q"
            if (userSelection.equals("Q"))
                completed = true;
        }
        userSelector.close();
        System.exit(0);
    }

    public static void printArrayList(ArrayList<String> valuesList) {
        System.out.println(valuesList);
    }

    public static void addToArrayList(ArrayList<String> valuesList, Scanner userSelector) {
        System.out.println("What value would you like to add?");
        String newValue = userSelector.next();
        userSelector.nextLine();
        valuesList.add(newValue);
    }

    public static void deleteFromArrayList(ArrayList<String> valuesList, Scanner userSelector) {
        System.out.println("Which index would you like to delete from?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot < valuesList.size()))
            valuesList.remove(newSpot);
        else
            System.out.println("Invalid index received; no change");
    }

    public static void insertIntoArrayList(ArrayList<String> valuesList, Scanner userSelector) {
        System.out.println("At which index would you like to insert a value?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot <= valuesList.size()))
        {
            System.out.println("What value would you like to add?");
            String newValue = userSelector.next();
            userSelector.nextLine();
            valuesList.add(newSpot, newValue);
        }
        else
        System.out.println("Invalid index received; no change");
    }
}
