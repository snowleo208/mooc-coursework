public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int montd, int year) {
        this.day = day;
        this.month = montd;
        this.year = year;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(MyDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month
                && this.day < compared.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(MyDate comparedDate) {
        int years = this.year * 365;
        int months = this.month * 12;
        int days = this.day;
        int currYear = years + months + days;

        int comparedYears = comparedDate.year * 365;
        int comparedMonths = comparedDate.month * 12;
        int comparedDays = comparedDate.day;
        int compareYear = comparedYears + comparedMonths + comparedDays;

//        System.out.println(currYear);
//        System.out.println(compareYear);
//        System.out.println(Math.abs((currYear - compareYear) / 365));

        return Math.abs((currYear - compareYear) / 365);
    }

}
