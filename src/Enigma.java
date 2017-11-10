import java.util.ArrayList;

public class Enigma {
	private Reflector ref = null;
	private Plugboard plug = null;
	private ArrayList<Rotor> rotorArray;
	private String inputText;
	private int[] inel = new int[3], pozRotor = new int[3];
	int ok = 0;

	/**
	 * setter
	 * 
	 * @param p
	 *            - parametru de tip Plugboard
	 */
	public void setPlugboard(Plugboard p) {
		this.plug = p;
	}

	/**
	 * setter
	 * 
	 * @param r
	 *            - parametru de tip Reflector
	 */
	public void setReflector(Reflector r) {
		this.ref = r;
	}

	/**
	 * constructor
	 * 
	 * @param pozInitInele
	 *            - pozitia initiala a inelelor(din fisier)
	 * @param pozInitRot
	 *            - pozitia initiala a rotoarelor(din fisier)
	 * @param str
	 *            - rotoarele ce vor fi folosite(din fisier)
	 * @param inputText
	 *            - mesajul care trebuie criptat-decriptat(din fisier)
	 */
	public Enigma(String pozInitInele, String pozInitRot, ArrayList<Rotor> str,
			String inputText) {
		this.rotorArray = str;
		this.inputText = inputText;

		// array de char-uri pentru pozitia initiala a inelelor
		char[] pozI = pozInitInele.toCharArray();
		for (int i = 0; i < pozI.length; i++) {
			inel[i] = (int) pozI[i] - 65;
		}

		// array de char-uri pentru pozitia initiala a rotoarelor
		char[] pozR = pozInitRot.toCharArray();
		for (int i = 0; i < pozR.length; i++) {
			pozRotor[i] = (int) pozR[i] - 65;
		}
	}

	/**
	 * 
	 * @param litera
	 *            - litera trecuta prin plugboard
	 * @return - se returneaza caracterul procesat prin plugboard
	 */
	private char mapLit(char litera) {
		char caracter = plug.getPlugMappedChar(litera);
		return caracter;
	}

	/**
	 * functie de rotatie a rotoarelor
	 */
	private void spinRotor() {
		// rotorul din dreapta se misca in permanenta
		pozRotor[2] = (pozRotor[2] + 1) % 26;
		// daca si-a atins notch-ul/notch-urile
		if ((pozRotor[2] == (int) rotorArray.get(2).notch1 - 65)
				|| (pozRotor[2] == (int) rotorArray.get(2).notch2 - 65)) {
			pozRotor[1] = (pozRotor[1] + 1) % 26;
		}

		// double stepping
		if (ok == 1) {
			pozRotor[1] = (pozRotor[1] + 1) % 26;
			pozRotor[0] = (pozRotor[0] + 1) % 26;
			ok = 0;
		}

		// daca si-a atins notch-ul/notch-urile
		if ((pozRotor[1] == (int) ((rotorArray.get(1).notch1 - 1) - 65))
				|| (pozRotor[1] == (int) ((rotorArray.get(1).notch2 - 1) - 65))) {
			ok = 1;
		}
	}

	/**
	 * functie care realizeaza drumul
	 * keyboard->plugboard->rotoare->reflector->reflector
	 * ->rotoare->plugboard->lightboard
	 */
	public void operatii() {
		for (int i = 0; i < inputText.length(); i++) {
			spinRotor();
			char litera = inputText.charAt(i);
			litera = mapLit(litera);

			// drumul plugboard - rotor - reflector
			for (int j = 2; j >= 0; j--) {
				// offset rotor
				int offset_rotor = pozRotor[j] - inel[j];
				// input rotor
				int indexLitera = ((int) litera - 65 + offset_rotor) % 26;
				litera = (char) (indexLitera + 65);
				int index = ((int) litera - 65 + 26) % 26;
				// mapare rotor
				litera = rotorArray.get(j).getMapInput(index);
				litera = (char) (((int) litera - 65 - offset_rotor + 26) % 26 + 65);
			}
			litera = ref.getRefMappedChar((int) litera - 65);

			// drumul invers
			for (int j = 0; j <= 2; j++) {
				int offset_rotor = pozRotor[j] - inel[j];
				int indexLitera = ((int) litera - 65 + offset_rotor) % 26;
				litera = (char) (indexLitera + 65);
				int index = ((int) litera - 65 + 26) % 26;
				litera = rotorArray.get(j).getReverse(index);
				litera = (char) (((int) litera - 65 - offset_rotor + 26) % 26 + 65);
			}
			litera = plug.getPlugMappedChar(litera);

			System.out.print(litera);
		}
		System.out.println();
	}
}