

import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentComponent {
private static   SessionFactory factory=new Configuration().configure().buildSessionFactory();;
public Integer addStudent(String stid,String firstname,String lastname,String course,String section){
    
    Session session=factory.openSession();
    Transaction tx=null;
    Integer stID=null;
    try{
    tx=session.beginTransaction();
    Student student=new Student( stid, firstname, lastname, course, section);
    stID=(Integer)session.save(student);
    tx.commit();}
    catch(HibernateException e){
        if(tx!=null)tx.rollback();
        JOptionPane.showMessageDialog(null,"Hibernate Exception Caught in addStudent \n "+e.getMessage());
    }
    finally{
        session.close();
    }
    return stID;
}
/*public void listStudents( ){
Session session = factory.openSession();
Transaction tx = null;
JFrame jfrm=new JFrame("Student Data");
Container cp=jfrm.getContentPane();

jfrm.setSize(1080, 480);
JTable table = null;
JScrollPane jsp;
jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
try{
tx = session.beginTransaction(); 

List employees = session.createQuery("FROM Student").list();

int stdcount=0;
for (Iterator iterator1 =
employees.iterator(); iterator1.hasNext();){
Student std1 = (Student) iterator1.next();
stdcount++;

}

String[] colheads={"Student ID","First Name","Last Name","Course","Section"};
 Object [][] data1=new Object[stdcount][stdcount+1];
for (
     Iterator iterator =employees.iterator(); 
 iterator.hasNext();){
Student student = (Student) iterator.next();
Object [][]data={{student.getStid(),student.getFirstname(),student.getLastname(),student.getCourse(),student.getSection()}};
table=new JTable(data,colheads);
jsp=new JScrollPane(table);

cp.add(jsp);
}


    
    
jfrm.setVisible(true);

tx.commit();
}catch (HibernateException e) {
if (tx!=null) tx.rollback();
e.printStackTrace();
}finally {
session.close();
}
}*/
public void updateStudent(String stid,String firstname,String lastname,String course,String section){
    
    Session session=factory.openSession();
    Transaction tx=null;
    try{
    tx=session.beginTransaction();
    String hql= "UPDATE Student set  stid= :stid, firstname= :firstname, lastname= :lastname, course= :course, section= :section WHERE stid = :stid";
    Query query = session.createQuery(hql);
    query.setParameter("stid", stid);
    query.setParameter("firstname", firstname);
    query.setParameter("lastname", lastname);
    query.setParameter("course", course);
    query.setParameter("section", section);
    int result = query.executeUpdate();
    
    tx.commit();}catch(HibernateException e){
        if(tx!=null)tx.rollback();
        JOptionPane.showMessageDialog(null,"Hibernate Exception Caught in updateStudent\n"+e.getMessage());
        
    }finally{
        session.close();
    }
    
}
public void deleteStudent(String stid){
    Session session=factory.openSession();
    Transaction tx=null;
    try{
    tx=session.beginTransaction();
    String hql = "DELETE FROM Student "  +
                  "WHERE stid = :stid";
    Query query = session.createQuery(hql);
    query.setParameter("stid", stid);
    int result = query.executeUpdate();
        tx.commit();}catch(HibernateException e){
        if(tx!=null)tx.rollback();
        JOptionPane.showMessageDialog(null,"Hibernate Exception Caught in deleteStudent \n "+e.getMessage());
        
    }finally{
        session.close();
    }
}

}
