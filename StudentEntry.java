

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentEntry extends JFrame{
    
    public StudentEntry(){
        setSize(400, 300);
setTitle("Student Management System");
setDefaultCloseOperation(EXIT_ON_CLOSE);
Toolkit toolkit = getToolkit();
Dimension size = toolkit.getScreenSize();
setLocation(size.width/2 - getWidth()/2, 
size.height/2 - getHeight()/2);
JPanel panel = new JPanel();
getContentPane().add(panel);
panel.setLayout(null);
JLabel stid = new JLabel("Student ID");
stid.setBounds(50, 10, 80, 25);
panel.add(stid);
JTextField stdid=new JTextField(20);
stdid.setBounds(215, 10, 150, 25);
panel.add(stdid);
JLabel fst = new JLabel("First Name");
fst.setBounds(50, 45, 80, 25);
panel.add(fst);
JTextField fstn=new JTextField(20);
fstn.setBounds(215, 45, 150, 25);
panel.add(fstn);
JLabel lst = new JLabel("Last Name");
lst.setBounds(50, 80, 80, 25);
panel.add(lst);
JTextField lstn=new JTextField(20);
lstn.setBounds(215, 80, 150, 25);
panel.add(lstn);
JLabel crse = new JLabel("Course");
crse.setBounds(50, 115, 80, 25);
panel.add(crse);
JTextField crsen=new JTextField(20);
crsen.setBounds(215, 115, 150, 25);
panel.add(crsen);
JLabel scn = new JLabel("Section");
scn.setBounds(50, 150, 80, 25);
panel.add(scn);
JTextField scnn=new JTextField(20);
scnn.setBounds(215, 150, 150, 25);
panel.add(scnn);
JButton save=new JButton("Save");
save.setBounds(50,185,100,25);
save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                StudentComponent sc=new StudentComponent();
                sc.addStudent(stdid.getText(), fstn.getText(), lstn.getText(), crsen.getText(), scnn.getText());
            }
        });
panel.add(save);
JButton show=new JButton("Show");
show.setBounds(215,185,100,25);
show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentShow sc=new StudentShow();
                /*StudentComponent sc=new StudentComponent();
                sc.listStudents();*/
            }
        });
panel.add(show);
JButton update=new JButton("Update");
update.setBounds(50,220,100,25);
update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                StudentComponent sc=new StudentComponent();
                sc.updateStudent(stdid.getText(), fstn.getText(), lstn.getText(), crsen.getText(), scnn.getText());
            
            }
        });
panel.add(update);
JButton delete=new JButton("Delete");
delete.setBounds(215,220,100,25);
delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                StudentComponent sc=new StudentComponent();
                String s=JOptionPane.showInputDialog("Student id ");
                sc.deleteStudent(s);
                JOptionPane.showMessageDialog(null, "Deleted sucessfully \nStudent Id "+s);
            
            }
        });
panel.add(delete);




        
    }
    
    
}
