package christmas.domain.biz;

import christmas.domain.ui.OutputView;

import java.text.DecimalFormat;
import java.util.Map;

public class Benefit {

    private static final int WEEK_BENEFIT_AMOUNT = 2023;
    private static final int SPECIAL_BENEFIT_AMOUNT = 1000;
    private static final int GIFT_BENEFIT_AMOUNT = 120000;
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
        totalBenefit += printDDayEvent(visitDate);
        totalBenefit += printWeekDayEvent(orderMenus, visitDate);
        totalBenefit += printSpecialDayEvent(visitDate);

        if (totalBenefit < 1) {
            System.out.println("없음");
        }

        return totalBenefit;
    }

    private int printDDayEvent(int visitDate) {
        int dDayBenefit = event.checkDDayEvent(visitDate);
        if (dDayBenefit > 0) {
            System.out.println("크리스마스 디데이 할인: -" + format.format(dDayBenefit) + "원");
        }
        return dDayBenefit;
    }

    private int printWeekDayEvent(Map<String, Integer> orderMenus, int visitDate) {
        boolean weekDayYN = event.checkWeekDayEvent(visitDate);
        int weekBenefit = 0;
        for (String orderMenu : orderMenus.keySet()) {
            for (Menu menu : Menu.values()) {
                weekBenefit += getWeekBenefit(weekDayYN, orderMenu, orderMenus.get(orderMenu), menu);
            }
        }

        if (weekBenefit > 0) {
            outputView.printWeekBenefitPrice(weekDayYN, weekBenefit);
        }

        return weekBenefit;
    }

    private int getWeekBenefit(boolean weekDayYN, String orderMenu, Integer orderCount, Menu menu) {
        int weeKBenefit = 0;
        if (weekDayYN && "디저트".equals(menu.getTypeName()) && orderMenu.equals(menu.getMenuName())) {
            weeKBenefit += WEEK_BENEFIT_AMOUNT * orderCount;
        }

        if (!weekDayYN && "메인".equals(menu.getTypeName()) && orderMenu.equals(menu.getMenuName())) {
            weeKBenefit += WEEK_BENEFIT_AMOUNT * orderCount;
        }

        return weeKBenefit;
    }

    private int printSpecialDayEvent(int visitDate) {
        boolean specialDayYN = event.checkSpecialDayEvent(visitDate);
        if (specialDayYN) {
            System.out.println("특별 할인: -1,000원");
            return SPECIAL_BENEFIT_AMOUNT;
        }
        return 0;
    }

    private int printGiftPrice(int orderPrice) {
        int giftPrice = 0;
        if (orderPrice > GIFT_BENEFIT_AMOUNT) {
            System.out.println("증정 이벤트: -25,000원");
            return giftPrice;
        }
        return giftPrice;
    }
}