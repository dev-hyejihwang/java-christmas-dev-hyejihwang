package christmas.domain.biz;

public class Date {

    public int validateDate(String inputDate) {
        try{
            int date = Integer.parseInt(inputDate);

            if(date < 1 || date > 31){
                throw new IllegalArgumentException();
            }

            return date;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public void confirmDate(int visitDate){
        System.out.println("방문 날짜는 " + visitDate + "일 입니다." );

        // TODO 날짜 변경 가능 로직 구현
    }

}
