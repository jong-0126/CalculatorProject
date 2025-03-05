package challenge;

import java.util.ArrayList;
import java.util.List;


public class ArithmeticCalculator<T extends Number> {

    // 속성
    private List<Double> result = new ArrayList<>();


    // 기능
    public void calculate(T firstNum, T secondNum, OperatorType operator) {

        double num1 = firstNum.doubleValue();
        double num2 = secondNum.doubleValue();

        double calculationResult;

        Operator sum = (a, b) -> a + b;
        Operator sub = (a, b) -> a - b;
        Operator mul = (a, b) -> a * b;
        Operator div = (a, b) -> a / b;

        if (operator == OperatorType.PLUS) {
            calculationResult = sum.operate(num1, num2) ;
        } else if (operator == OperatorType.MINUS) {
            calculationResult = sub.operate(num1, num2);
        } else if (operator == OperatorType.MULTIPLY) {
            calculationResult = mul.operate(num1, num2);
        } else if (operator == OperatorType.DIVIDE) {
            if (num2 == 0) {
                throw new RuntimeException("0으로 나눌 수 없습니다.");
            } else {
                calculationResult = div.operate(num1, num2);
            }
        } else {
            throw new RuntimeException("잘못 입력하셨습니다. 다시 입력해주세요");
        }

        result.add(calculationResult);
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
