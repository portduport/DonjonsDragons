public class Player {

    protected String name;
    protected String image;
    protected int live;
    protected int attack;

    public Player(String name, String image, int live, int attack) {
        this.name = name;
        this.image = image;
        this.live = live;
        this.attack = attack;
    }

    // We will create the SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    // We will create the GETTERS

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getLive() {
        return live;
    }

    public int getAttack() {
        return attack;
    }
}

