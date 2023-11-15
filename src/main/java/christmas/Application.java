package christmas;

import christmas.domain.biz.*;
import christmas.domain.ui.InputView;
import christmas.domain.ui.OutputView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Date date = new Date();
        int visitDate = date.getDate();

        Event event = new Event();
        event.checkEvent(visitDate);

        Order order = new Order();
        Map<String, Integer> orderMenus = order.process();

        System.out.println("\n12월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        OutputView outputView = new OutputView();
        outputView.printOrderMenu(orderMenus);
        int totalOrderPrice = outputView.printOrderPrice(orderMenus);

        Gift gift = new Gift();
        gift.checkGift(totalOrderPrice);

        int totalBenefit = outputView.printBenefit(orderMenus, visitDate);

        Badge badge = new Badge();
        String badgeName = badge.giveBadge(totalBenefit);

        outputView.printBadge(badgeName);
    }
}
