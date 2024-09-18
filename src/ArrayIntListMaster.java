import java.util.Scanner;

public class ArrayIntListMaster {

    public static void main(String[] args) {
        boolean completed = false;
        ArrayIntList valuesList = new ArrayIntList();
        Scanner userSelector = new Scanner(System.in);
        String userSelection;

        while (!completed) {
            System.out.println("Would you like to: ");
            System.out.println("'A' to add to the end.");
            System.out.println("'I' to insert in the middle.");
            System.out.println("'D' to delete a value.");
            System.out.println("'P' to print all of the values.");
            System.out.println("'Q' to quit.");

            userSelection = userSelector.next();
            userSelector.nextLine();

            if (userSelection.equals("A")) {
                addToArrayList(valuesList, userSelector);
            } else if (userSelection.equals("I")) {
                insertIntoArrayList(valuesList, userSelector);
            } else if (userSelection.equals("D")) {
                deleteFromArrayList(valuesList, userSelector);
            } else if (userSelection.equals("P")) {
                printArrayList(valuesList);
            } else if (userSelection.equals("Q")) {
                completed = true;
            }
        }
        userSelector.close();
        System.exit(0);
    }

    public static void printArrayList(ArrayIntList valuesList) {
        valuesList.printList();
    }

    public static void addToArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Enter a number to add:");
        int number = userSelector.nextInt();
        valuesList.add(number);
    }

    public static void insertIntoArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Enter a number to insert:");
        int number = userSelector.nextInt();
        System.out.println("Enter the index to insert at:");
        int index = userSelector.nextInt();
        valuesList.insert(number, index);
    }

    public static void deleteFromArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Enter the index of the number to delete:");
        int index = userSelector.nextInt();
        valuesList.delete(index);
    }
}

class ArrayIntList {
    private int[] list;
    private int size;

    public ArrayIntList() {
        list = new int[10]; // Initial capacity of 10
        size = 0;
    }

    public void add(int value) {
        ensureCapacity();
        list[size] = value;
        size++;
    }

    public void insert(int value, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index.");
            return;
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = value;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    public void printList() {
        if (size == 0) {
            System.out.println("The list is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    private void ensureCapacity() {
        if (size >= list.length) {
            int[] newList = new int[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
        }
    }
}
