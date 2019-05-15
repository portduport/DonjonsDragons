// Warrior creation class
public class Magician extends Player {

    private String filter;
    Spell spell;

    public Magician(String name, String image, int live, int attack, Spell spell, String filter) {
        super(name, image, live, attack);
        this.spell = spell;
        this.filter = filter;
    }

    @Override
    public String toString() {
        return super.toString() + " , filter : " + filter + " }";
    }

    @Override
    public String getType() {
        return ("filter");
    }

    // Setter for the String "filter"
    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public String getFilter() {
        return filter;
    }

    public Spell getSpell() {
        return spell;
    }
}