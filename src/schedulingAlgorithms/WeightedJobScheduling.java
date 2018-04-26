package schedulingAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*Given N jobs where every job is represented by following three elements of it.

Start Time
Finish Time
Profit or Value Associated
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.

Example:

Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50} 
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3 
but the profit with this schedule is 20+50+100 which is less than 250. 
*/
public class WeightedJobScheduling {

	public static void main(String[] args) {
		List<Job> jobs  = new ArrayList<>();
		for(int i=0; i<5;i++) {
			int start = (int) ((Math.random()*100)%20);
			int end = start + (int) ((Math.random()*100)%10);
			int profit =(int) ((Math.random()*100)%50);
			System.out.println(String.valueOf(start)+" - "+String.valueOf(end)+" - "+String.valueOf(profit));
			jobs.add(new Job(start, end, profit));
		}
		
		WeightedJobScheduling sol = new WeightedJobScheduling();
		System.out.println(sol.findMaxProfit(jobs));

	}
	
	public int findMaxProfit(List<Job> jobs) {
		
		int numOfJobs = jobs.size();
		
		//Table holds intermediate results calculated
		int[] table = new int[numOfJobs];
		
		//Sort all jobs in ascending order of finish time.
		//Earliest finish time first. At this point we are not concentrating on profit.
		//We want to set up to schedule maximum number of jobs but identifying overlaps.
		jobs.sort(new Comparator<Job>() {
			
			@Override
			public int compare(Job job1, Job job2) {
				return job1.end - job2.end;
			}
		});
		
		//initialize base case where we are choosing only the 1st job 
		table[0] = jobs.get(0).profit;
		
		for(int i=1;i<numOfJobs;i++) {
			
			Job jobI = jobs.get(i);
			int profitIncludingI = jobI.profit;
			
			//Get the previous job which doesn't overlap with jobI
			int j = getPreviousNonOverLappingJob(jobs, i);
			
			//If such a job exists get the max profit we can have for that job and add it to the profit of current job
			if(j!=-1)
				profitIncludingI += table[j];
			
			int profitExcludingI = table[i-1];
			
			//Pick the maximum profit of either including or excluding job I.
			table[i] = Math.max(profitIncludingI, profitExcludingI);
			
		}
		
		//Max profit is at the point of including or excluding the last finishing job.
		return table[numOfJobs-1];
		
	}
	
	int getPreviousNonOverLappingJob(List<Job> jobs, int i) {
		Job jobI = jobs.get(i);
		for(int j=i-1;j>=0;j--) {
			Job jobJ = jobs.get(j);
			if(jobJ.end < jobI.start)
				return j;
		}
		return -1;
	}
	

}
class Job{
	int start,end,profit;
	public Job(int start,int end,int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}
