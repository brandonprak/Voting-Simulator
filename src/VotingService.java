public class VotingService {
    private Student[] students;
    private Question question;
    private int A = 0, B = 0, C = 0, D = 0;
    private int right = 0;
    private int wrong = 0;

    public VotingService(Student[] students, Question question) {
        this.students = students;
        this.question = question;

        if (question.isMultipleChoice()) { // Determines if the question is single or multiple choice
            checkMultipleChoice();
        } else {
            checkSingleChoice();
        }
    }

    public void checkMultipleChoice() { // Compares a student's answer to the correct multiple choice answer
        for (Student i : students) {
            if (i.getAnswer().compareTo("A") == 0) {
                A++;
            } else if (i.getAnswer().compareTo("B") == 0) {
                B++;
            } else if (i.getAnswer().compareTo("C") == 0) {
                C++;
            } else {
                D++;
            }
        }
        print();
    }

    public void checkSingleChoice() {
        for (Student i : students) { // Compares a student's answer to the correct single choice answer
            if (i.getAnswer().compareTo("Right") == 0) {
                right++;
            } else {
                wrong++;
            }
        }
        print();
    }

    public void print() { // Prints out the question type and results of the 60-student poll
        System.out.println("Number of Students: 60\n");

        System.out.println(question.question() + " Results: ");
        if (question.isMultipleChoice()) {
            System.out.println("A: " + A);
            System.out.println("B: " + B);
            System.out.println("C: " + C);
            System.out.println("D: " + D);
        } else {
            System.out.println("Right: " + right);
            System.out.println("Wrong: " + wrong);
        }
    }
}
