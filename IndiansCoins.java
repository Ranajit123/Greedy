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
