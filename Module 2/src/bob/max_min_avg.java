package bob;

import java.util.Arrays;

public class max_min_avg {
    public static void main(String[] args) {
        double[] array = new double[]{-1, -2, -3, 1, 2, 3, -4, -5, -6};


        System.out.println(Arrays.toString(maxMinAvg(array)));
    }
    public static Double[] maxMinAvg(double[] arr) {

        Double[] arrnew = new Double[3];
        Double max = arr[0];
        Double min = arr[0];
        Double sum = 0d;
        Double avg = 0d;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
            sum = sum + arr[i];
        }
        avg = sum / arr.length;

        arrnew[0] = max;
        arrnew[1] = min;
        arrnew[2] = avg;
        return arrnew;
    }
}
