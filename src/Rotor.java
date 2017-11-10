public class Rotor {
	private char[] mapare;
	private char[] mapareInversa = new char[26];
	public char notch1, notch2;
	public static Rotor ROTOR_I = new Rotor(new char[] { 'E', 'K', 'M', 'F',
			'L', 'G', 'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X',
			'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J' }, 'R');
	public static Rotor ROTOR_II = new Rotor(new char[] { 'A', 'J', 'D', 'K',
			'S', 'I', 'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q',
			'G', 'Z', 'N', 'P', 'Y', 'F', 'V', 'O', 'E' }, 'F');
	public static Rotor ROTOR_III = new Rotor(new char[] { 'B', 'D', 'F', 'H',
			'J', 'L', 'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I',
			'W', 'G', 'A', 'K', 'M', 'U', 'S', 'Q', 'O' }, 'W');
	public static Rotor ROTOR_IV = new Rotor(new char[] { 'E', 'S', 'O', 'V',
			'P', 'Z', 'J', 'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L', 'N',
			'F', 'T', 'G', 'K', 'D', 'C', 'M', 'W', 'B' }, 'K');
	public static Rotor ROTOR_V = new Rotor(new char[] { 'V', 'Z', 'B', 'R',
			'G', 'I', 'T', 'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X', 'A',
			'W', 'M', 'J', 'Q', 'O', 'F', 'E', 'C', 'K' }, 'A');
	public static Rotor ROTOR_VI = new Rotor(new char[] { 'J', 'P', 'G', 'V',
			'O', 'U', 'M', 'F', 'Y', 'Q', 'B', 'E', 'N', 'H', 'Z', 'R', 'D',
			'K', 'A', 'S', 'X', 'L', 'I', 'C', 'T', 'W' }, 'A', 'N');
	public static Rotor ROTOR_VII = new Rotor(new char[] { 'N', 'Z', 'J', 'H',
			'G', 'R', 'C', 'X', 'M', 'Y', 'S', 'W', 'B', 'O', 'U', 'F', 'A',
			'I', 'V', 'L', 'P', 'E', 'K', 'Q', 'D', 'T' }, 'A', 'N');
	public static Rotor ROTOR_VIII = new Rotor(new char[] { 'F', 'K', 'Q', 'H',
			'T', 'L', 'X', 'O', 'C', 'B', 'J', 'S', 'P', 'D', 'Z', 'R', 'A',
			'M', 'E', 'W', 'N', 'I', 'U', 'Y', 'G', 'V' }, 'A', 'N');

	/**
	 * Constructor cu 2 parametri
	 * 
	 * @param mapare
	 *            - maparea unui rotor
	 * @param notch
	 *            - notch-ul unui rotor
	 */
	public Rotor(char[] mapare, char notch) {
		this.mapare = mapare;
		this.notch1 = notch;
		mapareInversa();
	}

	/**
	 * Functie fara parametri. Realizeaza maparea inversa a unui rotor
	 */
	public void mapareInversa() {
		for (int i = 0; i < 26; i++) {
			int j = mapare[i] - 65;
			mapareInversa[j] = (char) (i + 65);
		}
	}

	/**
	 * getter
	 * 
	 * @param toRevMap
	 * @return - returneaza maparea inversa
	 */
	public char getReverse(int toRevMap) {
		return mapareInversa[toRevMap];
	}

	/**
	 * Constructor cu 2 parametri
	 * 
	 * @param mapare
	 *            - maparea unui rotor
	 * @param notch1
	 *            - primul notch al unui rotor
	 * @param notch2
	 *            - al doilea notch al unui rotor
	 */
	public Rotor(char[] mapare, char notch1, char notch2) {
		this.mapare = mapare;
		this.notch1 = notch1;
		this.notch2 = notch2;
		mapareInversa();
	}

	/**
	 * Constructor fara parametri
	 */
	public Rotor() {
	}

	/**
	 * Functie care construieste un rotor in functie de index-ul primit
	 * @param indexRotor
	 * @return
	 */
	public Rotor makeRotor(int indexRotor) {
		switch (indexRotor) {
		case 1:
			return ROTOR_I;
		case 2:
			return ROTOR_II;
		case 3:
			return ROTOR_III;
		case 4:
			return ROTOR_IV;
		case 5:
			return ROTOR_V;
		case 6:
			return ROTOR_VI;
		case 7:
			return ROTOR_VII;
		case 8:
			return ROTOR_VIII;
		default:
			return null;
		}
	}

	/**
	 * getter
	 * 
	 * @param toMap
	 * @return - returneaza maparea indexului primit
	 */
	public char getMapInput(int toMap) {
		return mapare[toMap];
	}
}