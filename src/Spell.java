public class Spell {

    private String spellName;
    private int spellLevel;

    public Spell (String spellName, int spellLevel){
        this.spellName = spellName;
        this.spellLevel = spellLevel;
    }

    @Override
    public String toString() {
        return super.toString()  + " { spell name : " + spellName + " , spell level : " + spellLevel + " }";
    }

    //Setters

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    //Getters

    public String getSpellName() {
        return spellName;
    }

    public int getSpellLevel() {
        return spellLevel;
    }
}
