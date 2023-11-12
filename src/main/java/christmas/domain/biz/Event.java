package christmas.domain.biz;

public class Event {

    public int checkDDay(int visitDate){
        int dcPrice = 0;
        if(visitDate > 25){
            return dcPrice;
        }
        dcPrice = (visitDate - 1) * 100 + 1000;
        return dcPrice;
    }
}
