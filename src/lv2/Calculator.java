package lv2;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    //속성
    private ArrayList<Integer> result = new ArrayList<>();

    //기능
    public void calculator(int firstNum, int secondNum, char operator) {

        if(operator == '+') {
            result.add(firstNum + secondNum);
        }else if(operator == '-') {
            result.add(firstNum - secondNum);
        }else if(operator == '*') {
            result.add(firstNum * secondNum);
        }else if(operator == '/') {
            if(secondNum == 0) {
                throw new RuntimeException("0으로 나눌 수 없습니다.");
            }else{
                result.add(firstNum / secondNum);
            }
        }else{
            System.out.println("잘못 입력하셨습니다.");
        }
    }

    void removeResult() {
        result.remove(0);
        System.out.println("첫번째 결과가 제거 되었습니다.");
        System.out.println(result);
    }

    public ArrayList<Integer> getResult() {
        return result;
    }
}
