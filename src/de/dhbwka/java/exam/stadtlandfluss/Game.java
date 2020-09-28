package de.dhbwka.java.exam.stadtlandfluss;

// import java.io.FileWriter;
// import java.io.IOException;
// import java.nio.file.Paths;
// import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;


public class Game {

	private char firstLetter;
	private java.util.Set<ColumnType> columns;
	private List<Sheet> player = new ArrayList<Sheet>();

	private int minColumns;
	private int maxColumns;
	private int remainingSeconds;
	private boolean running;

	// private List<String> validWords;

	public Game(int min, int max, int seconds) {
		minColumns = min >= 3 ? min : 3;
		maxColumns = max >= min ? max : min;

		remainingSeconds = seconds;

		// try {
		// 	validWords = java.nio.file.Files.readAllLines(Paths.get("io/validwords.txt"));
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }
	}

	private char createFirstCharacter() {
		return (char) ('A' + Math.random() * 27);
	}

	private void createColumns() {
		firstLetter = createFirstCharacter();
		Random r = new Random();
		int colCount = r.nextInt(maxColumns - minColumns + 1) + minColumns;
		columns = new TreeSet<ColumnType>();

		columns.add(ColumnType.CITY);
		columns.add(ColumnType.COUNTRY);
		columns.add(ColumnType.RIVER);

		while (columns.size() < colCount)
		{
			switch ((int) (Math.random() * 8)) {
			case 0:
				columns.add(ColumnType.PROFESSION);
				break;
			case 1:
				columns.add(ColumnType.ANIMAL);
				break;
			case 2:
				columns.add(ColumnType.NAME);
				break;
			case 3:
				columns.add(ColumnType.SPORT);
				break;
			case 4:
				columns.add(ColumnType.FOOD);
				break;
			case 5:
				columns.add(ColumnType.BEVERAGE);
				break;
			case 6:
				columns.add(ColumnType.GAME);
				break;
			default:
				break;
			}
		}
	}

	public void register(Sheet sheet) {
		player.add(sheet);
	}

	public void startGame(){
		if(!running){
			createColumns();
			running = true;
			player.forEach(p -> p.start());
		}
	}

	public void stopGame(){
		player.forEach(p -> p.stop());
	}

	// private void CalculateResults(){

	// }


	// private Boolean isCorrect(String word, String category){
	// 	Boolean isOk = word.toUpperCase().startsWith(firstLetter+"") && word.length() > 0;

	// 	if(isOk && validWords.stream().anyMatch(v -> v.equalsIgnoreCase(word)))
	// 		isOk = true;
	// 	else if (isOk){
	// 			if(JOptionPane.YES_OPTION == JOptionPane.showOptionDialog(null, "Ist '" + word +"' korrekt für Kategorie '" + category + "'?",
	// 			"Option auswählen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null)){

	// 				try {
	// 					try (FileWriter fw = new FileWriter("io/validwords.txt", true)) {
	// 						fw.append(word + "\r\n");
	// 						validWords.add(word);
	// 					}
	// 				} catch (IOException e) {
	// 					e.printStackTrace();
	// 				}
					
	// 				isOk = true;
	// 			}
	// 			else{
	// 				isOk = false;
	// 			}
	// 	}
	// 	else{
	// 		isOk = false;
	// 	}

	// 	return isOk;
	// }

	public char getFirstLetter() {
		return this.firstLetter;
	}

	public java.util.Set<ColumnType> getColumns() {
		return this.columns;
	}

	public int getRemainingSeconds() {
		return this.remainingSeconds;
	}

}
