package challenge;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator calc = new ArithmeticCalculator();
        while (true) {
            try {
                System.out.println("첫번째 숫자를 입력하세요: ");
                String firstInput = sc.next();
                Number firstNum = firstInput.contains(".") ? Double.parseDouble(firstInput) : Integer.parseInt(firstInput);

                System.out.println("두번째 숫자를 입력하세요: ");
                String secondInput = sc.next();
                Number secondNum = secondInput.contains(".") ? Double.parseDouble(secondInput) : Integer.parseInt(secondInput);


                System.out.println("사칙연산 기호를 입력하세요: ");
                char op = sc.next().charAt(0);

                OperatorType operator = getOperatorType(op);


                calc.calculate(firstNum, secondNum, operator);
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
    // 연산자 문자로부터 OperatorType을 찾는 메서드
    private static OperatorType getOperatorType(char symbol) {
        return Arrays.stream(OperatorType.values())
                .filter(op -> op.getSymbol() == symbol)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("잘못된 연산자 입니다."));
    }
}