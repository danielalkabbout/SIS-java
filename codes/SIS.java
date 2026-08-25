import java.util.Scanner;
//import java.text.NumberFormat;
import java.text.DecimalFormat;

import java.util.ArrayList;

public class SIS {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        //Not needed
//		NumberFormat prctfmt = NumberFormat.getPercentInstance();
//		NumberFormat billsfmt = NumberFormat.getCurrencyInstance();

        DecimalFormat dcfmt = new DecimalFormat("0.###");
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Instructor> instructors = new ArrayList<Instructor>();

        String passKey,fname,dname,lname,address,courseName,courseID;
        int choice,age,majorNB,courseSize,creditSize,id;
        boolean available=false;
        Student studentLogIn = null;
        do {
            available=false;

            System.out.println("Welcome to the SIS. \n\n\n");

            System.out.println("Type anything to continue:");
            passKey = read.nextLine();
            if(passKey.equalsIgnoreCase("admin")) {
                do {
                    System.out.println("Welcome Administrator, here are your options:\n"
                            + "1- Check List of Courses.\n"
                            + "2- Check List of Students.\n"
                            + "3- Check List of Instructors.\n"
                            + "4- Check a Course.\n"
                            + "5- Check a Student.\n"
                            + "6- Check an Instructor.\n"
                            + "7- Register a Student.\n"
                            + "8- Enroll Student to Course.\n"
                            + "9- Check Student's Tuition Fees.\n"
                            + "10- Remove Student.\n"
                            + "11- Take Attendance For Course.\n"
                            + "12- Add Course.\n"
                            + "13- Check Students Enrolled in a Course.\n"
                            + "14- Remove Student From a Course.\n"
                            + "15- Check a Student's Grades in Each Course.\n"
                            + "16- Get a Student's GPA.\n"
                            + "17- Hire an Instructor.\n"
                            + "18- Fire an Instructor.\n"
                            + "19- Assign an Instructor to a course.\n"
                            + "20- Change a Student's grades.\n"
                            + "0- Exit Program.");
                    choice=read.nextInt();
                    read.nextLine();
                    switch(choice) {



                        case 1:
                            if(courses.size()!=0) {
                                for(Course c : courses) {
                                    System.out.println(c.getcourseId()+" - "+c.getCourseName());
                                }
                            }
                            else{
                                do {
                                    System.out.println("System seems unable to detect any courses, do you wish to create a new course?\n 1 for yes 0 for no");
                                    choice=read.nextInt();
                                }	while(choice!=0 && choice!=1);
                                if(choice==1) {
                                    read.nextLine();
                                    System.out.println("Enter course name: ");
                                    courseName = read.nextLine();
                                    do {
                                        System.out.println("Enter the maximal number of students for this course: ");
                                        courseSize = read.nextInt();
                                    }	while(courseSize<0||courseSize>20);
                                    read.nextLine();
                                    do {
                                        System.out.println("Enter the weight in credits of this course(1 or 3): ");
                                        creditSize = read.nextInt();
                                    }	while (creditSize!=1 && creditSize!=3);
                                    read.nextLine();
                                    if(instructors.size()!=0) {
                                        System.out.println("Please choose an instructor for this course out of our list of esteemed instructors by ID: \n");
                                        for(Instructor i : instructors) {
                                            System.out.println("\n"+i+"\n");
                                        }
                                        do {
                                            System.out.println("Select instructor by ID: ");
                                            id = read.nextInt();
                                            read.nextLine();
                                            for(Instructor i : instructors)
                                                if(id==i.getID())
                                                    available=true;
                                        }	while(available==false);
                                        Instructor temp=null;
                                        for(Instructor i : instructors)
                                            if(id==i.getID())
                                                temp=i;
                                        Course newCourse = new Course(courseName,courseSize,creditSize,temp);
                                        System.out.println("Well chosen! here is the course created:"+newCourse);
                                        courses.add(newCourse);
                                    }
                                    else{
                                        do {
                                            System.out.println("System seems unable to detect any instructors, do you wish to register a new instructor?\n 1 for yes 0 for no");
                                            choice=read.nextInt();
                                        }	while(choice!=0 && choice!=1);
                                        read.nextLine();
                                        if(choice==1) {
                                            read.nextLine();
                                            System.out.println("\nPlease enter first name of instructor:");
                                            fname = read.nextLine();
                                            System.out.println("\nPlease enter the name of the father:");
                                            dname = read.nextLine();
                                            System.out.println("\nPlease enter last name of instructor:");
                                            lname = read.nextLine();
                                            do {
                                                System.out.println("\nPlease enter the instructor's age (>=18):");
                                                age = read.nextInt();
                                            }	while(age<18);
                                            read.nextLine();
                                            System.out.println("\nPlease enter the address:");
                                            address = read.nextLine();

                                            Instructor newInstructor = new Instructor(fname,dname,lname,age,address);
                                            instructors.add(newInstructor);
                                            System.out.println("Instructor has been successfully registered! "
                                                    + "Here is the description of said instructor:\n"+newInstructor);
                                            courses.add(new Course(courseName, courseSize, creditSize,newInstructor));
                                        }
                                        else
                                            System.out.println("Please choose a different option.");
                                    }
                                }
                            }
                            break;



                        case 2:
                            if(students.size()!=0) {
                                for(Student s : students) {
                                    System.out.println(s.getID()+" - "+s.getFName()+" "+s.getDName()+" "+s.getLName());
                                }
                            }
                            else{
                                do {
                                    System.out.println("System seems unable to detect any students, do you wish to register a new student?\n 1 for yes 0 for no");
                                    choice=read.nextInt();
                                }	while(choice!=0 && choice!=1);
                                read.nextLine();
                                if(choice==1) {
                                    read.nextLine();
                                    System.out.println("\nPlease enter first name of student:");
                                    fname = read.nextLine();
                                    System.out.println("\nPlease enter the name of the father:");
                                    dname = read.nextLine();
                                    System.out.println("\nPlease enter last name of student:");
                                    lname = read.nextLine();

                                    do {
                                        System.out.println("\nPlease enter the student's age (>=18):");
                                        age = read.nextInt();
                                    }	while(age<18);
                                    read.nextLine();
                                    System.out.println("\nPlease enter the address:");
                                    address = read.nextLine();
                                    do {
                                        System.out.println("The student may choose up to TWO majors, how many does the student wish to choose(1 or 2).");
                                        majorNB = read.nextInt();
                                    }	while (majorNB>2||majorNB<0);
                                    read.nextLine();
                                    String[] majors = new String[2];
                                    if(majorNB==1) {
                                        System.out.print("Enter the name of the major: ");
                                        majors[0]=read.nextLine();
                                        majors[1]="None";
                                        Student newStudent = new Student(fname,dname,lname,age,address,majors,majorNB);
                                        students.add(newStudent);
                                        System.out.println("Student has been successfully registered! Here is the description of said student:\n"+newStudent);

                                    }
                                    else {
                                        System.out.print("Enter name of major 1: ");
                                        majors[0]=read.nextLine();
                                        if(majorNB==2) {
                                            do {
                                                System.out.print("Enter name of major 2: ");
                                                majors[1]=read.nextLine();
                                            }	while(majors[0].equalsIgnoreCase(majors[1]));
                                        }
                                    }
                                    Student newStudent = new Student(fname,dname,lname,age,address,majors,majorNB);
                                    students.add(newStudent);
                                    System.out.println("Student has been successfully registered! Here is the description of said student:\n"+newStudent);

                                }
                                else
                                    System.out.println("Please choose a different option.");
                            }
                            break;



                        case 3:
                            if(instructors.size()!=0) {
                                for(Instructor i : instructors) {
                                    System.out.println(i.getID()+" - "+i.getFName()+" "+i.getDName()+" "+i.getLName());
                                }
                            }
                            else {
                                do {
                                    System.out.println("System seems unable to detect any instructors, do you wish to register a new instructor?\n 1 for yes 0 for no");
                                    choice=read.nextInt();
                                }	while(choice!=0 && choice!=1);
                                read.nextLine();
                                if(choice==1) {
                                    read.nextLine();
                                    System.out.println("\nPlease enter first name of instructor:");
                                    fname = read.nextLine();
                                    System.out.println("\nPlease enter the name of the father:");
                                    dname = read.nextLine();
                                    System.out.println("\nPlease enter last name of instructor:");
                                    lname = read.nextLine();
                                    do {
                                        System.out.println("\nPlease enter the instructor's age (>=18):");
                                        age = read.nextInt();
                                    }	while(age<18);
                                    read.nextLine();
                                    System.out.println("\nPlease enter the address:");
                                    address = read.nextLine();

                                    Instructor newInstructor = new Instructor(fname,dname,lname,age,address);
                                    instructors.add(newInstructor);
                                    System.out.println("Instructor has been successfully registered! "
                                            + "Here is the description of said instructor:\n"+newInstructor);

                                }
                                else
                                    System.out.println("Please choose a different option.");
                            }

                            break;



                        case 4:
                            if(courses.size()!=0) {
                                for(Course c : courses) {
                                    System.out.println(c.getcourseId()+" - "+c.getCourseName());
                                }
                                do {
                                    System.out.println("Select course by ID: ");
                                    courseID = read.nextLine();
                                    for(Course c : courses)
                                        if(courseID==c.getcourseId())
                                            available=true;
                                }	while(available==false);
                                Course temp=null;
                                for(Course c : courses)
                                    if(courseID==c.getcourseId())
                                        temp=c;
                                System.out.println("Course chosen: "+temp);
                                System.out.println("Choose what you would like to do with this course: ");
                                do {
                                    do {
                                        System.out.println("1- Enroll a Student.\n"
                                                + "2- Remove Student.\n"
                                                + "3- Remove Course.\n"
                                                + "4- Change Instructor (Assigning New Instructor To Course).\n"
                                                + "5- Enter a Student's Grades for Course (Overwrites Grades).\n"
                                                + "6- List of Students In Course.\n"
                                                + "0- Exit.");
                                        choice=read.nextInt();
                                    }while(choice<0||choice>6);
                                    read.nextLine();
                                    switch(choice) {
                                        case 1:
                                            if(students.size()==0) {
                                                System.out.println("\nPlease enter first name of student:");
                                                fname = read.nextLine();
                                                System.out.println("\nPlease enter the name of the father:");
                                                dname = read.nextLine();
                                                System.out.println("\nPlease enter last name of student:");
                                                lname = read.nextLine();

                                                do {
                                                    System.out.println("\nPlease enter the student's age (>=18):");
                                                    age = read.nextInt();
                                                }	while(age<18);
                                                read.nextLine();
                                                System.out.println("\nPlease enter the address:");
                                                address = read.nextLine();
                                                do {
                                                    System.out.println("The student may choose up to TWO majors, how many does the student wish to choose.");
                                                    majorNB = read.nextInt();
                                                }	while (majorNB>2||majorNB<0);
                                                read.nextLine();
                                                String[] majors = new String[2];
                                                for(int i=0;i<majorNB;i++) {
                                                    if(majorNB==1) {
                                                        System.out.print("Enter the name of the major: ");
                                                        majors[i]=read.nextLine();
                                                        majors[1]=null;
                                                    }
                                                    else {
                                                        System.out.print("Enter name of major "+(i+1)+": ");
                                                        majors[i]=read.nextLine();
                                                        if(i==1) {
                                                            do {
                                                                System.out.print("Enter name of major "+(i+1)+": ");
                                                                majors[i]=read.nextLine();
                                                            }	while(majors[0].equalsIgnoreCase(majors[1]));
                                                        }
                                                    }
                                                    Student newStudent = new Student(fname,dname,lname,age,address,majors,majorNB);
                                                    students.add(newStudent);
                                                    System.out.println("Student has been successfully registered! Here is the description of said student:\n"+newStudent+"\nNew Student Will Now Be Enrolled.");
                                                    temp.addStudent(newStudent);
                                                }
                                            }
                                            else {
                                                for(Student s : students) {
                                                    System.out.println(s.getID()+" - "+s.getFName()+" "+s.getDName()+" "+s.getLName());
                                                }
                                                do {
                                                    System.out.println("Select student by ID: ");
                                                    id = read.nextInt();
                                                    read.nextLine();
                                                    for(Student s : students)
                                                        if(id==s.getID())
                                                            available=true;
                                                }	while(available==false);
                                                Student tempStudent=null;
                                                for(Student s : students)
                                                    if(id==s.getID())
                                                        tempStudent=s;
                                                System.out.println("Student chosen: "+tempStudent);
                                                temp.addStudent(tempStudent);
                                            }

                                            break;
                                        case 2:
                                            if(students.size()==0) {
                                                temp.PrintStudents();
                                            }
                                            else {
                                                for(Student s : students) {
                                                    System.out.println(s.getID()+" - "+s.getFName()+" "+s.getDName()+" "+s.getLName());
                                                }
                                                do {
                                                    System.out.println("Select student by ID: ");
                                                    id = read.nextInt();
                                                    read.nextLine();
                                                    for(Student s : students)
                                                        if(id==s.getID())
                                                            available=true;
                                                }	while(available==false);
                                                Student tempStudent=null;
                                                for(Student s : students)
                                                    if(id==s.getID())
                                                        tempStudent=s;
                                                System.out.println("Student chosen: "+tempStudent);
                                                temp.removeStudent(tempStudent);
                                            }

                                            break;
                                        case 3:
                                            if(temp.getNbStudents()!=0) {
                                                for(Student s : students) {
                                                    s.removeCourse(temp, true);
                                                }
                                            }
                                            else
                                                System.out.println("No Students Enrolled in Course.");
                                            courses.remove(temp);
                                            break;
                                        case 4:
                                            if(instructors.size()!=0) {
                                                for(Instructor i : instructors) {
                                                    System.out.println(i.getID()+" - "+i.getFName()+" "+i.getDName()+" "+i.getLName());
                                                }
                                                do {
                                                    System.out.println("Select instructor by ID: ");
                                                    id = read.nextInt();
                                                    read.nextLine();
                                                    for(Instructor i : instructors)
                                                        if(id==i.getID())
                                                            available=true;
                                                }	while(available==false);
                                                Instructor tempInstructor=null;
                                                for(Instructor i : instructors)
                                                    if(id==i.getID())
                                                        tempInstructor=i;
                                                System.out.println("Instructor chosen: "+tempInstructor);
                                                temp.setInstructor(tempInstructor);
                                            }
                                            break;
                                        case 5:

                                            if(temp.getNbStudents()==0) {
                                                System.out.println("No Students Enrolled in Course.");
                                            }
                                            else {
                                                temp.PrintStudents();
                                                do {
                                                    System.out.println("Select student by ID: ");
                                                    id = read.nextInt();
                                                    for(Student s : students)
                                                        if(id==s.getID())
                                                            available=true;
                                                }	while(available==false);
                                                Student tempStudent=null;
                                                for(Student s : students)
                                                    if(id==s.getID())
                                                        tempStudent=s;
                                                System.out.println("Student chosen: "+tempStudent);
                                                temp.setGrade(tempStudent);
                                            }
                                            break;
                                        case 6:
                                            if(temp.getNbStudents()==0) {
                                                System.out.println("No Students Are Enrolled In This Course.");
                                            }
                                            else
                                                temp.PrintStudents();
                                            break;
                                        case 0:
                                            System.out.println("Returning to Main Menu...");
                                            break;
                                        default:
                                            System.out.println("Please enter valid value.");
                                            break;
                                    }
                                }	while(choice!=0);


                            }
                            else{
                                do {
                                    System.out.println("System seems unable to detect any courses, do you wish to create a new course?\n 1 for yes 0 for no");
                                    choice=read.nextInt();
                                }	while(choice!=0 && choice!=1);
                                if(choice==1) {
                                    read.nextLine();
                                    System.out.println("Enter course name: ");
                                    courseName = read.nextLine();
                                    System.out.println("Enter the maximal number of students for this course: ");
                                    courseSize = read.nextInt();
                                    read.nextLine();
                                    do {
                                        System.out.println("Enter the weight in credits of this course(1 or 3): ");
                                        creditSize = read.nextInt();
                                    }	while (creditSize!=1 && creditSize!=3);
                                    if(instructors.size()!=0) {
                                        System.out.println("Please choose an instructor for this course out of our list of esteemed instructors by ID: \n");
                                        for(Instructor i : instructors) {
                                            System.out.println("\n"+i+"\n");
                                        }
                                        do {
                                            System.out.println("Select instructor by ID: ");
                                            id = read.nextInt();
                                            read.nextLine();
                                            for(Instructor i : instructors)
                                                if(id==i.getID())
                                                    available=true;
                                        }	while(available==false);
                                        Instructor temp=null;
                                        for(Instructor i : instructors)
                                            if(id==i.getID())
                                                temp=i;
                                        Course newCourse = new Course(courseName,courseSize,creditSize,temp);
                                        System.out.println("Well chosen! here is the course created:"+newCourse);
                                        courses.add(newCourse);
                                    }
                                    else{
                                        do {
                                            System.out.println("System seems unable to detect any instructors, do you wish to register a new instructor?\n 1 for yes 0 for no");
                                            choice=read.nextInt();
                                        }	while(choice!=0 && choice!=1);
                                        read.nextLine();
                                        if(choice==1) {
                                            System.out.println("\nPlease enter first name of instructor:");
                                            fname = read.nextLine();
                                            System.out.println("\nPlease enter the name of the father:");
                                            dname = read.nextLine();
                                            System.out.println("\nPlease enter last name of instructor:");
                                            lname = read.nextLine();
                                            do {
                                                System.out.println("\nPlease enter the instructor's age (>=18):");
                                                age = read.nextInt();
                                            }	while(age<18);
                                            read.nextLine();
                                            System.out.println("\nPlease enter the address:");
                                            address = read.nextLine();

                                            Instructor newInstructor = new Instructor(fname,dname,lname,age,address);
                                            instructors.add(newInstructor);
                                            System.out.println("Instructor has been successfully registered! "
                                                    + "Here is the description of said instructor:\n"+newInstructor);
                                            System.out.println("The instuctor will be assigned to this course, you can change this later.");
                                            Course newCourse = new Course(courseName,courseSize,creditSize,newInstructor);
                                            courses.add(newCourse);
                                        }
                                        else
                                            System.out.println("Please choose a different option.");
                                    }
                                }
                            }

                            break;
                        case 5:

                            if(students.size()!=0) {
                                for(Student s : students) {
                                    System.out.println(s.getID()+" - "+s.getFName()+" "+s.getDName()+" "+s.getLName());
                                }
                                do {
                                    System.out.println("Select student by ID: ");
                                    id = read.nextInt();
                                    read.nextLine();
                                    for(Student s : students)
                                        if(id==s.getID())
                                            available=true;
                                }	while(available==false);
                                Student temp=null;
                                for(Student s : students)
                                    if(id==s.getID())
                                        temp=s;
                                do {
                                    do {
                                        System.out.println("Choose option: \n"
                                                + "1- View Info.\n"
                                                + "2- Remove Student.\n"
                                                + "3- View GPA And Grades.\n"
                                                + "4- View Tuition Fees.\n"
                                                + "0- Exit.");
                                        choice = read.nextInt();
                                    }	while (choice<0||choice>4);
                                    switch(choice) {
                                        case 1:
                                            System.out.println(temp);
                                            break;
                                        case 2:
                                            for(Course c : courses)
                                                c.removeStudent(temp);
                                            students.remove(temp);
                                            break;
                                        case 3:
                                            temp.setGpa();
                                            System.out.println("Student ID: "+temp.getID()+"\nGPA: "+dcfmt.format(temp.getGpa())+"\nGrades: ");
                                            for(Course c : temp.getCourses()) {
                                                System.out.println(c.getGrade(temp)+"\n");
                                            }
                                            break;
                                        case 4:
                                            temp.setFees();
                                            System.out.println("Student ID: "+temp.getID()+"\nFees: \n"+temp.getFees());
                                            break;
                                        case 0:
                                            System.out.println("Returning to Main Menu...");
                                    }
                                }	while(choice!=0);
                            }

                            else
                                System.out.println("System Seems Unable To Detect Any Students.");

                            break;



                        case 6:
                            if(instructors.size()!=0) {
                                for(Instructor i : instructors) {
                                    System.out.println(i.getID()+" - "+i.getFName()+" "+i.getDName()+" "+i.getLName());
                                }
                                do {
                                    System.out.println("Select Instructor by ID: ");
                                    id = read.nextInt();
                                    for(Instructor i : instructors)
                                        if(id==i.getID())
                                            available=true;
                                }	while(available==false);
                                Instructor temp=null;
                                for(Instructor i : instructors)
                                    if(id==i.getID())
                                        temp=i;
                                do {
                                    do {
                                        System.out.println("Choose option: \n"
                                                + "1- View Info.\n"
                                                + "2- Remove Instructor.\n"
                                                + "3- Assign Instructor to Course.\n"
                                                + "0- Exit.");
                                        choice = read.nextInt();
                                        read.nextLine();
                                    }	while(choice<0||choice>3);
                                    switch(choice) {
                                        case 1:
                                            System.out.println(temp);
                                            break;
                                        case 2:
                                            for(Course c : courses)
                                                c.setInstructor(null);
                                            instructors.remove(temp);
                                            break;
                                        case 3:
                                            String idString;
                                            if(courses.size()!=0) {
                                                for(Course c : courses) {
                                                    System.out.println(c.getcourseId()+" - "+c.getCourseName());
                                                }
                                                System.out.println("Select course by ID: ");
                                                idString = read.nextLine();
                                                do {
                                                    for(Course c : courses)
                                                        if(idString.equalsIgnoreCase(c.getcourseId()))
                                                            available=true;
                                                }	while(available==false);
                                                Course tempCourse=null;
                                                for(Course c : courses)
                                                    if(idString.equalsIgnoreCase(c.getcourseId()))
                                                        tempCourse=c;
                                                tempCourse.setInstructor(temp);
                                                System.out.println("Here is the current course state:\n"+tempCourse);
                                            }
                                            else
                                                System.out.println("System seems unable to detect any courses.");
                                            break;
                                        case 0:
                                            System.out.println("Returning to Main Menu...");
                                        default:
                                            System.out.println("Enter Valid Value.\n");
                                            break;

                                    }
                                }while(choice!=0);
                            }

                            else
                                System.out.println("System seems unable to detect any students.");

                            break;



                        case 7:
                            System.out.println("\nPlease enter first name of student:");
                            fname = read.nextLine();
                            System.out.println("\nPlease enter the name of the father:");
                            dname = read.nextLine();
                            System.out.println("\nPlease enter last name of student:");
                            lname = read.nextLine();

                            do {
                                System.out.println("\nPlease enter the student's age (>=18):");
                                age = read.nextInt();
                            }	while(age<18);
                            read.nextLine();
                            System.out.println("\nPlease enter the address:");
                            address = read.nextLine();
                            do {
                                System.out.println("The student may choose up to TWO majors, how many does the student wish to choose.");
                                majorNB = read.nextInt();
                            }	while (majorNB>2||majorNB<0);
                            read.nextLine();
                            String[] majors = new String[2];
                            if(majorNB==1) {
                                System.out.print("Enter the name of the major: ");
                                majors[0]=read.nextLine();
                                majors[1]="None";
                                Student newStudent = new Student(fname,dname,lname,age,address,majors,majorNB);
                                students.add(newStudent);
                                System.out.println("Student has been successfully registered! Here is the description of said student:\n"+newStudent);
                            }
                            else {
                                System.out.print("Enter name of major 1: ");
                                majors[0]=read.nextLine();
                                if(majorNB==2) {
                                    do {
                                        System.out.print("Enter name of major 2: ");
                                        majors[1]=read.nextLine();
                                    }	while(majors[0].equalsIgnoreCase(majors[1]));
                                }
                                Student newStudent = new Student(fname,dname,lname,age,address,majors,majorNB);
                                students.add(newStudent);
                                System.out.println("Student has been successfully registered! Here is the description of said student:\n"+newStudent);
                            }
                            break;



                        case 8:
                            //To avoid further repitition and confusion.
                            //Such cases exist only to showcase what this program can actually do and as a
                            //guide for users, whilst allowing them to see what can be done to every individual student, course, and instructor
                            System.out.println("In Order To Enroll a Student To a Course, It Is Preferred To Check The Course You Wish To Enroll Into, Or Simply Check The Student And Enroll From There.\n"
                                    + "Note: PLEASE MAKE SURE THERE EXISTS BOTH A COURSE AND A STUDENT ALREADY.");
                            break;



                        case 9:
                            System.out.println("In Order To Check a Student's Tuition Fees, It Is Preferred To Check The Student And Do It From That Menu.\n"
                                    + "Note: PLEASE MAKE SURE THERE EXISTS BOTH A COURSE AND A STUDENT ALREADY.");
                            break;



                        case 10:
                            System.out.println("In Order To Remove a Student, It Is Preferred To Check The Student You Wish To Remove And Do It From That Menu.\n"
                                    + "Note: PLEASE MAKE SURE THERE EXISTS BOTH A COURSE AND A STUDENT ALREADY.");
                            break;



                        case 11:
                            if(courses.size()!=0) {
                                for(Course c : courses) {
                                    System.out.println(c.getcourseId()+" - "+c.getCourseName());
                                }
                                do {
                                    System.out.println("Select course by ID: ");
                                    courseID = read.nextLine();
                                    for(Course c : courses)
                                        if(courseID==c.getcourseId())
                                            available=true;
                                }	while(available==false);
                                Course temp=null;
                                for(Course c : courses)
                                    if(courseID==c.getcourseId())
                                        temp=c;
                                System.out.println("Course chosen: "+temp);
                                if(temp.getNbStudents()==0) {
                                    System.out.println("Please Enroll Students Into This Course First.");
                                }
                                else
                                    temp.setAttendance();
                            }
                            break;



                        case 12:
                            System.out.println("Enter course name: ");
                            courseName = read.nextLine();
                            System.out.println("Enter the maximal number of students for this course: ");
                            courseSize = read.nextInt();
                            do {
                                System.out.println("Enter the weight in credits of this course(1 or 3): ");
                                creditSize = read.nextInt();
                            }	while (creditSize!=1 && creditSize!=3);
                            if(instructors.size()!=0) {
                                System.out.println("Please choose an instructor for this course out of our list of esteemed instructors by ID: \n");
                                for(Instructor i : instructors) {
                                    System.out.println("\n"+i+"\n");
                                }
                                do {
                                    System.out.println("Select instructor by ID: ");
                                    id = read.nextInt();
                                    read.nextLine();
                                    for(Instructor i : instructors)
                                        if(id==i.getID())
                                            available=true;
                                }	while(available==false);
                                Instructor temp=null;
                                for(Instructor i : instructors)
                                    if(id==i.getID())
                                        temp=i;
                                Course newCourse = new Course(courseName,courseSize,creditSize,temp);
                                System.out.println("Well chosen! here is the course created:"+newCourse);
                                courses.add(newCourse);
                            }
                            else{
                                do {
                                    System.out.println("System seems unable to detect any instructors, do you wish to register a new instructor?\n 1 for yes 0 for no");
                                    choice=read.nextInt();
                                }	while(choice!=0 && choice!=1);
                                read.nextLine();
                                if(choice==1) {
                                    System.out.println("\nPlease enter first name of instructor:");
                                    fname = read.nextLine();
                                    System.out.println("\nPlease enter the name of the father:");
                                    dname = read.nextLine();
                                    System.out.println("\nPlease enter last name of instructor:");
                                    lname = read.nextLine();
                                    do {
                                        System.out.println("\nPlease enter the instructor's age (>=18):");
                                        age = read.nextInt();
                                    }	while(age<18);
                                    read.nextLine();
                                    System.out.println("\nPlease enter the address:");
                                    address = read.nextLine();

                                    Instructor newInstructor = new Instructor(fname,dname,lname,age,address);
                                    instructors.add(newInstructor);
                                    System.out.println("Instructor has been successfully registered! "
                                            + "Here is the description of said instructor:\n"+newInstructor);
                                }
                                else
                                    System.out.println("Please choose a different option.");
                            }
                            break;



                        case 13:
                            System.out.println("In Order To Check The Enrolled Students In a Course, It Is Preferred To Check The Course, And See From There.\n"
                                    + "Note: PLEASE MAKE SURE THERE EXISTS BOTH A COURSE AND A STUDENT ALREADY.");
                            break;



                        case 14:
                            System.out.println("In Order To Remove a Student From a Course, It Is Preferred To Check The Course You Wish To Remove The Student From, Or Simply Check The Student And Withdraw From There.\n"
                                    + "Note: PLEASE MAKE SURE THERE EXISTS BOTH A COURSE AND A STUDENT ALREADY.");
                            break;



                        case 15:
                        case 16:
                            System.out.println("Please Check Student. It Can Be Found From Menu.\n"
                                    + "Note: PLEASE MAKE SURE THERE EXISTS BOTH A COURSE AND A STUDENT ALREADY.");
                            break;



                        case 17:
                            System.out.println("\nPlease enter first name of instructor:");
                            fname = read.nextLine();
                            System.out.println("\nPlease enter the name of the father:");
                            dname = read.nextLine();
                            System.out.println("\nPlease enter last name of instructor:");
                            lname = read.nextLine();
                            do {
                                System.out.println("\nPlease enter the instructor's age:");
                                age = read.nextInt();
                            }	while(age<18);
                            read.nextLine();
                            System.out.println("\nPlease enter the address:");
                            address = read.nextLine();

                            Instructor newInstructor = new Instructor(fname,dname,lname,age,address);
                            instructors.add(newInstructor);
                            System.out.println("Instructor has been successfully registered! "
                                    + "Here is the description of said instructor:\n"+newInstructor);
                            break;



                        case 18:
                            if(instructors.size()!=0) {
                                for(Instructor i : instructors) {
                                    System.out.println(i.getID()+" - "+i.getFName()+" "+i.getDName()+" "+i.getLName());
                                }
                                do {
                                    System.out.println("Select instructor by ID: ");
                                    id = read.nextInt();
                                    read.nextLine();
                                    for(Instructor i : instructors)
                                        if(id==i.getID())
                                            available=true;
                                }	while(available==false);
                                Instructor temp=null;
                                for(Instructor i : instructors)
                                    if(id==i.getID())
                                        temp=i;
                                instructors.remove(temp);

                            }
                            else
                                System.out.println("There Are No Instructors To Remove.");
                            break;



                        case 19:
                            System.out.println("Go To Check Instructor Or Check Course To Perform This Action.\n"
                                    + "Note: PLEASE MAKE SURE THERE EXISTS BOTH A COURSE AND A STUDENT ALREADY.");
                            break;



                        case 20:
                            System.out.println("Go Check Course To Perform This Action.\n"
                                    + "Note: PLEASE MAKE SURE THERE EXISTS BOTH A COURSE AND A STUDENT ALREADY.");
                            break;



                        case 0:
                            System.out.println("Exiting... Thank you for using our software.\n");
                            break;



                        default:
                            System.out.println("Please select an appropriate value.");
                            break;
                    }
                }	while(choice!=0);
            }
            else {
                System.out.println("Enter Your Student ID:\n");
                available=false;
                if(students.size()!=0) {
                    for(Student s : students) {
                        Integer placeHolder=s.getID();
                        if(passKey.equalsIgnoreCase(placeHolder.toString())) {
                            available=true;
                            studentLogIn=s;
                        }
                    }
                    if(available==true) {
                        System.out.println("Welcome Student, here are your options:\n"
                                + "1- Check List of Courses.\n"
                                + "2- Enroll in Course.\n"
                                + "3- Check Payments.\n"
                                + "4- Withdraw From a Course.\n"
                                + "0- Exit Program.");
                        choice=read.nextInt();
                        read.nextLine();
                        switch(choice) {
                            case 1:
                                if(courses.size()!=0) {
                                    for(Course c : courses) {
                                        System.out.println(c.getcourseId()+" - "+c.getCourseName());
                                    }
                                }
                                else
                                    System.out.println("System Cannot Detect Any Courses. Please Contact Administration For A Fix.\n");
                                break;
                            case 2:
                                if(courses.size()!=0) {
                                    for(Course c : courses) {
                                        System.out.println(c.getcourseId()+" - "+c.getCourseName());
                                    }
                                    do {
                                        System.out.println("Select course by ID: ");
                                        courseID = read.nextLine();
                                        for(Course c : courses)
                                            if(courseID==c.getcourseId())
                                                available=true;
                                    }	while(available==false);
                                    Course temp=null;
                                    for(Course c : courses)
                                        if(courseID==c.getcourseId())
                                            temp=c;
                                    System.out.println("Course chosen: "+temp);
                                    studentLogIn.addCourse(temp);
                                }
                                else
                                    System.out.println("System Cannot Detect Any Courses. Please Contact Administration For A Fix.\n");
                                break;
                            case 3:
                                System.out.println(studentLogIn+"\n"+studentLogIn.getFees()+"\n");
                                break;
                            case 4:
                                if(studentLogIn.getCourses().size()!=0) {
                                    System.out.println("Select course by ID: ");
                                    courseID = read.nextLine();
                                    do {
                                        for(Course c : studentLogIn.getCourses())
                                            if(courseID==c.getcourseId())
                                                available=true;
                                    }	while(available==false);
                                    Course temp=null;
                                    for(Course c : studentLogIn.getCourses())
                                        if(courseID==c.getcourseId())
                                            temp=c;
                                    System.out.println("Course chosen: "+temp);
                                    studentLogIn.removeCourse(temp, true);
                                }
                                else
                                    System.out.println("Please Register Into a Course First.");
                                break;
                            case 0:
                                System.out.println("Exiting... Thank You For Using Our Software.\n");
                                break;
                            default:
                                System.out.println("Please Select An Appropriate Value.");
                                break;
                        }
                    }
                    else
                        System.out.println("Invalid ID. Please Contact Admin.");
                }
                else
                    System.out.println("Error Detected. Contact Admin.");
            }
        }	while(!passKey.equalsIgnoreCase("Terminate"));
        System.out.println("Terminating Program... \nDeleting Information... \nThank you for using our software.\n");
        read.close();
    }
}