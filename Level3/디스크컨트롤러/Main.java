package Level3.디스크컨트롤러;

import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] jobs = {
				{0,4},
				{2,100},
				{11,1}
		};
		
//		int[][] jobs = {
//				{0,3},
//				{1,9},
//				{2,6}
//		};
		
		System.out.println(solution.solution(jobs));
	}
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        int jobsCount = jobs.length;
        
        PriorityQueue<Job> responseTimePriorityQueue = new PriorityQueue<>((j1,j2) -> {
        	if(j1.responseTime - j2.responseTime < 0) {
				return j1.responseTime - j2.responseTime;
			}else if(j1.responseTime -j2.responseTime > 0) {
				return j1.responseTime - j2.responseTime;
			}else {
				return j1.requestTime - j2.requestTime;
			}
        });
        
        PriorityQueue<Job> requestTimePriorityQueue = new PriorityQueue<>((j1,j2)-> {
        	if(j1.requestTime - j2.requestTime < 0) {
				return j1.requestTime - j2.requestTime;
			}else if(j1.requestTime -j2.requestTime > 0) {
				return j1.requestTime - j2.requestTime;
			}else {
				return j1.responseTime - j2.responseTime;
			}
        });
        
        
        for(int i=0;i<jobsCount;i++) {
        	Job job = new Job(jobs[i][0], jobs[i][1]);
        	responseTimePriorityQueue.add(job);
        	requestTimePriorityQueue.add(job);
        }
        
//        System.out.println(requestTimePriorityQueue.peek().requestTime);
        
        int pqSize = responseTimePriorityQueue.size();
        int total = 0;
        int startTime = 0;
        int endTime = 0;
        int count = 0;
        while(true) {
        	boolean isStop = false;
        	
        	if(requestTimePriorityQueue.isEmpty() || responseTimePriorityQueue.isEmpty())
        		break;
        	Job job;
        	if(count == 0) {
        		job = requestTimePriorityQueue.peek();
        	}else {
        		job = responseTimePriorityQueue.peek();
        	}
        	count++;
        	
        	System.out.println("*********************");
        	
//        	int waitTime = Math.abs(startTime - job.requestTime);
        	int waitTime = startTime - job.requestTime;
        	if(waitTime < 0) {
        		isStop = true;
        		System.out.println("@ " + waitTime + " " + job.requestTime);
        		job = requestTimePriorityQueue.peek();
        		waitTime = Math.abs(job.requestTime - endTime);
        		if(startTime < job.requestTime) {
        			startTime = job.requestTime;
        		}else {
        			startTime = endTime;
        		}
        	}
        	
        	System.out.println("requestTime: " + job.requestTime + " time: "+ job.time);
        	
        	endTime = startTime + job.time;
        	total += endTime - startTime + waitTime;
        	System.out.println("startTime: " + startTime + " endTime: " + endTime + " total: " + total + " wait: " + waitTime);
        	startTime = endTime;
        	
        	if(isStop) {
        		responseTimePriorityQueue.remove(job);
        		requestTimePriorityQueue.poll();
        		
        	}else {
        		requestTimePriorityQueue.remove(job);
        		responseTimePriorityQueue.poll();
        	}
//        	startTime = startTime + job.responseTime;
        }
        
        answer = total/pqSize;
        
        return answer;
    }
    
    class Job {
    	int requestTime;
    	int time;
    	int responseTime;
    	
    	public Job(int requestTime, int time) {
    		this.requestTime = requestTime;
    		this.time = time;
    		this.responseTime = requestTime + time;
    	}
    }
}
