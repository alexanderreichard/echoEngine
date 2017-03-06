import java.util.Scanner;

public class UI {
    //Java input scanner
    static Scanner in = new Scanner(System.in);

    /*
     * Waits for the user to input a choice between 1 and n, and returns an
     * integer equal to the choice finally selected. Will not break when the
     * user enters a String. The value of n must be <= 5.
     */
    public static int getChoice(int n) {
        String input = in.nextLine();
        if (n == 1) {
            while (!(input.equals("1"))) {
                input = in.nextLine();
            }
            return 1;
        }
        if (n == 2) {
            while (!(input.equals("1") | input.equals("2"))) {
                input = in.nextLine();
            }
            if (input.equals("1")) {
                return 1;
            } else {
                return 2;
            }
        }
        if (n == 3) {
            while (!(input.equals("1") | input.equals("2")
                    | input.equals("3"))) {
                input = in.nextLine();
            }
            if (input.equals("1")) {
                return 1;
            } else if (input.equals("2")) {
                return 2;
            } else {
                return 3;
            }
        }
        if (n == 4) {
            while (!(input.equals("1") | input.equals("2") | input.equals("3")
                    | input.equals("4"))) {
                input = in.nextLine();
            }
            if (input.equals("1")) {
                return 1;
            } else if (input.equals("2")) {
                return 2;
            } else if (input.equals("3")) {
                return 3;
            } else {
                return 4;
            }
        }
        if (n == 5) {
            while (!(input.equals("1") | input.equals("2") | input.equals("3")
                    | input.equals("4") | input.equals("5"))) {
                input = in.nextLine();
            }
            if (input.equals("1")) {
                return 1;
            } else if (input.equals("2")) {
                return 2;
            } else if (input.equals("3")) {
                return 3;
            } else if (input.equals("4")) {
                return 4;
            } else {
                return 5;
            }
        }
        System.out.println("Choice method error");
        return 0;
    }

    /*
     * Creates a line-break and prints text to the output stream on a new line.
     */
    public static void writeNew(String text) {
        System.out.println("\n" + text);
    }

    /*
     * Writes to the output stream on a new line. No prior line-break.
     */
    public static void write(String text) {
        System.out.println(text);
    }
}
