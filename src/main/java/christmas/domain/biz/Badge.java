package christmas.domain.biz;

public class Badge {
    public String giveBadge(int totalBenefit){
        if(totalBenefit > 19999){
            return "SANTA";
        }

        if(totalBenefit > 9999){
            return "TREE";
        }

        if(totalBenefit > 4999){
            return "STAR";
        }

        return "NOTING";
    }
}
