package christmas.domain.vo;

public enum Menu {
    APPETIZER_1("애피타이저", "양송이스프", 6_000),
    APPETIZER_2("애피타이저", "타파스", 5_500),
    APPETIZER_3("애피타이저", "시저샐러드", 8_000),

    MAIN_1("메인", "티본스테이크", 55_000),
    MAIN_2("메인", "바비큐립", 54_000),
    MAIN_3("메인", "해산물파스타", 35_000),
    MAIN_4("메인", "크리스마스파스타", 25_000),

    DESSERT_1("디저트", "초코케이크", 15_000),
    DESSERT_2("디저트", "아이스크림", 5_000),

    DRINK_1("음료", "제로콜라", 3_000),
    DRINK_2("음료", "레드와인", 60_000),
    DRINK_3("음료", "샴페인", 25_000);

    private final String typeName;
    private final String menuName;
    private final int price;

    Menu(String typeName, String menuName, int price) {
        this.typeName = typeName;
        this.menuName = menuName;
        this.price = price;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }
}