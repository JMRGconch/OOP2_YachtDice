import javax.swing.*;

public class TitlePanel extends JPanel {
	private MainFrame frame;
	
	public TitlePanel(MainFrame frame) {
		this.frame = frame;
		initTitleUI();
	}
	
	// 화면 구성 (제목, 버튼)
	private void initTitleUI() {
		JLabel titleLabel = new JLabel("스킬 요트");
		JButton startBtn = new JButton("게임 시작");
		JButton helpBtn = new JButton("도움말");
		JButton lbBtn = new JButton("리더보드");
		JButton exitBtn = new JButton("종료");
		
		
	}
	
	// 게임 시작 버튼 처리
	private void onStartSetup() {
		
	}
	
	// 도움말 버튼 처리
	private void onHelp() {
		
	}
	
	// 리더보드 버튼 처리
	private void onLeaderboard() {
		
	}
	
	// 종료 버튼 처리
	private void onExit() {
		
	}
}
