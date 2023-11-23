package christmas.domain.vo;

public enum Badge {

    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int price;
    Badge(String name, int price){
        this.name = name;
        this.price = price;
    }

    public static String getBadge(int price){
        String badgeName = NONE.name;
        for(Badge badge : values()){
            if(badge.price <= price){
                badgeName = badge.name;
            }
        }
        return badgeName;
    }

}