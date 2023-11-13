package christmas.domain.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    public Map<String,Integer> validateForm(String inputMenu) {
        try{
            List<String> inputMenus = List.of(inputMenu.split(","));
            Map<String, Integer> orderMenu = new HashMap<>();
            for (String menu : inputMenus) {
                List<String> tempMenu = List.of(menu.split("-"));

                if(orderMenu.containsKey(tempMenu.get(0))){
                    throw new IllegalArgumentException();
                }
                orderMenu.put(tempMenu.get(0),Integer.parseInt(tempMenu.get(1)));
            }

            return orderMenu;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateMenu(Map<String, Integer> orderMenus){
        //TODO 3depth 확인
        for (String orderMenu : orderMenus.keySet()) {
            boolean menuExistYN = false;
            for (Menu menu : Menu.values()) {
                if(orderMenu.equals(menu.getMenuName())){
                    menuExistYN = true;
                    break;
                }
            }

            if(!menuExistYN){
                for (Menu menu : Menu.values()) {
                    //TODO 출력 양식 확인
                    System.out.println("<" + menu.getTypeName() + ">");
                    System.out.println(" - " + menu.getMenuName() + " : " + menu.getPrice() + "원") ;
                }
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void validateMenuCount(Map<String, Integer> orderMenus){
        int orderCountSum = 0;
        for (String orderMenu : orderMenus.keySet()) {
            Integer orderCount = orderMenus.get(orderMenu);
            orderCountSum += orderCount;
        }

        if(orderCountSum > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 최대 20개까지 주문 가능합니다. 다시 입력해주세요.");
        }
    }

}
