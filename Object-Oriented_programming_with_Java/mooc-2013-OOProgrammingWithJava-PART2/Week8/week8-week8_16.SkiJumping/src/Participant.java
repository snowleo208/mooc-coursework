import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Participant {
    private String name;
    private ArrayList<Integer> scores;
    private int length;
    private ArrayList<Integer> currentRoundScores;
    private Random random;

    public Participant (String name) {
        this.name = name;
        this.scores = new ArrayList<Integer>();
        this.length = 0;
        this.random = new Random();
        this.currentRoundScores = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public ArrayList<Integer> getCurrentRoundScores() {
        return currentRoundScores;
    }

    public ArrayList<Integer> getScoreList() {
        return scores;
    }

    public void jump() {
        int length = this.random.nextInt(120);

        // generate a new length btw 60-120
        while(length < 60 || length > 120) {
            length = this.random.nextInt(120);
        }

        this.length = length;

        // clear the scores and add new scores randomly btw 10-20
        this.currentRoundScores.clear();
        while(this.currentRoundScores.size() < 5) {
            int score = this.random.nextInt(20);
            while (score < 10 || score > 20) {
                score = this.random.nextInt(20);
            }
            this.scores.add(score);
            this.currentRoundScores.add(score);
        }
    }

    public int getScores() {
        int score = 0;
        for (int i : this.scores) {
            score += i;
        }
        return score;
    }

    public String toString() {
        return this.name + " ("+ this.getScores() +" points)";
    }
}