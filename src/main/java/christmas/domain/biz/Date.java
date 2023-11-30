package christmas.domain.biz;

import christmas.domain.exception.DomainException;
import christmas.domain.ui.InputView;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Date {

    private static final int YEAR = 2023;
    private static final int MONTH = 12;

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
                System.out.println(DomainException.getExceptionMessage("INVALID_DATE"));
            }
        }
        return date;
    }

    private static void validateDate(int date) {
        try{
            LocalDate.of(YEAR, MONTH, date);
        }catch (DateTimeException e){
            throw new IllegalArgumentException();
        }
    }
}
