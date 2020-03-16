import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Sidnumrering uppgift nummer 9 i classroom
 */

public class Sidnummer2 {

	static String input;

	public static String readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		System.out.println("Inmatningen skall ske i stigande ordning\nutan dubbletter och avslutas med en nolla.\n");

		while (true) {
			System.out.print("Skriv in sidnummer: ");
			String input = reader.readLine();
			int num = Integer.parseInt(input);

			if (arrayList.contains(num) || arrayList.stream().anyMatch(n -> n > num && num != 0)) { // Kontrollerar
																									// syntax
				System.out.println("Felaktig inmatning, programmet avslutas...");
				System.exit(0);
			} else if (num == 0) {
				break;
			}
			arrayList.add(num);
		}
		String s = arrayList.toString().replaceAll("[\\[\\]]", "").replaceAll(",", "");
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