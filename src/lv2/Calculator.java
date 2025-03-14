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
    // 계산 메서드
    public List<Integer> calculate(int num1, int num2, String operator) {

        // 결과 저장 변수
        double calculationResult = 0;

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
                calculationResult =  (double) num1 / num2;
                break;
        }

        // result 리스트에 추가
        result.add((int) calculationResult);

        // 데이터 보호 강화: 외부에서 리스트 수정 불가
        return Collections.unmodifiableList(result);
    }

    // 삭제 메소드
    public void removeResult() {
        // result 가 비어있을때 대비
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

}
