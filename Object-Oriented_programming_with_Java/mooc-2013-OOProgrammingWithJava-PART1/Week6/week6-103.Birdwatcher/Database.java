import java.util.ArrayList;

public class Database {
    private ArrayList<Bird> db;

    public Database () {
        this.db = new ArrayList<Bird>();
    }

    public ArrayList<Bird> getDb() {
        return db;
    }

    public void add(Bird bird) {
        db.add(bird);
    }

    public boolean observation (String name) {
        for(Bird bird : this.db) {
            if(bird.getName().equals(name)) {
                bird.observe();
                return true;
            }
        }

        return false;
    }

    public boolean statistics () {
        for(Bird bird : this.db) {
            System.out.println(bird);
        }

        return false;
    }

    public void show (String name) {
        for(Bird bird : this.db) {
            if(bird.getName().contains(name)) {
                System.out.println(bird);
            }
        }
    }
}