package christmas.domain.biz;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menu {

    public void validateForm(String inputMenu) {
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
            System.out.println("orderMenu = " + orderMenu);

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateMenu(){
        //TODO 주문 메뉴 검증
    }

    public void validateMenuCount(){
        //TODO 주문 메뉴 수량 검증
    }

}
