package PROJECT;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class requestApproval extends JFrame {

private JPanel reqappro;
private JTextField fnametxt,idtxt,servicetxt,departmenttxt,lnametxt;
public requestApproval() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 880, 530);
	reqappro = new JPanel();
	reqappro.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(reqappro);
	reqappro.setLayout(null);

	JLabel reqhead = new JLabel("REQUEST FOR APPROVAL");
	reqhead.setFont(new Font("Times New Roman", Font.BOLD, 18));
	reqhead.setBounds(301, 10, 262, 62);
	reqappro.add(reqhead);

	JLabel fname = new JLabel("FNAME NAME");
	fname.setFont(new Font("Tahoma", Font.PLAIN, 13));
	fname.setBounds(259, 104, 79, 17);
	reqappro.add(fname);
	
	fnametxt = new JTextField();
	fnametxt.setBounds(410, 104, 153, 19);
	reqappro.add(fnametxt);
	fnametxt.setColumns(10);
	
	JLabel lname = new JLabel("LAST NAME");
	lname.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lname.setBounds(259, 138, 79, 17);
	reqappro.add(lname);

	lnametxt = new JTextField();
	lnametxt.setColumns(10);
	lnametxt.setBounds(410, 138, 153, 19);
	reqappro.add(lnametxt);

	JLabel id = new JLabel("ID");
	id.setFont(new Font("Tahoma", Font.PLAIN, 13));
	id.setBounds(259, 177, 45, 13);
	reqappro.add(id);
	
	idtxt = new JTextField();
	idtxt.setBounds(410, 175, 153, 19);
	reqappro.add(idtxt);
	idtxt.setColumns(10);

	JLabel service = new JLabel("SERVICE");
	service.setFont(new Font("Tahoma", Font.PLAIN, 13));
	service.setBounds(259, 220, 66, 13);
	reqappro.add(service);
	
	servicetxt = new JTextField();
	servicetxt.setBounds(410, 218, 153, 19);
	reqappro.add(servicetxt);
	servicetxt.setColumns(10);
	
	JLabel dept = new JLabel("DEPARTMENT");
	dept.setFont(new Font("Tahoma", Font.PLAIN, 13));
	dept.setBounds(259, 261, 92, 19);
	reqappro.add(dept);
	
	departmenttxt = new JTextField();
	departmenttxt.setBounds(410, 262, 153, 19);
	reqappro.add(departmenttxt);
	departmenttxt.setColumns(10);

	JButton addbtn = new JButton("ADD");
	addbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String first_name=fnametxt.getText();
			String last_name=lnametxt.getText();
			String id=idtxt.getText();
			String service=servicetxt.getText();
			String department=departmenttxt.getText();
			try {
				Connection c=null;
				Class.forName("org.postgresql.Driver");
				c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectsample","postgres","Aswin123");
				String query="INSERT INTO requestapproval values('"+first_name+"','"+last_name+"','"+id+"','"+service+"','"+department+"')";
				Statement sta=c.createStatement();
				int x= sta.executeUpdate(query);
				if(x==0) {
					JOptionPane.showMessageDialog(addbtn,"This is already exist");
				}else {
					JOptionPane.showMessageDialog(addbtn,"Sucessfully added");
				}
				c.close();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}	
		}
	});
	addbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
	addbtn.setBounds(466, 338, 97, 42);
	reqappro.add(addbtn);

	JButton bckbtn = new JButton("BACK");
	bckbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Faculty backbtn = new Faculty();
			backbtn.setVisible(true);
			dispose();
		}});
	bckbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
	bckbtn.setBounds(259, 338, 107, 42);
	reqappro.add(bckbtn);

}
}