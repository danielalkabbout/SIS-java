
import java.util.Scanner;

public class Course{

    private String courseName,courseID;
    private static int counter_For_CourseID_Generation=1001;
    private int size=10,creditSize=3,nbStudents=0;	//These set values are only temporary and default values, they are in place to avoid errors.
    private Student[] students = new Student[size];
    private Grade[] studentGrades = new Grade[size];
    private Attendance[] studentAttendance = new Attendance[size];
    private Instructor instructor;

    public Course(String courseName, int size, int creditSize,Instructor instructor){
        this.courseName=courseName;
        if(size>0&&size<20)
            this.size=size;
        else
            this.size=10;
        if(creditSize!=1&&creditSize!=3)
            this.creditSize=3;
        else
            this.creditSize=creditSize;
        this.instructor=instructor;

        //The next block's only purpose is to make sure all parameters exist per object created from this Class.
        this.students = new Student[this.size];
        this.studentGrades = new Grade[this.size];
        this.studentAttendance = new Attendance[this.size];
        this.nbStudents=0;

        this.courseID=this.courseName.substring(0,4).toUpperCase()+"_"+counter_For_CourseID_Generation++;
        System.out.println("Course created!\n");
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String name) {
        this.courseName=name;
    }




    //The below chunk of code is meant for the PrintWriter Class reserved to the Course class.
//	public String getCourseName() {
//		return this.courseName;
//	}
//	public void setName(String name) {
//		this.courseName=name;
//	}
//	
//	public int getCFCIG() {
//		return counter_For_CourseID_Generation;
//	}
//	public void setCFCIG(int C) {
//		counter_For_CourseID_Generation=C;
//	}
//	
//	public Student[] getStudentsArray() {
//		return this.students;
//	}
//	public void setStudentsArray(Student[] newStudents) {
//		this.students=newStudents;
//	}
//	
//	public Grade[] getGradesArray() {
//		return this.studentGrades;
//	}
//	public void setGradesArray(Grade[] newGrades) {
//		this.studentGrades=newGrades;
//	}
//	
//	public Attendance[] getAttendanceArray() {
//		return this.studentAttendance;
//	}
//	public void setAttendanceArray(Attendance[] newAttendance) {
//		this.studentAttendance=newAttendance;
//	}
//	

    public String getcourseId() {
        return this.courseID;
    }
    public void setCourseId(String courseID) {
        this.courseID=this.courseName.substring(0,4).toUpperCase()+"_"+counter_For_CourseID_Generation++;
        System.out.println("ID created.");
    }


    public int getSize() {
        return size;
    }

    public int getNbStudents() {
        return this.nbStudents;
    }

    public Instructor getInstructor() {
        return instructor;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        System.out.println("Instructor for this course has been changed successfully!");
    }

    public int getCreditSize() {
        return this.creditSize;
    }
    public void setCreditSize(int creditSize) {
        if(creditSize!=1&&creditSize!=3) {
            this.creditSize=3;
            System.out.println("Credit size can only be 1 or 3. Set to 3.");
        }
        else {
            this.creditSize=creditSize;
            System.out.println("Credit size set to: "+creditSize);
        }
    }

    public void addStudent(Student newStudent) {
        if(nbStudents==size) {
            System.out.println("Our sincere apologies, but in seems that this class is full! Please try to enroll again at another time!");
        }
        else {
            boolean alreadyExists=false;
            for(int i=0;i<nbStudents;i++) {
                if(newStudent==students[i])
                    alreadyExists=true;
            }
            if(alreadyExists==false) {
                this.students[nbStudents]=newStudent;
                newStudent.addCourse(this);
                this.studentGrades[nbStudents]= null;
                Integer idtoString=newStudent.getID();
                this.studentAttendance[nbStudents]=new Attendance(idtoString.toString());
                this.nbStudents++;
                System.out.println("\nSuccessfully enrolled! This student is now part of this course!");
            }
            else
                System.out.println("This student is already enrolled in this course.\nCourse info:\n"+this.toString()+"\nStudent in question: \n"+newStudent);
        }
    }

