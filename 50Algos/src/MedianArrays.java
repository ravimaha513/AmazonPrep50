import java.util.Arrays;

public class MedianArrays {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        int[] arr1 = new int[]{2,4,7};
        System.out.println(medianofTwoArrays(arr, arr1));
    }

    public static double medianofTwoArrays(int[] arr, int[] arr1){

        int[] result = new int[arr.length + arr1.length];

        for(int i=0; i < arr.length; i++){
            result[i] = arr[i];
        }

        for(int j=0; j < arr1.length; j++){
            result[arr.length + j] = arr1[j];
        }

        Arrays.sort(result);

        System.out.println(Arrays.toString(result));

        double median = 0;
        if(result.length%2==0){

             median = result[result.length/2] + result[result.length/2 - 1];
            median = median/2;

        }else{
            median = result[result.length/2];
        }
        return median;
    }
}
