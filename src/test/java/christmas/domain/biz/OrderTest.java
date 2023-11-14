package christmas.domain.biz;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


class OrderTest extends NsTest {

    @DisplayName("주문 형식이 다르면 예외가 발생한다.")
    @Test
    void 주문_형식_예외_테스트(){
        assertSimpleTest(() -> {
            runException("해산물파스타2,레드와인-1", "해산물파스타2-레드와인-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("중복 주문시 예외가 발생한다.")
    @Test
    void 주문_중복_예외_테스트(){
        assertSimpleTest(() -> {
            runException("해산물파스타-2,해산물파스타-2");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("없는 메뉴 주문시 예외가 발생한다.")
    @Test
    void 메뉴_예외_테스트(){
        assertSimpleTest(() -> {
            runException("오일파스타-2,딸기케이크-2");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("총 주문 메뉴 수량이 20개가 넘는 경우 예외가 발생한다.")
    @Test
    void 메뉴_수량_예외_테스트(){
        assertSimpleTest(() -> {
            runException("오일파스타-20,해산물파스타-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Order order = new Order();
        order.process();
    }
}