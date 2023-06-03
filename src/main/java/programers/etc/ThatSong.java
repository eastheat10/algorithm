package programers.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 방금 그 곡
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/17683
 */
public class ThatSong {

    public String solution(String m, String[] musicinfos) {
        List<Music> list = new ArrayList<>();
        m = convert(m);

        for (String music : musicinfos) {
            Music myMusic = change(music);
            if (myMusic.isHear(m)) {
                list.add(myMusic);
            }
        }

        list.sort((m1, m2) -> m2.getPlayTime() - m1.getPlayTime());

        return list.isEmpty() ? "(None)" : list.get(0).title;
    }

    private Music change(String m) {
        StringTokenizer st = new StringTokenizer(m, ",");
        return new Music(timeToInt(st.nextToken()), timeToInt(st.nextToken()), st.nextToken(), st.nextToken());
    }

    private int timeToInt(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    private String convert(String m) {
        int len = m.length();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char c = m.charAt(i);
            if (c == '#') {
                char remove = list.remove(list.size() - 1);
                list.add((char) (remove + 7));
            } else {
                list.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);

        return sb.toString();
    }

    static class Music {

        int start;
        int end;
        String title;
        String score;

        public Music(int start, int end, String title, String score) {
            this.start = start;
            this.end = end;
            this.title = title;
            this.score = makeScore(start, end, score);
        }

        private String makeScore(int start, int end, String score) {
            List<Character> list = new ArrayList<>();

            int len = score.length();
            int playTime = end - start + 1;
            int idx = 0;
            int cnt = 0;

            while (cnt < playTime) {
                char c = score.charAt(idx++);
                idx %= len;
                if (c == '#') {
                    Character remove = list.remove(list.size() - 1);
                    list.add((char) (remove + 7));
                } else {
                    list.add(c);
                    cnt++;
                }

                if (cnt == playTime && score.charAt(idx) == '#') {
                    cnt--;
                }
            }

            StringBuilder sb = new StringBuilder();
            list.forEach(sb::append);

            return sb.toString();
        }

        public int getPlayTime() {
            return end - start;
        }

        public boolean isHear(String score) {
            return this.score.contains(score);
        }

    }

}
