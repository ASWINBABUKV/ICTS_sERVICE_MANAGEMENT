package PROJECT;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class viewRequests extends JFrame {
	private JPanel reqappro;
	public viewRequests() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 530);
		reqappro = new JPanel();
		reqappro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(reqappro);
		reqappro.setLayout(null);
		
		JLabel reqhead = new JLabel("VIEW REQUEST");
		reqhead.setFont(new Font("Times New Roman", Font.BOLD, 18));
		reqhead.setBounds(301, 10, 262, 62);
		reqappro.add(reqhead);
		
		JButton bckbtn = new JButton("BACK");
		bckbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff backbtn = new Staff();
				backbtn.setVisible(true);
				dispose();
			}
		});
		bckbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		bckbtn.setBounds(352, 340, 107, 42);
		reqappro.add(bckbtn);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(163, 77, 521, 229);
		reqappro.add(scrollBar);
	}
}
