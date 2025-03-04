package lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        String operator = "";

        Calculator calc = new Calculator();
        while (true) {
            try {
                while (true) {
                    System.out.println("첫번째 숫자를 입력하세요: ");
                    num1 = sc.nextInt();
                    if (num1 < 0) {
                        System.out.println("양의 정수를 입력해주세요");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.println("두번째 숫자를 입력하세요: ");
                    num2 = sc.nextInt();
                    if (num2 < 0) {
                        System.out.println("양의 정수를 입력해주세요");
                    } else {
                        break;
                    }
                }

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

                calc.setResult(calc.calculate(num1, num2, operator));
                System.out.println("결과:" + calc.getResult());

            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                sc.nextLine();
                continue;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
                continue;
            }

            sc.nextLine();

            System.out.println("첫 번째 데이터 삭제하기 - (yes/no)");
            String removeResult = sc.nextLine();
            if (removeResult.equals("yes")) {
                calc.removeResult();
            }

            System.out.println("더 계산하시겠습니까? 아무키나 눌러주세요(exit 입력 시 종료)");

            String exit = sc.nextLine();
            if (exit.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}