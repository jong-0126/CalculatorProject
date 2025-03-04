package lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    //속성
    // 결과 값 저장(컬렉션, 캡슐화)
    private List<Integer> result = new ArrayList<>();

    // 기능
    // 코드리뷰 반영 함수 이름 동사
    // 계산 메소드
    public List<Integer> calculate(int num1, int num2, String operator) {

        // 결과 저장 변수
        int calculationResult;

        // if 문 보다 더 간결함
        switch (operator) {
            case "+":
                calculationResult = num1 + num2;
                break;
            case "-":
                calculationResult = num1 - num2;
                break;
            case "*":
                calculationResult = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                calculationResult = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다. (+, -, *, / 중 하나를 입력해주세요)");
        }

        // result 리스트에 추가
        result.add(calculationResult);

        // 데이터 보호 강화: 외부에서 리스트 수정 불가
        return Collections.unmodifiableList(result);
    }

    // 삭제 메소드
    public void removeResult() {
        // result가 비어있을때 대비
        if (result.isEmpty()) {
            System.out.println("저장된 결과가 없습니다.");
            return;
        }
        result.remove(0);
        System.out.println("첫번째 결과가 제거 되었습니다.");
        System.out.println(result);
    }

    // getter
    public List<Integer> getResult() {
        // 데이터 보호 강화: 리스트를 외부에서 수정할 수 없음
        return Collections.unmodifiableList(result);
    }

    // setter
    public void setResult(List<Integer> result) {
        this.result = result;
    }
}
