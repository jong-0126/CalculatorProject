package lv2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calc = new Calculator();

        while(true){

            System.out.println("첫번째 숫자를 입력하세요: ");
            calc.setNum1(sc.nextInt());
            System.out.println("두번째 숫자를 입력하세요: ");
            calc.setNum2(sc.nextInt());
            System.out.println("사칙연산 기호를 입력하세요: ");
            calc.setOperator(sc.next().charAt(0));

            calc.calculator(calc.getNum1(), calc.getOperator(), calc.getNum2());

            System.out.println("결과:" + calc.getResult());

            sc.nextLine();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.nextLine();
            if(exit.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                calc.removeResult();
                break;
            }
        }
        sc.close();
    }
}
