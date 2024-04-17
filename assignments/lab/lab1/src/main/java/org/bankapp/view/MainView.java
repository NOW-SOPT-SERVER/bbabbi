package org.bankapp.view;

import org.bankapp.controller.BankController;
import java.util.Scanner;

public class MainView {

    private BankController bankController;
    private Scanner sc;

    public MainView() {
        bankController = new BankController();
        sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            printMenu();
            System.out.print("선택:");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        bankController.createAccount();
                        break;
                    case 2:
                        bankController.deposit();
                        break;
                    case 3:
                        bankController.withdraw();
                        break;
                    case 4:
                        System.out.println("출금계좌\t입금계좌\t이체금액");
                        bankController.transfer();
                        break;
                    case 5:
                        System.out.println("조회할 계좌번호\t성명\t잔액");
                        bankController.inquire();
                        break;
                    case 6:
                        System.out.println("종료합니다.");
                        sc.close();
                        return;
                    default:
                        System.out.println("잘못 누르셨습니다. 다시 선택해주세요.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("올바른 값을 입력해주세요.");
//                sc.nextLine(); // 입력 버퍼 클리어
                e.printStackTrace();
            }
        }
    }

    public static void printMenu() {
        System.out.println("========================================");
        System.out.println("           🏦 은행 서비스 선택 🏦            ");
        System.out.println("========================================");
        System.out.println("  1️⃣. 계좌개설");
        System.out.println("  2️⃣. 입금");
        System.out.println("  3️⃣. 출금");
        System.out.println("  4️⃣. 계좌이체");
        System.out.println("  5️⃣. 잔액조회");
        System.out.println("  6️⃣. 프로그램종료");
        System.out.println("========================================");
    }
}

