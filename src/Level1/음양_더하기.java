package Level1;

class 음양_더하기 {
    public int solution(int[] 값, boolean[] 양수) {
        int 답 = 0;
        for (int i = 0; i < 값.length; i++)
            답 += 양수[i] ? 값[i] : -값[i];
        return 답;
    }
}