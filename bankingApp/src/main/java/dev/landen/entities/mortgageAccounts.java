package dev.landen.entities;

public class mortgageAccounts {

    private int  mortgage_id;
    private int user_mortgage_account_number;

    public mortgageAccounts(int mortgage_id, int user_mortgage_account_number) {
        this.mortgage_id = mortgage_id;
        this.user_mortgage_account_number = user_mortgage_account_number;
    }

    public mortgageAccounts() {
    }

    public int getMortgage_id() {
        return mortgage_id;
    }

    public void setMortgage_id(int mortgage_id) {
        this.mortgage_id = mortgage_id;
    }

    public int getUser_mortgage_account_number() {
        return user_mortgage_account_number;
    }

    public void setUser_mortgage_account_number(int user_mortgage_account_number) {
        this.user_mortgage_account_number = user_mortgage_account_number;
    }

    @Override
    public String toString() {
        return "mortgageAccounts{" +
                "mortgage_id=" + mortgage_id +
                ", user_mortgage_account_number=" + user_mortgage_account_number +
                '}';
    }
}
