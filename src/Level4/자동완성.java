package Level4;

import java.util.*;

class 자동완성 {
    class 노드 {
        HashMap<Character, 노드> 자식;
        int 빈도;

        노드() {
            자식 = new HashMap<>();
            빈도 = 0;
        }
    }

    class 트라이 {
        노드 루트;

        트라이() {
            루트 = new 노드();
        }

        void 삽입(String 단어) {
            var 노드 = 루트;
            for (int i = 0; i < 단어.length(); i++) {
                var 문자 = 단어.charAt(i);
                노드.자식.putIfAbsent(문자, new 노드());
                노드 = 노드.자식.get(문자);
                노드.빈도++;
            }
        }

        int 접두사길이(String 단어) {
            int 길이 = 0;
            var 노드 = 루트;
            for (int i = 0; i < 단어.length(); i++) {
                var 문자 = 단어.charAt(i);
                노드 = 노드.자식.get(문자);
                if (노드.빈도 == 1)
                    return i + 1;
            }

            return 단어.length();
        }
    }

    public int solution(String[] 단어들) {
        var 트라이 = new 트라이();
        for (String 단어 : 단어들)
            트라이.삽입(단어);

        int 답 = 0;
        for (String 단어 : 단어들)
            답 += 트라이.접두사길이(단어);

        return 답;
    }
}