package christmas.domain.biz;

public class Date {

//- [X] 방문 일자를 검증 validateDate()
//    - [X] 정수 아닌 값 입력 시 "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." 메시지 출력
//    - [X] 1~31 까지만 입력 가능하며 이외 값 입력시 "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." 메시지 출력
//- [X] 고객 입력 날짜를 재확인 요청 confirmDate()
//    - [] 날짜 변경 요청 시 날짜 입력으로 리턴

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

        // 추후 날짜 변경 가능 로직 구현
    }

}
