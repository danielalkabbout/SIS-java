
import java.text.NumberFormat;
import java.util.ArrayList;

public class TuitionFees {
    private double paymentPerMonth;
    private double fullPayment,fee;
    private double discount;
    private double PricePerCredit=1000000;
    public TuitionFees(double gpa,ArrayList<Course> courses){
        for(Course c : courses) {
            this.fee+=PricePerCredit*(c.getCreditSize());
        }
        if(gpa>=3.3&&gpa<3.5)
            this.discount = 0.1;
        else
        if(gpa>=3.5&&gpa<3.7)
            this.discount=0.25;
        else if (gpa>=3.7&&gpa<3.9)
            this.discount=0.5;
        else
        if(gpa>=3.9&&gpa<4)
            this.discount=0.75;
        else
        if(gpa==4)
            this.discount=1;
        else
            this.discount=0;
        if(discount==0)
            this.fullPayment=fee;
        else
            this.fullPayment=fee-fee*discount;
        this.paymentPerMonth=fullPayment/3;
    }

    public double getPaymentPerMonth() {
        return paymentPerMonth;
    }

    public void setPaymentPerMonth(double paymentPerMonth) {

        this.paymentPerMonth = paymentPerMonth;
    }

    public double getFullPayment() {

        return fullPayment;
    }

    public void setFullPayment(double fullPayment) {
        if(discount==0)
            this.fullPayment=fullPayment;
        else
            this.fullPayment=fullPayment*discount-fullPayment;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double gpa) {
        if(gpa>=3.3&&gpa<3.5)
            this.discount = 0.1;
        else
        if(gpa>=3.5&&gpa<3.7)
            this.discount=0.25;
        else if (gpa>=3.7&&gpa<3.9)
            this.discount=0.5;
        else
        if(gpa>=3.9&&gpa<4)
            this.discount=0.75;
        else
        if(gpa==4)
            this.discount=1;
        else this.discount=0;

    }
    public double getPricePerCredit() {
        return this.PricePerCredit;
    }
    public String toString(){
        NumberFormat fmt = NumberFormat.getPercentInstance();
        return "\nTuition Fees:\nPayment per Month:"+paymentPerMonth+"\nFull Payment:"+fullPayment+"\nDiscount:"+fmt.format(discount*100);
    }



}