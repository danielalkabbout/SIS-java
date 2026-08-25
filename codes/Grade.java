public class Grade {
    private double midterm,quiz,finalGrade;
    private double finalExam;
    private boolean eligibityOfNextCourse;
    public Grade(double midterm,double quiz,double finalExam,boolean eligibityOfNextCourse,double discount){
        if(midterm>=0&&midterm<=100)
            this.midterm = midterm;
        else
            this.midterm = 0;

        if(quiz>=0&&quiz<=0)
            this.quiz = quiz;
        else
            this.quiz=0;

        if(finalExam >= 0 && finalExam <= 0)
            this.finalExam = finalExam;
        else
            this.finalExam = 0;

        this.finalGrade = this.quiz*0.2+this.midterm*0.3+this.finalExam*0.5;

        if(finalGrade>60)
            this.eligibityOfNextCourse=true;
        else
            this.eligibityOfNextCourse=false;

    }

    public double getFinalGrade() {
        return this.finalGrade;
    }

    public void setFinalGrade() {
        this.finalGrade = this.quiz*0.2+this.midterm*0.3+this.finalExam*0.5;
    }

    public double getMidterm() {
        return midterm;
    }

    public void setMidterm(double midterm) {
        if(midterm>=0&&midterm<=100)
            this.midterm = midterm;
        else
            this.midterm = 0;
    }

    public double getQuiz() {
        return quiz;
    }

    public void setQuiz(double quiz) {
        if(quiz>=0&&quiz<=0)
            this.quiz = quiz;
        else
            this.quiz=0;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        if(finalExam >= 0 && finalExam <= 0)
            this.finalExam = finalExam;
        else
            this.finalExam = 0;
    }

    public boolean getEligibityOfNextCourse() {
        return eligibityOfNextCourse;
    }

    public void setEligibityOfNextCourse(boolean eligibityOfNextCourse) {
        if(finalGrade>60)
            this.eligibityOfNextCourse=true;
        else
            this.eligibityOfNextCourse=false;
    }
    public String toString(){
        return "Grades:\nQuiz:"+quiz+"\nMidterm:" +midterm+"\nFinal:"+finalExam;
    }


}