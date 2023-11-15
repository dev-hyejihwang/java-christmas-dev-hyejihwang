package christmas.domain.biz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {
    @DisplayName("1~25일에 방문하는 경우 할인을 받는다.")
    @Test
    void 디데이_할인_가능일자_테스트() {
        Event event = new Event();

        int visitDate = 25;
        assertThat(event.checkDDayEvent(visitDate)).isEqualTo(3400);

        visitDate = 1;
        assertThat(event.checkDDayEvent(visitDate)).isEqualTo(1000);

        visitDate = 10;
        assertThat(event.checkDDayEvent(visitDate)).isEqualTo(1900);
    }

    @DisplayName("26~31일에 방문하는 경우 할인을 못 받는다.")
    @Test
    void 디데이_할인_불가일자_테스트() {
        Event event = new Event();
        int visitDate = 26;
        assertThat(event.checkDDayEvent(visitDate)).isEqualTo(0);
    }

    @DisplayName("입력한 날짜가 평일인 경우 true, 아닌 경우 false를 리턴한다.")
    @Test
    void 평일_날짜_테스트() {
        Event event = new Event();

        int visitDate = 26;
        assertThat(event.checkWeekDayEvent(visitDate)).isTrue();

        visitDate = 10;
        assertThat(event.checkWeekDayEvent(visitDate)).isFalse();
    }

    @DisplayName("입력한 날짜가 특별 일자인 경우 true, 아닌 경우 false를 리턴한다.")
    @Test
    void 특별_날짜_테스트() {
        Event event = new Event();

        int visitDate = 10;
        assertThat(event.checkSpecialDayEvent(visitDate)).isTrue();

        visitDate = 29;
        assertThat(event.checkSpecialDayEvent(visitDate)).isFalse();
    }
}