import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RingingCentre {
    private Map<Bird, List<String>> observeList;

    public RingingCentre () {
        this.observeList = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if(this.observeList.containsKey(bird)) {
            this.observeList.get(bird).add(place);
        } else {
            List<String> places = new ArrayList<String>();
            places.add(place);
            this.observeList.put(bird, places);
        }
    }

    public void observations(Bird bird) {
        if(this.observeList.size() <= 0 || !this.observeList.containsKey(bird)) {
            System.out.println(bird + " observations: " + 0);
        } else {
            System.out.print(bird);
            System.out.print(" observations: ");
            System.out.println(this.observeList.get(bird).size());
        }

        if(this.observeList.containsKey(bird)) {
            for(String places : this.observeList.get(bird)) {
                System.out.println(places);
            }
        }
    }
}