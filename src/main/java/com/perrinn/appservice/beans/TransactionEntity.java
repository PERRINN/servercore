package com.perrinn.appservice.beans;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class TransactionEntity {
    private int id;
    private int senderTeam;
    private int receiverTeam;
    private int currency;
    private double input;
    private double output;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderTeam() {
        return senderTeam;
    }

    public void setSenderTeam(int senderTeam) {
        this.senderTeam = senderTeam;
    }

    public int getReceiverTeam() {
        return receiverTeam;
    }

    public void setReceiverTeam(int receiverTeam) {
        this.receiverTeam = receiverTeam;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (id != that.id) return false;
        if (senderTeam != that.senderTeam) return false;
        if (receiverTeam != that.receiverTeam) return false;
        if (currency != that.currency) return false;
        if (Double.compare(that.input, input) != 0) return false;
        if (Double.compare(that.output, output) != 0) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + senderTeam;
        result = 31 * result + receiverTeam;
        result = 31 * result + currency;
        temp = Double.doubleToLongBits(input);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(output);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
