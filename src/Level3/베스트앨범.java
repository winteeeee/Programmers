package Level3;

import java.util.*;

class 베스트앨범 {
    class Genre implements Comparable<Genre> {
        String genre;
        int sumOfPlay;

        Genre(String g, int s) {
            genre = g;
            sumOfPlay = s;
        }

        @Override
        public int compareTo(Genre g) {
            return Integer.compare(g.sumOfPlay, sumOfPlay);
        }
    }

    class Music implements Comparable<Music> {
        int play;
        int idx;

        Music(int p, int i) {
            play = p;
            idx = i;
        }

        @Override
        public int compareTo(Music m) {
            int comp1 = Integer.compare(m.play, play);
            int comp2 = Integer.compare(idx, m.idx);
            return comp1 != 0 ? comp1 : comp2;
        }
    }

    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        var map = new TreeMap<String, Integer>();
        for (int i = 0; i < plays.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            map.put(genre, map.getOrDefault(genre, 0) + play);
        }

        var map2 = new TreeMap<Genre, PriorityQueue<Music>>();
        var map3 = new TreeMap<String, Genre>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Genre g = new Genre(e.getKey(), e.getValue());
            map2.put(g, new PriorityQueue<Music>());
            map3.put(e.getKey(), g);
        }

        for (int i = 0; i < plays.length; i++) {
            var h = map2.get(map3.get(genres[i]));
            h.add(new Music(plays[i], i));
        }

        var answer = new ArrayList<Integer>();
        for (Map.Entry<Genre, PriorityQueue<Music>> e : map2.entrySet()) {
            var h = e.getValue();
            for (int i = 0; i < 2 && !h.isEmpty(); i++) {
                answer.add(h.remove().idx);
            }
        }

        return answer;
    }
}