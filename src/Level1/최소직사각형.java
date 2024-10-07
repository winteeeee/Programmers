package Level1;

class 최소직사각형 {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            maxW = w > h ? Math.max(w, maxW) : Math.max(h, maxW);
            maxH = w > h ? Math.max(h, maxH) : Math.max(w, maxH);
        }

        return maxW * maxH;
    }
}