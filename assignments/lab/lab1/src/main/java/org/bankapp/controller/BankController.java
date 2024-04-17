package org.bankapp.controller;

import org.bankapp.model.Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class BankController {
    private ArrayList<Bank> list;
    private Scanner sc;

    public BankController() {
        list = new ArrayList<Bank>();
        sc = new Scanner(System.in);
    }

    // 1. 계좌 개설
    public void createAccount() {
        Bank bank = new Bank();

        Scanner sc = new Scanner(System.in);
        System.out.print("계좌번호:");
        bank.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("이름:");
        bank.setName(sc.next());

        System.out.print("입금액:");
        bank.setBalance(sc.nextLong());
        sc.nextLine();

        list.add(bank);

        System.out.println("계좌가 개설되었습니다.");
        System.out.println(list.toString() +"\t");

    }

    //2. 입금
    public void deposit() {
        System.out.print("계좌번호:");
        int id = sc.nextInt();

        System.out.print("입금액:");
        long money = sc.nextLong();

        for(int i=0; i<list.size(); i++) {
            Bank bank = list.get(i);

            if(bank.getId()==id) {
                long balance = bank.getBalance();
                money += balance;

                bank.setBalance(money);
                System.out.println("💰입금 완료💰");
                return;
            }
        }
        System.out.println("해당 계좌번호가 존재하지 않습니다.");
    }


    //3. 출금
    public void withdraw() {
        System.out.print("계좌번호:");
        int id = sc.nextInt();

        System.out.print("출금액:");
        long money = sc.nextLong();

        for(int i=0; i<list.size(); i++) {
            Bank bank = list.get(i);

            if(bank.getId()==id) {
                if(bank.getBalance() < money) {
                    System.out.println("잔액이 부족합니다.");
                    return;
                }else {
                    long balance = bank.getBalance();
                    money = balance - money;

                    bank.setBalance(money);
                    System.out.println("💰출금 완료💰");
                    return;
                }
            }
        }
        System.out.println("해당 계좌번호가 존재하지 않습니다.");

    }

    //4. 계좌이체
    public void transfer() {
        System.out.print("출금할 계좌번호:");
        int fromId = sc.nextInt();

        System.out.print("입금할 계좌번호:");
        int toId = sc.nextInt();

        System.out.print("이체 금액:");
        long amount = sc.nextLong();

        Bank fromBank = null;
        Bank toBank = null;

        for (Bank bank : list) {
            if (bank.getId() == fromId) {
                fromBank = bank;
            } else if (bank.getId() == toId) {
                toBank = bank;
            }
        }

        if (fromBank == null || toBank == null) {
            System.out.println("계좌번호가 잘못되었습니다.");
            return;
        }

        if (fromBank.getBalance() < amount) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        // 이체 처리
        fromBank.setBalance(fromBank.getBalance() - amount);
        toBank.setBalance(toBank.getBalance() + amount);

        System.out.println("💸 " + amount + "원이 " + fromBank.getId() + "계좌에서 " + toBank.getId() + "계좌로 이체되었습니다.");
    }

    //5. 잔액조회
    public void inquire() {	//잔액조회
        System.out.print("계좌번호:");
        int id = sc.nextInt();

        for(int i=0; i<list.size(); i++) {
            Bank bank = list.get(i);

            if(bank.getId()==id) {
                System.out.println(bank.getId() + "\t" + bank.getName() + "\t" + bank.getBalance());
                return;
            }
        }
        System.out.println("해당 계좌번호가 존재하지 않습니다.");
    }
}
