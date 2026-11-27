import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TitlePanel extends JPanel {
	private MainFrame frame;
	private JLabel titleLabel;
	private JButton startBtn;
	private JButton ruleBtn;
	private JButton lbBtn;
	private JButton exitBtn;
	
	public TitlePanel(MainFrame frame) {
		this.frame = frame;
		setLayout(null);
		
		// 제목 라벨 추가
		titleLabel = new JLabel("스킬 요트");
		titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 80f));
		int titleWidth = titleLabel.getPreferredSize().width;  // 타이틀 폰트의 넓이 저장
		int titleHeight = titleLabel.getPreferredSize().height;  // 타이틀 폰트의 높이 저장
		titleLabel.setBounds((1280-titleWidth)/2, 150, 1280, titleHeight);  // 폰트 위치 설정
		add(titleLabel);
		
		// 시작 버튼 추가와 이벤트 처리
		startBtn = new JButton("게임 시작");
		startBtn.setSize(200, 30);
		startBtn.setLocation(540, 400);
		add(startBtn);
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.change("gamePanel");
			}
		});
		
		// 규칙 버튼 추가와 이벤트 처리
		ruleBtn = new JButton("규칙");
		ruleBtn.setSize(200, 30);
		ruleBtn.setLocation(540, 440);
		add(ruleBtn);
		ruleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.change("rulePanel");
			}
		});
		
		// 리더보드 버튼 추가와 이벤트 처리
		lbBtn = new JButton("리더보드");
		lbBtn.setSize(200, 30);
		lbBtn.setLocation(540, 480);
		add(lbBtn);
		lbBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.change("lbPanel");
			}
		});
		
		// 종료 버튼 추가와 이벤트 처리
		exitBtn = new JButton("종료");
		exitBtn.setSize(200, 30);
		exitBtn.setLocation(540, 520);
		add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);  // 프로그램 종료
			}
		});
	}
}
