import java.util.EnumSet;
import java.util.Arrays;

public class Player {
    private String name;            // 플레이어의 이름
    private int[] scores;           // 플레이어의 각 족보별 점수
    private boolean[] filled;       // 각 족보 채움 여부
    private boolean[] skills;       // 각 스킬 사용 가능 여부
    private int[] currentDice;      // 현재 주사위 배열
    private int currentCount;       // 현재 주사위 개수
    private int[] keptDice;         // 보관된 주사위 배열
    private int keptCount;          // 보관된 주사위 개수
    private int rollsLeft;          // 남은 굴림 횟수

    // 초기 세팅
    public Player() {
        resetPlayer();              // 플레이어 정보 초기화
    }

    // 플레이어 이름 설정
    public void setName(String name) {
        this.name = name;
    }

    // 채운 족보인지 확인
    public boolean isFilled(Category c) {
        return filled[c.getIndex()];
    }

    // 점수 확정
    public void setScore(Category c, int score) {
        scores[c.getIndex()] = score;
    }

    // 에이스 ~ 식스 합계 (채운 것만)
    public int getOnesToSixes() {
        int sum = 0;
        for (Category c : EnumSet.range(Category.ACES, Category.SIXES))
            if (isFilled(c)) sum += scores[c.getIndex()];
        return sum;
    }

    // 보너스 점수: getOnesToSixes() 값이 63 이상이면 35 아니면 0
    public int getBonus() {
        if (getOnesToSixes() >= 63) return 35;
        else return 0;
    }

    // 채운 점수 총합 + 보너스 점수
    public int getTotal() {
        int sum = getOnesToSixes() + getBonus();                            // (에이스~식스) + (보너스)
        for (Category c : EnumSet.range(Category.CHOICE, Category.YACHT))   // + (초이스~요트)
            if (isFilled(c)) sum += scores[c.getIndex()];
        return sum;
    }

    // 스킬 사용 가능 여부 확인 (턴 제한 반영은 X. 스킬 빠졌는지만 확인)
    public boolean canUseSkill(Skill s) {
        return skills[s.getIndex()];
    }

    // 스킬 사용
    public void useSkill(Skill s) {
        skills[s.getIndex()] = false;   // 사용 불가로 전환
        switch(s) {
            case DICE_CHANGE:
                                // (몇 번 주사위가 선택되었는지 알아야 함)
                break;
            case EXTRA_ROLL:
                addRoll();      // 굴림 횟수 1 증가
                break;
            case SIXTH_DIE:
                addSixthDie();  // 6번째 주사위 추가
                break;
            default:
                break;
        }
    }

    // 플레이어 정보 초기화
    public void resetPlayer() {
        name = "";                   // 이름 초기화
        Arrays.fill(filled, false);  // filled 배열을 전부 false로 초기화
        Arrays.fill(skills, true);   // skills 배열을 전부 true로 초기화 
        Arrays.fill(scores, 0);      // scores 배열을 전부 0으로 초기화
        currentCount = 0;            // 현재 주사위 개수 초기화
        keptCount = 0;               // 보관된 주사위 개수 초기화
        rollsLeft = 3;               // 남은 굴림 횟수 초기화
    }

    // 현재 주사위 굴리기
    public void roll() {
        // 현재 주사위 배열을 초기화하고, 랜덤으로 1~6 사이의 값으로 채움
        for (int i = 0; i < currentCount; i++) {
            currentDice[i] = (int)(Math.random() * 6) + 1;
        }
        rollsLeft--;  // 굴림 횟수 감소
    }

    // 주사위 보관하기 (보관된 주사위 배열에 추가하고, 현재 주사위 배열에서 제거)
    public void keep(int index) {
        keptDice[keptCount++] = currentDice[index];      // 보관된 주사위 배열에 추가

        // 현재 주사위 배열에서 제거 (뒤로 한 칸씩 이동)
        for (int i = index; i < currentCount - 1; i++) {
            currentDice[i] = currentDice[i + 1];
        }
        currentCount--;  // 현재 주사위 개수 감소
    }

    // 보관된 주사위 다시 현재 주사위로 이동
    public void release(int index) {
        currentDice[currentCount++] = keptDice[index];  // 현재 주사위 배열에 추가

        // 보관된 주사위 배열에서 제거 (뒤로 한 칸씩 이동)
        for (int i = index; i < keptCount - 1; i++) {
            keptDice[i] = keptDice[i + 1];
        }
        keptCount--;  // 보관된 주사위 개수 감소
    }

    // 주사위 굴릴 수 있는지 확인
    public boolean canRoll() {
        return rollsLeft > 0;
    }

    // 현재 주사위 배열과 보관한 주사위 배열을 합친 배열을 반환 -> 족보별 점수 계산에 사용
    public int[] getAllDice() {
        int[] allDice = new int[currentCount + keptCount];

        for (int i = 0; i < currentCount; i++) {
            allDice[i] = currentDice[i];
        }
        for (int i = 0; i < keptCount; i++) {
            allDice[currentCount + i] = keptDice[i];
        }

        return allDice;
    }

    // 다음 턴을 위해 현재 주사위와 보관된 주사위를 초기화하고, 굴림 횟수를 3으로 리셋
    public void resetForNextTurn() {
        currentCount = 0;  // 현재 주사위 개수 초기화
        keptCount = 0;     // 보관된 주사위 개수 초기화
        rollsLeft = 3;     // 굴림 횟수 초기화
    }

    // [스킬 - 원하는 값 변경] 현재 주사위 중 하나 클릭 시 눈 1씩 증가 (6 -> 1)
    public int setValue(int index) {
        currentDice[index] = (currentDice[index] % 6) + 1;  // 1~6 사이의 값으로 순환
        return currentDice[index];  // 변경된 값을 반환
    }

    // [스킬 - 굴림 횟수 추가] 굴림 횟수 1 증가
    public void addRoll() {
        rollsLeft++;
    }

    // [스킬 - 6번째 주사위] 현재 주사위 배열에 6번째 주사위 추가 (값은 1~6 랜덤)
    public void addSixthDie() {
        if (currentCount < 6) {
            currentDice[currentCount++] = (int)(Math.random() * 6) + 1;  // 1~6 랜덤
        }
    }
}

