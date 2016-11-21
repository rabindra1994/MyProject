import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class index {
    private static SessionFactory factory;
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        try{
    factory=new Configuration().configure().buildSessionFactory();
            }
    catch(Throwable ex)
        {
        JOptionPane.showMessageDialog(null, "Failed to create Session Factory Object \n"+ex.getMessage());
        throw new ExceptionInInitializerError(ex);
        }
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        StudentEntry std=new StudentEntry();
        std.setVisible(true);
    }
    
}