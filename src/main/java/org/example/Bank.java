package org.example;

import java.util.HashMap;
import java.util.Set;

public class Bank {
    private HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private double rate = 0.1;
    private int nextacct = 0;
    public int newAccount(boolean isForeign){
        int acctnum = nextacct++;
        BankAccount ba = new BankAccount(acctnum);
        ba.setForeign(isForeign);
        accounts.put(acctnum, ba);
        return acctnum;
    }
    public int getBalance(int acctNum){
        BankAccount ba = accounts.get(acctNum);
        return ba.getBalance();
    }
    public void deposit(int acctNum, int amt){
        BankAccount ba = accounts.get(acctNum);
        int balance = ba.getBalance();
        ba.setBalance(balance + amt);
    }
    public boolean authorizeLoan(int acctNum, int loanAmt){
        BankAccount ba = accounts.get(acctNum);
        int balance = ba.getBalance();
        return balance >= loanAmt / 2;
    }
    public void setForeign(int acctnum, boolean isForeign){
        BankAccount ba = accounts.get(acctnum);
        ba.setForeign(isForeign);
    }

    public String toString(){
        String result = "The bank has " + accounts.size() + " acounts.";
        for(BankAccount ba: accounts.values()){
            result += "\n\tBank account " + ba.getAccnum() + ": balance = " + ba.getBalance()
             + " is " + (ba.isForeign() ? "foreign" : "domestic");
        }
        return result;
    }
    public void addInterest(){
        for(BankAccount ba: accounts.values()){
            int balance = ba.getBalance();
            balance += (int) (balance * rate);
            ba.setBalance(balance);
        }
    }
}
