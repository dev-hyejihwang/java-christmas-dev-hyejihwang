package christmas.domain.biz;

import christmas.domain.exception.DomainException;
import christmas.domain.ui.InputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    public Map<String, Integer> process() {
        Map<String, Integer> orderMenus = validateForm();
        validateMenu(orderMenus);
        validateMenuCount(orderMenus);
        return orderMenus;
    }

    public Map<String, Integer> validateForm() {
        InputView inputView = new InputView();
        Map<String, Integer> orderMenu = new HashMap<>();
        while (true) {
            try {
                List<String> inputMenus = List.of(inputView.readMenu().split(","));
                organizeMenus(orderMenu, inputMenus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(DomainException.getExceptionMessage("INVALID_ORDER"));
            } catch (IndexOutOfBoundsException e) {
                System.out.println(DomainException.getExceptionMessage("INVALID_ORDER"));
            }
        }
        return orderMenu;
    }

    private static void organizeMenus(Map<String, Integer> orderMenu, List<String> inputMenus) {
        for (String menu : inputMenus) {
            List<String> tempMenu = List.of(menu.split("-"));
            if (orderMenu.containsKey(tempMenu.get(0))) {
                throw new IllegalArgumentException();
            }
            orderMenu.put(tempMenu.get(0), Integer.parseInt(tempMenu.get(1)));
        }
    }

    private void validateMenu(Map<String, Integer> orderMenus) {
        for (String orderMenu : orderMenus.keySet()) {
            boolean menuExistYN = isMenuExistYN(orderMenu);
            if (!menuExistYN) {
                System.out.println(DomainException.getExceptionMessage("INVALID_ORDER"));
            }
        }
    }

    private boolean isMenuExistYN(String orderMenu) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> orderMenu.equals(menu.getMenuName()));
    }

    private void validateMenuCount(Map<String, Integer> orderMenus) {
        int orderCountSum = orderMenus.values()
                .stream().mapToInt(Integer::intValue).sum();

        if (orderCountSum > 20) {
            System.out.println(DomainException.getExceptionMessage("INVALID_ORDER"));
        }
    }

    public int getTotalPrice(String orderMenu, Integer orderCount) {
        return Arrays.stream(Menu.values())
                .filter(menu -> orderMenu.equals(menu.getMenuName()))
                .mapToInt(menu -> menu.getPrice()).sum();
    }
}