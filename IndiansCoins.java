/*
  we are given an infinite supply of denominations [1, 2, 5, 10, 20, 50 , 100, 500, 1000] find min no. of coins/note to change the value v

  sample input ->
  v=590

  sample output ->
  ans = 4

  Pseudo Code ->

  step1 -> sort the array in descending order
  step2 -> take a variable for counting the total number of coins
  step3 -> traverse through the array and check the array element is less than the value or not, if less then increase the coin counter and decrease the value 
  step 4 -> return the coin counter
 */
import java.util.*;
public class IndiansCoins {
  public static int mimCoinReq(Integer arr[], int price){
    Arrays.sort(arr, Comparator.reverseOrder());
    int totalCoin=0;
    for(int i=0; i<arr.length;i++){
      if(arr[i]<=price){
        while (arr[i]<=price) {
          price -= arr[i];
          totalCoin++;
        }
      }
    }
    return totalCoin;
  }
  public static void main(String[] args) {
    Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int price = 1999;
    System.out.println(mimCoinReq(coins, price));
  }
}
