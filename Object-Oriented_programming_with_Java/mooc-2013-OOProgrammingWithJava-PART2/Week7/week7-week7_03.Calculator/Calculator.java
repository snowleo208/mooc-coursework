public class Calculator {
    private int times;
    private Reader reader;

    public Calculator() {
        this.times = 0;
        this.reader = new Reader();
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = this.reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }

    private void sum() {
        System.out.print("value1: ");
        int value1 = this.reader.readInteger(); // read the value using the Reader-object
        System.out.print("value2: ");
        int value2 = this.reader.readInteger(); // read the value using the Reader-object

        // print the value according to the example above
        System.out.print("sum of the values ");
        System.out.print(value1 + value2);
        System.out.println();

        this.times++;
    }

    private void product() {
        System.out.print("value1: ");
        int value1 = this.reader.readInteger(); // read the value using the Reader-object
        System.out.print("value2: ");
        int value2 = this.reader.readInteger(); // read the value using the Reader-object

        // print the value according to the example above
        System.out.print("product of the values ");
        System.out.print(value1 * value2);
        System.out.println();

        this.times++;
    }

    private void difference() {
        System.out.print("value1: ");
        int value1 = this.reader.readInteger(); // read the value using the Reader-object
        System.out.print("value2: ");
        int value2 = this.reader.readInteger(); // read the value using the Reader-object

        // print the value according to the example above
        System.out.print("difference of the values ");
        System.out.print(value1 - value2);
        System.out.println();

        this.times++;
    }

    private void statistics() {
        System.out.print("Calculations done ");
        System.out.print(this.times);
    }
}