/*
 * README:
 * The in-game clock.
 * Variables are always saved in 24 hour time.
 *
 * To display current time:
 * Clock.printTime();
 *
 * To return (but not display) current time:
 * (variable, not function)
 * Clock.currentTime;
 *
 * To increment the clock:
 * Clock.increment(int amount);
 *
 * To set the clock to a certain hour:
 * Clock.set(int hour);
 *
 * To change to 24 hour clock (default):
 * Clock.changeSetting(24);
 *
 * To change to 12 hour clock:
 * Clock.changeSetting(12);
 */
public class Clock {

    //clock variable
    public static int currentTime = 0;
    public static boolean militaryTime = true;

    /*
     * Increment the clock by a set amount of hours. To decrement, enter a
     * negative integer.
     */
    public static void increment(int amount) {
        currentTime += amount;
        if (currentTime > 24) {
            currentTime -= 24;
        } else if (currentTime < 0) {
            currentTime = +24;
        }
    }

    /*
     * Set the clock to the designated hour (use 24 hours)
     */
    public static void set(int hour) {
        currentTime = hour;
    }

    /*
     * Print the current time to the screen in the designated format.
     */
    public static void printTime() {
        if (militaryTime) { //24 hour clock
            if (currentTime < 10) { //leading zero
                System.out.print("0");
            }
            System.out.println(currentTime + ":00");
        } else { //12 hour clock
            if (currentTime < 12) {
                System.out.print(currentTime + ":00 am");
            } else {
                System.out.print(currentTime - 12 + ":00 pm");
            }
        }

    }

    /*
     * Allows the user to switch between 12 and 24 hour clock settings.
     */
    public static void changeSetting(int hour) {
        if (hour == 24) {
            militaryTime = true;
        } else if (hour == 12) {
            militaryTime = false;
        } else {
            System.out.println("Error. Incorrect clock setting.");
        }
    }

}
