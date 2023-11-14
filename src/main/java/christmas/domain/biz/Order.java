package christmas.domain.biz;

import christmas.domain.ui.InputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    public Map<String, Integer> process(){
        Map<String, Integer> orderMenus = validateForm();
        validateMenu(orderMenus);
        validateMenuCount(orderMenus);
        return orderMenus;
    }

    public Map<String,Integer> validateForm() {
        InputView inputView = new InputView();
        Map<String, Integer> orderMenu = new HashMap<>();
        while(true){
            try{
                String inputMenu = inputView.readMenu();
                List<String> inputMenus = List.of(inputMenu.split(","));

                for (String menu : inputMenus) {
                    List<String> tempMenu = List.of(menu.split("-"));

                    if(orderMenu.containsKey(tempMenu.get(0))){
                        throw new IllegalArgumentException();
                    }
                    orderMenu.put(tempMenu.get(0),Integer.parseInt(tempMenu.get(1)));
                }
                break;

            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }catch (IndexOutOfBoundsException e){
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
        return orderMenu;
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
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

}
