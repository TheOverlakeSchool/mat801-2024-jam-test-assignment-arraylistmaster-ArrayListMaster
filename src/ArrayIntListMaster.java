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
        if ((newSpot >= 0) && (newSpot <= valuesList.size()))
        {
            System.out.println("What value would you like to add?");
            int newValue = userSelector.nextInt();
            userSelector.nextLine();
            valuesList.add(newSpot, newValue);
        }
        else
        System.out.println("Invalid index received; no change");
    }
}

class ArrayIntList{
    int[] array;
    int items;


    ArrayIntList(){
        array = new int[10];
        items = 0;
    }
    int size(){
        return items;
    }
     
    void add(int value){
        ensureLength(items + 1);
        array[items] = value;
        items++;
    }
    void add(int index, int value){
        ensureLength(items + 1);
        for(int i = items; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = value;
        items++;
    }
    int get(int index){
        return array[index];
    }

    int remove(int index){
        int previous = array[index];
        for(int i = index; i < items - 1; i++){
            array[i] = array[i+1];
        }
        items--;
        return previous;
    }

    void update(int[] temp){
        for(int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }
    }
    void ensureLength(int requiredLength){
        if(requiredLength > array.length){
            int newLength = array.length * 2;
            if(newLength < requiredLength){
                newLength = requiredLength + 1;
            }
            int[] temp = new int[newLength];
            for (int i = 0; i < items; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }
    public String toString() {
        if (items == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(array[0]);
            for (int i = 1; i < items; i++) {
                sb.append(", ");
                sb.append(array[i]);
            }
            sb.append("]");
            return sb.toString();
        }
    }

}