    public void removeStudent(Student student){
        for(int i=0;i<nbStudents;i++) {
            if(this.students[i]==student) {
                for(int j=i;j<nbStudents;j++) {
                    this.students[j]=this.students[j+1];
                    if(j==nbStudents-1)
                        students[j]=null;
                    this.studentAttendance[j]=studentAttendance[j+1];
                    if(j==nbStudents-1)
                        this.studentAttendance[j]=null;
                    this.studentGrades[j]=this.studentGrades[j+1];
                    if(j==nbStudents-1)
                        this.studentGrades[j]=null;
                    student.removeCourse(this, true);
                }
                nbStudents--;
            }
        }
        System.out.println("Student has successfully withdrawn from the course: \nCourse ID: "+this.courseID+"\nCourse Name: "+this.courseName);
    }

    public String toString() {
        String sentence="Course ID: "+this.courseID+"\nCourse Name: "+this.courseName+"\nInstructor:\n"+instructor+"\n\n";
        for(int i=0;i<nbStudents;i++)
            sentence+=students[i]+"\n";
        return sentence;
    }

    public double getGrade(Student student) {
        boolean studentFound=false;
        int temp=0;
        for(int i=0;i<nbStudents;i++) {
            if(students[i]==student) {
                studentFound=true;
                temp=i;
                break;
            }
        }
        if(studentFound==true)
            return studentGrades[temp].getFinalGrade();
        else {
            System.out.println("\nStudent is not enrolled in this course! Course: \n"+this.toString());
            return 0;
        }
    }

    public void setGrade(Student student) {

        Scanner read = new Scanner(System.in);

        boolean studentFound=false;
        int temp=0;
        for(int i=0;i<nbStudents;i++) {
            if(students[i]==student) {
                studentFound=true;
                temp=i;
                break;
            }
        }
        if(studentFound==false)
            System.out.println("\nStudent is not enrolled in this course! Course: \n"+this.toString());
        else {
            double q,m,f;
            do {
                System.out.println("Enter quiz grade: \n");
                q = read.nextDouble();
            }	while(q>100 || q<0);
            studentGrades[temp].setQuiz(q);
            System.out.println("Quiz grade set to: "+studentGrades[temp].getQuiz());
            do {
                System.out.println("Enter midterm grade: \n");
                m = read.nextDouble();
            }	while(m>100 || m<0);
            studentGrades[temp].setMidterm(m);
            System.out.println("Midterm grade set to: "+studentGrades[temp].getMidterm());
            do {
                System.out.println("Enter final grade: \n");
                f = read.nextDouble();
            }	while(f>100 || f<0);
            studentGrades[temp].setFinalExam(f);
            System.out.println("Final grade set to: "+studentGrades[temp].getFinalExam());
            read.nextLine();
        }
        read.close();
    }

    //This will serve to return how many times a student was absent.
    public void getAttendance() {
        for(int i=0;i<nbStudents;i++) {
            System.out.println(students[i]);
            if(studentAttendance[i].getAbsenceCounter()==9) {
                students[i].removeCourse(this, false);
                removeStudent(students[i]);
            }
            else
                System.out.println(studentAttendance[i].getAbsenceCounter());
        }
    }

    public void setAttendance() {

        Scanner read = new Scanner(System.in);

        for(int i=0;i<nbStudents;i++) {
            System.out.println(students[i]);
            if(studentAttendance[i].getAbsenceCounter()==9) {
                students[i].removeCourse(this, false);
                removeStudent(students[i]);
            }
            else {
                int presence;
                do {
                    System.out.println("Please enter 1 for present and 0 for absent:");
                    presence=read.nextInt();
                }	while(presence!=0 && presence!=1);
                read.nextLine();
                if(presence==0) {
                    studentAttendance[i].setAbsenceCounter(studentAttendance[i].getAbsenceCounter()+1);
                    if(studentAttendance[i].getAbsenceCounter()==9) {
                        students[i].removeCourse(this, false);
                        removeStudent(students[i]);
                    }
                }
            }
        }
        read.close();
    }

    public void PrintStudents() {
        for(int i=0;i<this.nbStudents;i++) {
            System.out.println(this.students[i]);
        }
    }

}