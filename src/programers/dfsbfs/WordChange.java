package programers.dfsbfs;

// 단어 변환
public class WordChange {

    static int answer;
    static boolean[] visit;

    public static int solution(String begin, String target, String[] words) {
        answer = 0;
        visit = new boolean[words.length];

        dfs(0, begin, target, words);

        return answer;
    }

    static boolean check(String present, String nextWord) {
        int count = 0;
        for (int i = 0; i < present.length(); i++) {
            if (present.charAt(i) != nextWord.charAt(i))
                count++;
            if (count > 1) return false;
        }
        return count == 1;
    }

    static void dfs(int depth, String present, String target, String[] words) {
        if (target.equals(present)) {
            answer = depth;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visit[i] && check(present, words[i])) {
                visit[i] = true;
                dfs(depth + 1, words[i], target, words);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    /**
     * begin	target	words	                                    return
     * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
     * "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	        0
     */
}