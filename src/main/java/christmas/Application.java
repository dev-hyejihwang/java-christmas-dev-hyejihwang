package christmas;

import christmas.domain.biz.*;
import christmas.domain.ui.InputView;
import christmas.domain.ui.OutputView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

        InputView inputView = new InputView();
        String inputDate = inputView.readDate();

        Date date = new Date();
        int visitDate = date.validateDate(inputDate);
        date.confirmDate(visitDate);

        Event event = new Event();
        event.checkEvent(visitDate);

        String inputMenu = inputView.readMenu();
        Order order = new Order();
        Map<String, Integer> orderMenus = order.validateForm(inputMenu);
        order.validateMenu(orderMenus);
        order.validateMenuCount(orderMenus);

        System.out.println("12월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        OutputView outputView = new OutputView();
        outputView.printOrderMenu(orderMenus);
        outputView.printOrderPrice(orderMenus);

        Gift gift = new Gift();
        gift.checkGift(orderMenus);

        int totalBenefit = outputView.printBenefit(orderMenus, visitDate);

        Badge badge = new Badge();
        badge.giveBadge(totalBenefit);

    }
}
