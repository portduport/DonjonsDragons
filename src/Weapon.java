public class Weapon {

    private String weaponName;
    private int attackLevel;

    public Weapon(String weaponName, int attackLevel){
        this.weaponName = weaponName;
        this.attackLevel = attackLevel;
    }

    @Override
    public String toString() {
        return super.toString()  + " { weapon name : " + weaponName + " , attack level : " + attackLevel + " }";
    }

    //Setters

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    //Getters

    public String getWeaponName() {
        return weaponName;
    }

    public int getAttackLevel() {
        return attackLevel;
    }
}
