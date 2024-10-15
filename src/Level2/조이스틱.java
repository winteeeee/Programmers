package Level2;

import java.util.*;

class 조이스틱 {
    public int solution(String name) {
        int count = name.length();
        int cursorCount = getCursorCount(name);

        int alphabetCount = 0;
        for (int i = 0; i < name.length(); i++)
            alphabetCount += getAlphabetCount(name.charAt(i));

        return cursorCount + alphabetCount;
    }

    public int getCursorCount(String name) {
        int length = name.length();
        int moveCount = length - 1;

        for (int i = 0; i < length; i++) {
            int aEndIdx = i + 1;
            for (; aEndIdx < length && name.charAt(aEndIdx) == 'A'; aEndIdx++);
            //i = 현재 위치, aEndIdx = i 이후 연속된 A가 끝나는 위치
            //방문할 위치는 i(현재 위치가 i이므로) + length - aEndIdx(연속된 A 이후 남은 문자열)만큼 방문할 것이므로 먼저 값을 계산
            //그럼 경우의 수는 두 가지. i만큼 오른쪽으로 간 후, 다시 i만큼 왼쪽으로 가서 나머지 문자열을 보는 경우와 처음부터 왼쪽으로 이동하여 오른쪽 끝으로 이동하여 length - aEndIdx만큼을 본 후 다시 length - aEndIdx만큼 이동하여 처음 위치 돌아온 뒤, i만큼 이동하는 경우.
            //전자의 경우 i가 두 번 더해지고 후자의 경우 length - aEndIdx가 두 번 더해지므로 두 가지 경우 중 작은 경우를 선택
            moveCount = Math.min(moveCount, i + length - aEndIdx + Math.min(i, length - aEndIdx));
        }

        return moveCount;
    }

    public int getAlphabetCount(char c) {
        return Math.min(c - 'A', 'Z' - c + 1);
    }
}