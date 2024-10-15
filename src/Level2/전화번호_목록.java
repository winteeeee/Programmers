package Level2;

import java.util.*;

class 전화번호_목록 {
    class PhoneNumber implements Comparable<PhoneNumber> {
        String number;

        PhoneNumber(String n) {
            number = n;
        }

        @Override
        public int compareTo(PhoneNumber p) {
            if (number.startsWith(p.number) || p.number.startsWith(number)) return 0;
            return number.compareTo(p.number);
        }
    }

    public boolean solution(String[] phoneBook) {
        var set = new TreeSet<PhoneNumber>();
        for (String p : phoneBook)
            set.add(new PhoneNumber(p));

        return set.size() == phoneBook.length;
    }
}