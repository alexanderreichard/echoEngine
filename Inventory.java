/*
 * README:
 * The inventory MUST be reset once at the beginning of the game,
 * to avoid null-pointer exceptions. From then on, the inventory will
 * automatically create its own indexing system, every time an item is
 * added that wasn't added before.
 *
 * To reset inventory:
 * (assuming class is set to variable 'inventory')
 * inventory.reset();
 *
 * To add items:
 * inventory.add(String itemName);
 *
 * To remove items:
 * inventory.remove(String itemName);
 *
 * To check if an item is in the inventory:
 * (this will return type boolean)
 * inventory.check(String itemName);
 *
 * To return the number of items of a given name in the inventory:
 * (this will return type int)
 * inventory.getCount(String itemName);
 *
 * To print the inventory to the screen:
 * (the order will be the order the items were added)
 * inventory.print()
 *
 * To change the displayed title of the inventory:
 * inventory.setTitle(string title);
 */

public class Inventory {

    //array indexing
    static boolean[] inventory = new boolean[100];
    static String[] inventoryName = new String[100];
    static int[] inventoryCount = new int[100];
    static int currentItem = 0;

    //aesthetic
    static String inventoryTitle = "Inventory:";

    /*
     * Resets the inventory. Must be done at least once per game.
     */
    public static void reset() {
        //reset all names
        for (int k = 0; k < inventoryName.length; k++) {
            inventoryName[k] = "empty";
        }
        //reset all values
        for (int k = 0; k < inventory.length; k++) {
            inventory[k] = false;
        }
        //create error variable
        inventoryName[0] = "error";
        currentItem++;
    }

    /*
     * Creates indexes for the item, if the item does not already exist.
     */
    public static void createItem(String itemName) {
        if (!itemExists(itemName)) {
            inventoryName[currentItem] = itemName;
            currentItem++;
        } else {
            return;
        }
    }

    /*
     * Checks to see if item exists. Used to check if item has been created
     * previously, to make sure the item isn't created twice.
     */
    private static boolean itemExists(String item) {
        boolean exists = false;
        for (int k = 0; k < inventoryName.length; k++) {
            if (inventoryName[k].equals(item)) {
                exists = true;
            }
        }
        return exists;
    }

    /*
     * Given string input of an item name, it returns the item index number in
     * the inventory boolean array.
     */
    public static int getItemNum(String item) {
        for (int k = 0; k < inventoryName.length; k++) {
            if (item.equals(inventoryName[k])) {
                return k;
            }
        }
        return 0; //failure case
    }

    /*
     * Adds specified item to the player inventory.
     */
    public static void add(String item) {
        createItem(item);
        int itemNum = getItemNum(item);
        inventory[itemNum] = true;
        inventoryCount[itemNum]++;
    }

    /*
     * Removes specified item from the player inventory, if it exists.
     */
    public static void remove(String item) {
        if (itemExists(item)) {
            int itemNum = getItemNum(item);
            //if it is there, remove one
            if (inventory[itemNum]) {
                inventoryCount[itemNum]--;
            }
            //if none left, switch to false
            if (inventoryCount[itemNum] <= 0) {
                inventory[itemNum] = false;
            }
        }
    }

    /*
     * Checks if the input item is present in the inventory. Returns boolean.
     */
    public static boolean check(String item) {
        if (itemExists(item)) {
            int itemNum = getItemNum(item);
            return inventory[itemNum];
        } else {
            return false;
        }
    }

    /*
     * Returns int value of item count.
     */
    public static int getCount(String item) {
        if (itemExists(item)) {
            int itemNum = getItemNum(item);
            return inventoryCount[itemNum];
        } else {
            return 0;
        }
    }

    /*
     * Changes the title of the inventory.
     */
    public static void setTitle(String title) {
        inventoryTitle = title;
    }

    /*
     * Prints the inventory to the screen.
     */
    public static void print() {
        System.out.println("\n" + inventoryTitle);
        for (int k = 0; k < inventory.length; k++) {
            if (inventory[k]) {
                System.out.print("-" + inventoryName[k]);
                System.out.println(" (" + inventoryCount[k] + ")");
            }
        }
    }
}
