package Level0;

import java.math.*;

class 분수의_덧셈 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        int gcd = BigInteger.valueOf(denom).gcd(BigInteger.valueOf(numer)).intValue();

        int[] answer = {numer / gcd, denom / gcd};
        return answer;
    }
}