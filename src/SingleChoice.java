public class SingleChoice implements Question { // Sets the question type and answer for single choice questions
    String question;
    String answer;

    public String question() {
        return question;
    }
    public String answer() {
        return answer;
    }

    public void setQuestion(String q) {
        this.question = q;
    }

    public void setAnswer(String a) {
        this.answer = a;
    }

    public boolean isMultipleChoice() {
        return false;
    }
}
