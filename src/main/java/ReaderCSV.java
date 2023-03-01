import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderCSV {
    public static final String SEPARATOR = ",";

    public Student read(String str){
        try {
            String[] tokens = str.split(SEPARATOR);
            return Student.create(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3])
                    ,Integer.parseInt(tokens[4]),Long.parseLong(tokens[5]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  List<Student> readFromFile(File file){
        List<Student> listOfStudents = new ArrayList<>();
        String data;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((data = reader.readLine()) != null){
                Student stud = read(data);
                listOfStudents.add(stud);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfStudents;
    }
}
