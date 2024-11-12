package bob;

import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int[] array = new int []{-1,-2,-3,1,2,3,-4,-5,-6};
        System.out.println(Arrays.toString(swap(array)));
    }
    public static int[] swap(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[arr.length -1];
        arr[arr.length -1] = temp;
        return arr;
    }
}
