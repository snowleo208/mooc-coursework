import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> teamList;
    private int maxSize;

    public Team(String name) {
        this.name = name;
        this.teamList = new ArrayList<Player>();
        this.maxSize = 16;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        if(this.teamList.size() < this.maxSize) {
            this.teamList.add(player);
        }
    }

    public void printPlayers() {
        int n = 0;
        while(n < this.teamList.size()) {
            System.out.println(this.teamList.get(n));
            n++;
        }
    }

    public int size() {
        return this.teamList.size();
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int goals() {
        int n = 0;
        int goals = 0;
        while(n < this.teamList.size()) {
            goals += this.teamList.get(n).goals();
            n++;
        }

        return goals;
    }
}