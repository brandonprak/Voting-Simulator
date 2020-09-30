public class Student {
    private String studentID;
    private String answer;

    public Student() {
        this.studentID = "";
        this.answer = "";
    }

    public void setID(String studentID) {
        this.studentID = studentID;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getID() {
        return studentID;
    }

    public String getAnswer() {
        return answer;
    }
}
