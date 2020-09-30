public interface Question {
    public String question();
    public String answer();
    public void setQuestion(String q);
    public void setAnswer(String a);
    public boolean isMultipleChoice();
}
