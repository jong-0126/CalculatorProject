package challenge;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {

    // 속성
    private List<Double> result = new ArrayList<>();


    // 기능
    public void calculator(T firstNum, T secondNum, char operator) {

        double num1 = firstNum.doubleValue();
        double num2 = secondNum.doubleValue();
//
//        Calculator cal = new Calculator();
//        double sum = cal.sum(num1, num2);
//
//
//        CalculatorSub sub = (a, b) -> num1 - num2;

        if (operator == OperatorType.PLUS.getSymbol()) {
            result.add(num1 + num2);
        } else if (operator == OperatorType.MINUS.getSymbol()) {
            result.add(num1 - num2);
        } else if (operator == OperatorType.MULTIPLY.getSymbol()) {
            result.add(num1 * num2);
        } else if (operator == OperatorType.DIVIDE.getSymbol()) {
            if (num2 == 0) {
                throw new RuntimeException("0으로 나눌 수 없습니다.");
            } else {
                result.add(num1 / num2);
            }
        } else {
            throw new RuntimeException("잘못 입력하셨습니다. 다시 입력해주세요");
        }
    }

    public void removeResult() {
        result.remove(0);
        System.out.println("첫번째 결과가 제거 되었습니다.");
        System.out.println(result);
    }

    public List<Double> getResult() {
        return result;
    }

}
