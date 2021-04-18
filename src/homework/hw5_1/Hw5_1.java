package homework.hw5_1;

public class Hw5_1 {

    public static String selection(String[] arr, int start, int end, int i) {
        if (start == end) {		// 원소가 하나일 경우
            return arr[start];
        }
        int q = partition(arr, start, end);

        int k = q - start + 1;	// 기준원소가 전체에서 k번째 작은 원소
        if (i < k) {			// 왼쪽그룹으로 범위 좁힘
            return selection(arr, start, q - 1, i);
        } else if (i > k) {		// 오른쪽 범위로 범위 좁힘
            return selection(arr, q + 1, end, i - k);
        } else {				// 기준원소가 찾는원소
            return arr[q];
        }
    }

    public static int partition(String[] arr, int p, int r) {
    	// 파티션 메서드
        String pivot = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if(arr[j].compareToIgnoreCase(pivot) <= 0) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    public static void swap(String arr[], int i, int j) {
    	// 두 단어 순서 변경
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    public static void main(String[] args) {
        String[] arr = { "put", "quiz", "rest", "fee", "get", "hi", "int", "just", "but", "can", "key", "low",
        "my", "new", "ok", "stop", "AGE", "dog", "egg", "BUT"};

        System.out.println("hw5_1 : 윤동열");

        System.out.print("20개 단어 입력 : put quiz rest fee get hi int just but can key low \n"
        		+ "my new ok stop AGE dog egg BUT");

        System.out.println("1번째 작은 단어 = " + selection(arr, 0, arr.length - 1, 1));
        System.out.println("6번째 작은 단어 = " + selection(arr, 0, arr.length - 1, 6));
        System.out.println("17번째 작은 단어 = " + selection(arr, 0, arr.length - 1, 17));
        System.out.println("20번째 작은 단어 = " + selection(arr, 0, arr.length - 1, 20));

    }
}
