package Algo.CoinChange.com;
// Dynamic Approach
import java.util.Arrays;

class CoinChangeDynamic
{
    static int minCoins(int coins[], int m, int amount)
    {
        int arr[] = new int[amount + 1];
        arr[0] = 0;
        for (int i = 1; i <= amount; i++)
            arr[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= amount; i++)
        {
            for (int j = 0; j < m; j++)
                if (coins[j] <= i)
                {
                    int a = arr[i - coins[j]];
                    if (a != Integer.MAX_VALUE
                            && a + 1 < arr[i])
                         arr[i] = a + 1;
                }
        }
        return arr[amount];
    }

    public static void main (String[] args)
    {
        int denominations[] = {1, 5, 10, 25};
        int size = denominations.length;
        int amount = 100;
        System.out.println( "Minimum Coins Required is : "
                + minCoins(denominations, size, amount));
    }
}