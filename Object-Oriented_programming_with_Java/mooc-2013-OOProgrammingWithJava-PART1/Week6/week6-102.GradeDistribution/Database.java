import java.util.ArrayList;

public class Database {
    private ArrayList<Grade> list;
    private ArrayList<Grade> notAccepted;
    private int[] distributions;

    public Database () {
        this.list = new ArrayList<Grade>();
        this.notAccepted = new ArrayList<Grade>();
        this.distributions = new int[6];
    }

    public ArrayList<Grade> getList() {
        return list;
    }

    public void add(Grade score) {
        if(score.getScore() >= 0 && score.getScore() <= 60) {
            this.list.add(score);
            distributions[score.getGrade()] +=1;
        }

        // add to not accepted list as its score is lower than 29
        if(score.getScore() >= 0 && score.getScore() <= 29) {
            this.notAccepted.add(score);
        }
    }

    public double getAcceptances() {
        return (double) (100 * Math.abs(this.list.size() - this.notAccepted.size())) / this.list.size();
    }

    public void getDistribution() {
        for(int i = this.distributions.length - 1; i >= 0; i--) {
            System.out.println(i + ": " + ScoreUtils.printStars(this.distributions[i]));
        }
    }
}