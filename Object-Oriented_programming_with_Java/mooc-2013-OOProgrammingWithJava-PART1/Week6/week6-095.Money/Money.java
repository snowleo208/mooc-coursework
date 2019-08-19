
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public Money plus(Money added) {
        int newEuro = this.euros + added.euros;
        int newCents = this.cents + added.cents;

        return new Money(newEuro, newCents);
    }

    public boolean less(Money compared) {
        if (this.euros < compared.euros) {
            return true;
        }

        if (this.euros == compared.euros && this.cents < compared.cents) {
            return true;
        }

        return false;
    }

    public Money minus(Money decremented) {
        int newEuros = this.euros - decremented.euros;
        int newCents = this.cents - decremented.cents;

        //If the value would be negative, the resulting Money object should have the value 0.
        if (this.less(decremented)) {
            return new Money(0,0);
        }

        if (this.cents < decremented.cents) {
            newEuros--;
            newCents = 100 - decremented.cents;
        }

        Money newAmount = new Money(newEuros, newCents);

        return newAmount;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    @Override
    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }

}
