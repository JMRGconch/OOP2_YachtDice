// 각 족보를 식별 및 관리하기 위한 상수 열거형 클래스
// Ca
public enum Category {
    ACES("Ones", 0),
    TWOS("Twos", 1),
    THREES("Threes", 2),
    FOURS("Fours", 3),
    FIVES("Fives", 4),
    SIXES("Sixes", 5),
    CHOICE("Choice", 6),
    FOUR_DICE("4 of a Kind", 7),
    FULL_HOUSE("Full House", 8),
    SMALL_STRAIGHT("Small Straight", 9),
    LARGE_STRAIGHT("Large Straight", 10),
    YACHT("Yacht", 11);

    private final String categoryName;
    private final int categoryIndex;

    Category(String categoryName, int categoryIndex) {
        this.categoryName = categoryName;
        this.categoryIndex = categoryIndex;
    }

    // 족보 이름 반환
    public String getCategoryName() {
        return this.categoryName;
    }

    // 족보 인덱스 반환
    public int getCategoryIndex() {
        return this.categoryIndex;
    }
}
