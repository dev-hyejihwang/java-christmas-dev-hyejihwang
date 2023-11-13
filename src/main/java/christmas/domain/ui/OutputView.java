package christmas.domain.ui;


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

    public void printOrderPrice(Map<String,Integer> orderMenus){
        System.out.println("<주문 메뉴>");
        for (String orderMenu : orderMenus.keySet()) {
            System.out.println(orderMenu + " " + orderMenus.get(orderMenu) +"개");
        }
    }
}
