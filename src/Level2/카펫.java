package Level2;

class 카펫 {
    public int[] solution(int brown, int yellow) {
        int a;
        int b;

        for (b = 3; true; b++) {
            boolean isFind = false;

            for (a = 1; a <= b; a++) {
                if (isBrown(brown, a, b) && isYellow(yellow, a, b)) {
                    isFind = true;
                    break;
                }
            }

            if (isFind) break;
        }

        return new int[]{b, a};
    }

    public boolean isBrown(int brown, int a, int b) {
        return brown == 2 * a + 2 * b - 4;
    }

    public boolean isYellow(int yellow, int a, int b) {
        return yellow == (a - 2) * (b - 2);
    }
}