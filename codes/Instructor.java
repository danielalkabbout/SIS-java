import java.util.ArrayList;

public class Instructor extends Person{
    private ArrayList<Course> courses;

    public Instructor(String fName, String dName, String lName, int age, String address) {
        super(fName, dName, lName, age, address);
        this.id=super.YEAR+idC++;
        super.email=this.id + "@ua.edu.lb";
        this.courses = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        for(Course c : courses) {
            c.setInstructor(this);
        }
        this.courses = courses;
    }

    public String toString() {
        String s="Instructor info:\n First name:" + getFName() + "\n Father's name:" + getDName()
                + "\nLast name:" + getLName() +
                "\nAddress:" + getAddress() + "\nAge:" + getAge()
                + "\nID:" + getID()
                + "\nEmail:" + getEmail();
        if(courses.size()!=0)
            s+="\nCourses:"+getCourses();
        else
            s+="\nCourses: None.";
        return s;
    }


    public void setEmail() {
        this.email=this.id + "@ua.edu.lb";
    }

    public void setID(int id) {
        this.id=YEAR+idC++;
    }
}