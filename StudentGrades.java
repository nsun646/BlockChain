import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class StudentGrades {
    private int index;
    private long timestamp;
    private String previousHash;
    private String hash;
    private String data;
    private int studentID;
    private String studentName;
    private String studentCourse;
    private String studentGrade;

    public StudentGrades(int index, String previousHash, String data,int studentID, String studentName, String studentCourse, String studentGrade) {
        this.index = index;
        this.timestamp = new Date().getTime();
        this.previousHash = previousHash;
        this.data = data;
        this.hash = calculateHash(3);
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentCourse = studentCourse;
        this.studentGrade = studentGrade;

    }
    public String calculateHash(int difficulty) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String input = index + timestamp + previousHash + data;
            int nonce = 0;
            String target = "0".repeat(difficulty);

            while (true) {
                String dataToHash = input + nonce;
                byte[] hashBytes = digest.digest(dataToHash.getBytes("UTF-8"));
                String hash = bytesToHex(hashBytes);

                if (hash.substring(0, difficulty).equals(target)) {
                    return hash;
                }

                nonce++;
            }
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public String getData() {
        return data;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }
    public String getStudentCourse() {
        return studentCourse;
    }
    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }
    public String getStudentGrade() {
        return studentGrade;
    }
}
