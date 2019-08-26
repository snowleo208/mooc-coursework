import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class Participant implements Comparable<Participant> {
    private String name;
    private ArrayList<Integer> scores;
    private ArrayList<Integer> lengthList;
    private int length;
    private int[] currentRoundScores;
    private Random random;

    public Participant (String name) {
        this.name = name;
        this.scores = new ArrayList<Integer>();
        this.lengthList = new ArrayList<Integer>();
        this.length = 0;
        this.random = new Random();
        this.currentRoundScores = new int[5];
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int[] getCurrentRoundScores() {
        return currentRoundScores;
    }

    public ArrayList<Integer> getScoreList() {
        return scores;
    }

    public int getScores() {
        int score = 0;
        for (int i : this.scores) {
            score += i;
        }
        return score;
    }

    public ArrayList<Integer> getLengthList() {
        return lengthList;
    }

    public void jump() {
        int length = this.random.nextInt(120);

        // generate a new length btw 60-120
        while(length < 60 || length > 120) {
            length = this.random.nextInt(120);
        }

        // add length to score (and length list for the result)
        this.length = length;
        this.lengthList.add(length);
        this.scores.add(length);

        // clear the scores and add new judge scores randomly btw 10-20
        this.currentRoundScores = new int[5];
        for(int i = 0; i < 5; i++) {
            int score = this.random.nextInt(20);
            while (score < 10 || score > 20) {
                score = this.random.nextInt(20);
            }
            this.currentRoundScores[i] = score;
        }

        // filter the smallest and the biggest points after sort
        Arrays.sort(this.currentRoundScores);
        for(int j = 0; j < this.currentRoundScores.length - 1; j++) {
            if(j == 0 || j == this.currentRoundScores.length - 1) continue;

            this.scores.add(this.currentRoundScores[j]);
        }
    }

    @Override
    public int compareTo(Participant p) {
        return this.getScores() - p.getScores();
    }

    public String toString() {
        return this.name + " ("+ this.getScores() +" points)";
    }
}