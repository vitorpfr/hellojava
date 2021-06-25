package grocerylist;

import java.util.ArrayList;

public class GroceryList {
    // to define an array, we need to specify the type and the number of elements (size)
    // to define an ArrayList, we need to specify the type, but not the size: it resizes automatically
    private int[] myNumbers = new int[50];
    private ArrayList<String> groceryList = new ArrayList<String>(); // ArrayList is a class, so it also needs to instantiate an object with 'new'

    public void addGroceryItem(String item) {
        // normal array: we'd need to specify the index
//        myNumbers[4] = 5;

        // method 'add' from the class ArrayList automatically handles resizing, memory allocation, etc, adding element in the end of the list
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position+1) + " has been modified");
    }

    public void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }

    public String findItem(String searchItem) {
//        boolean exists = groceryList.contains(searchItem);

        int position = groceryList.indexOf(searchItem);
        if (position >= 0) {
            return groceryList.get(position);
        }

        return null;
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }


}
