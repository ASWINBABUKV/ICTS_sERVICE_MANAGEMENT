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

public class approvereq extends JFrame {

	private JPanel reqappro;
	public approvereq() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 530);
		reqappro = new JPanel();
		reqappro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(reqappro);
		reqappro.setLayout(null);
		
		JLabel reqhead = new JLabel("REQUESTS FOR APPROVAL");
		reqhead.setFont(new Font("Times New Roman", Font.BOLD, 18));
		reqhead.setBounds(301, 10, 262, 62);
		reqappro.add(reqhead);
		
		JButton addbtn = new JButton("ACCEPT");
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addbtn.setBounds(466, 338, 97, 42);
		reqappro.add(addbtn);
		
		JButton bckbtn = new JButton("BACK");
		bckbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hodLog backbtn = new hodLog();
				backbtn.setVisible(true);
				dispose();
			}
		});
		bckbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		bckbtn.setBounds(259, 338, 107, 42);
		reqappro.add(bckbtn);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(163, 77, 521, 229);
		reqappro.add(scrollBar);
	}
}