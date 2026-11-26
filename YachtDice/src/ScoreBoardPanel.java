// GamePanel에 넣을 점수판 UI
// 족보 이름 + 플레이어 2명의 점수 칸

import java.awt.*;
import javax.swing.*;
import java.util.EnumSet;

public class ScoreBoardPanel extends JPanel {
	private static final int PLAYER_COUNT = 2;  // 플레이어 수
	private static final int CATEGORY_COUNT = Category.values().length;		// 족보 개수
	private static final int ROW_COUNT = CATEGORY_COUNT + 3;  // 제목 1 + 윗족보 6 + 소계 1 + 아랫족보 6 + 총점 1

	private JLabel[] playerNameLabels;  // 맨 위 P1, P2 칸
	private JLabel[][] scoreLabels;  // 점수 칸 [플레이어][족보 12개]
	private JLabel[] subtotalLabels;  // Ones~Sixes 합 칸
	private JLabel[] totalLabels;  // 총점 칸

	public ScoreBoardPanel() {
		initUI();
	}

	// UI 배치
	public void initUI() {
		setLayout(new GridLayout(ROW_COUNT, PLAYER_COUNT + 1));  // 15줄 × 3칸 (족보, P1, P2)
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));  // 바깥 테두리
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(450, 680));  // 화면 왼쪽 열의 크기

		playerNameLabels = new JLabel[PLAYER_COUNT];
		scoreLabels = new JLabel[PLAYER_COUNT][CATEGORY_COUNT];
		subtotalLabels = new JLabel[PLAYER_COUNT];
		totalLabels = new JLabel[PLAYER_COUNT];

		// GridLayout은 왼쪽 → 오른쪽, 위 → 아래 순서로 채우므로 한 줄씩 족보, P1, P2 순서로 추가함

		// 제목 줄
		add(createCell("족보", 2, true));
		for (int p = 0; p < PLAYER_COUNT; p++) {
			playerNameLabels[p] = createCell("P" + (p + 1), 2, true);
			add(playerNameLabels[p]);
		}

		// 윗족보 (Ones ~ Sixes)
		for (Category c : EnumSet.range(Category.ACES, Category.SIXES)) {
			addScoreRow(c, 1);
		}

		// 소계 줄 (아래에 굵은 선)
		add(createCell("Ones~Sixes 합", 2, true));
		for (int p = 0; p < PLAYER_COUNT; p++) {
			subtotalLabels[p] = createCell("0", 2, false);
			add(subtotalLabels[p]);
		}

		// 아랫족보 (Choice ~ Yacht), Choice 아래에 굵은 선
		for (Category c : EnumSet.range(Category.CHOICE, Category.YACHT)) {
			int bottom = (c.getName().equals("Choice")) ? 2 : 1;
			addScoreRow(c, bottom);
		}

		// 총점 줄
		add(createCell("총점", 0, true));
		for (int p = 0; p < PLAYER_COUNT; p++) {
			totalLabels[p] = createCell("0", 0, false);
			add(totalLabels[p]);
		}
	}

	// 족보 한 줄 추가 (족보 이름 + 플레이어별 빈 점수 칸)
	private void addScoreRow(Category c, int bottom) {
		String name = c.getName();
		int index = c.getIndex();
		add(createCell(name, bottom, false));
		for (int p = 0; p < PLAYER_COUNT; p++) {
			scoreLabels[p][index] = createCell("", bottom, false);  // 처음에는 빈 칸
			add(scoreLabels[p][index]);
		}
	}

	// 칸 하나를 같은 모양으로 만듦 (bottom: 아래 선 두께, bold: 굵은 글씨 여부)
	private JLabel createCell(String text, int bottom, boolean bold) {
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setBorder(BorderFactory.createMatteBorder(0, 0, bottom, 1, Color.GRAY));  // 아래, 오른쪽 선
		if (bold) {
			label.setFont(label.getFont().deriveFont(Font.BOLD));
		}
		return label;
	}
}
