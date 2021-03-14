import java.util.Arrays;

public class ArrayImpl {
    
    // Driver Stub
    public static void main(String[] args) {
        
        // Integer Array.
        int [] arr = new int [5];
        arr[0] = 1 ;
        arr[1] = 2 ;
        arr[2] = 3 ;
        arr[3] = 4 ;
        arr[4] = 5 ;

        // Accessing Array Elements using foreach loop.
        for(int i : arr) {
            System.out.print(i+",");
        }
        System.out.println();

        // Accessing Array Elements using normal for loop
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();

        // Accessing Array Elements using streams
        Arrays.stream(arr).forEach(i -> System.out.print(i+","));

        // String Array.
        String [] strArr = new String[5];
        strArr[0] = "India";
        strArr[1] = "Pakistan";
        strArr[2] = "USA";
        strArr[3] = "England";
        strArr[4] = "Japan";
        System.out.println();

        // Accessing via streams
        Arrays.stream(strArr).forEach(str -> System.out.print(str+","));
    }
}