/*
  You have n pairs of number. In every pair, the 1st number is smaller than the 2nd number.
  A pair (c,d) can come after pair (a,b) if b<c. Find the longest pair wich can be formed with the given set of pairs.

  Sample Input ->
  pairs = 
  (5, 24)
  (39, 60)
  (5, 28)
  (27, 40)
  (50, 90)

  Sample Output ->
  ans = 3

  Pseudo Code

  step1 -> Sort the 2nd colum of the array.
  step2 -> Take chainLen variable initialize with 1(cause 1st pair is has the min value so selected)
  step3 -> Take a chainEnd variable initialize with 1st chain end
  step4 -> Check the pair starting point if it is gretter than the previous pair ending point then increase chainLen value
  step5 -> return the chainLen
 */

import java.util.*;

public class MaxLengthChainPair {
  public static int maxChainLen(int arr[][]){
    Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));
    int chainLen = 1;
    int chainEnd = arr[0][1];
    for(int i=0; i<arr.length; i++){
      if(arr[i][0] > chainEnd){
        chainLen++;
        chainEnd = arr[i][1];
      }
    }
    return chainLen;
  }
  public static void main(String[] args) {
    int pair[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
    System.out.println(maxChainLen(pair));
  }
}