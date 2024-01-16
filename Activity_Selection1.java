// sorted According to end time
/*
  Q. you have given n activities with their start and end times. select the maximum number of activities that you can be performed, assuming that a you can only work on a single activity at a time. *Activities are sorted according to end time.*

  smaple input ->
  start = [1, 3, 0, 5, 8, 5]
  end = [2, 4, 6, 7, 9, 9]

  smaple output ->
  maxActivities = 4

  Pseudo Code->

  Step1-> Creat a maxActivities variable and initialize it with 1(cause select the 1st activite).
  Step2-> check the overlapping condition, start time >= end time of last activite
  Step3-> incress the maxActivities for non-loverlapping activie
  Step4-> return maxActivities.
 */

public class Activity_Selection1 {
  public static int findMaxActivity(int[] startTime, int[] endTime){
    int maxActivities=1;
    int lastTime = endTime[0];
    for(int i=0; i<endTime.length; i++){
      if(startTime[i] >= lastTime){
        maxActivities++;
        lastTime = endTime[i];
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