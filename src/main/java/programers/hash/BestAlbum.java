package programers.hash;

import java.util.ArrayList;
import java.util.HashMap;

// 베스트 앨범
public class BestAlbum {

    public static int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genrePlay = new HashMap<>();

        for (int i = 0; i < len; i++)
            genrePlay.put(genres[i], genrePlay.getOrDefault(genres[i], 0) + plays[i]);

        ArrayList<String> genre = new ArrayList<>(genrePlay.keySet());
        genre.sort((o1, o2) -> genrePlay.get(o2) - genrePlay.get(o1));

        for (String s : genre) {
            HashMap<Integer, Integer> indexPlay = new HashMap<>();
            for (int i = 0; i < len; i++)
                if (genres[i].equals(s))
                    indexPlay.put(i, plays[i]);

            ArrayList<Integer> index = new ArrayList<>(indexPlay.keySet());
            index.sort((o1, o2) -> indexPlay.get(o2) - indexPlay.get(o1));

            int count = 0;
            for (Integer integer : index) {
                if(count > 1)
                    break;
                answer.add(integer);
                count++;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] answer = solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500});
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    /**
     * genres	                                        plays                   	return
     * ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
     */
}
