import java.util.HashMap;
import java.util.Map;

public class PromissoryNote {
    private HashMap<String,Double> list;


    public PromissoryNote() {
        this.list = new HashMap<String,Double>();
    }

    public void setLoan(String toWhom, double value) {
        this.list.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose) {
        if(this.list.containsKey(whose)) {
            return this.list.get(whose);
        }

        return 0;
    }

}