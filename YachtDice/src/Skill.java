// 각 스킬을 식별 및 관리하기 위한 상수 열거형 클래스
public enum Skill {
    DICE_CHANGE("주사위 변경", 0),
    EXTRA_ROLL("추가 굴림", 1),
    SIXTH_DIE("6번째 주사위", 2);

    private final String skillName;
    private final int skillIndex;

    Skill(String skillName, int skillIndex) {
        this.skillName = skillName;
        this.skillIndex = skillIndex;
    }

    // 스킬 이름 반환
    public String getName() {
        return this.skillName;
    }

    // 스킬 인덱스 반환
    public int getIndex() {
        return this.skillIndex;
    }
}
