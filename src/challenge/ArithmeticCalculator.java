package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ArithmeticCalculator<T extends Number> {

    // 속성
    private List<Double> result = new ArrayList<>();

    // 연산자와 해당 연산을 연결하는 맵
    private final Map<OperatorType, Operator> OPERATOR_MAP = Map.of(
            OperatorType.PLUS, (a,b) -> a+b,
            OperatorType.MINUS, (a,b) -> a-b,
            OperatorType.MULTIPLY, (a, b) -> a * b,
            OperatorType.DIVIDE, (a, b) -> {
                if(b == 0) {
                    throw new RuntimeException("0으로 나눌 수 없습니다.");
                }
                return a/b;
            }
    );


    // 기능
    public void calculate(T firstNum, T secondNum, OperatorType operator) {

        double num1 = firstNum.doubleValue();
        double num2 = secondNum.doubleValue();

        Operator operatorFunction = OPERATOR_MAP.get(operator);
        if(operatorFunction == null){
            throw new RuntimeException("잘못된 연산자 입니다.");
        }

        double calculationResult = operatorFunction.operate(num1, num2);
        result.add(calculationResult);


//        if (operator == OperatorType.PLUS) {
//            calculationResult = sum.operate(num1, num2) ;
//        } else if (operator == OperatorType.MINUS) {
//            calculationResult = sub.operate(num1, num2);
//        } else if (operator == OperatorType.MULTIPLY) {
//            calculationResult = mul.operate(num1, num2);
//        } else if (operator == OperatorType.DIVIDE) {
//            if (num2 == 0) {
//                throw new RuntimeException("0으로 나눌 수 없습니다.");
//            } else {
//                calculationResult = div.operate(num1, num2);
//            }
//        } else {
//            throw new RuntimeException("잘못 입력하셨습니다. 다시 입력해주세요");
//        }

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
