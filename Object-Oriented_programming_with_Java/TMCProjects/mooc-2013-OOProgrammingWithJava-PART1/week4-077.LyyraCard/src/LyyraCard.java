/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author snowleo208
 */
public class LyyraCard {
    private double balance;

    public LyyraCard(double balanceAtStart) {
        // write code here
        this.balance = balanceAtStart;
    }

    public String toString() {
        // write code here
        return "The card has "+ this.balance +" euros";
    }
    
    public void payEconomical() {
    // write code here
        if (this.balance - 2.50 < 0) return;
        this.balance -= 2.50;
    }

    public void payGourmet() {
        // write code here
        if (this.balance - 4.00 < 0) return;
        this.balance -= 4.00;
    }
    
    public void loadMoney(double amount) {
    // write code here
        if (amount <= 0) return;
        
        this.balance += amount;
        if(this.balance >= 150) {
            this.balance = 150;
        }
    }

}
    