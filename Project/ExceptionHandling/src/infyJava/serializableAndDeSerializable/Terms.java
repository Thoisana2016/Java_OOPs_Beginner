package infyJava.serializableAndDeSerializable;

import java.io.Serializable;
import java.util.List;

public class Terms implements Serializable {

    private String termName;
    private String studentName;
    private List<Mark> markList;
    public Terms(String termName, String studentName, List<Mark> markList){
        this.markList = markList;
        this.termName = termName;
        this.studentName = studentName;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }
}
