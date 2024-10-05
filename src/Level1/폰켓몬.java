package Level1;

import java.util.HashMap;

class 폰켓몬 {
    public int solution(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return Math.min(map.size(), nums.length / 2);
    }
}