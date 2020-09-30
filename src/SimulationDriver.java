import java.util.*;

public class SimulationDriver {
    private static Random r = new Random();
    private static Student[] students;
    private static Question q;

    public static void main(String[] args) {
        students = createStudents();

        int num = r.nextInt((100 - 1) + 1) + 1;

        if (num % 2 == 0) {
            q = new MultipleChoice();
            multiple();
        } else {
            q = new TrueFalse();
            single();
        }

        VotingService v = new VotingService(students, q);
    }

    private static void multiple() { // answers for multiple choice question
        String answers[] = {"A", "B", "C", "D"};
        q.setQuestion("Choose the correct multiple choice answer");
        int index = r.nextInt(4);
        q.setAnswer(answers[index]); // set correct answer to the question

        for (Student i : students) { // assign an answer to each student
            index = r.nextInt(4);
            i.setAnswer(answers[index]);
        }
    }


    private static void single() { // answers for single choice question
        q.setQuestion("Write the correct answer");
        q.setAnswer("Right"); // set correct answer to the question

        int index = 0;
        for (Student i : students) { // assign an answer to each student
            index = r.nextInt(3);
            if (index % 2 == 0)
                i.setAnswer("Right");
            else
                i.setAnswer("Wrong");
        }
    }

    private static Student[] createStudents(){
        int numOfStudents = r.nextInt(100-30) + 30; // generate number of students between 30 - 100

        Student students[] = new Student[numOfStudents];
        for (int i = 0; i < numOfStudents; i++) { // initiate all student objects
            students[i] = new Student();
        }

        List<String> idNumbers= new ArrayList<>(); // holds all unique student IDs

        for (Student i : students) { // traverse array and assign each student a unique ID
            i.setID(Integer.toString(r.nextInt(9999-1000) + 1000));
            while (idNumbers.contains(i.getID())){ // make sure that no duplicate IDs
                i.setID(Integer.toString(r.nextInt(9999-1000) + 1000));
            }
            idNumbers.add(i.getID());
        }

        return students;
    }
}
