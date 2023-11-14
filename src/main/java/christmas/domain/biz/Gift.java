package christmas.domain.biz;

import christmas.domain.ui.OutputView;

import java.util.Map;

public class Gift {
    public void checkGift(Map<String, Integer> orderMenus, int totalOrderPrice){

        if(totalOrderPrice > 120000){
            System.out.println("<증정 메뉴>");
            System.out.println("샴페인 1개");
        }

        //TODO 총 구매 개수 20개 미만 체크 총 주문 금액 11만원 ~ 11만 9000원 인 경우 차액 만큼 구매시 샴페인 증정 안내 문구 출력
        //TODO 추가 주문 여분 확인 후 추가 주문 가능하도록 구현
    }
}
