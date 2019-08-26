package mooc.logic;
import mooc.ui.UserInterface;

public class ApplicationLogic {
    private UserInterface ui;

    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }

    public void execute(int howManyTimes) {
        int n = 0;
        while(n < howManyTimes) {
            System.out.println("The application logic works");
            this.ui.update();
            n++;
        }
    }
}