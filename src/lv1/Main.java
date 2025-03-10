package lv1;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        String operator = "";

        while (true) {
            int result = 0;
            System.out.println("계산기 입니다.");

            /**
             * 이전 코드
             * System.out.println("첫번째 숫자를 입력하세요: ");
             * num1 = sc.nextInt();
             * 첫번째 양의 정수 입력
             * 코드리뷰 반영(양의 정수만 입력 가능)
             */
            while (true) {
                System.out.println("첫번째 숫자를 입력하세요: ");
                num1 = sc.nextInt();
                if (num1 < 0) {
                    System.out.println("양의 정수를 입력해주세요");
                } else {
                    break;
                }
            }

            /**
             * 이전 코드
             * System.out.println("첫번째 숫자를 입력하세요: ");
             * num1 = sc.nextInt();
             * 두번째 양의 정수 입력
             * 코드 리뷰 반영 양의 정수만 입력 가능
             */
            while (true) {
                System.out.println("두번째 숫자를 입력하세요: ");
                num2 = sc.nextInt();
                if (num2 < 0) {
                    System.out.println("양의 정수를 입력해주세요");
                } else {
                    break;
                }
            }

            /**
             * 이전 코드
             * System.out.println("사칙연산 기호를 입력하세요: ");
             * operator = sc.next().charAt(0);
             * 사칙 연산 기호 입력
             * 코드 리뷰 반영 사칙연산 기호만 입력 가능
             */

            while (true) {
                System.out.println("사칙연산 기호를 입력하세요: ");
                operator = sc.next();
                // 정규 표현식 사용
                if (operator.length() == 1 && operator.matches("[+\\-*/]")) {
                    break;
                } else {
                    System.out.println("사칙 연산 기호를 다시 입력해주세요");
                }
            }

            // 연산 부분
            if (operator.equals("+")) {
                result = num1 + num2;
            } else if (operator.equals("-")) {
                result = num1 - num2;
            } else if (operator.equals("*")) {
                result = num1 * num2;
            } else if (operator.equals("/")) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue;
                }
            } else {
                System.out.println("연산자를 입력해주세요");
            }

            System.out.println("결과: " + result);

            sc.nextLine();

            // 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.nextLine();
            if (exit.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}