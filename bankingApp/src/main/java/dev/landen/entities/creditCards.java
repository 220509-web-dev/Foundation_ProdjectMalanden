package dev.landen.entities;

public class creditCards {

    private int credit_card_id;
    private int user_credit_card_numbers;

    public creditCards(int credit_card_id, int user_credit_card_numbers) {
        this.credit_card_id = credit_card_id;
        this.user_credit_card_numbers = user_credit_card_numbers;
    }

    public creditCards() {
    }

    public int getCredit_card_id() {
        return credit_card_id;
    }

    public void setCredit_card_id(int credit_card_id) {
        this.credit_card_id = credit_card_id;
    }

    public int getUser_credit_card_numbers() {
        return user_credit_card_numbers;
    }

    public void setUser_credit_card_numbers(int user_credit_card_numbers) {
        this.user_credit_card_numbers = user_credit_card_numbers;
    }

    @Override
    public String toString() {
        return "creditCards{" +
                "credit_card_id=" + credit_card_id +
                ", user_credit_card_numbers=" + user_credit_card_numbers +
                '}';
    }
}
