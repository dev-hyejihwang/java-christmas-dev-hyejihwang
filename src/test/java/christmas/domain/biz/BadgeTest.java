package christmas.domain.biz;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class BadgeTest extends NsTest {
    @DisplayName("혜택 금액에 따라 배지를 부여받는다.")
    @Test
    void 배지_부여_테스트() {
        assertSimpleTest(() -> {
            Badge badge = new Badge();
            badge.giveBadge(20000);
            assertThat(output()).contains("산타");

            badge.giveBadge(19999);
            assertThat(output()).contains("트리");

            badge.giveBadge(4000);
            assertThat(output()).contains("별");
        });
    }

    @Override
    protected void runMain() {
    }
}