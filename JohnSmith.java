/*
 * README:
 * A sample copy/paste class for NPC characters.
 * Requires coding of the class itself.
 */
public class JohnSmith {

    //the character's name (written as a descriptor)
    static String name = "John Smith: ";

    //the character's interaction statement
    static String openingStatementFriendly = "\n" + name + "Hello World.";
    static String openingStatementNeutral = "\n" + name + "Hello.";
    static String openingStatementAnnoyed = "\n" + name + "What do you want?";

    //the character's feelings towards the player
    static int moodMeter = 90;
    static String moodStatus = "friendly";

    //whether or not the character has met the player
    static boolean hasMet;

    //which statements have been said
    static boolean saidOption1;
    static boolean saidOption2;
    static boolean saidOption3;
    static boolean saidOption4;

    /*
     * Approach/talk to the character.
     */
    public static void interact() {
        if (!hasMet) {
            introduction();
        } else {
            if (moodStatus.equals("angry")) {
                System.out.println(
                        "This character doesn't want to speak to you.");
            } else if (moodStatus.equals("friendly")) {
                System.out.println(openingStatementFriendly);
            } else if (moodStatus.equals("annoyed")) {
                System.out.println(openingStatementAnnoyed);
            } else {
                System.out.println(openingStatementNeutral);
            }
        }
        System.out.println("");
        listOptions();

    }

    /*
     * The character introduces themselves for the first time.
     */
    public static void introduction() {
        System.out.println("\n" + name + "How can I help you?");
        UI.playerSpeak("Hello, I'm Detective " + UI.playerName
                + ". May I ask you a few questions?");
        System.out.println(name + "Go ahead.");
    }

    /*
     * Lists dialogue options & waits for the user to select one.
     */
    public static void listOptions() {
        System.out.println("1: Option 1");
        System.out.println("2: Option 2");
        System.out.println("3: Option 3");
        System.out.println("4: Option 4");
        System.out.println("5: Nevermind");
        int choice = UI.getChoice(5);

        if (choice == 1) {
            option1();
        } else if (choice == 2) {
            option2();
        } else if (choice == 3) {
            option3();
        } else if (choice == 4) {
            option4();
        } else {
            option5();
        }
    }

    /*
     * Dialogue options code: This is where we code different responses for
     * different moods.
     */
    public static void option1() {
        UI.playerSpeak("Hello John.");
        UI.write(name + "Hello Detective.");
    }

    public static void option2() {
        UI.playerSpeak("Hello John.");
        UI.write(name + "Hello Detective.");
    }

    public static void option3() {
        UI.playerSpeak("Hello John.");
        UI.write(name + "Hello Detective.");
    }

    public static void option4() {
        UI.playerSpeak("Hello John.");
        UI.write(name + "Hello Detective.");
    }

    public static void option5() {
        UI.playerSpeak("Goodbye John.");
        UI.write(name + "Goodbye Detective.");
    }

    /*
     * Adjust the mood of the NPC.
     */
    public static void adjustMood(int amount) {
        moodMeter += amount;
        if (moodMeter <= 0) {
            moodMeter = 0;
            moodStatus = "angry";
        } else if (moodMeter <= 20) {
            moodStatus = "angry";
        } else if (moodMeter <= 50) {
            moodStatus = "annoyed";
        } else if (moodMeter <= 75) {
            moodStatus = "guarded";
        } else if (moodMeter <= 85) {
            moodStatus = "neutral";
        } else {
            moodStatus = "friendly";
        }
    }

}
