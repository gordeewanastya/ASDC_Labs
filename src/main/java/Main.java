import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/studentsUnique.csv");
        ReaderCSV readerCSV = new ReaderCSV();

        // READ STUDENTS FROM FILE INTO LIST
        List<Student> students = readerCSV.readFromFile(file);

//        // SHOW THEM ON THE SCREEN
//        students.stream().forEach(System.out::println);


        Long wrongIDNPtoSearch = 2020890123456L;
        Long studentIDNPtoSearch = 1034000000034L;

        System.out.println("___Linear Search:___");
        Searcher.resultOfSearchByIDNP(Searcher.linearSearch(students,studentIDNPtoSearch), students);
        System.out.println("___Binary Search:___");
        Searcher.resultOfSearchByIDNP(Searcher.binarySearch(students,studentIDNPtoSearch),students);
        System.out.println("___Fibonacci Search:___");
        Searcher.resultOfSearchByIDNP(Searcher.fibonacciSearch(students, studentIDNPtoSearch), students);

    }
}
