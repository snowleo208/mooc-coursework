public class CashRegister {

    private double cashInRegister;
    private int economicalSold;
    private int gourmetSold;

    public CashRegister() {
        // at start the register has 1000 euros
        this.cashInRegister = 1000;
    }

    public double payEconomical(double cashGiven) {
        // price of the economical lunch is 2.50 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price 
        // if not enough money given, all is returned and nothing else happens
        if(cashGiven >= 2.50) {
            this.cashInRegister += 2.50;
            this.economicalSold += 1;
            return (cashGiven - 2.50);
        } else {
            return cashGiven;
        }
    }

    public boolean payEconomical(LyyraCard card) {
        // price of the economical lunch is 2.50 euros
        // if the given cash is at least the price of the lunch:
        //    card payments do not affect the amount of money in the register
        //    the amount of sold lunch is incremented by one
        boolean canPay = card.pay(2.50);

        if(canPay) {
            this.economicalSold += 1;
        }

        return canPay;
    }

    public double payGourmet(double cashGiven) {
        // price of the gourmet lunch is 4.00 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price
        // if not enough money given, all is returned and nothing else happens
        if(cashGiven >= 4.00) {
            this.cashInRegister += 4.00;
            this.gourmetSold += 1;
            return (cashGiven - 4.00);
        } else {
            return cashGiven;
        }
    }

    public boolean payGourmet(LyyraCard card) {
        // price of the gourmet lunch is 4.00 euros
        // if the given cash is at least the price of the lunch:
        //    card payments do not affect the amount of money in the register
        //    the amount of sold lunch is incremented by one
        boolean canPay = card.pay(4.00);

        if(canPay) {
            this.gourmetSold += 1;
        }

        return canPay;
    }

    public void loadMoneyToCard(LyyraCard card, double sum) {
        // load cash to Lyyra Cards
        if(sum > 0) {
            card.loadMoney(sum);
            this.cashInRegister += sum;
        }
    }


    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " gourmet lunches sold: " + gourmetSold;
    }
}
