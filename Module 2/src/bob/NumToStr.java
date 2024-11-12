package bob;

import java.util.Arrays;

public class NumToStr {
    public static void main(String[] args) {
        int[] array = new int []{-1,-2,-3,1,2,3,-4,-5,-6};
        System.out.println(Arrays.toString(numToStr(array)));
    }
    public static String[] numToStr(int[] arr) {
        String[] result = new String[arr.length];

        for ( int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                result[i] = "Dojo";
            }else {
                result[i] =  String.valueOf(arr[i]);
            }
        }
        return result;
    }
}
