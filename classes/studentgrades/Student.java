import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private String ssn;
    private int year;
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String firstName, String lastName, String ssn, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public int getYear() {
        return year;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public int overallGrade() {
        double avg = 0;
        for (int grade : grades) {
            avg += grade;
        }
        avg /= grades.size();
        return (int) (avg + 0.5);
    }

    public String letterGrade() {
        int avg = overallGrade();
        avg /= 10;
        String[] letters = { "F", "F", "F", "F", "F", "F", "D", "C", "B", "A", "A" };
        return letters[avg];
    }

    public int classCount() {
        return grades.size();
    }

    public boolean isFailing() {
        return letterGrade().equals("F");
    }

    public int compareTo(Student other) {
        return other.overallGrade() - this.overallGrade();
    }
}
