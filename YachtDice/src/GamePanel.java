// 메인 게임 화면
// 왼쪽: 점수판, 가운데: 주사위, 오른쪽: 턴 수 + 규칙 요약, 아래: 스킬

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel{
	private MainFrame frame;  // MainFrame의 정보를 받음
	
	private DicePanel dicePanel;  // 주사위 칸
	private ScoreBoardPanel scoreBoardPanel;  // 점수판
	private SkillPanel skillPanel;  // 스킬 칸
	
	private JLabel turnLabel;  // 턴 수
	private JTextArea ruleLabel;  // 규칙 설명 요약
	
	private int nowTurn = 1;  // 현재 턴
	
	// 생성자
	public GamePanel(MainFrame frame) {
		this.frame = frame;
		
		// 패널 사이의 간격을 10으로 설정
		setLayout(new BorderLayout(10, 10));
		// 화면 가장자리 여백
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  
		
		// 점수판 위치 잡기 (왼쪽)
		scoreBoardPanel = new ScoreBoardPanel();
		add(scoreBoardPanel, BorderLayout.WEST);
				
		// 주사위 칸 위치 잡기 (가운데)
		dicePanel = new DicePanel();
		add(dicePanel, BorderLayout.CENTER);
				
		// 스킬 칸 위치 잡기 (아래)
		skillPanel = new SkillPanel();
		add(skillPanel, BorderLayout.SOUTH);
				
		// 현재 턴 수 표시 칸
		turnLabel = new JLabel("턴  " + nowTurn + " / 12", SwingConstants.CENTER);
		turnLabel.setFont(turnLabel.getFont().deriveFont(Font.BOLD, 28f));
		add(turnLabel, BorderLayout.EAST);
				
		// 규칙 요약 칸
		//ruleLabel = new JLabel("")
		
		
		
	}
/*
	// 오른쪽 정보 영역 (위: 턴 수 / 아래: 규칙 요약)
	private JPanel infoArea() {
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
	}*/
}
