// GamePanel에 넣을 주사위 UI
// 주사위 굴리기 칸 + 보관된 주사위

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DicePanel extends JPanel {
	private static int DICE_COUNT = 5;  // 주사위 개수

	private JButton[] keptButtons;  // 보관된 주사위 5칸
	private JButton[] rolledButtons;  // 굴린 주사위 5칸
	private JButton rollButton;  // 굴리기 버튼
	private JButton confirmChangeButton;  // 주사위 변경 스킬의 확정 버튼

	public DicePanel() {
		initUI();
	}
	
	// UI 배치
	public void initUI() {
		setLayout(new BorderLayout(0, 10));  // 두 영역 사이의 거리
		add(KeptArea(), BorderLayout.NORTH);  // 보관된 주사위 칸의 위치 (위)
		add(RolledArea(), BorderLayout.CENTER);  // 주사위 및 굴리기 칸의 위치 (가운데)
	}

	// 보관된 주사위 영역
	private JPanel KeptArea() {
		JPanel area = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 8));
		area.setBorder(TitledBorder("보관된 주사위"));

		keptButtons = new JButton[DICE_COUNT];
		for (int i = 0; i < DICE_COUNT; i++) {
			keptButtons[i] = DiceButton("");  // 처음에는 빈 칸
			area.add(keptButtons[i]);
		}
		return area;
	}

	// 굴린 주사위 영역 (주사위 5개 + 아래쪽 버튼 줄)
	private JPanel RolledArea() {
		JPanel area = new JPanel(new BorderLayout());
		area.setBorder(TitledBorder("주사위"));

		// 주사위 5개를 가로로 나열
		JPanel diceRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
		rolledButtons = new JButton[DICE_COUNT];
		for (int i = 0; i < DICE_COUNT; i++) {
			rolledButtons[i] = DiceButton("?");  // 굴리기 전이라 ?로 표시
			diceRow.add(rolledButtons[i]);
		}

		// GridBagLayout은 안에 넣은 컴포넌트를 가운데에 놓으므로, 주사위 줄이 세로로도 가운데에 옴
		JPanel diceCenter = new JPanel(new GridBagLayout());
		diceCenter.add(diceRow);
		area.add(diceCenter, BorderLayout.CENTER);

		// 아래쪽 버튼 줄
		JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 8));
		rollButton = new JButton("굴리기 (3)");
		confirmChangeButton = new JButton("변경 확정");
		confirmChangeButton.setEnabled(false);  // 주사위 변경 스킬을 쓸 때만 활성화할 예정
		buttonRow.add(rollButton);
		buttonRow.add(confirmChangeButton);
		area.add(buttonRow, BorderLayout.SOUTH);

		return area;
	}

	// 주사위 버튼 하나를 같은 모양으로 만듦
	private JButton DiceButton(String text) {
		JButton button = new JButton(text);
		button.setPreferredSize(new Dimension(80, 80));  // FlowLayout은 setSize가 아니라 PreferredSize를 따름
		button.setFocusable(false);  // 나중에 키보드 조작(setupKeys)을 할 때 버튼이 포커스를 가져가지 않게 함
		return button;
	}

	// 글꼴을 지정한 제목 테두리
	private TitledBorder TitledBorder(String title) {
		TitledBorder border = BorderFactory.createTitledBorder(title);
		return border;
	}
}
