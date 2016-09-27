package com.perrinn.appservice.beans;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class CurrencyEntity {
    private int id;
    private String code;
    private double buyRate;
    private double sellRate;
    private String currency;
    private double input;
    private double output;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(double buyRate) {
        this.buyRate = buyRate;
    }

    public double getSellRate() {
        return sellRate;
    }

    public void setSellRate(double sellRate) {
        this.sellRate = sellRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getInput() {
        return input;
    }

    public void setInput(double input) {
        this.input = input;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyEntity that = (CurrencyEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.buyRate, buyRate) != 0) return false;
        if (Double.compare(that.sellRate, sellRate) != 0) return false;
        if (Double.compare(that.input, input) != 0) return false;
        if (Double.compare(that.output, output) != 0) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        temp = Double.doubleToLongBits(buyRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sellRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        temp = Double.doubleToLongBits(input);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(output);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
