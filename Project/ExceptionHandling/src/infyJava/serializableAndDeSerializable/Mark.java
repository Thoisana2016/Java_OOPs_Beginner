package infyJava.serializableAndDeSerializable;

import java.io.Serializable;
import java.util.Map;

public class Mark implements Serializable {
    private String subject;
    private double marks;

    public Mark(String subject, double marks){
        this.subject = subject;
        this.marks = marks;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
