package christmas.domain.biz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class MenuTest {

    @DisplayName("주문 형식이 맞으면 정상 동작한다.")
    @Test
    void 주문_정상_동작_테스트(){
        Menu menu = new Menu();
        menu.validateForm("해산물파스타-2,레드와인-1,초코케이크-1");
        //TODO 정상 동작 테스트 구현
    }

    @DisplayName("주문 형식이 다르면 예외가 발생한다.")
    @Test
    void 주문_형식_예외_테스트(){
        Menu menu = new Menu();

        assertThrows(IllegalArgumentException.class,() ->
                menu.validateForm("해산물파스타2,레드와인-1"));

        assertThrows(IllegalArgumentException.class,() ->
                menu.validateForm("해산물파스타2-레드와인-1"));
    }

    @DisplayName("중복 주문시 예외가 발생한다.")
    @Test
    void 주문_중복_예외_테스트(){
        Menu menu = new Menu();

        assertThrows(IllegalArgumentException.class,() ->
                menu.validateForm("해산물파스타-2,해산물파스타-2"));

    }


}