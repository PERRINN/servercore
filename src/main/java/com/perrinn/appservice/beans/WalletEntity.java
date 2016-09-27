package com.perrinn.appservice.beans;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class WalletEntity {
    private int id;
    private double credit;
    private int currency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WalletEntity that = (WalletEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.credit, credit) != 0) return false;
        if (currency != that.currency) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(credit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + currency;
        return result;
    }
}
