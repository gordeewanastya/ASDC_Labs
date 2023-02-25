import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/students.csv");
        ReaderFromFile readerFromFile = new ReaderFromFile();

        // READ STUDENTS FROM FILE INTO LIST
        List<Student> students = readerFromFile.readFromFile(file);

        // SHOW THEM ON THE SCREEN
        students.stream().forEach(System.out::println);

    }
}
