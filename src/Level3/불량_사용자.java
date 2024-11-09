package Level3;

import java.util.*;

class 불량_사용자 {
    HashSet<TreeSet<String>> 방문함 = new HashSet<>();
    ArrayList<ArrayList<String>> 제재아이디들 = new ArrayList<>();

    public int solution(String[] 응모자들, String[] 불량사용자들) {
        for (String 불량사용자 : 불량사용자들) {
            var 제재아이디 = new ArrayList<String>();
            for (String 응모자 : 응모자들)
                if (응모자.matches(정규식(불량사용자)))
                    제재아이디.add(응모자);
            제재아이디들.add(제재아이디);
        }

        경우의수구하기(new TreeSet<String>());
        return 방문함.size();
    }

    public void 경우의수구하기(TreeSet<String> 뽑힘) {
        if (뽑힘.size() == 제재아이디들.size()) {
            if (!방문함.contains(뽑힘)) {
                방문함.add(new TreeSet<String>(뽑힘));
            }
            return;
        }

        var 제재아이디 = 제재아이디들.get(뽑힘.size());
        for (int i = 0; i < 제재아이디.size(); i++) {
            String 뽑을아이디 = 제재아이디.get(i);
            if (!뽑힘.contains(뽑을아이디)) {
                뽑힘.add(뽑을아이디);
                경우의수구하기(뽑힘);
                뽑힘.remove(뽑을아이디);
            }
        }
    }

    public String 정규식(String 불량사용자) {
        var sb = new StringBuilder();
        for (int i = 0; i < 불량사용자.length(); i++) {
            char 현재문자 = 불량사용자.charAt(i);
            if (현재문자 == '*')
                sb.append("[0-9a-z]");
            else
                sb.append(현재문자);
        }
        return sb.toString();
    }
}
