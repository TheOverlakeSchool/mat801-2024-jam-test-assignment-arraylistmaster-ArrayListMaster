//import java.util.ArrayList;
import java.util.Scanner;

public class ArrayIntListMaster {
    public static void main(String[] args) {
        boolean completed = false;
        ArrayIntList valuesList = new ArrayIntList();
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
                addToArrayIntList(valuesList, userSelector);

            // If "I", call the insert method
            if (userSelection.equals("I"))
                insertIntoArrayIntList(valuesList, userSelector);

            // If"D", call the delete method
            if (userSelection.equals("D"))
                deleteFromArrayIntList(valuesList, userSelector);

            // If "P", call the print method
            if (userSelection.equals("P"))
                printArrayIntList(valuesList);
            // If "Q"
            if (userSelection.equals("Q"))
                completed = true;
        }
        userSelector.close();
        System.exit(0);
    }

    public static void printArrayIntList(ArrayIntList valuesList) {
        System.out.println(valuesList);
    }

    public static void addToArrayIntList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("What value would you like to add?");
        int newValue = Integer.parseInt(userSelector.next());
        userSelector.nextLine();
        valuesList.add(newValue);
    }

    public static void deleteFromArrayIntList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which index would you like to delete from?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot < valuesList.size()))
            valuesList.remove(newSpot);
        else
            System.out.println("Invalid index received; no change");
    }

    public static void insertIntoArrayIntList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("At which index would you like to insert a value?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot <= valuesList.size()))
        {
            System.out.println("What value would you like to add?");
            String newValue = userSelector.next();
            userSelector.nextLine();
            valuesList.add(newSpot, Integer.parseInt(newValue));
        }
        else
            System.out.println("Invalid index received; no change");
    }

    static class ArrayIntList {
        private int[] values;
        private int size;

        public ArrayIntList() {
            values = new int[10];
            size = 0;
        }

        public void add (int newValue) {
            if (size >= values.length) {
                System.out.println("Array is full. Cannot add more values.");
                return;
            }

            values[size] = newValue;
            size++;

        }

        public void add(int newSpot, int newValue) {
            if (size >= values.length) {
                System.out.println("Array is full.");
                return;

            }

            if (newSpot < 0 || newSpot > size) {
                System.out.println("Invalid index.");
                return;

            }

            for (int i = size; i > newSpot; i--) {
                values[i] = values[i - 1];
            }
            values[newSpot] = newValue;
            size++;

        }

        public void remove(int newValue) {
            if (newValue < 0 || newValue >= size) {
                System.out.println("Invalid index.");
                return;
            }

            for (int i = newValue; i < size - 1; i++) {
                values[i] = values[i + 1];
            }
            size--;
        }
        public int size() {
            return size;
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(values[i] + " ");
            }
            System.out.println();
        }
    }

}

