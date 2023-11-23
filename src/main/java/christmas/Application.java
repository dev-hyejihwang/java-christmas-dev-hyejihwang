package christmas;

import christmas.domain.biz.*;
import christmas.domain.ui.OutputView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int visitDate = dateCheck();

        Map<String, Integer> orderMenus = orderCheck();

        benefitCheck(visitDate, orderMenus);
    }

    private static int dateCheck() {
        Date date = new Date();
        int visitDate = date.getDate();

        Event event = new Event();
        event.checkEvent(visitDate);
        return visitDate;
    }

    private static Map<String, Integer> orderCheck() {
        Order order = new Order();
        return order.process();
    }

    private static void benefitCheck(int visitDate, Map<String, Integer> orderMenus) {
        System.out.println("\n12월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        OutputView outputView = new OutputView();
        outputView.printOrderMenu(orderMenus);
        int totalOrderPrice = outputView.printOrderPrice(orderMenus);

        Gift gift = new Gift();
        gift.checkGift(totalOrderPrice);

        Benefit benefit = new Benefit();
        int totalBenefit = benefit.process(orderMenus, visitDate);

        outputView.printBadge(totalBenefit);
    }
}
