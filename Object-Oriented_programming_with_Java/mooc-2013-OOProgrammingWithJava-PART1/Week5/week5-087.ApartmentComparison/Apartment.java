
public class Apartment {

    private int rooms;
    private int squareMeters;
    private int pricePerSquareMeter;

    public Apartment(int rooms, int squareMeters, int pricePerSquareMeter) {
        this.rooms = rooms;
        this.squareMeters = squareMeters;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public boolean larger(Apartment otherApartment) {
        return this.squareMeters > otherApartment.squareMeters;
    }

    public int priceDifference(Apartment otherApartment) {
        int currentPrice = this.squareMeters * this.pricePerSquareMeter;
        int ComparePrice = otherApartment.squareMeters * otherApartment.pricePerSquareMeter;

        return Math.abs(currentPrice - ComparePrice);
    }

    public boolean moreExpensiveThan(Apartment otherApartment) {
        return this.pricePerSquareMeter > otherApartment.pricePerSquareMeter;
    }

}