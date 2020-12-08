import java.util.ArrayList;

public class Executor {
	public void run() {
		String[] rawInput = InputLoader.getInput();
		String[] processedInput = new String[rawInput.length];
		int[] processedInputValues = new int[rawInput.length];
		ArrayList<Integer> visitedLines = new ArrayList<>();
		int lineIndex = 0;
		int accumulator = 0;
		for (int x = 0; x < rawInput.length; x++) {
			processedInput[x] = rawInput[x].substring(0, 3);
			processedInputValues[x] = Integer.parseInt(rawInput[x].substring(4));
		}
		while (!contains(lineIndex, visitedLines)) {
			if (processedInput[lineIndex].equals("jmp")) {
				lineIndex += +processedInputValues[lineIndex];
			} else if (processedInput[lineIndex].equals("acc")) {
				accumulator += processedInputValues[lineIndex];
				lineIndex++;
			} else {
				lineIndex++;
			}
		}
		System.out.println(accumulator);
	}

	public boolean contains(int num, ArrayList<Integer> arr) {
		for (int x = 0; x < arr.size(); x++) {
			if (arr.get(x) == num) {
				return true;
			}
		}
		arr.add(num);
		return false;
	}
}