// Warrior creation class
public class Magician extends Player {

    private String filter;
    Spell conjuro = new Spell("gsdfgs",6);

    public Magician(String name, String image, int live, int attack, String filter) {
        super(name, image, live, attack);
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
    public String getFilter() {
        return filter;
    }
}