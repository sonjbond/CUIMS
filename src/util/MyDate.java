package util;

public class MyDate {
	int YY, MM, DD;

	public MyDate(int Y, int M, int D) {
		YY = Y;
		MM = M;
		DD = D;
	}

	public String getDate() {
		String S = YY + "-";
		if (MM < 10)
			S = S + "0";
		S += MM + "-";
		if (DD < 10)
			S += "0";
		S += DD;
		return S;
	}
}
