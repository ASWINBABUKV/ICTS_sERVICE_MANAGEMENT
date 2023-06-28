package PROJECT;



import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class addservice extends JFrame{
	private JPanel addservicepage;
	private JTextField SER,SERN;
	public addservice() {
		setTitle("ADD SERVICE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 530);
		addservicepage = new JPanel();
		addservicepage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addservicepage);
		addservicepage.setLayout(null);
		
		JLabel enterdetail1 = new JLabel("ENTER DETAILS");
		enterdetail1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		enterdetail1.setBounds(318, 10, 207, 33);
		addservicepage.add(enterdetail1);
		
		JLabel namelblserv = new JLabel("NAME OF SERVICE: ");
		namelblserv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		namelblserv.setBounds(224, 157, 137, 26);
		addservicepage.add(namelblserv);
		
		SER = new JTextField();
		SER.setBounds(436, 92, 147, 26);
		addservicepage.add(SER);
		SER.setColumns(10);
		
		JLabel serlabl = new JLabel("SERVICE ID: ");
		serlabl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		serlabl.setBounds(224, 90, 137, 26);
		addservicepage.add(serlabl);
		
		SERN = new JTextField();
		SERN.setColumns(10);
		SERN.setBounds(436, 157, 147, 26);
		addservicepage.add(SERN);
		
		JButton btnadddetail = new JButton("ADD");
		btnadddetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String service_id = SER.getText();
				String service_name = SERN.getText();
				try {
					Connection c =null;
					Class.forName("org.postgresql.Driver");
			        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectsample", "postgres", "Aswin123");
			        String query = "INSERT INTO service values('" + service_id + "','" + service_name + "')";
			        Statement sta = c.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnadddetail, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnadddetail,"Welcome, Your account is sucessfully created");
                    }
                    c.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnadddetail.setBounds(436, 240, 147, 33);
		addservicepage.add(btnadddetail);
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin adm = new admin();
				adm.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(234, 240, 137, 33);
		addservicepage.add(btnBack);
	}
}
