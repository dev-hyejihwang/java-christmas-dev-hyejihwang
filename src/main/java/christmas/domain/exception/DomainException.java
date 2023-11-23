package christmas.domain.exception;

public enum DomainException {

    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    DomainException(String message){
        this.message = message;
    }

    public static String getExceptionMessage(String exceptionName){
        return valueOf(exceptionName).message;
    }

}
