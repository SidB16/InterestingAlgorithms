/**
 * 
 */

/**
 * Java provides easy-to-use methods convert between char[]'s and strings.
 * Through this concept, keeping in mind type-conversion, and the arithmetic property of the Modulus operator (i.e. wrap around),
 * I implemented the simple CaesarCipher algorithm, which operates on UpperCase letters only for rotation r,
 * from the plaintext letter.
 * 
 * Reference text used: Goodrich DTS textbook.
 * @author sid16
 *
 */
public class caesarCipher {
	protected char[] encoder = new char[26]; //encrption array
	protected char[] decoder = new char[26]; //decryption array
	
	
	//Constructor for initializing the two arrays
	public caesarCipher(int rotation) {
		for (int k = 0; k < 26; k++) {
			this.encoder[k] = (char) ('A' -(k + rotation) % 26);
			this.decoder[k] = (char) ('A' -(k - rotation + 26) % 26);
		}
	}
	//Returns String representation of encrypted message
	public String encrypt(String plaintext) {
		return transform(plaintext, this.encoder);
	}
	//Returns decrypted message given encrypted secret
	public String decrypt(String ciphertext) {
		return transform(ciphertext, this.decoder);
	}
	//Returns transformation of original String using given code
	private String transform(String original, char[] code) {
		char[] msg = original.toCharArray();
		for(int k = 0; k < msg.length; k++) {
			if(Character.isUpperCase(msg[k])) {
				int j = msg[k] - 'A';
				msg[k] = code[j];
			}
		}
		return new String(msg);
	}
	
}
