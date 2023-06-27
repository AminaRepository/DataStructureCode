public class Student implements Comparable <Student> {
    private int ID;
    private String name;
    private String d_birth;
    private String university;
    private String dep_code;
    private String dep_name;
    private int enrolment;

    public Student(int ID, String name, String d_birth, String university, String dep_code, String dep_name, int enrolment) {
        this.ID = ID;
        this.name = name;
        this.d_birth = d_birth;
        this.university = university;
        this.dep_code = dep_code;
        this.dep_name = dep_name;
        this.enrolment = enrolment;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.ID, o.ID);
    }

    public int getGlobalId() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getDateOfBirth() {
        return this.d_birth;
    }

    public String getUniversityName() {
        return this.university;
    }

    public String getDepartmentCode() {
        return this.dep_code;
    }

    public String getDepartmentName() {
        return this.dep_name;
    }

    public int getYearOfEnrollment() {
        return this.enrolment;
    }
}
