public class VotingService {
    private Student[] students;
    private Question q;
    private int A = 0, B = 0, C = 0, D = 0;
    private int right = 0, wrong = 0;

    public VotingService(Student[] students, Question q) {
        this.students = students;
        this.q = q;

        if (q.isMultipleChoice()) {
            checkMultiple();
        } else {
            checkSingle();
        }
    }

    public void checkMultiple(){

        for (Student i : students) { // check student's answer
            if (i.getAnswer().compareTo("A") == 0)
                A++;
            else if (i.getAnswer().compareTo("B") == 0)
                B++;
            else if (i.getAnswer().compareTo("C") == 0)
                C++;
            else
                D++;
        }

        printInitial();
    }

    public void checkSingle(){

        for (Student i : students) { // check student's answer
            if (i.getAnswer().compareTo("Right") == 0)
                right++;
            else
                wrong++;
        }

        printInitial();
    }

    public void printInitial() { // print initial information about question
        System.out.println("Number of people who participated : " + students.length);
        System.out.println("Given Question                    : " + q.question());
        System.out.println("Correct Answer                    : " + q.answer() + "\n");
        printResults();
    }

    public void printResults (){ // print information about student results
        System.out.println("---Students' Results Below---");

        if (q.isMultipleChoice()){
            System.out.println("A: " + A);
            System.out.println("B: " + B);
            System.out.println("C: " + C);
            System.out.println("D: " + D);
        }
        else {
            System.out.println("Right: " + right);
            System.out.println("Wrong: " + wrong);
        }
    }
}
