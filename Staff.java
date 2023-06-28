package PROJECT;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Staff extends JFrame {

	private JPanel welfac;
	public Staff() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 530);
		welfac = new JPanel();
		welfac.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(welfac);
		welfac.setLayout(null);
		
		JLabel Welcomestf = new JLabel("WELCOME STAFF");
		Welcomestf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Welcomestf.setHorizontalAlignment(SwingConstants.CENTER);
		Welcomestf.setBounds(255, 36, 369, 45);
		welfac.add(Welcomestf);
		
		JButton modifybtn = new JButton("MODIFY DETAILS");
		modifybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifydetails modify=new modifydetails();
				modify.setVisible(true);
				dispose();
			}
		});
		modifybtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		modifybtn.setBounds(323, 125, 228, 45);
		welfac.add(modifybtn);
		
		JButton viewbtn = new JButton("VIEW REQUEST");
		viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRequests reqapp=new viewRequests();
				reqapp.setVisible(true);
				dispose();
			}
		});
		viewbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		viewbtn.setBounds(323, 221, 228, 45);
		welfac.add(viewbtn);
		
		JButton BACK = new JButton("BACK");
		BACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login logi = new login();
				logi.setVisible(true);
				dispose();
			}
		});
		BACK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		BACK.setBounds(323, 311, 228, 45);
		welfac.add(BACK);
	}
}
