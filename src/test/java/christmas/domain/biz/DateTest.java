package christmas.domain.biz;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


class DateTest extends NsTest {
    @DisplayName("숫자가 아닌 값을 입력하면 오류가 발생한다.")
    @Test
    void 숫자_예외_테스트() {
        assertSimpleTest(() -> {
            runException("number");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("1~31 이외의 숫자를 입력하면 오류가 발생한다.")
    @Test
    void 날짜_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("52");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Date date = new Date();
        date.getDate();
    }
}