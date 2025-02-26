package lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        char operator = ' ';

        while (true) {
            int result = 0;
            System.out.println("계산기 입니다.");
            System.out.println("첫번째 숫자를 입력하세요: ");
            num1 = sc.nextInt();
            System.out.println("두번째 숫자를 입력하세요: ");
            num2 = sc.nextInt();
            System.out.println("사칙연산 기호를 입력하세요: ");
            operator = sc.next().charAt(0);

            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("두번째 정수에 0이 입력 될 수 없습니다.");
                    continue;
                }
            } else {
                System.out.println("연산자를 입력해주세요");
            }

            System.out.println("결과: " + result);

            sc.nextLine();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.nextLine();
            if(exit.equals("exit")){
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}