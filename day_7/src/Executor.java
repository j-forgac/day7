import java.util.ArrayList;

public class Executor {
	public void run() {
		String[] rawInput = InputLoader.getInput();
		String[][] processedInput = new String[rawInput.length][5];
		int shorten = 0;
		ArrayList<String> bagsContainingGoldenBag = new ArrayList<>();
		bagsContainingGoldenBag.add("shiny gold bag");
		for (int x = 0; x < rawInput.length; x++) {
			rawInput[x] = rawInput[x].replaceAll("contain", "#");
			rawInput[x] = rawInput[x].replaceAll(",", "#");

			processedInput[x] = rawInput[x].split("#");
			for (int y = 0; y < processedInput[x].length; y++) {
				if (y == 0) {
					processedInput[x][y] = processedInput[x][y].substring(0, processedInput[x][y].length() - 2);
				} else {
					if (processedInput[x][y].charAt(1) == '1') {
						shorten = 0;
					} else {
						shorten = 1;
					}
					if (y == processedInput[x].length - 1) {
						processedInput[x][y] = processedInput[x][y].substring(3, processedInput[x][y].length() - 1 - shorten);
					} else {
						processedInput[x][y] = processedInput[x][y].substring(3, processedInput[x][y].length() - shorten);
					}
				}
			}
		}
		startAgain:
		for(int x = 0; x < processedInput.length; x++){
			for(int y = 1; y < processedInput[x].length; y++){
				for(int bags = 0; bags < bagsContainingGoldenBag.size(); bags++){
					if(processedInput[x][y].equals(bagsContainingGoldenBag.get(bags))){
						if(!bagsContainingGoldenBag.contains(processedInput[x][0])){
							x = -1;
							continue startAgain;
						}
					}
				}
			}
		}
		System.out.println(bagsContainingGoldenBag.size() - 1);

	}
}













/*
				for(int bags = 0; bags < bagsContainingGoldenBag.size(); bags++){
					if(processedInput[x][y].equals(bagsContainingGoldenBag.get(bags))){
						for(int checkBags = 0; checkBags < bagsContainingGoldenBag.size(); checkBags++){
							if(processedInput[x][y].equals(bagsContainingGoldenBag.get(checkBags))){
								alreadyOnList = true;
							} else {
								alreadyOnList = false;
							}
						}
					}
				}*/