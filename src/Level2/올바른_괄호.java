package Level2;

import java.util.*;

class 올바른_괄호 {
    boolean solution(String s) {
        var stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            if (curChar == '(') {
                stack.push(curChar);
            } else if (curChar == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}