package Level2;

import java.util.*;

class 큰_수_만들기 {
    class Number implements Comparable<Number> {
        int number;
        int idx;

        Number(char n, int i) {
            number = Integer.parseInt(String.valueOf(n));
            idx = i;
        }

        @Override
        public int compareTo(Number n) {
            int comp1 = Integer.compare(number, n.number);
            int comp2 = Integer.compare(n.idx, idx);
            return comp1 != 0 ? comp1 : comp2;
        }
    }

    public String solution(String number, int k) {
        var sb = new StringBuilder();
        int limit = number.length() - k;
        int max = 0;
        int maxIdx = 0;
        var set = new TreeSet<Number>();
        var numbers = new LinkedList<Number>();
        for (int i = 0; i < number.length() - limit; i++) {
            Number n = new Number(number.charAt(i), i);
            numbers.add(n);
            set.add(n);
        }

        int end = number.length() - limit;
        for (int i = 0; i < limit; i++) {
            Number n = new Number(number.charAt(end), end++);
            numbers.add(n);
            set.add(n);
            end = end == number.length() ? end - 1 : end;

            max = set.last().number;
            maxIdx = set.last().idx;

            sb.append(max);
            int temp = numbers.getFirst().idx;
            for (; temp <= maxIdx; temp++) {
                Number removed = numbers.removeFirst();
                set.remove(removed);
            }
        }

        return sb.toString();
    }
}