public class Plugboard {
	private String alfabet;
	private String plug;

	/**
	 * constructor cu un parametru
	 * 
	 * @param alfabet
	 *            - alfabetul masinii
	 */
	public Plugboard(String alfabet) {
		this.alfabet = alfabet;
		this.plug = new String(alfabet);
	}

	/**
	 * functie care interschimba 2 litere din alfabet; noul alfabet format se
	 * pastreaza in variabila plug
	 * 
	 * @param litera1
	 *            - prima litera de schimbat(primita din main)
	 * @param litera2
	 *            - a doua litera de schimbat(primtia din main)
	 */
	public void pereche(char litera1, char litera2) {
		char alph[] = plug.toCharArray();

		for (int i = 0; i < alfabet.length(); i++) {
			if (alph[i] == litera1) {
				alph[i] = litera2;
			} else if (alph[i] == litera2) {
				alph[i] = litera1;
			}
		}
		plug = new String(alph);
	}

	/**
	 * primeste direct caracterul pe care vreau sa il mapez
	 * @param toMap - caracterul de mapat
	 * @return - returneaza maparea caracterului
	 */
	public char getPlugMappedChar(char toMap) {
		char alph[] = alfabet.toCharArray();
		char plug2[] = plug.toCharArray();

		for (int i = 0; i < alfabet.length(); i++) {
			if (alph[i] == toMap) {
				return plug2[i];
			}
		}
		return '\0';
	}
}