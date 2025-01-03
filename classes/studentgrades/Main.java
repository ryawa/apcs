import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Student> students = new ArrayList<>();

        Scanner s = new Scanner(new File("students.txt"));
        s.useDelimiter(",|\n");
        while (s.hasNext()) {
            String lastName = s.next();
            String firstName = s.next();
            String ssn = s.next();
            int year = s.nextInt();
            String course = s.next();
            int grade = s.nextInt();

            Student student = findStudent(students, lastName);
            if (student == null) {
                student = new Student(firstName, lastName, ssn, year);
                students.add(student);
            }
            student.addGrade(grade);
        }

        s.close();

        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + ": " + student.letterGrade()
                    + " (" + student.overallGrade() + ")");
        }

        // Row is each year, last row is overall
        // Columns are # of students, avg grade of all students, # of students failing
        int stats[][] = new int[4][3];
        for (int year = 9; year <= 12; year++) {
            int i = year - 9;
            for (Student student : students) {
                if (student.getYear() == year) {
                    stats[i][0]++;
                    stats[i][1] += student.overallGrade();
                    if (student.isFailing()) {
                        stats[i][2]++;
                    }
                }
            }
            System.out.println(
                    "Year " + year + ": " + stats[i][0] + " students, average grade is "
                            + (double) stats[i][1] / stats[i][0] + ", "
                            + stats[i][2] + " failing");
        }
        double overallAvg = (double) (stats[0][1] + stats[1][1] + stats[2][1] + stats[3][1]) / students.size();
        int overallFailing = stats[0][2] + stats[1][2] + stats[2][2] + stats[3][2];
        System.out.println("Overall: " + students.size() + " students, average grade is " + overallAvg + ", "
                + overallFailing + " failing");
    }

    public static Student findStudent(ArrayList<Student> students, String key) {
        for (Student s : students) {
            if (s.getLastName().equals(key) || s.getSsn().equals(key)) {
                return s;
            }
        }
        return null;
    }

    public static void printStudentInfo(ArrayList<Student> students, String key) {
        Student s = findStudent(students, key);
        if (s == null) {
            return;
        }
        System.out.println("Grade: " + s.overallGrade());
        System.out.println("# of classes: " + s.classCount());
        System.out.println("Letter grade: " + s.letterGrade());
    }
}
