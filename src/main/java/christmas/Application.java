package christmas;

import christmas.domain.biz.Date;
import christmas.domain.biz.Event;
import christmas.domain.biz.Order;
import christmas.domain.ui.InputView;

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
        Map<String, Integer> orderMenu = order.validateForm(inputMenu);
        order.validateMenu(orderMenu);
    }
}
