package christmas.domain.biz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    @DisplayName("혜택 금액에 따라 배지를 부여받는다.")
    @Test
    void 배지_부여_테스트(){
        Badge badge = new Badge();
        String badgeName = badge.giveBadge(20000);
        Assertions.assertThat(badgeName).isEqualTo("SANTA");

        badgeName = badge.giveBadge(19999);
        Assertions.assertThat(badgeName).isEqualTo("TREE");

        badgeName = badge.giveBadge(4000);
        Assertions.assertThat(badgeName).isEqualTo("NOTING");
    }

}