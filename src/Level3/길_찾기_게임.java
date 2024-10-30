package Level3;

import java.util.*;

class 길_찾기_게임 {
    ArrayList<Integer> 전위순회결과 = new ArrayList<Integer>();
    ArrayList<Integer> 후위순회결과 = new ArrayList<Integer>();

    class 노드 implements Comparable<노드> {
        int number;
        int x;
        int y;
        노드 왼쪽;
        노드 오른쪽;

        노드(int number, int[] arr) {
            this.number = number;
            this.x = arr[0];
            this.y = arr[1];
        }

        void 삽입(노드 노드) {
            if (x < 노드.x) {
                if (오른쪽 == null)
                    오른쪽 = 노드;
                else
                    오른쪽.삽입(노드);

            } else {
                if (왼쪽 == null)
                    왼쪽 = 노드;
                else
                    왼쪽.삽입(노드);

            }
        }

        void 전위순회() {
            전위순회결과.add(number);
            if (왼쪽 != null) 왼쪽.전위순회();
            if (오른쪽 != null) 오른쪽.전위순회();
        }

        void 후위순회() {
            if (왼쪽 != null) 왼쪽.후위순회();
            if (오른쪽 != null) 오른쪽.후위순회();
            후위순회결과.add(number);
        }

        @Override
        public int compareTo(노드 노드) {
            int comp1 = Integer.compare(노드.y, y);
            int comp2 = Integer.compare(x, 노드.x);
            return comp1 != 0 ? comp1 : comp2;
        }
    }

    public ArrayList<ArrayList<Integer>> solution(int[][] nodeinfo) {
        var 힙 = new PriorityQueue<노드>();
        for (int i = 0; i < nodeinfo.length; i++)
            힙.add(new 노드(i + 1, nodeinfo[i]));

        노드 트리 = 힙.remove();
        while (!힙.isEmpty())
            트리.삽입(힙.remove());

        var 답 = new ArrayList<ArrayList<Integer>>();
        트리.전위순회(); 답.add(전위순회결과);
        트리.후위순회(); 답.add(후위순회결과);

        return 답;
    }
}