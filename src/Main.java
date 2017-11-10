import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	private static BufferedReader test;

	public static void main(String[] args) throws IOException {
		// citire linia 1
		test = new BufferedReader(new FileReader(args[0]));
		String line1 = test.readLine();
		String alphabet_machine = line1;

		Plugboard plug = new Plugboard(alphabet_machine);

		// citire linia 2
		String line2 = test.readLine();
		char c1 = 0;
		char c2 = 0;
		String[] line2_split = line2.split("[()]");

		for (int i = 0; i < line2_split.length; i++) {
			if (i % 2 != 0) {
				c1 = line2_split[i].charAt(0);
				c2 = line2_split[i].charAt(1);
				plug.pereche(c1, c2);
			}
		}

		// citire linia 3
		String line3 = test.readLine();
		String[] line3_split = line3.split("\\s+");
		String tip_reflector = null;
		String tip_rotorStanga = null;
		String tip_rotorMijloc = null;
		String tip_rotorDreapta = null;

		for (int i = 0; i < line3_split.length; i++) {
			tip_reflector = line3_split[0];
			tip_rotorStanga = line3_split[1];
			tip_rotorMijloc = line3_split[2];
			tip_rotorDreapta = line3_split[3];
		}
		Reflector ref = new Reflector(tip_reflector);

		// citire liniile 4, 5, 6
		String line4 = test.readLine();
		String line5 = test.readLine();
		test.readLine();

		int a = Integer.parseInt(tip_rotorStanga);
		int b = Integer.parseInt(tip_rotorMijloc);
		int c = Integer.parseInt(tip_rotorDreapta);

		ArrayList<Rotor> str = new ArrayList<Rotor>();

		Rotor rot1 = new Rotor();
		Rotor rot2 = new Rotor();
		Rotor rot3 = new Rotor();

		rot1 = rot1.makeRotor(a);
		rot2 = rot2.makeRotor(b);
		rot3 = rot3.makeRotor(c);

		str.add(rot1);
		str.add(rot2);
		str.add(rot3);

		// citire pana la finalul fisierului
		StringBuilder everything = new StringBuilder();
		String line;

		while ((line = test.readLine()) != null) {
			everything.append(line);
		}
		String text = everything.toString();

		Enigma en1 = new Enigma(line4, line5, str, text);
		en1.setPlugboard(plug);
		en1.setReflector(ref);
		en1.operatii();
	}
}