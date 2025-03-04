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
                num1 = getNumber(sc, "첫번째 숫자를 입력해주세요.");
                num2 = getNumber(sc, "두번째 숫자를 입력해주세요.");
                operator = getOperator(sc);

                calc.calculate(num1, num2, operator);
                System.out.println("결과:" + calc.getResult());

            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                sc.nextLine();
                continue;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
                continue;
            }

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

    // 숫자 입력 메서드
    private static int getNumber(Scanner sc, String message) {
        while (true) {
            System.out.println(message);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.out.println("양의 정수를 입력해주세요");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요");
            }
        }
    }

    // 사칙연산 기호 메서드
    private static String getOperator(Scanner sc){
        while(true){
            System.out.println("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            String operator = sc.nextLine();
            if(operator.matches("[+\\-*/]")){
                return operator;
            }else{
                System.out.println("올바른 사칙연산 기호를 입력해주세요.");
            }
        }
    }
}