package christmas;

import christmas.domain.ui.InputView;

public class Application {
    public static void main(String[] args) {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

        InputView inputView = new InputView();
        int inputDate = inputView.readDate();
        System.out.println("입력받은 날짜:" +inputDate);

    }
}
