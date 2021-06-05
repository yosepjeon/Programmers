package 라인.p2;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static int currentTime = 0;

    public int[] solution(int endingTime, int[][] jobs) {
        int[] answer = {};

        // job[0]: 고유번호
        // job[1]: 입력시간
        // job[2]: 유효시간
        // job[3]: 작업시간
        int totalJobs = jobs.length;
        RealtimeJob[] realtimeJobs = new RealtimeJob[totalJobs];
        for(int i=0;i<totalJobs;i++) {
            realtimeJobs[i] = new RealtimeJob(jobs[i][0],jobs[i][1],jobs[i][2],jobs[i][3]);
        }

        return answer;
    }

    class RealtimeJob {
        int id;
        int inputTime;
        int validTime;
        int workTime;

        public RealtimeJob(int id, int inputTime, int validTime, int workTime) {
            this.id = id;
            this.inputTime = inputTime;
            this.validTime = validTime;
            this.workTime = workTime;
        }

        public void work() {

        }
    }

    class RealtimeQueue {
        Queue<RealtimeJob> queue = new LinkedList<>();

        public void push(RealtimeJob job) {
            if(job.validTime < currentTime) {
                return;
            }
            queue.add(job);
        }

        public RealtimeJob poll() {
            while(!queue.isEmpty()) {
                RealtimeJob job = queue.poll();

                if(job.validTime < currentTime)
                    continue;
                job.work();
                if(job.validTime >= currentTime)
                    return job;
            }

            return null;
        }
    }
}
