import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Sidnumrering uppgift nummer 9 i classroom
 */
public class Sidnummer2 {

	static String input;

	public static String readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vad skall användaren skriva in: ");
		String s = reader.readLine();
		return s;
	}

	public static int getNextPage() {
		int blankPos = input.indexOf(" ");
		String s;
		if (blankPos != -1) {
			s = input.substring(0, blankPos);
			input = input.substring(blankPos + 1);
		} else {
			s = input;
			input = "";
		}
		int page = Integer.parseInt(s);
		return page;
	}

	public static void writeRange(int start, int end, String delim) {
		if (start == -1) {
			return;
		}
		if (start == end) {
			System.out.print(start + delim);
		} else {
			System.out.print(start + "-" + end + delim);
		}
	}

	public static void main(String[] args) throws IOException {

		int rangeStart = -1;
		int rangeEnd = -1;
		input = readInput();
		while (input.length() > 0) {
			int page = getNextPage();
			if (page == rangeEnd + 1) {
				rangeEnd = page;
			} else {
				writeRange(rangeStart, rangeEnd, ", ");
				rangeStart = page;
				rangeEnd = page;
			}
		}
		writeRange(rangeStart, rangeEnd, "");

	}

}