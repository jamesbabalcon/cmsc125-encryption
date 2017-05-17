package simplifiedDES;

public class SimplifiedDES {

	public static void main(String[] args) {
		
		String key = "1010000010";
		KeyGen keygen = new KeyGen();
		keygen.generateKeys(key);
		
		String plainText = "01110010";
		int[] pt = new int[8];
		
		System.out.print("plaintext: ");
		for(int i = 0; i <= 7; i++) {
			pt[i] = Character.getNumericValue(plainText.charAt(i));
			System.out.print(pt[i] + " ");
		}
		System.out.println();
		
		Encrypt enc =  new Encrypt();
		enc.encrypt(pt, keygen.getK1(), keygen.getK2());
		
		System.out.println("Encrypted text: " + enc.getEncrypted());
		
		for(int i = 0; i <= 7; i++) {
			pt[i] = Character.getNumericValue(enc.getEncrypted().charAt(i));
		}
		Decrypt dec = new Decrypt();
		dec.decrypt(pt, keygen.getK1(), keygen.getK2());
		
		System.out.println("Decrypted text: " + dec.getDecrypted());
	}
}
