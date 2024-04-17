package org.bankapp.model;

public class Bank {
    private int id;       //계좌번호
    private String name;  //이름
    private long balance; //잔액

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}
