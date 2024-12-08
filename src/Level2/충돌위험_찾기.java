package Level2;

import java.awt.*;
import java.util.*;

class 충돌위험_찾기 {
    class Robot {
        Point pos;
        Queue<Point> destinations;

        public Robot(Point pos, Queue<Point> destinations) {
            this.pos = pos;
            this.destinations = destinations;
        }

        public void moveNextPoint() {
            if (destinations.isEmpty()) {
                pos = null;
                return;
            }

            Point destination = destinations.peek();
            int xDiff = pos.x - destination.x;
            int yDiff = pos.y - destination.y;
            pos = new Point(xDiff == 0 ? pos.x : xDiff > 0 ? pos.x - 1 : pos.x + 1,
                    xDiff != 0 ? pos.y : yDiff > 0 ? pos.y - 1 : pos.y + 1);

            if (pos.x == destination.x && pos.y == destination.y)
                destinations.remove();
        }

        public boolean isDeleted() {
            return pos == null;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        Point[] pointArr = new Point[points.length + 1];
        for (int i = 1; i <= points.length; i++)
            pointArr[i] = new Point(points[i - 1][0], points[i - 1][1]);

        Queue<Robot> q = new LinkedList<>();
        for (int i = 0; i < routes.length; i++) {
            Queue<Point> destinations = new LinkedList<>();
            for (int j = 0; j < routes[i].length; j++)
                destinations.add(pointArr[routes[i][j]]);
            q.add(new Robot(destinations.peek(), destinations));
            destinations.remove();
        }

        int ans = duplicateCheck(q);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Robot cur = q.remove();
                cur.moveNextPoint();
                if (!cur.isDeleted())
                    q.add(cur);
            }

            ans += duplicateCheck(q);
        }

        return ans;
    }

    public int duplicateCheck(Queue<Robot> q) {
        HashMap<Point, Integer> map = new HashMap<>();
        for (Robot r : q) {
            map.put(r.pos, map.getOrDefault(r.pos, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Point, Integer> e : map.entrySet()) {
            if (e.getValue() > 1)
                ans++;
        }

        return ans;
    }
}