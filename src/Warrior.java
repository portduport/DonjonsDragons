// Warrior creation class
public class Warrior extends Player {

    private String shield;
    Weapon weapon;



    public Warrior(String name, String image, int live, int attack, Weapon weapon, String shield) {
        super(name, image, live, attack);
        this.weapon = weapon;
        this.shield = shield;
    }

    @Override
    public String toString() {
        return super.toString() + " , weapon : " + weapon + " , shield : " + shield + " }";
    }

    @Override
    public String getType() {
        return ("Shield");
    }

    // Setter for the String "shield"
    public void setShield(String shield) {
        this.shield = shield;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getShield() {
        return shield;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}