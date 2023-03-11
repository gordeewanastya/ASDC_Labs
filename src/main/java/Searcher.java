
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Searcher {

    // Time complexity: O(N)
    // Space complexity: O(1)
    public static int linearSearch(List<Student> studentList, Long studentIDNP){
        Iterator<Student> it = studentList.iterator();
        while(it.hasNext()){
            Student current = it.next();
            if(current.getIdentificationNumber() ==  studentIDNP){
                return studentList.indexOf(current);
            }
        }

        return -1;
    }

    // Time complexity: O(log(N))
    // Space complexity: O(1)
    public static int binarySearch(List<Student> studentList, Long studentIDNP){
        //binary search works on sorted collections
        Collections.sort(studentList);

        int firstIndex = 0;
        int lastIndex = studentList.size() - 1;

        while(firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;
            Student studentInTheMiddle = studentList.get(middleIndex);

            if(studentInTheMiddle.getIdentificationNumber() == studentIDNP){
                return middleIndex;
            }else if(studentInTheMiddle.getIdentificationNumber() > studentIDNP){
                lastIndex = middleIndex - 1;
            }else{
                firstIndex = middleIndex + 1;
            }
        }

        return -1;
    }

    // Time complexity: O(log2(log2 N))
    // Space complexity: O(1)

    public static int interpolationSearch(List<Student> studentList, Long studentIDNP){
        int low = 0;
        int high = studentList.size() - 1;

        while (low <= high && studentIDNP >= studentList.get(low).getIdentificationNumber()
                && studentIDNP <= studentList.get(high).getIdentificationNumber()) {
            if (low == high) {
                if (studentList.get(low).getIdentificationNumber() == studentIDNP) {
                    return low;
                } else {
                    return -1;
                }
            }

            int pos = low + ((int) (((double) (high - low) / (studentList.get(high).getIdentificationNumber()
                    - studentList.get(low).getIdentificationNumber()))
                    * (studentIDNP - studentList.get(low).getIdentificationNumber())));

            if (studentList.get(pos).getIdentificationNumber() == studentIDNP) {
                return pos;
            } else if (studentList.get(pos).getIdentificationNumber() < studentIDNP) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1;
    }

    // Time complexity: O(log(N))
    // Space complexity: O(4) ???
    public static int fibonacciSearch(List<Student> studentList, Long studentIDNP){
        /*Size of collection*/
        int listSize = studentList.size();

        /* Initialize fibonacci numbers */
        int fibMMm2 = 0; // (m-2)'th Fibonacci No.
        int fibMMm1 = 1; // (m-1)'th Fibonacci No.
        int fibM = fibMMm2 + fibMMm1; // m'th Fibonacci

        /* fibM is going to store the smallest
        Fibonacci Number greater than or equal to n */
        while (fibM < listSize) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        // Marks the eliminated range from front
        int offset = -1;

        /* while there are elements to be inspected.
        Note that we compare arr[fibMm2] with x.
        When fibM becomes 1, fibMm2 becomes 0 */
        while (fibM > 1) {
            // Check if fibMm2 is a valid location
            int i = Math.min(offset + fibMMm2, listSize - 1);

            /* If x is greater than the value at
            index fibMm2, cut the subarray array
            from offset to i */
            if (studentList.get(i).getIdentificationNumber() < studentIDNP) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }

            /* If x is less than the value at index
            fibMm2, cut the subarray after i+1 */
            else if (studentList.get(i).getIdentificationNumber() < studentIDNP) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }

            /* element found. return index */
            else
                return i;
        }

        /* comparing the last element with x */
        if (fibMMm1 == 1 && studentList.get(listSize - 1).getIdentificationNumber() == studentIDNP)
            return listSize-1;

        /*element not found. return -1 */
        return -1;
    }

    public static void resultOfSearchByIDNP(int result,List<Student> studentList){
        if (result == -1){
            System.out.println("Such student doesn't exist");
        }else{
            System.out.println("Found  required student =\n" + studentList.get(result).toString() +  "\nat index: " + result);
        }
    }

}
