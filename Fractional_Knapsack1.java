/*
  Given the weights and values of N items, put these items in a knapsack of capacity W to get the max total value in the knapsack.

  sample input ->
  value = [60, 100, 120]
  weight = [10, 20, 30]
  W = = 50

  sample output ->
  ans = 240

  Pseudo Code ->
  Step1 -> find the profit ratio.
  step2 -> sort the profit ratio in descending order.
  step3 -> sort the profit ratio in descending order.(here profit ration is already sorted)
  step4 -> take a variable for calculationg capacity(initialize with given weight).
  step5 -> take a variable to calculate total value
  step6 -> traverse through the profit ratio array 
  step7 -> compare capacity with the weight, if capacity is more than the weight then add the value to the totalValue and reduced the capacity from the weight, else add profit ratio multipli with capacity to the totalValue.
  step8 -> return totalValue.
 */
import java.util.*;
public class Fractional_Knapsack1 {
  public static int maxTotalValue(int value[], int weight[], int W){
    double profitRatio[][] = new double[value.length][2];
    for(int i=0; i<value.length; i++){
      profitRatio[i][0] = i;
      profitRatio[i][1] = value[i]/(double)weight[i];
    }
    Arrays.sort(profitRatio, Comparator.comparing(o -> o[1]));
    int capacity = W;
    int totalValue = 0;
    for(int i=profitRatio.length-1; i>=0; i--){
      int idx = (int)profitRatio[i][0];
      if(capacity>= weight[idx]){
        totalValue += value[idx];
        capacity -= weight[idx];
      }else{
        totalValue += profitRatio[i][1]*capacity;
        capacity = 0;
        break;
      }
    }
    return totalValue;
  }
  public static void main(String[] args) {
    int value[] = {60, 100, 120};
    int weight[] = {10, 20, 30};
    int W = 50;
    System.out.println(maxTotalValue(value, weight, W));
  }
}