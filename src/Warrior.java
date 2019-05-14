// Warrior creation class
public class Warrior extends Player {

    private String shield;
    Weapon weapon = new Weapon("espada",12);



    public Warrior(String name, String image, int live, int attack, String shield) {
        super(name, image, live, attack);
        this.shield = shield;
    }

// Setter for the String "shield"
    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getShield() {
        return shield;
    }
}