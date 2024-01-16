/*
  we are given a bar of chocolate composed of m*n squares. one should break the chocolate into single square. Each break of the chocolate is charged a cost expresed by a positive integer. This charge is does not depend on the size of the part that is being broken but only depends the line the break goes along. Let us denote the cost of breaking along consecuitive vertical lines with X1, X2,....,Xm-1 and along horizontal line Y1, Y2,.., Yn-1. Compute the minimul cost of breaking the whole chocolate into single parts.
  
  sample input ->
  vertical cuts = [2, 1, 3, 1, 4]
  horizontal cuts = [4, 1, 2]
  
  sample output ->
  cost = 42

  Pseudo Code ->
  step1 -> sort both the cuts into descending order
  step2 -> take two pointers, one is pointing vertical cuts 0th index and other is pointing horizontal cuts 0th index
  step3 -> take two variables for tracking total number of horizontal and vertical pices, initialize with both 1
  step4 -> take a variable for calculation total cost 
  step5 -> traverse through the array and check the max cost of cut, the maximum cost will be cut 1st, add the value of cost to the cost variable
  step6 -> check for left vertical custs cost price and add to the total cost
  step7 -> Check for the left horizontal cuts cost price and add to the total cost
  step8 -> return the cost

 */
import java.util.*;
public class ChocolaProblem {
  public static int minCost(Integer verCost[], Integer horiCost[]){
    Arrays.sort(verCost, Collections.reverseOrder());
    Arrays.sort(horiCost, Collections.reverseOrder());
    int v=0, h=0;
    int vp = 1, hp = 1;
    int cost = 0;
    while (v<verCost.length && h<horiCost.length) {
      if(verCost[v] <= horiCost[h]){ //hoizontal cut
        cost += vp*horiCost[h];
        hp++;
        h++;
      }else{ //vertical cut 
        cost += hp*verCost[v];
        vp++;
        v++;
      }
    }
    while (v<verCost.length) {
      cost += hp*verCost[v];
      vp++;
      v++;
    }

    while (h<horiCost.length) {
      cost += vp*horiCost[h];
      hp++;
      h++;
    }

    return cost;
  }
  public static void main(String[] args) {
    Integer verticalCost [] = {2, 1, 3, 1, 4};
    Integer horizontalCost[] = {4, 1, 2};
    System.out.println(minCost(verticalCost, horizontalCost));
  }
}
