package Students;

import java.math.BigDecimal;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private double grade;

    public Student(String fn, String ln, double grade) {
        this.setFn(fn);
        this.setLn(ln);
        this.setGrade(grade);
    }

    public void setFn(String fn) {
        this.firstName = fn;
    }

    public void setLn(String ln) {
        this.lastName = ln;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(this.firstName).append(" ").append(this.lastName).append(", ").append(this.grade).append(" ]");
        return sb.toString();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public double getGrade() {
        return this.grade;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Student)) {
            return false;
        } else {
            Student s = (Student)o;
            return s.getFirstName().equals(this.getFirstName()) && s.getLastName().equals(this.getLastName());
        }
    }

    public int hashCode() {
        Object[] var10000 = new Object[1];
        String var10003 = this.getFirstName();
        //var10000[0] = var10003 + this.getLastName();
        return Objects.hash(var10000);
    }
    
}
