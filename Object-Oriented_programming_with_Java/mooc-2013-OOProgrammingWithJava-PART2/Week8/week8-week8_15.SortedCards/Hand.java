import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> list;

    public Hand () {
        this.list = new ArrayList<Card>();
    }

    public void add (Card card) {
        this.list.add(card);
    }

    public void print () {
        for (Card c : this.list) {
            System.out.println(c);
        }
    }

    public void sort() {
        Collections.sort(this.list);
    }

    public void sortAgainstSuit() {
        SortAgainstSuitAndValue sorter = new SortAgainstSuitAndValue();
        Collections.sort(this.list, sorter);
    }

    @Override
    public int compareTo (Hand h) {
        int a = 0;
        for (Card card : h.list){
            a += card.getValue();
        }

        int b = 0;
        for (Card card : this.list){
            b += card.getValue();
        }

        return b - a;
    }
}