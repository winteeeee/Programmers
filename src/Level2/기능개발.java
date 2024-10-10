package Level2;

import java.util.ArrayList;
import java.util.LinkedList;

class 기능개발 {
    class Task {
        int progress;
        int speed;

        public Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        var answer = new ArrayList<Integer>();
        var q = new LinkedList<Task>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(new Task(progresses[i], speeds[i]));
        }

        while (!q.isEmpty()) {
            int progressDate = (int) Math.ceil((double) (100 - q.peek().progress) / q.peek().speed);
            for (int i = 0; i < q.size(); i++) {
                Task t = q.remove();
                q.add(new Task(t.progress + progressDate * t.speed, t.speed));
            }

            int cnt = 0;
            while (!q.isEmpty() && q.peek().progress >= 100) {
                cnt++;
                q.remove();
            }

            answer.add(cnt);
        }

        return answer;
    }
}