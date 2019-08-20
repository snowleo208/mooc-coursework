public class Grade {
    private int score;
    private int grade;

    public Grade (int score) {
        this.score = score;
        this.grade = 0;
    }

    public int getScore() {
        return this.score;
    }

    public int getGrade() {
        this.setGrade(this.score);
        return this.grade;
    }

    public void setGrade(int score) {
        if(score <= 29) {
            this.grade = 0;
        } else if (score <= 34) {
            this.grade = 1;
        } else if (score <= 39) {
            this.grade = 2;
        } else if (score <= 44) {
            this.grade = 3;
        } else if (score <= 49) {
            this.grade = 4;
        } else if (score <= 60) {
            this.grade = 5;
        }
    }
}