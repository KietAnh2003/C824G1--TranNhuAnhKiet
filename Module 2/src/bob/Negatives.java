package bob;

import java.util.Arrays;

public class Negatives {
    public static void main(String[] args) {
        int[] array = new int []{-1,-2,-3,1,2,3,-4,-5,-6};
        noNeg(array);

        System.out.println(Arrays.toString(array));
    }
    public static int[] noNeg(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0 ){
                arr[i]=0;
            }
        }
        return arr;
    }
}


