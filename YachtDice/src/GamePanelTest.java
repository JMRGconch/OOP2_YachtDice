// [임시] GamePanel의 UI 배치를 확인하기 위한 실행용 코드
// 확인이 끝나면 이 파일은 삭제하세요.

import javax.swing.*;

public class GamePanelTest {
	public static void main(String[] args) {
		// Swing 화면은 이벤트 디스패치 스레드(EDT)에서 만드는 것이 원칙
		SwingUtilities.invokeLater(() -> {
			JFrame testFrame = new JFrame("GamePanel 테스트");
			testFrame.setSize(1280, 720);  // MainFrame과 같은 크기
			testFrame.setLocationRelativeTo(null);  // 화면 가운데
			testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // x를 누르면 종료

			// GamePanel은 아직 frame을 쓰지 않으므로 MainFrame 대신 null을 넘김
			testFrame.setContentPane(new GamePanel(null));
			testFrame.setVisible(true);
		});
	}
}
