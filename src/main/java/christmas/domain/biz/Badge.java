package christmas.domain.biz;

public class Badge {
    public void giveBadge(int totalBenefit){
        System.out.println("\n혜택 금액 별 배지가 부여되며 새해 이벤트에 활용됩니다!");
        System.out.println("<12월 이벤트 배지>");

        if(totalBenefit > 19999){
            System.out.println("산타");
            return;
        }

        if(totalBenefit > 9999){
            System.out.println("트리");
            return;
        }

        if(totalBenefit > 4999){
            System.out.println("별");
            return;
        }

        System.out.println("없음");
    }
}
