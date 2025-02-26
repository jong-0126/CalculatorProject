package lv2;

import java.util.Scanner;

public class Calculator {

    //속성
    private int num1, num2;
    private char operator;
    private int result;

    //생성자
    public Calculator(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    //기능
    public int calculator() {

        if(operator == '+') {
            result = num1 + num2;
        }else if(operator == '-') {
            result = num1 - num2;
        }else if(operator == '*') {
            result = num1 * num2;
        }else if(operator == '/') {
            if(num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                result = 0;
            }else{
                result = num1 / num2;
            }
        }else{
            System.out.println("잘못 입력하셨습니다.");
            result = 0;
        }

        return result;
    }

    void removeResult() {
        result = 0;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
