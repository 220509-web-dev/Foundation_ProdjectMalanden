package dev.landen.entities;


public class app_user {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String pswd;
    private int bank_id;
    private int credit_card_id;
    private int mortgage_id;

    public app_user() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public int getCredit_card_id() {
        return credit_card_id;
    }

    public void setCredit_card_id(int credit_card_id) {
        this.credit_card_id = credit_card_id;
    }

    public int getMortgage_id() {
        return mortgage_id;
    }

    public void setMortgage_id(int mortgage_id) {
        this.mortgage_id = mortgage_id;
    }

    @Override
    public String toString() {
        return "app_user{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", pswd='" + pswd + '\'' +
                ", bank_id=" + bank_id +
                ", credit_card_id=" + credit_card_id +
                ", mortgage_id=" + mortgage_id +
                '}';
    }

    public app_user(int id, String first_name, String last_name, String email, String username, String pswd, int bank_id, int credit_card_id, int mortgage_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.pswd = pswd;
        this.bank_id = bank_id;
        this.credit_card_id = credit_card_id;
        this.mortgage_id = mortgage_id;
    }

}