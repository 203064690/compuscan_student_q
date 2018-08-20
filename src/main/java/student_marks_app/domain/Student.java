package student_marks_app.domain;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
@Audited
public class Student implements Serializable {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String stud_no;
    private String stud_first_name;
    private String stud_last_name;
    private double stud_mark;

    public Student(){}

    public Long getID() {
        return ID;
    }

    public String getStud_no() {
        return stud_no;
    }
    public String getStud_first_name() {
        return stud_first_name;
    }
    public String getStud_last_name() {
        return stud_last_name;
    }
    public double getStud_mark() {
        return stud_mark;
    }


    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setStud_no(String stud_no) {
        this.stud_no = stud_no;
    }
    public void setStud_first_name(String stud_first_name) {
        this.stud_first_name = stud_first_name;
    }
    public void setStud_last_name(String stud_last_name) {
        this.stud_last_name = stud_last_name;
    }
    public void setStud_mark(double stud_mark) {
        this.stud_mark = stud_mark;
    }

    public Student(Builder builder){
        ID = builder.ID;
        stud_no = builder.stud_no;
        stud_first_name = builder.stud_first_name;
        stud_last_name = builder.stud_last_name;
        stud_mark = builder.stud_mark;

    }

    public static class Builder{

        private Long ID;
        private String stud_no;
        private String stud_first_name;
        private String stud_last_name;
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

        public Builder stud_first_name( String value )
        {
            this.stud_first_name = value;
            return this;
        }

        public Builder stud_last_name( String value )
        {
            this.stud_last_name = value;
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
                ", stud_first_name='" + stud_first_name + '\'' +
                ", stud_last_name='" + stud_last_name + '\'' +
                ", stud_mark=" + stud_mark +
                '}';
    }


}
