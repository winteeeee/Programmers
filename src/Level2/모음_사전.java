package Level2;

class 모음_사전 {
    int 카운트 = 0;
    int 답 = 0;
    char[] 알파벳모음 = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        백트래킹("", word, 0);
        return 답;
    }

    public void 백트래킹(String 단어, String 목표, int 길이) {
        if (단어.equals(목표)) {
            답 = 카운트;
            return;
        }
        if (길이 > 5) return;

        if (답 == 0) {
            카운트++;
            for (int i = 0; i < 알파벳모음.length; i++) {
                백트래킹(단어 + 알파벳모음[i], 목표, 길이 + 1);
            }
        }
    }
}