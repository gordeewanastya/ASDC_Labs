import java.util.Objects;

public class Student implements Cloneable,Comparable<Student>{
    private String firstName;
    private String lastName;
    private String faculty;
    private int yearOfBirth;
    private int yearOfAdmission;
    private long identificationNumber;

    // DEFAULT CONSTRUCTOR
    public Student(){
        this.firstName = "";
        this.lastName = "";
        this.faculty = "";
    }

    // CONSTRUCTOR WITH PARAMETERS
    public Student(String firstName, String lastName,
                   String faculty, int yearOfBirth,
                   int yearOfAdmission, long identificationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.yearOfBirth = yearOfBirth;
        this.yearOfAdmission = yearOfAdmission;
        this.identificationNumber = identificationNumber;
    }

    // COPY CONSTRUCTOR
    public Student(Student s){
        this.firstName = s.firstName;
        this.lastName = s.lastName;
        this.faculty = s.faculty;
        this.yearOfBirth = s.yearOfBirth;
        this.yearOfAdmission = s.yearOfAdmission;
    }

    // USING OBJECT CLASS CLONE METHOD TO BE ABLE TO CLONE OUR STUDENTS
    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }

    //OR COULD CLONE IT IN THIS WAY
    /*
    * public Student copy(){
    *   return new Student(this);
    * }
    */

    // OVERRIDING EQUALS METHOD, TWO STUDENTS ARE CONSIDERED EQUAL ONLY IF THEIR IDNP IS THE SAME
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return  identificationNumber == student.identificationNumber;
    }

    // IF WE OVERRIDE THE EQUALS METHOD, SHOULD OVERRIDE AND THIS
    @Override
    public int hashCode() {
        return Objects.hash(identificationNumber);
    }

    // METHOD TO READ/WRITE
    public static Student create(String firstName, String lastName,
                          String faculty, int yearOfBirth,
                          int yearOfAdmission, long identificationNumber){
        return new Student(firstName,lastName,faculty,yearOfBirth,yearOfAdmission,identificationNumber);
    }



    // GETTERS AND SETTERS

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", yearOfAdmission=" + yearOfAdmission +
                ", identificationNumber=" + identificationNumber +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        return Long.compare(this.getIdentificationNumber(),other.getIdentificationNumber());
    }
}
