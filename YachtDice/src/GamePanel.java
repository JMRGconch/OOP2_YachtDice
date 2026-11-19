// 메인 게임 화면
// 왼쪽: 점수판 / 가운데: 주사위 / 오른쪽: 턴 수 + 규칙 요약 / 아래: 스킬

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel{
	private MainFrame frame;
	private DicePanel dicePanel;
	private ScoreBoardPanel scoreBoardPanel;
	private SkillPanel skillPanel;
	private JLabel turnLabel;  // 턴 수
	private JTextArea ruleArea;  // 규칙 설명 요약

	public GamePanel(MainFrame frame) {
		this.frame = frame;
		initUI();
	}

	// UI 배치
	public void initUI() {
		setLayout(new BorderLayout(10, 0));  // 왼쪽 점수판과 오른쪽 영역 사이 간격 10
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // 화면 가장자리 여백

		scoreBoardPanel = new ScoreBoardPanel();
		add(scoreBoardPanel, BorderLayout.WEST);  // 왼쪽: 점수판
		add(RightArea(), BorderLayout.CENTER);  // 나머지: 주사위, 정보, 스킬
	}

	// 점수판 오른쪽 영역 (가운데: 주사위 / 오른쪽: 정보 / 아래: 스킬)
	private JPanel RightArea() {
		JPanel area = new JPanel(new BorderLayout(10, 10));

		dicePanel = new DicePanel();
		skillPanel = new SkillPanel();

		area.add(dicePanel, BorderLayout.CENTER);  // 가운데: 주사위
		area.add(InfoArea(), BorderLayout.EAST);  // 오른쪽: 턴 수 + 규칙 요약
		area.add(skillPanel, BorderLayout.SOUTH);  // 아래: 스킬 (주사위와 정보 영역 아래에 걸쳐 있음)
		return area;
	}

	// 오른쪽 정보 영역 (위: 턴 수 / 아래: 규칙 요약)
	private JPanel InfoArea() {
		JPanel area = new JPanel(new BorderLayout(0, 10));
		area.setPreferredSize(new Dimension(240, 0));  // 너비만 정함 (높이는 BorderLayout이 채움)

		// 턴 수
		turnLabel = new JLabel("턴  1 / 12", SwingConstants.CENTER);
		turnLabel.setFont(turnLabel.getFont().deriveFont(Font.BOLD, 28f));
		turnLabel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.DARK_GRAY, 2),  // 바깥 테두리
				BorderFactory.createEmptyBorder(10, 0, 10, 0)));  // 글자 위아래 여백
		area.add(turnLabel, BorderLayout.NORTH);

		// 규칙 요약
		ruleArea = new JTextArea(
				"ㅁㄴㅇㄹ");
		ruleArea.setEditable(false);  // 글을 고칠 수 없게 함
		ruleArea.setFocusable(false);  // 클릭해도 커서가 생기지 않게 함
		ruleArea.setLineWrap(true);  // 너비를 넘으면 줄바꿈
		ruleArea.setWrapStyleWord(true);  // 단어 단위로 줄바꿈
		ruleArea.setOpaque(false);  // 배경을 패널과 같게
		ruleArea.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("규칙 요약"),
				BorderFactory.createEmptyBorder(5, 8, 5, 8)));
		area.add(ruleArea, BorderLayout.CENTER);

		return area;
	}
}
