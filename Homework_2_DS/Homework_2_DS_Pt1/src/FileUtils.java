import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static Student[] readFile(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        // Read all lines from the file
        List<String> lines = Files.readAllLines(Path.of(filePath));
        // Process each line to create Student objects
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 7){  // Assuming format: ID,Name,DOB,University,DeptCode,DeptName,Year
                int ID = Integer.parseInt(parts[0]);
                String name = parts[1];
                String d_birth = parts[2];
                String university = parts[3];
                String dep_code = parts[4];
                String dep_name = parts[5];
                int enrolment = Integer.parseInt(parts[6]);

                Student student = new Student(ID, name, d_birth, university, dep_code, dep_name, enrolment);
                students.add(student);
            }
        }
        // Convert the List<Student> to Student[]
        return students.toArray(new Student[0]);
    }

    public static void writeToFile(Student[] students, String filePath) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            // Write the header
            writer.write("ID, Name, Date of Birth, University, Dept Code, Dept Name, Year of Enrollment");
            writer.newLine();
            // Write each student's data
            for (Student student : students) {
                writer.write(student.getGlobalId() + ",");
                writer.write(student.getName() + ",");
                writer.write(student.getDateOfBirth() + ",");
                writer.write(student.getUniversityName() + ",");
                writer.write(student.getDepartmentCode() + ",");
                writer.write(student.getDepartmentName() + ",");
                writer.write(student.getYearOfEnrollment() + "");
                writer.newLine();
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}