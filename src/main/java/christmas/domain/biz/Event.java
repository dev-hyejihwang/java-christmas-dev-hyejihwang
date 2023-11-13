package christmas.domain.biz;

import christmas.domain.ui.OutputView;

import java.util.Arrays;
import java.util.List;

public class Event {

    public void checkEvent(int visitDate){
        OutputView outputView = new OutputView();

        int dDayDCPrice = checkDDay(visitDate);
        outputView.notifyDDayEvent(dDayDCPrice);

        boolean weekDayYn = checkWeekDay(visitDate);
        outputView.notifyWeekDayEvent(weekDayYn);

        boolean specialDayYn = checkSpecialDay(visitDate);
        outputView.notifySpecialDayEvent(specialDayYn);
    }

    public int checkDDay(int visitDate){
        int dcPrice = 0;
        if(visitDate > 25){
            return dcPrice;
        }
        dcPrice = (visitDate - 1) * 100 + 1000;
        return dcPrice;
    }

    public boolean checkWeekDay(int visitDate){
        if(visitDate % 7 == 4 || visitDate % 7 == 5 || visitDate % 7 == 6 ||visitDate % 7 == 0 ){
            return true;
        }
        return false;
    }

    public boolean checkSpecialDay(int visitDate){
        List<Integer> specialDays = Arrays.asList(3,10,17,24,25,31);
        if(specialDays.contains(visitDate)){
            return true;
        }
        return false;
    }
}
