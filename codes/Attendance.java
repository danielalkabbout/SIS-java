
public class Attendance {
    private String studentInCourse;
    private boolean absence;
    private int absenceCounter=0;

    public Attendance(String studentInCourse){
        this.studentInCourse=studentInCourse;
        this.absence=false;
        this.absenceCounter=0;
    }

    public String getStudentInCourse() {
        return studentInCourse;
    }

    public void setStudentInCourse(String studentInCourse) {
        this.studentInCourse = studentInCourse;
    }

    public boolean isAbsence() {
        return absence;
    }

    public void setAbsence(boolean absence) {
        this.absence = absence;
    }

    public int getAbsenceCounter() {
        return absenceCounter;
    }

    public void setAbsenceCounter(int absenceCounter) {
        if(absence==true)
            this.absenceCounter=absenceCounter++;
        else
            this.absenceCounter=absenceCounter;
    }
    public String toString(){
        return "Absence:\nStudent in Course:"+studentInCourse+"\nAbsence Counter:"+absenceCounter+"\n";
    }
}