package christmas.domain.biz;

import christmas.domain.ui.OutputView;

import java.util.Map;

public class Gift {
    public void checkGift(int totalOrderPrice) {
        System.out.println("<증정 메뉴>");
        if (totalOrderPrice > 120_000) {
            System.out.println("샴페인 1개\n");
            return;
        }
        System.out.println("없음\n");
    }
}
