package dev.landen.entities;

public class bank_accounts {

    private int bank_id;
    private int app_user_account_number;

    public bank_accounts(int bank_id, int app_user_account_number) {
        this.bank_id = bank_id;
        this.app_user_account_number = app_user_account_number;
    }

    public bank_accounts() {
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public int getApp_user_account_number() {
        return app_user_account_number;
    }

    public void setApp_user_account_number(int app_user_account_number) {
        this.app_user_account_number = app_user_account_number;
    }

    @Override
    public String toString() {
        return "bank_accounts{" +
                "bank_id=" + bank_id +
                ", app_user_account_number=" + app_user_account_number +
                '}';
    }
}
