package christmas.domain.biz;

import java.util.ArrayList;

public class Event {

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
}
