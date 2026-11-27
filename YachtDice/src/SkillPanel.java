// GamePanel에 넣을 스킬 UI
// 스킬 버튼 3칸

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SkillPanel extends JPanel {
	private static String[] SKILL_NAMES = {"주사위 변경", "추가 굴림", "6번째 주사위"};  // 스킬 칸 이름

	private JButton[] skillButtons;  // 스킬 버튼 (0: 주사위 변경, 1: 추가 굴림, 2: 미정)

	public SkillPanel() {
		initUI();
	}

	// UI 배치
	public void initUI() {
		setLayout(new GridLayout(1, SKILL_NAMES.length, 20, 0));  // 1줄 × 3칸, 칸 사이 간격 20
		setBorder(titledBorder("스킬"));
		setPreferredSize(new Dimension(760, 170));  // 화면 아래쪽 영역의 크기

		skillButtons = new JButton[SKILL_NAMES.length];
		for (int i = 0; i < SKILL_NAMES.length; i++) {
			skillButtons[i] = skillButton(SKILL_NAMES[i]);
			add(skillButtons[i]);
		}
	}

	// 스킬 버튼 하나를 같은 모양으로 만듦
	private JButton skillButton(String name) {
		JButton button = new JButton(name);
		button.setFont(button.getFont().deriveFont(Font.BOLD, 18f));  // 글씨를 조금 크게
		button.setFocusable(false);  // 나중에 키보드 조작(setupKeys)을 할 때 버튼이 포커스를 가져가지 않게 함
		return button;
	}

	// 제목 테두리
	private TitledBorder titledBorder(String title) {
		TitledBorder border = BorderFactory.createTitledBorder(title);
		return border;
	}
}
