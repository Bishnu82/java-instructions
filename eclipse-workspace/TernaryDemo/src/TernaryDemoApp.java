
public class TernaryDemoApp {

	public static void main(String[] args) {
		int num = 50;
		String msg = "";
		if (num > 10) {
			msg = "number is greater than 10";
		} else {
			msg = "number is less than, or equal to, 10.";
		}

		System.out.println(msg);

		msg = (num >= 10) ? "Number is greaterthan, or equalto, 10." : "Number is less than 10.";

	}

}
