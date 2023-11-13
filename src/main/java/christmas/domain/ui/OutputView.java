package christmas.domain.ui;


import christmas.domain.biz.Event;
import christmas.domain.biz.Menu;

import java.util.Map;

public class OutputView {

    public void notifyDDayEvent(int dDayDCPrice){
        System.out.println("방문하시는 날짜에 진행하는 이벤트 안내드립니다. (10,000원 이상 구매시 적용)");
        System.out.println("총 구매금액에서 " + dDayDCPrice + "원 할인!");
    }

    public void notifyWeekDayEvent(boolean weekDayYN){
        if(weekDayYN){
            System.out.println("디저트 메뉴 1개당 2,023원 할인!");
            return;
        }
        System.out.println("메인 메뉴 1개당 2,023원 할인!");
    }

    public void notifySpecialDayEvent(boolean specialDayYN){
        if(specialDayYN){
            System.out.println("특별할인 총 주문금액에서 1,000원 할인!");
        }
    }

    public void printOrderMenu(Map<String,Integer> orderMenus){
        System.out.println("<주문 메뉴>");
        for (String orderMenu : orderMenus.keySet()) {
            System.out.println(orderMenu + " " + orderMenus.get(orderMenu) +"개");
        }
    }

    public int printOrderPrice(Map<String, Integer> orderMenus){
        //TODO 3depth 확인
        System.out.println("<할인 전 총주문 금액>");
        int totalPrice = 0;
        int orderPrice = 0;
        for (String orderMenu : orderMenus.keySet()) {
            for (Menu menu : Menu.values()) {
                if(orderMenu.equals(menu.getMenuName())){
                    orderPrice = menu.getPrice();
                    totalPrice += orderPrice * orderMenus.get(orderMenu);
                }
            }
        }
        System.out.println(totalPrice+"원");
        return totalPrice;
    }

    public void printBenefit(Map<String, Integer> orderMenus, int visitDate){
        //TODO 함수 분리 및 출력 양식 확인
        int totalBenefit = 0;
        System.out.println("<혜택 내역>");
        Event event = new Event();
        int dDayBenefit = event.checkDDay(visitDate);
        if(dDayBenefit > 0){
            totalBenefit += dDayBenefit;
            System.out.println("크리스마스 디데이 할인: -" + dDayBenefit + "원");
        }

        boolean weekDayYN = event.checkWeekDay(visitDate);
        int weekDayBenefit = 0;
        int weekendBenefit = 0;

        for (String orderMenu : orderMenus.keySet()) {
            for (Menu menu : Menu.values()) {
                if(orderMenu.equals(menu.getMenuName())){
                    if("디저트".equals(menu.getTypeName())){
                        weekDayBenefit += 2023;
                    }
                    if("메인".equals(menu.getTypeName())){
                        weekendBenefit += 2023;
                    }
                }
            }
        }

        if(weekDayYN){
            totalBenefit += weekDayBenefit;
            System.out.println("평일 할인: -" + weekDayBenefit + "원");
        }else{
            totalBenefit += weekendBenefit;
            System.out.println("주말 할인: -" + weekendBenefit + "원");
        }

        boolean specialDayYN = event.checkSpecialDay(visitDate);
        if(specialDayYN){
            totalBenefit += 1000;
            System.out.println("특별 할인: -1000원");
        }

        int orderPrice = printOrderPrice(orderMenus);
        if(orderPrice > 120000){
            totalBenefit += 25000;
            System.out.println("증정 이벤트: -25000원");
        }

        System.out.println("<총혜택 금액>");
        System.out.println("-" + totalBenefit + "원");

        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(orderPrice - totalBenefit + "원");

    }
}
