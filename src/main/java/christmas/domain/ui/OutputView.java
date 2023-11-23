package christmas.domain.ui;

import christmas.domain.biz.Order;
import christmas.domain.vo.Badge;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private DecimalFormat format = new DecimalFormat("###,###");

    public void printDDayEvent(int dDayDCPrice) {
        System.out.println("방문하시는 날짜에 진행하는 이벤트 안내드립니다. (10,000원 이상 구매시 적용)");
        System.out.println("총 구매금액에서 " + format.format(dDayDCPrice) + "원 할인!");
    }

    public void printWeekDayEvent(boolean weekDayYN) {
        if (weekDayYN) {
            System.out.println("디저트 메뉴 1개당 2,023원 할인!");
            return;
        }
        System.out.println("메인 메뉴 1개당 2,023원 할인!");
    }

    public void printSpecialDayEvent(boolean specialDayYN) {
        if (specialDayYN) {
            System.out.println("특별할인 총 주문금액에서 1,000원 할인!");
        }
    }

    public void printOrderMenu(Map<String, Integer> orderMenus) {
        System.out.println("\n<주문 메뉴>");
        for (String orderMenu : orderMenus.keySet()) {
            System.out.println(orderMenu + " " + orderMenus.get(orderMenu) + "개");
        }
        System.out.println();
    }

    public int printOrderPrice(Map<String, Integer> orderMenus) {
        Order order = new Order();
        System.out.println("<할인 전 총주문 금액>");
        int totalPrice = 0;
        for (String orderMenu : orderMenus.keySet()) {
            totalPrice += order.getTotalPrice(orderMenu, orderMenus.get(orderMenu));
        }
        System.out.println(format.format(totalPrice) + "원");
        System.out.println();
        return totalPrice;
    }

    public void printTotalBenefitPrice(int totalBenefit) {
        System.out.println("\n<총혜택 금액>");
        System.out.println("-" + format.format(totalBenefit) + "원");
    }

    public void printExpectPrice(int expectPrice) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(format.format(expectPrice) + "원");
    }

    public void printWeekBenefitPrice(boolean weekDayYN, int weekBenefit) {
        if (weekDayYN) {
            System.out.println("평일 할인: -" + format.format(weekBenefit) + "원");
            return;
        }
        System.out.println("주말 할인: -" + format.format(weekBenefit) + "원");
    }

    public void printBadge(int totalBenefit){
        System.out.println("\n혜택 금액 별 배지가 부여되며 새해 이벤트에 활용됩니다!");
        System.out.println("<12월 이벤트 배지>");
        String badge = Badge.getBadge(totalBenefit);
        System.out.println(badge);
    }
}
