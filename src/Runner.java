import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Runner {
	static ArrayList<String> lines = new ArrayList<String>();
	static int[] years;
	static String[] name;
	static String[] piece1, piece2, piece3;
	static String[] objective1, objective2;
	static String[] pickup;
	static String[] climb;
	static String gamename = "";
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("Games.csv"));
		while(scan.hasNext()) 
			lines.add(scan.nextLine());
		
		init(lines.size() - 1);
		for (int i = 0; i < lines.size() - 1; i++) 
			splitLine(lines.get(i + 1), i);
		
		String[] game = new String[7];
		game[0] = getRandom(piece1);
		game[1] = getRandom(piece2);
		game[2] = getRandom(piece3);
		game[3] = getRandom(objective1);
		game[4] = getRandom(objective2);
		game[5] = getRandom(pickup);
		game[6] = getRandom(climb);

		String objectives = game[3] + "\n" + game[4] + "\n" + game[5];
		objectives = objectives.replaceAll("game piece #1", game[0]);
		objectives = objectives.replaceAll("game piece #2", game[1]);
		objectives = objectives.replaceAll("game piece #3", game[2]);
		
		System.out.println(objectives);
		System.out.println("Climb: " + game[6]);
	}

	private static void init(int size) {
		years = new int[size];
		name = new String[size];
		piece1 = new String[size];
		piece2 = new String[size];
		piece3 = new String[size];
		objective1 = new String[size];
		objective2 = new String[size];
		pickup = new String[size];
		climb = new String[size];
	}

	private static void splitLine(String s, int i) {
		years[i] = Integer.parseInt(s.substring(0, s.indexOf(',')));
		s = s.substring(s.indexOf(',') + 1);
		name[i] = s.substring(0, s.indexOf(','));
		s = s.substring(s.indexOf(',') + 1);
		piece1[i] = s.substring(0, s.indexOf(','));
		s = s.substring(s.indexOf(',') + 1);
		piece2[i] = s.substring(0, s.indexOf(','));
		s = s.substring(s.indexOf(',') + 1);
		piece3[i] = s.substring(0, s.indexOf(','));
		s = s.substring(s.indexOf(',') + 1);
		objective1[i] = s.substring(0, s.indexOf(','));
		s = s.substring(s.indexOf(',') + 1);
		objective2[i] = s.substring(0, s.indexOf(','));
		s = s.substring(s.indexOf(',') + 1);
		pickup[i] = s.substring(0, s.indexOf(','));
		s = s.substring(s.indexOf(',') + 1);
		climb[i] = s;
	}

	private static String getRandom(String[] arr) {
		int r;
		String s;
		do {
			r = (int) (Math.random() * arr.length);
			s = arr[r];
		} while(s.equals("NA"));
		gamename += name[r];
		return s;
	}
}
