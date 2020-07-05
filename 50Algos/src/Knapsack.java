import java.util.List;

public class Knapsack {

    static int val[] = new int[] { 60, 100, 120 };
    static int wt[] = new int[] { 10, 20, 30 };

    static int K[][] = null;

    public static void main(String[] args) {
        /*
            Given a list of items with values and weights, as well as a max weight, find the
            maximum value you can generate from items where the sum of the weights is less than
            the max.
         */



        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));

        K = new int[wt.length+1][W+1];
        System.out.println(KS(2, 50));
    }

    private static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] knapsack = new int[n+1][W+1];

        for (int i=0; i <= n; i++){
            for(int j=0; j<= W; j++){
                if(i==0 || j==0){
                    knapsack[i][j] = 0;
                }

                //wt[i-1] <= j
                else if(wt[i-1] <= j){
                    knapsack[i][j] = Math.max(
                            val[i - 1] + knapsack[i - 1][j - wt[i - 1]],
                            knapsack[i - 1][j]);
                }else{
                    knapsack[i][j] = knapsack[i - 1][j];
                }
            }
        }

        return knapsack[n][W];
    }

    //recursion
    public static int KS(int n, int C){
    int result;
    if(K[n][C] != 0){
        return K[n][C];
    }
        if(n==0 || C == 0){
            result = 0;
        }
        else if(wt[n] > C){
            result = KS(n-1, C);
        }
        else{
            int temp = KS(n-1, C);
            int temp1 = val[n] + KS(n-1, C - wt[n]);

            result = Math.max(temp, temp1);
        }

        K[n][C] = result;
        return result;
    }


}
