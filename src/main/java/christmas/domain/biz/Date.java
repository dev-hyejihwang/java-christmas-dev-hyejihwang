package christmas.domain.biz;

import christmas.domain.ui.InputView;

public class Date {
    public int getDate() {
        InputView inputView = new InputView();
        int date;
        while (true) {
            try {
                String inputDate = inputView.readDate();
                date = Integer.parseInt(inputDate);
                validateDate(date);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        return date;
    }

    private static void validateDate(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException();
        }
    }
}
