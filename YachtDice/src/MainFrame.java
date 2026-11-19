import javax.swing.*;

public class MainFrame extends JFrame {
	private TitlePanel titlePanel;
	private SetupPanel setupPanel;
	private GamePanel gamePanel;
	private ResultPanel resultPanel;
	
	public MainFrame() {
		setTitle("Skill Yacht");  // 프레임 타이틀
		setSize(1280, 720);  // 프레임 크기 720p
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // x를 누르면 전체 종료
		
		titlePanel = new TitlePanel(this);
		setupPanel = new SetupPanel(this);
		gamePanel = new GamePanel(this);
		resultPanel = new ResultPanel(this);
		
		setVisible(true);
	}
	
	public void showWindow(String name) {
		JPanel nextPanel;
		switch (name) {
		case "TITLE":
			nextPanel = titlePanel;
			break;
		case "SETUP":
			nextPanel = setupPanel;
			break;
		case "GAME":
			nextPanel = gamePanel;
			break;
		case "RESULT":
			nextPanel = resultPanel;
			break;
		default:
			throw new IllegalArgumentException(name + "은 없는 화면 이름입니다.");
		}
		setContentPane(nextPanel);
		revalidate();  // 바뀐 패널로 레이아웃을 다시 계산함
		repaint();  // GUI 화면을 다시 그리도록 요청
	}
}
