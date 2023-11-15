package christmas.domain.biz;

import christmas.domain.ui.OutputView;

import java.util.Arrays;
import java.util.List;

public class Event {
    public void checkEvent(int visitDate) {
        OutputView outputView = new OutputView();
        System.out.println("##################################################################");
        outputView.printDDayEvent(checkDDayEvent(visitDate));
        outputView.printWeekDayEvent(checkWeekDayEvent(visitDate));
        outputView.printSpecialDayEvent(checkSpecialDayEvent(visitDate));
        System.out.println("##################################################################\n");
    }

    public int checkDDayEvent(int visitDate) {
        int dcPrice = 0;
        if (visitDate > 25) {
            return dcPrice;
        }
        dcPrice = (visitDate - 1) * 100 + 1000;
        return dcPrice;
    }

    public boolean checkWeekDayEvent(int visitDate) {
        return visitDate % 7 == 4 || visitDate % 7 == 5 || visitDate % 7 == 6 || visitDate % 7 == 0;
    }

    public boolean checkSpecialDayEvent(int visitDate) {
        List<Integer> specialDays = Arrays.asList(3, 10, 17, 24, 25, 31);
        return specialDays.contains(visitDate);
    }
}
