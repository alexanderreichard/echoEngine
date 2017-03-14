/*
 * README:
 * Creates the necessary map variables and allows map-based commands.
 *
 * To reset map:
 * (must be done once before using)
 * Map.reset();
 *
 * To create a new region:
 * (must be done before creating first location)
 * Map.newRegion(String name);
 *
 * To create a new location in a region:
 * Map.newLocation(String region, String location name):
 *
 * To print the available regions to screen:
 * (indicates current region)
 * Map.printRegions();
 *
 * To print the locations in the current region to screen:
 * (indicates the current location)
 * Map.printLocations();
 *
 * To change the current region:
 * Map.setCurrentRegion(String region);
 *
 * To change the current location:
 * Map.setCurrentLocation(String lcoation);
 *
 * To check if a location is in the current region:
 * Map.inCurrentRegion(String location);
 */
public class Map {

    //players current region and location
    static String currentRegion = "not set";
    static String currentLocation = "not set";

    //String[] containing names of regions and names of locations within
    //regions. Currently limited to 5.
    static String[] regions = new String[5];
    static String[] locationsRegion1 = new String[10];
    static String[] locationsRegion2 = new String[10];
    static String[] locationsRegion3 = new String[10];
    static String[] locationsRegion4 = new String[10];
    static String[] locationsRegion5 = new String[10];

    //used to not overwrite names
    static int regionCounter = 0;
    static int[] locationCounter = new int[5];

    /*
     * Sets all navigation string values to "empty". Must be done once before
     * using navigation commands.
     */
    public static void reset() {
        for (int k = 0; k < regions.length; k++) {
            regions[k] = "empty";
        }
        for (int k = 0; k < locationsRegion1.length; k++) {
            locationsRegion1[k] = "empty";
        }
        for (int k = 0; k < locationsRegion2.length; k++) {
            locationsRegion1[k] = "empty";
        }
        for (int k = 0; k < locationsRegion3.length; k++) {
            locationsRegion1[k] = "empty";
        }
        for (int k = 0; k < locationsRegion4.length; k++) {
            locationsRegion1[k] = "empty";
        }
        for (int k = 0; k < locationsRegion5.length; k++) {
            locationsRegion1[k] = "empty";
        }
    }

    /*
     * Creates a new region of the specified name. Does not check if region
     * already exists, should only occur once.
     */
    public static void newRegion(String regionName) {
        regions[regionCounter] = regionName;
        regionCounter++;
    }

    /*
     * Creates a new location inside the specified region. Does not check if
     * location already exists, should only occur once.
     */
    public static void newLocation(String regionName, String locationName) {
        //check each region
        for (int k = 0; k < regions.length; k++) {
            //if name matches
            if (regions[k].equals(regionName)) {
                if (k == 0) {
                    locationsRegion1[locationCounter[k]] = locationName;
                } else if (k == 1) {
                    locationsRegion2[locationCounter[k]] = locationName;
                } else if (k == 2) {
                    locationsRegion3[locationCounter[k]] = locationName;
                } else if (k == 3) {
                    locationsRegion4[locationCounter[k]] = locationName;
                } else if (k == 4) {
                    locationsRegion5[locationCounter[k]] = locationName;
                }
                locationCounter[k]++; //increment correct location counter
            }
        }
    }

    /*
     * Get the index number of the region you are currently in. NOTE: In default
     * case- returns zero.
     */
    public static int getRegionIndex() {
        for (int k = 0; k < regions.length; k++) {
            if (regions[k].equals(currentRegion)) {
                return k;
            }
        }
        return 0;
    }

    /*
     * Print the possible regions to travel to (must be created). Indicate the
     * current region.
     */
    public static void printRegions() {
        //get current region
        int currentIndex = getRegionIndex();
        //print if not current region
        for (int k = 0; k < regions.length; k++) {
            if (k != currentIndex && !regions[k].equals("empty")) {
                System.out.println("-" + regions[k]);
            }
        }
        //print current region
        System.out.println("Current Region: " + regions[currentIndex]);
    }

    /*
     * Prints all locations in current region to the screen. Indicate the
     * current region.
     */
    public static void printLocations() {
        //get region index
        int regionIndex = getRegionIndex();

        //if region 1:
        if (regionIndex == 0) {
            for (int k = 0; k < locationsRegion1.length; k++) {
                if (!locationsRegion1[k].equals("empty")
                        && !locationsRegion1[k].equals(currentLocation)) {
                    System.out.println("-" + locationsRegion1[k]);
                }
            }
        }
        //if region 2:
        if (regionIndex == 1) {
            for (int k = 0; k < locationsRegion1.length; k++) {
                if (!locationsRegion2[k].equals("empty")
                        && !locationsRegion2[k].equals(currentLocation)) {
                    System.out.println("-" + locationsRegion2[k]);
                }
            }
        }
        //if region 3:
        if (regionIndex == 2) {
            for (int k = 0; k < locationsRegion1.length; k++) {
                if (!locationsRegion3[k].equals("empty")
                        && !locationsRegion3[k].equals(currentLocation)) {
                    System.out.println("-" + locationsRegion3[k]);
                }
            }
        }
        //if region 4:
        if (regionIndex == 3) {
            for (int k = 0; k < locationsRegion1.length; k++) {
                if (!locationsRegion4[k].equals("empty")
                        && !locationsRegion4[k].equals(currentLocation)) {
                    System.out.println("-" + locationsRegion4[k]);
                }
            }
        }
        //if region 5:
        if (regionIndex == 4) {
            for (int k = 0; k < locationsRegion1.length; k++) {
                if (!locationsRegion5[k].equals("empty")
                        && !locationsRegion5[k].equals(currentLocation)) {
                    System.out.println("-" + locationsRegion5[k]);
                }
            }
        }
        System.out.println("Current location: " + currentLocation);
    }

    /*
     * Returns true if the input location is inside the current region. If input
     * location is not in current region, or does not exist, returns false.
     */
    public static boolean inCurrentRegion(String location) {
        //get region index
        int regionIndex = getRegionIndex();
        boolean inRegion = false;

        //if region 1:
        if (regionIndex == 0) {
            for (int k = 0; k < locationsRegion1.length; k++) {
                if (locationsRegion1[k].equals(location)) {
                    inRegion = true;
                }
            }
        }
        //if region 2:
        else if (regionIndex == 1) {
            for (int k = 0; k < locationsRegion2.length; k++) {
                if (locationsRegion2[k].equals(location)) {
                    inRegion = true;
                }
            }
        }
        //if region 3:
        else if (regionIndex == 2) {
            for (int k = 0; k < locationsRegion3.length; k++) {
                if (locationsRegion3[k].equals(location)) {
                    inRegion = true;
                }
            }
        }
        //if region 4:
        else if (regionIndex == 3) {
            for (int k = 0; k < locationsRegion4.length; k++) {
                if (locationsRegion4[k].equals(location)) {
                    inRegion = true;
                }
            }
        }
        //if region 5:
        else if (regionIndex == 4) {
            for (int k = 0; k < locationsRegion5.length; k++) {
                if (locationsRegion5[k].equals(location)) {
                    inRegion = true;
                }
            }
        }
        return inRegion;
    }

    /*
     * Set the current region to the input string.
     */
    public static void setCurrentRegion(String region) {
        currentRegion = region;
    }

    /*
     * Set current location to the input string.
     */
    public static void setCurrentLocation(String location) {
        currentLocation = location;
    }

}
