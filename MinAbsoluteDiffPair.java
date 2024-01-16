/*
  Given two Arrays A and B of equal length n. pair element of array A with element of array B, such that sum S of absolute difference of all pairs is minimum

  sample input ->
  A = [1, 2, 3]
  B = [2, 1, 3]

  sample outPut ->
  S = 0

  Pseudo Code->

  step1 -> sort both arrays in ascending order
  step2 -> take a variable for calculate the sum
  step3 -> calculate the absolute difference between ith element of array A and array B, then add the difference to the sum
  step4 -> return the sum
 */

import java.util.Arrays;

public class MinAbsoluteDiffPair {
  public static int minPairSum(int A[], int B[]){
    Arrays.sort(A);
    Arrays.sort(B);
    int S = 0;
    for(int i=0; i<A.length; i++){
      S += Math.abs(A[i] - B[i]);
    }
    return S;
  }
  public static void main(String[] args) {
    int A[] = {4, 1, 8, 7};
    int B[] = {2, 3, 6, 5};
    System.out.println(minPairSum(A, B));
  }
}