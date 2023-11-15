package christmas.domain.biz;

import christmas.domain.ui.OutputView;

import java.text.DecimalFormat;
import java.util.Map;

public class Benefit {
    private final Event event = new Event();
    private final OutputView outputView = new OutputView();
    private final DecimalFormat format = new DecimalFormat("###,###");

    public int process(Map<String, Integer> orderMenus, int visitDate) {
        Order order = new Order();
        int totalBenefit = getBenefitList(orderMenus, visitDate);
        int orderPrice = 0;
        for (String orderMenu : orderMenus.keySet()) {
            orderPrice += order.getTotalPrice(orderMenu, orderMenus.get(orderMenu));
        }

        totalBenefit += printGiftPrice(orderPrice);
        outputView.printTotalBenefitPrice(totalBenefit);
        outputView.printExpectPrice(orderPrice - totalBenefit);
        return totalBenefit;
    }

    public int getBenefitList(Map<String, Integer> orderMenus, int visitDate) {
        int totalBenefit = 0;

        System.out.println("<혜택 내역>");
        totalBenefit += printDDayEvent(visitDate, totalBenefit);
        totalBenefit += printWeekDayEvent(orderMenus, visitDate, totalBenefit);
        totalBenefit += printSpecialDayEvent(visitDate, totalBenefit);

        if (totalBenefit < 1) {
            System.out.println("없음");
        }

        return totalBenefit;
    }

    private int printDDayEvent(int visitDate, int totalBenefit) {
        int dDayBenefit = event.checkDDayEvent(visitDate);
        if (dDayBenefit > 0) {
            totalBenefit += dDayBenefit;
            System.out.println("크리스마스 디데이 할인: -" + format.format(dDayBenefit) + "원");
        }
        return totalBenefit;
    }

    private int printWeekDayEvent(Map<String, Integer> orderMenus, int visitDate, int totalBenefit) {
        boolean weekDayYN = event.checkWeekDayEvent(visitDate);
        int weekBenefit = 0;
        for (String orderMenu : orderMenus.keySet()) {
            for (Menu menu : Menu.values()) {
                weekBenefit = getWeekBenefit(weekDayYN, orderMenu, menu);
            }
        }

        if (weekBenefit > 0) {
            totalBenefit += weekBenefit;
            outputView.printWeekBenefitPrice(weekDayYN, weekBenefit);
        }

        return totalBenefit;
    }

    private int getWeekBenefit(boolean weekDayYN, String orderMenu, Menu menu) {
        int weeKBenefit = 0;
        if (weekDayYN) {
            if ("디저트".equals(menu.getTypeName()) && orderMenu.equals(menu.getMenuName())) {
                weeKBenefit += 2023;
            }
            return weeKBenefit;
        }

        if ("메인".equals(menu.getTypeName()) && orderMenu.equals(menu.getMenuName())) {
            weeKBenefit += 2023;
        }
        return weeKBenefit;
    }

    private int printSpecialDayEvent(int visitDate, int totalBenefit) {
        boolean specialDayYN = event.checkSpecialDayEvent(visitDate);
        if (specialDayYN) {
            totalBenefit += 1000;
            System.out.println("특별 할인: -1,000원");
        }
        return totalBenefit;
    }

    private int printGiftPrice(int orderPrice) {
        int giftPrice = 0;
        if (orderPrice > 120000) {
            System.out.println("증정 이벤트: -25,000원");
            return giftPrice;
        }
        return giftPrice;
    }
}