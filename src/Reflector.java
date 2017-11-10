public class Reflector {
	private String type;
	public final char[] REFLECTOR_B = { 'Y', 'R', 'U', 'H', 'Q', 'S', 'L', 'D',
			'P', 'X', 'N', 'G', 'O', 'K', 'M', 'I', 'E', 'B', 'F', 'Z', 'C',
			'W', 'V', 'J', 'A', 'T' };
	public final char[] REFLECTOR_C = { 'F', 'V', 'P', 'J', 'I', 'A', 'O', 'Y',
			'E', 'D', 'R', 'Z', 'X', 'W', 'G', 'C', 'T', 'K', 'U', 'Q', 'S',
			'B', 'N', 'M', 'H', 'L' };

	/**
	 * constructor cu un parametru
	 * 
	 * @param type
	 *            - parametru primit din main, acesta poaet fi de 2 feluri: 'B'
	 *            sau 'C'
	 */
	public Reflector(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @param toMap - caracterul de mapat
	 * @return - se returneaza caracterul mapat
	 */
	public char getRefMappedChar(int toMap) {
		if (type.equals("B")) {
			return REFLECTOR_B[toMap];
		} else {
			return REFLECTOR_C[toMap];
		}
	}
}