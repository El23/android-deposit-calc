package com.blueteam.fincalc.data.model;


public class Deposit {


    private double depositAmount;
    private int depositTerm;
    private double depositReplenishment;
    private double depositRate;
    private boolean isCapitalizationEnabled;
    private double depositTax;

    public Deposit(double depositAmount, int depositTerm, double depositReplenishment, double depositRate, boolean isCapitalizationEnabled, double depositTax) {
        this.depositAmount = depositAmount;
        this.depositTerm = depositTerm;
        this.depositReplenishment = depositReplenishment;
        this.depositRate = depositRate;
        this.isCapitalizationEnabled = isCapitalizationEnabled;
        this.depositTax = depositTax;
    }

    public double getMonthlyIncome() {
        double monthlyIncome;
        monthlyIncome = (depositAmount * depositRate) / 12;
        monthlyIncome = monthlyIncome * (1 - depositTax);

        return monthlyIncome;
    }

    public double getDepositRepAmount() {
        double depositRepAmount = 0;

        if (isCapitalizationEnabled) {
            for (int i = 1; i < depositTerm + 1; i++) {
                depositRepAmount += depositReplenishment + getMonthlyIncome();
            }
        } else {
            depositRepAmount = depositReplenishment * depositTerm;
        }
        return depositRepAmount;
    }


    public double getTotalRev() {
        double totalRev = 0;
        if (isCapitalizationEnabled) {
            for (int i = 1; i < depositTerm + 1; i++) {
                totalRev += getMonthlyIncome();
                depositAmount += getMonthlyIncome();
            }
        } else {
            totalRev = getMonthlyIncome() * depositTerm;
        }
        return totalRev;
    }


    public double getTotalAmount() {
        double totalAmount;
        if (isCapitalizationEnabled) {
            totalAmount = depositAmount + getDepositRepAmount();
        } else {
            totalAmount = depositAmount + getDepositRepAmount() + getTotalRev();
        }
        return totalAmount;
    }

}
