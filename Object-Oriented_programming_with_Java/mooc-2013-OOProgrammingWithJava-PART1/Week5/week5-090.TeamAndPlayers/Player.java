public class Player {
    private String name;
    private int goal;

    public Player(String name) {
        this.name = name;
        this.goal = 0;
    }

    public Player(String name, int goal) {
        this.name = name;
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + ", goals " + this.goal;
    }

    public int goals() {
        return this.goal;
    }


}