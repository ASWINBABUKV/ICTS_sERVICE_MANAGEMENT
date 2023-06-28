package PROJECT;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.Statement;

public class req_app extends JFrame {

	private JPanel req_app;
	private JTextField fnametxt,studidtxt,sertxt,lnametxt,depttxt;

	public req_app() {
		setTitle("REQUEST APPROVAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 530);
		req_app = new JPanel();
		req_app.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(req_app);
		req_app.setLayout(null);
		
		JLabel request_app_head = new JLabel("REQUEST FOR APPROVAL");
		request_app_head.setFont(new Font("Dialog", Font.BOLD, 15));
		request_app_head.setBounds(279, 10, 226, 31);
		req_app.add(request_app_head);

		JLabel student_fname = new JLabel("FIRST NAME");
		student_fname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		student_fname.setBounds(216, 74, 76, 22);
		req_app.add(student_fname);
		
		fnametxt = new JTextField();
		fnametxt.setBounds(374, 77, 167, 19);
		req_app.add(fnametxt);
		fnametxt.setColumns(10);

		JLabel student_id = new JLabel("STUDENT ID");
		student_id.setFont(new Font("Tahoma", Font.PLAIN, 13));
		student_id.setBounds(216, 155, 76, 22);
		req_app.add(student_id);

		studidtxt = new JTextField();
		studidtxt.setColumns(10);
		studidtxt.setBounds(374, 158, 167, 19);
		req_app.add(studidtxt);

		JLabel service = new JLabel("SERVICE");
		service.setFont(new Font("Tahoma", Font.PLAIN, 13));
		service.setBounds(216, 195, 76, 22);
		req_app.add(service);


		sertxt = new JTextField();
		sertxt.setColumns(10);
		sertxt.setBounds(374, 198, 167, 19);
		req_app.add(sertxt);

		JLabel student_lname = new JLabel("LAST NAME");
		student_lname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		student_lname.setBounds(216, 113, 76, 22);
		req_app.add(student_lname);

		lnametxt = new JTextField();
		lnametxt.setColumns(10);
		lnametxt.setBounds(374, 119, 167, 19);
		req_app.add(lnametxt);

		JLabel dept = new JLabel("DEPARTMENT");
		dept.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dept.setBounds(216, 238, 87, 22);
		req_app.add(dept);

		depttxt = new JTextField();
		depttxt.setColumns(10);
		depttxt.setBounds(374, 241, 167, 19);
			req_app.add(depttxt);

			JButton add_button = new JButton("ADD");
			add_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String first_name=fnametxt.getText();
					String last_name=lnametxt.getText();
					String id=studidtxt.getText();
					String service=sertxt.getText();
					String department=depttxt.getText();
					try {
						Connection c=null;
						Class.forName("org.postgresql.Driver");
						c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectsample","postgres","Aswin123");
						String query="INSERT INTO requestapproval values('"+first_name+"','"+last_name+"','"+id+"','"+service+"','"+department+"')";
						Statement sta=c.createStatement();
						int x= sta.executeUpdate(query);
						if(x==0) {
							JOptionPane.showMessageDialog(add_button,"This is already exist");
						}else {
							JOptionPane.showMessageDialog(add_button,"Sucessfully added");
						}
						c.close();
					}
					catch(Exception e1){
						e1.printStackTrace();
					}	
				}
			});
			add_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
	add_button.setBounds(419, 292, 122, 39);
	req_app.add(add_button);

	JButton back_button = new JButton("BACK");
	back_button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	stud s=new stud();
	s.setVisible(true);
	dispose();
	}
	});
	back_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
	back_button.setBounds(216, 292, 122, 39);
	req_app.add(back_button);


}
}