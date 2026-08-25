
public abstract class Person {
    private String fName, dName, lName, address;
    protected String email;
    private int age;
    protected int id;
    protected final int YEAR = 20230000;
    protected static int idC = 1001;

    public Person(String fName, String dName, String lName, int age, String address) {

        this.fName = fName;
        this.dName = dName;
        this.lName = lName;
        if (this.age > 18)
            this.age = age;
        else
            this.age = 18;
        this.id=YEAR+idC;
        this.address = address;
        this.email = id + "@ua.edu.lb";
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public abstract void setEmail();


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age < 18)
            this.age = 18;
        else
            this.age = age;

    }

    public int getID() {
        return id;
    }

    public abstract void setID(int id);
}