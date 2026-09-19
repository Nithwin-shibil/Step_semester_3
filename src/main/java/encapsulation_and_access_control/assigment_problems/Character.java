package encapsulation_and_access_control.assigment_problems;

/**
 * Week 7 - Problem 1 : The Health Bar
 * health is private and always clamped between 0 and maxHealth - never set directly.
 */
public class Character {

    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;   // characters start at full health
    }

    public void takeDamage(int amount) {
        health = health - amount;
        if (health < 0) {
            health = 0;            // clamp at the floor - extra damage is wasted
        }
    }

    public void heal(int amount) {
        health = health + amount;
        if (health > maxHealth) {
            health = maxHealth;    // clamp at the ceiling - extra healing is wasted
        }
    }

    public int getHealth() {       // read-only access - no setter exists
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("health = " + c.getHealth());   // 70

        c.heal(50);
        System.out.println("health = " + c.getHealth());   // 100 (capped)

        c.takeDamage(150);
        System.out.println("health = " + c.getHealth());   // 0 (floored)
    }
}
