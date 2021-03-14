import java.util.Arrays;

public class ArrayListImpl {
    
    // Driver Class
    public static void main(String[] args) {
        ArrayListClass arrayList = new ArrayListClass(null, -1);
        int [] arr = null;
        arrayList = arrayList.insertAtLast(1, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(2, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(3, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(4, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(5, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(1, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(2, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(3, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(4, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(5, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(1, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(2, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(3, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(4, arrayList.lastIndex);
        arrayList = arrayList.insertAtLast(5, arrayList.lastIndex);
        arrayList = arrayList.insertInBetween(10, 5, arrayList.lastIndex);
        arrayList = arrayList.removeAtIndex(arrayList.arr , 3, arrayList.lastIndex);
        arrayList.printArray();
    }
}

class ArrayListClass {
    int arr[];
    int lastIndex;

    public ArrayListClass(int [] arr , int lastIndex){
        this.arr = arr;
        this.lastIndex = lastIndex;
    }

    public ArrayListClass removeAtIndex(int [] arr, int index, int lastIndex){
        if(index < lastIndex){
            for(int i = index+1 ; i <= lastIndex; i++){
                arr[i-1] = arr[i]; 
            }
            arr[lastIndex] = 0;
        }
        return new ArrayListClass(arr,lastIndex-1);
    }

    public ArrayListClass insertInBetween(int value, int index, int lastIndex) {
        if(lastIndex == -1) {
            arr = new int[index+1];
            return new ArrayListClass(arr, index+1);
        }else if(lastIndex < arr.length-1) {
            if(index < arr.length) {
                int temp = arr[index];
                arr[index] = value;
                for(int i = index+1; i <= lastIndex+1 ; i++) {
                    value = arr[i];
                    arr[i] = temp;
                    temp = value;
                }
            }
        }else if(lastIndex < arr.length-1 && lastIndex == arr.length-1){
            int temp = arr[index];
            int finalEle = arr[arr.length-1];
            arr[index] = value;
            for(int i = index+1; i < arr.length-1 ; i++) {
                arr[i] = temp;
                temp = arr[i+1];
            }
            arr[arr.length-1] = temp;
            int copyArr [] = new int[arr.length*2];
            for(int i = 0 ; i < arr.length ; i++){
                copyArr[i] = arr[i];
            }
            copyArr[arr.length] = finalEle;
            return new ArrayListClass(copyArr, lastIndex+1);
        }
        return new ArrayListClass(arr, lastIndex+1);
    }

    // Insert at last
    public ArrayListClass insertAtLast(int value, int lastIndex) {        
        if (lastIndex == -1) {
            arr = new int[10];
            arr[0] = value;
            return new ArrayListClass(arr, lastIndex+1);
        }else if(lastIndex == arr.length-1) {
            int copyarr [] = new int[arr.length*2];
            for(int i = 0 ; i < arr.length ; i++) {
                copyarr[i] = arr[i];
            }
            copyarr[arr.length] = value;
            return new ArrayListClass(copyarr,lastIndex+1);
        }else {
            arr[lastIndex+1] = value;
            return new ArrayListClass(arr,lastIndex+1);
        }
    }

    // Printing elements in an Array.
    public void printArray() {
        Arrays.stream(this.arr).forEach(i -> System.out.print(i+","));
    }
}
