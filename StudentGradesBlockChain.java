import java.util.ArrayList;
import java.util.List;
public class StudentGradesBlockChain {
    private List<StudentGrades> chain;
    public StudentGradesBlockChain() {
        chain = new ArrayList<StudentGrades>();
        chain.add(new StudentGrades(0, "0", "Grade 1",3442, "Greg", "Algebra", "B"));
    }
    public void addBlock(String data) {
        StudentGrades previousBlock = chain.get(chain.size() - 1);
        StudentGrades newBlock = new StudentGrades(previousBlock.getIndex() + 1, previousBlock.getHash(), data,711, "Steve", "Biology", "F");
        chain.add(newBlock);
    }
    public void addBlock2(String data) {
        StudentGrades previousBlock = chain.get(chain.size() - 1);
        StudentGrades newBlock1 = new StudentGrades(previousBlock.getIndex() + 1, previousBlock.getHash(), data,4277, "Maria", "Gym", "C");
        chain.add(newBlock1);
    }
    public void printBlockChain() {
        for (StudentGrades studentGrades : chain) {
            System.out.println("Block #" + studentGrades.getIndex());
            System.out.println("Timestamp: " + studentGrades.getTimestamp());
            System.out.println("Previous Hash: " + studentGrades.getPreviousHash());
            System.out.println("Hash: " + studentGrades.getHash());
            System.out.println("Data: " + studentGrades.getData());
            System.out.println("Student ID: " + studentGrades.getStudentID());
            System.out.println("Student Name: " + studentGrades.getStudentName());
            System.out.println("Student Course: " + studentGrades.getStudentCourse());
            System.out.println("Student Grade: " + studentGrades.getStudentGrade());
            System.out.println();
        }
    }
}
