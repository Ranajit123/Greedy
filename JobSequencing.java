// using class object sorting 
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

  step1 -> create a class
  step2 -> store the id, job deadline and profit as a class object
  step3 -> sort in descending order on profit basis
  step4 -> create a empy arraylist for store doable jobs id
  step5 -> take a time variable for tracking the job deadline initialize with 0.
  step6 -> traverse through 2d array and check the deadline of job if it not corss then it doable, add the job id to the arraylist and inscrease the time
  step7 -> return doable job ids arraylist

 */
import java.util.*;
public class JobSequencing {
   static class job{
    int id;
    int deadline;
    int profit;

    public job(int i, int d, int p){
      id = i;
      deadline = d;
      profit = p;
    }
  }
  public static void maxProfit(int jobsInfo[][]){
    ArrayList<job> jobs = new ArrayList<>();
    for(int i=0; i<jobsInfo.length; i++){
      jobs.add(new job(i, jobsInfo[i][0], jobsInfo[i][1]));
    }

    Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); //descending order sorting of object using user define comparator
    ArrayList<Integer> seq = new ArrayList<>();
    int time = 0;
    int totalProfit = 0;
    for(int i=0; i<jobs.size(); i++){
      job curr = jobs.get(i);
      if(curr.deadline>time){
        time++;
        totalProfit += curr.profit;
        seq.add(curr.id);
      }
    }
    System.out.println(seq.size());
    System.out.println(totalProfit);
    for(int i=0; i<seq.size(); i++){
      System.out.print(seq.get(i)+" ");
    }
  }
  public static void main(String[] args) {
    int jobsInfo[][]={{4, 20}, {1, 10}, {1, 40}, {1, 30}};
    maxProfit(jobsInfo);
  }
}
