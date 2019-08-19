
public class Main {

    public static void main(String[] args) {
        // Test your code here!
        Money a = new Money(10,0);
        Money b = new Money(3,50);


        Money r1 = new Money(1,0);
        Money r2 = new Money(1,50);
        System.out.println(r1.less(r2));

        Money c = a.minus(b);

        System.out.println(a);  // 10.00e
        System.out.println(b);  // 3.50e
        System.out.println(c);  // 6.50e

        c = c.minus(a);         // NOTE: new Money-object is created and reference to that
                                // is assigned to variable c
                                // the Money object 6.50e that variable c used to hold,
                                // is not referenced anymore

        System.out.println(a);  // 10.00e
        System.out.println(b);  // 3.50e
        System.out.println(c);  // 0.00e
    }
}
