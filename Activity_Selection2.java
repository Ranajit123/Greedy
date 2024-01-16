// Without sorted According to end time
/*
  Q. you have given n activities with their start and end times. select the maximum number of activities that you can be performed, assuming that a you can only work on a single activity at a time.

  smaple input ->
  start = [1, 3, 0, 5, 8, 5]
  end = [2, 4, 6, 7, 9, 9]

  smaple output ->
  maxActivities = 4

  Pseudo Code->

  Step1-> Creat a 2d Array, store the start time in 1st colum and end time in 2nd colum
  Step2-> Sort the 2nd colum of the 2d array.
  Strp3-> Creat a maxActivities variable and initialize it with 1(cause select the 1st activite).
  Step3-> check the overlapping condition, start time >= end time of last activite
  Step4-> incress the maxActivities for non-loverlapping activie
  Step5-> return maxActivities.
 */

import java.util.*;

public class Activity_Selection2 {
  public static int findMaxActivity(int[] startTime, int[] endTime){
    int activities[][] = new int[startTime.length][2];
    for(int i=0; i<startTime.length; i++){
      activities[i][0]=startTime[i];
      activities[i][1]=endTime[i];
    }
    // Comparator.comparingDouble(o -> o[2]) --> this is a lamda function, use for sorting specific colum of a 2d array, 
    Arrays.sort(activities, Comparator.comparingDouble(o -> o[1]));
    int maxActivities = 1;
    int lastTime = activities[0][1];
    for(int i=0; i<endTime.length; i++){
      if(activities[i][0]>lastTime){
        maxActivities++;
        lastTime = activities[i][1];
      }
    }
    return maxActivities;
  }
  public static void main(String[] args) {
    int startTime[] = {1, 3, 0, 5, 8, 5};
    int endTime[] = {2, 4, 6, 7, 9, 9};
    System.out.println("maxActivities = "+findMaxActivity(startTime, endTime));
  }
}