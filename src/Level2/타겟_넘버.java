package Level2;

class 타겟_넘버 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        backTracking(numbers, target, 0, 0);
        return answer;
    }

    public void backTracking(int[] numbers, int target, int value, int count) {
        if (count == numbers.length) {
            if (value == target)
                answer++;
            return;
        }

        backTracking(numbers, target, value + numbers[count], count + 1);
        backTracking(numbers, target, value - numbers[count], count + 1);
    }
}