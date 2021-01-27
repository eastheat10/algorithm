package algo.stage12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A11650_object {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<Point>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point p =
				new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list.add(i, p);
		}
		Collections.sort(list);

		for(int i = 1; i < list.size(); i++) {
			Point tmp;
			if(list.get(i).getY() < list.get(i - 1).getY()) {
				tmp = list.remove(i);
				list.add(i, list.get(i - 1));
				list.remove(i - 1);
				list.add(i - 1, tmp);
			}
		}

		for(int i = 0; i < list.size(); i++)
			sb.append(String.format("%d %d", list.get(i).getX(), list.get(i).getY()) + "\n");

		bw.write(sb.toString());
		bw.flush(); bw.close(); br.close();

	}

}

class Point implements Comparable<Point> {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int compareTo(Point p) {
		return this.getX() - p.getX();
	}

}
