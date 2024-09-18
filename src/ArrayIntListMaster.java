import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

    public static void printArrayList(ArrayIntList valuesList) {
        System.out.println(valuesList);
    }

    public static void addToArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("What value would you like to add?");
        int newValue = userSelector.nextInt();
        userSelector.nextLine();
        valuesList.add(newValue);
    }

    public static void deleteFromArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which index would you like to delete from?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot < valuesList.size()))
            valuesList.remove(newSpot);
        else
            System.out.println("Invalid index received; no change");
    }

    public static void insertIntoArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("At which index would you like to insert a value?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot <= valuesList.size())) {
            System.out.println("What value would you like to add?");
            int newValue = userSelector.nextInt();
            userSelector.nextLine();
            valuesList.add(newSpot, newValue);
        } else
            System.out.println("Invalid index received; no change");
    }
}

class ArrayIntList {
    private static final int initialLength = 10;

    private int contents[];
    private int length;

    public ArrayIntList() {
        length = 0;
        contents = new int[initialLength];
    }

    private void expand() {
        int tempArray[] = new int[length * 2];
        for (int i = 0; i < length; ++i) {
            tempArray[i] = contents[i];
        }
        contents = tempArray;
    }

    public boolean add(int value) {
        if (length >= contents.length) expand();
        
        contents[length] = value;
        ++length;
        return true;
    }

    public void add(int index, int value) {
        if (length >= contents.length) expand();

        for (int i = length; i >= index + 1; --i) {
            contents[i] = contents[i-1];
        } 

        contents[index] = value;

        ++length;
    }

    public int get(int index) {
        return contents[index];
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int remove(int index) {
        int value = contents[index];
        for (int i = index; i < length; ++i) {
            contents[index] = contents[index+1];
        }
        --length;
        return value;
    }

    public int indexOf(int value) {
        for (int i = 0; i < length; ++i) {
            if (contents[i] == value) return i;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public String toString() {
        String result = "[";
        if (length != 0) {
            result += contents[0];
            for (int i = 1; i < length; ++i) {
                result += ","+contents[i];
            }
        }
        result += "]";
        return result;
    }
}
