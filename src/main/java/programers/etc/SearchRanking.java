package programers.etc;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class SearchRanking {

    private List<Participant> list;

    public int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];
        list = init(info);

        for (int i = 0; i < query.length; i++) {

            Set<Participant> langSet = new HashSet<>();
            Set<Participant> positionSet = new HashSet<>();
            Set<Participant> levelSet = new HashSet<>();
            Set<Participant> soulFoodSet = new HashSet<>();
            Set<Participant> scoreSet = new HashSet<>();
            String[] qs = query[i].split(" ");

            int cnt = 0;
            for (String q : qs) {
                if (q.equals("and")) continue;
                if (q.trim().equals("-")) {
                    cnt++;
                    continue;
                }

                if (cnt == 0) {
                    langSet = checkLanguage(q);
                } else if (cnt == 1) {
                    positionSet = checkPosition(q);
                } else if (cnt == 2) {
                    levelSet = checkLevel(q);
                } else if (cnt == 3) {
                    soulFoodSet = checkSoulFood(q);
                } else if (cnt == 4) {
                    scoreSet = checkScore(Integer.parseInt(q));
                }

                cnt++;
            }

            int count = 0;

            Set<Participant> all = get();

            for (Participant p : all) {
                if (langSet.contains(p)
                    && positionSet.contains(p)
                    && levelSet.contains(p)
                    && soulFoodSet.contains(p)
                    && scoreSet.contains(p)) {
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }

    private Set<Participant> checkLanguage(String lang) {
        Set<Participant> set = get();
        Set<Participant> copy = new HashSet<>();
        for (Participant p : set) {
            if (!lang.equals(p.lang)) {
                copy.add(p);
            }
        }

        for (Participant p : copy) {
            set.remove(p);
        }

        return set;
    }

    private Set<Participant> checkPosition(String position) {
        Set<Participant> set = get();
        Set<Participant> copy = new HashSet<>();
        for (Participant p : set) {
            if (!position.equals(p.position)) {
                copy.add(p);
            }
        }

        for (Participant p : copy) {
            set.remove(p);
        }

        return set;
    }

    private Set<Participant> checkLevel(String level) {
        Set<Participant> set = get();
        Set<Participant> copy = new HashSet<>();
        for (Participant p : set) {
            if (!level.equals(p.level)) {
                copy.add(p);
            }
        }

        for (Participant p : copy) {
            set.remove(p);
        }

        return set;
    }

    private Set<Participant> checkSoulFood(String soulFood) {
        Set<Participant> set = get();
        Set<Participant> copy = new HashSet<>();
        for (Participant p : set) {
            if (!soulFood.equals(p.soulFood)) {
                copy.add(p);
            }
        }

        for (Participant p : copy) {
            set.remove(p);
        }

        return set;
    }

    private Set<Participant> checkScore(int score) {
        Set<Participant> set = get();
        Set<Participant> copy = new HashSet<>();
        for (Participant p : set) {
            if (score > p.score) {
                copy.add(p);
            }
        }

        for (Participant p : copy) {
            set.remove(p);
        }

        return set;
    }

    private List<Participant> init(String[] info) {
        List<Participant> list = new ArrayList<>();

        for (String i : info) {
            String[] s = i.split(" ");
            list.add(new Participant(s[0], s[1], s[2], s[3], Integer.parseInt(s[4])));
        }

        return list;
    }

    private Set<Participant> get() {
        Set<Participant> set = new HashSet<>();
        for (Participant participant : list) {
            set.add(participant);
        }
        return set;
    }

    static class Participant {
        String lang;
        String position;
        String level;
        String soulFood;
        int score;

        public Participant(String lang, String position, String level, String soulFood, int score) {
            this.lang = lang;
            this.position = position;
            this.level = level;
            this.soulFood = soulFood;
            this.score = score;
        }
    }

}