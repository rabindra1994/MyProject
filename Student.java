
public class Student {
    private int id;
    private String stid;
    private String firstname,lastname,course,section;
    public Student(){}
    public Student(String stid,String firstname,String lastname,String course,String section){
        this.stid=stid;
        this.firstname=firstname;
        this.lastname=lastname;
        this.course=course;
        this.section=section;
    }
    public int getId(){
        return id;
        
    }
    public void setId(int id){
        this.id=id;
    }
    public String getStid(){
        return stid;
        
    }
    public void setStid(String stid){
        this.stid=stid;
    }
    
    public String getFirstname(){
        return firstname;
        
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public String getLastname(){
        return lastname;
        
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public String getCourse(){
        return course;
        
    }
    public void setCourse(String course){
        this.course=course;
    }
    public String getSection(){
        return section;
        
    }
    public void setSection(String section){
        this.section=section;
    }
    
}
