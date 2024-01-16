// using 2d array sorting 
/*
  given a array of jobs where evey job has a deadline and profit, if the job is finished before the deadline. It also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the profit if only one job can be scheduled at a time.

  smaple input ->
  job 0 = 4, 20
  job 1 = 1, 10
  job 2 = 1, 40
  job 3 = 1, 30

  sample output ->
  ans = 2, 0

  Pseudo Code ->

  step1 -> create a 2d array of size given job length * 3
  step2 -> store job id in 0th colum, job deadline in 1st colum and profit in 2nd colum
  step3 -> sort the 2d array on profit basis
  step4 -> create a empy arraylist for store doable jobs id
  step5 -> take a time variable for tracking the job deadline initialize with 0.
  step6 -> traverse through 2d array and check the deadline of job if it not corss then it doable, add the job id to the arraylist and inscrease the time
  step7 -> return doable job ids arraylist

 */
import java.util.*;
public class JobSequencing1 {

  public static void maxProfit(int jobs[][]){
    int jobsInfo[][] = new int[jobs.length][3];
    for(int i=0; i<jobsInfo.length; i++){
      jobsInfo[i][0] = i;
      jobsInfo[i][1] = jobs[i][0];
      jobsInfo[i][2] = jobs[i][1];
    }
    
    Arrays.sort(jobsInfo, Comparator.comparingDouble(o -> o[2]));

    ArrayList<Integer> seq = new ArrayList<>();
    int time = 0;
    int totalProfit = 0;
    for(int i=jobs.length-1; i>=0; i--){
      if(jobsInfo[i][1]> time ){
        time++;
        totalProfit += jobsInfo[i][2];
        seq.add(jobsInfo[i][0]);
      }
    }
    System.out.println(seq.size());
    System.out.println(totalProfit);
    for(int i=0; i<seq.size(); i++){
      System.out.print(seq.get(i)+" ");
    }

  }
  public static void main(String[] args) {
    int jobs[][] ={{4, 20}, {1, 10}, {1, 40}, {1, 30}}; 
    maxProfit(jobs);
  }
}

