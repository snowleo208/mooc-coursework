import java.util.ArrayList;

public class Flight {
    private Airplane plane;
    private String origin;
    private String destination;

    public Flight (Airplane plane, String origin, String destination) {
        this.plane = plane;
        this.origin = origin;
        this.destination = destination;
    }

    public Airplane getPlane() {
        return plane;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String toString() {
        return this.plane + " (" + this.origin + "-" + this.destination + ")";
    }
}