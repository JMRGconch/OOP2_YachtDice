import javax.swing.*;

public class MainFrame extends JFrame {
	private TitlePanel titlePanel;  // 시작 패널
	private GamePanel gamePanel;  // 인게임 패널
	private RulePanel rulePanel;  // 규칙 설명 패널
	private ResultPanel resultPanel;  // 결과 패널
	private LbPanel lbPanel;  // 리더보드 패널
	
	public MainFrame() {
		setTitle("Skill Yacht - 스킬 요트");  // 프레임 타이틀
		setSize(1280, 720);  // 프레임 크기 720p
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // x를 누르면 전체 종료
		
		titlePanel = new TitlePanel(this);
		gamePanel = new GamePanel(this);
		rulePanel = new RulePanel(this);
		resultPanel = new ResultPanel(this);
		lbPanel = new LbPanel(this);
		
		change("titlePanel");  // titlePanel을 초기 화면으로
		setVisible(true);
	}
	
	void change(String panelName) {
		if (panelName.equals("titlePanel")) {
			getContentPane().removeAll();  // 기존 패널을 없앰
			getContentPane().add(titlePanel);  // titlePanel로 패널 변경
		}
		else if (panelName.equals("gamePanel")) {
			getContentPane().removeAll();  // 기존 패널을 없앰
			getContentPane().add(gamePanel);  // gamePanel로 패널 변경
		}
		else if (panelName.equals("rulePanel")) {
			getContentPane().removeAll();  // 기존 패널을 없앰
			getContentPane().add(rulePanel);  // rulePanel로 패널 변경
		}
		else if (panelName.equals("resultPanel")) {
			getContentPane().removeAll();  // 기존 패널을 없앰
			getContentPane().add(resultPanel);  // resultPanel로 패널 변경
		}
		else {
			getContentPane().removeAll();  // 기존 패널을 없앰
			getContentPane().add(lbPanel);  // lbPanel로 패널 변경
		}
		// 패널을 변경한 뒤에 패널 정보를 갱신함
		revalidate();  // 기존 데이터가 최신 상태인지 확인하고 갱신
		repaint();  // 화면을 다시 그림
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
