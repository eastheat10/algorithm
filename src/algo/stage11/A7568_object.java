package algo.stage11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
// 덩치

class Info{
	int weight;
	int height;
	int name;
	int rank = 0;

	public Info(int weight, int height, int name) {
		this.weight = weight;
		this.height = height;
		this.name = name;
	}

	public int getWeight() {
		return this.weight;
	}
	public int getHeight() {
		return this.height;
	}
	public int getRank() {
		return this.rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getName() {
		return this.name;
	}

}

class SortWeight implements Comparator<Info>{
	@Override
	public int compare(Info i1, Info i2) {
		return i2.getWeight() - i1.getWeight();
	}
}

class SortName implements Comparator<Info>{
	@Override
	public int compare(Info i1, Info i2) {
		return i1.getName() - i2.getName();
	}
}

public class A7568_object {

	static int rank = 1;
	static int tmp = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine().trim());

		ArrayList<Info> info = new ArrayList<Info>();

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Info in = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			info.add(i, in);
		}

		Collections.sort(info, new SortWeight());
		info.get(0).setRank(rank);

		for(int j = 1; j < info.size(); j++) {
			if(info.get(j - 1).getHeight() > info.get(j).getHeight()) {
				rank++;
				info.get(j).setRank(rank + tmp - 1);
				tmp = 1;
			}
			else {
				info.get(j).setRank(rank);
				tmp++;
			}
		}

		Collections.sort(info, new SortName());
		for(int k = 0; k < info.size(); k++) {
			sb.append(info.get(k).getRank() + " ");
		}

		bw.write(sb.toString().trim());
		br.close(); bw.flush(); bw.close();
	}

}
