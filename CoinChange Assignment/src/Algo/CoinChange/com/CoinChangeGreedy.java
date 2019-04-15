package Algo.CoinChange.com;
//Greedy Approach
import java.util.ArrayList;

public class CoinChangeGreedy {

    public static void findMin(int amount)
    {
        int coins[] = { 1, 5, 10, 25 };
        //int[] coinList = {};
        int[] arr = new int[100];
        int i, k = 0;
        for (i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                int max_coins = coins[i];
                //System.out.println(" coins"+ coins[i]);
                arr[k++] = max_coins;
            }
        }
        System.out.println("Denominations of coins :"  );

        for (i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Minimum_Number of Coins using GreedyAlgorithm :"+ k);
        return;
    }

    public static void main (String[] args)
    {
        int n = 200;
        findMin(n);
    }
}