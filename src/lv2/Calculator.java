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

        if (operator.equals("+")) {
            calculationResult = num1 + num2;
        } else if (operator.equals("-")) {
            calculationResult = num1 - num2;
        } else if (operator.equals("*")) {
            calculationResult = num1 * num2;
        } else if (operator.equals("/")) {
            if (num2 == 0) {
                // 예외 처리
                throw new RuntimeException("0으로 나눌 수 없습니다.");
            } else {
                calculationResult = num1 / num2;
            }
        } else {
            throw new RuntimeException("잘못 입력하셨습니다. 다시 입력해주세요");
        }

        // result 리스트에 추가
        this.result.add(calculationResult);

        return this.result;
    }

    // 삭제 메소드
    public void removeResult() {
        result.remove(0);
        System.out.println("첫번째 결과가 제거 되었습니다.");
        System.out.println(result);
    }

    // getter
    public List<Integer> getResult() {
        return result;
    }

    // setter
    public void setResult(List<Integer> result) {
        this.result = result;
    }
}
