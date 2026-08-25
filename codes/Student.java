import java.util.ArrayList;
import java.text.DecimalFormat;

public class Student extends Person{
    private ArrayList<Course> courses;
    //    private int creditCap;
    private TuitionFees bills;
    private double gpa=0;
    private String[] majors=new String[2];
    private int majorNB=0;

    public Student(String fName, String dName, String lName, int age, String address,String[] majors,int majorNB) {
        super(fName, dName, lName, age, address);
//        this.creditCap=creditCap;
        this.id=super.YEAR+idC++;
        this.courses = new ArrayList<Course>();
        if(courses.size()!=0) {
            for(Course c : this.courses) {
                this.gpa+=(c.getGrade(this)*c.getCreditSize());
            }
            this.gpa=this.gpa/this.courses.size();
        }
        else
            this.gpa=0;
        this.majors=majors;
        this.majorNB=majorNB;
        this.bills=new TuitionFees(gpa,courses); //will be edited using setters
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
        for(Course c : courses) {
            c.addStudent(this);
        }
        this.setFees();
    }

//    public int getCreditCap() {
//        return creditCap;
//    }
//
//    public void setCreditCap(int creditCap) {
//        this.creditCap = creditCap;
//    }

    public TuitionFees getFees() {
        return bills;
    }

    public void setFees() {
        this.bills=new TuitionFees(this.gpa,courses);
    }

    public String[] getMajors() {
        return majors;
    }

    public void setMajors(String[] majors) {
        this.majors = majors;
    }


    public void setEmail() {
        this.email=this.id + "@ua.edu.lb";
    }

    public void setID(int id) {
        this.id=YEAR+idC++;
    }

    public void setGpa() {

        if(courses.size()!=0) {
            for(Course c : this.courses) {
                this.gpa+=(c.getGrade(this)*c.getCreditSize());
            }
            this.gpa=this.gpa/this.courses.size();
        }
        else
            this.gpa=0;

    }

    public double getGpa() {
        return this.gpa;
    }

    public String toString(){
        DecimalFormat fmt = new DecimalFormat("0.###");
        this.setGpa();
        String s="Student info:\nFirst name:"+getFName()+"\nFather's name:"+getDName()
                +"\nLast name:"+getLName()+
                "\nAddress:"+getAddress()+"\nAge:"+getAge()
                +"\nID:"+getID()
                +"\nEmail:"+getEmail()
                +"\nGPA:"+fmt.format(gpa);
        if(courses.size()!=0)
            s+="\nCourses:"+getCourses();
        else
            s+="\nCourses: None.";
        if(this.majorNB==1)
            s+="Major: "+majors[0];
        else
            s+="Major 1: "+majors[0]+"\nMajor 2: "+majors[1];

        return s;
    }
    public void addCourse(Course newCourse){

        boolean courseExists=false;
        for(int i=0;i<courses.size();i++) {
            if(newCourse==courses.get(i))
                courseExists=true;
        }
        if(courseExists==false) {
            this.courses.add(newCourse);
            newCourse.addStudent(this);
            System.out.println("Enrolled Successfully!\n");
        }

        this.bills.setFullPayment(this.bills.getFullPayment()+(this.bills.getPricePerCredit()*newCourse.getCreditSize()));
    }
    public void removeCourse(Course newCourse,boolean voluntary){
        for(Course c : courses) {
            if(c==newCourse) {
                this.courses.remove(newCourse);
                System.out.println("Successfully withdrawn from course: \n"+newCourse);
                newCourse.removeStudent(this);
                if(voluntary==true) {
                    bills.setFullPayment(bills.getFullPayment()-newCourse.getCreditSize()*bills.getPricePerCredit());
                    System.out.println("\nYour tuition fees have been changed: \n"+bills);
                }
                else
                    System.out.println("\nDue to the student's abscences, the tuition fees remain the same, they must pay for the course.\nThe student in question: \n"+this);
            }
        }
    }

    public double getCourseGrade(Course course) {
        boolean courseFound=false;
        //The logic here is if the course has been found, it will return the grade, if not it will display and error message.
        for(Course c : courses) {
            if(c==course) {
                courseFound=true;
            }
        }
        if(courseFound==false) {
            System.out.println("\nThis student is not enrolled in this course!!");
            return 0;
        }
        else
            return course.getGrade(this);
    }

}