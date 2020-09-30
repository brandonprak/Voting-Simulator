import java.util.*;

public class SimulationDriver {
    private static Random random = new Random();
    private static Student[] students;
    private static Question question;

    public static void main(String[] args) {
        students = createStudents();

        int num = random.nextInt(100); // Uses a random number generator to choose the question type
        if (num % 2 == 0) {
            question = new MultipleChoice();
            multipleChoice();
        } else {
            question = new SingleChoice();
            singleChoice();
        }
        new VotingService(students, question);
    }

    private static void multipleChoice() {
        String answers[] = {"A", "B", "C", "D"}; // Initiates all possible answers for this question type
        question.setQuestion("Multiple Choice");

        int index = random.nextInt(4); // Randomly determines which answer is the correct one
        question.setAnswer(answers[index]);
        for (Student i : students) { // Uses a RNG to determine every student's answer
            index = random.nextInt(4);
            i.setAnswer(answers[index]);
        }
    }


    private static void singleChoice() {
        question.setQuestion("Single Choice");
        question.setAnswer("Right"); // Initiates the only possible correct answer for this question type

        int index = 0;
        for (Student i : students) { // Uses a RNG to determine every student's answer
            index = random.nextInt(3);
            if (index % 2 == 0) {
                i.setAnswer("Right");
            } else {
                i.setAnswer("Wrong");
            }
        }
    }

    private static Student[] createStudents() {
        Student students[] = new Student[60]; // Initializes all 60 students
        for (int i = 0; i < 60; i++) {
            students[i] = new Student();
        }

        List<String> studentID = new ArrayList<>(); // Creates a list to store all student IDs
        for (Student i : students) { // Assigns a unique ID to every student and checks for duplicates
            i.setID(Integer.toString(random.nextInt(99999 - 10000) + 10000));
            while (studentID.contains(i.getID())){
                i.setID(Integer.toString(random.nextInt(99999 - 10000) + 10000));
            }
            studentID.add(i.getID());
        }
        return students;
    }
}
