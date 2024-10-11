package Level2;

import java.util.Arrays;

class 가장_큰_수 {
    public String solution(int[] numbers) {
        String[] numbersStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            numbersStr[i] = String.valueOf(numbers[i]);

        Arrays.sort(numbersStr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        var sb = new StringBuilder();
        for (String num : numbersStr) {
            sb.append(num);
        }

        String result = sb.toString();
        return result.charAt(0) == '0' ? "0" : result;
    }
}