/*
 * README:
 * Keeps track of player's health.
 *
 * To display player health:
 * (assuming class is set to variable 'health')
 * health.print();
 *
 * To increase player health:
 * health.increase();
 *
 * To decrease player health:
 * health.decrease();
 *
 * To reset player health:
 * health.reset();
 *
 */
public class Health {

    //health "bar"
    static int maxHealth = 100;
    static int health = maxHealth;

    public static void print() {
        System.out.println("\nHealth: " + health + "/" + maxHealth);
    }

    /*
     * Increase player's health by input amount.
     */
    public static void increase(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    /*
     * Decrease player's health by input amount.
     */
    public static void decrease(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
            //queue death
        }
    }

    /*
     * Resets player health to maxHealth
     */
    public static void reset() {
        health = maxHealth;
    }

}
