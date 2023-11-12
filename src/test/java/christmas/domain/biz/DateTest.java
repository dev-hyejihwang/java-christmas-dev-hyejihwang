package christmas.domain.biz;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;


class DateTest {

    @DisplayName("숫자가 아닌 값을 입력하면 오류가 발생한다.")
    @Test
    void 숫자_예외_테스트(){
        Date date = new Date();
        String notNumber = "number";
        assertThrows(IllegalArgumentException.class,() -> date.validateDate(notNumber));
    }

    @DisplayName("1~31 이외의 숫자를 입력하면 오류가 발생한다.")
    @Test
    void 날짜_범위_예외_테스트(){
        Date date = new Date();
        String number = "52";
        assertThrows(IllegalArgumentException.class,() -> date.validateDate(number));
    }
}