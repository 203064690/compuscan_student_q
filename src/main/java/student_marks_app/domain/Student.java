package student_marks_app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String stud_no;
    private String stud_firstName;
    private String stud_lastName;
    private double stud_mark;

    public Student(){}

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getStud_no() {
        return stud_no;
    }

    public void setStud_no(String stud_no) {
        this.stud_no = stud_no;
    }

    public String getStud_firstName() {
        return stud_firstName;
    }

    public void setStud_firstName(String stud_firstName) {
        this.stud_firstName = stud_firstName;
    }

    public String getStud_lastName() {
        return stud_lastName;
    }

    public void setStud_lastName(String stud_lastName) {
        this.stud_lastName = stud_lastName;
    }

    public double getStud_mark() {
        return stud_mark;
    }

    public void setStud_mark(double stud_mark) {
        this.stud_mark = stud_mark;
    }

    public Student(Builder builder){

    }

    public static class Builder{

        private Long ID;
        private String stud_no;
        private String stud_firstName;
        private String stud_lastName;
        private double stud_mark;

        public Builder( String value )
        {
            this.stud_no = value;
        }

        public Builder ID( Long value )
        {
            this.ID = value;
            return this;
        }

        public Builder stud_firstName( String value )
        {
            this.stud_firstName = value;
            return this;
        }

        public Builder stud_lastName( String value )
        {
            this.stud_lastName = value;
            return this;
        }

        public Builder stud_mark( double value )
        {
            this.stud_mark = value;
            return this;
        }

        public Student build()
        {
            return new Student( this );
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", stud_no='" + stud_no + '\'' +
                ", stud_firstName='" + stud_firstName + '\'' +
                ", stud_lastName='" + stud_lastName + '\'' +
                ", stud_mark=" + stud_mark +
                '}';
    }


}
